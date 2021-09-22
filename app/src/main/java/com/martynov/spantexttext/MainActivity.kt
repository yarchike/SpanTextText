package com.martynov.spantexttext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ImageSpan
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = listOf<String>("25 - отдых", " 26 Гулянка", "29 - итд")
        val textVIew = findViewById<TextView>(R.id.textVIew)
        var builder = SpannableStringBuilder()
        val image = ContextCompat.getDrawable(this, R.drawable.orders_plus)
        image?.intrinsicWidth?.let { image.setBounds(0, 0, it, image.intrinsicHeight) }
        for(item in list){
            val imageSpan = image?.let { ImageSpan(it, ImageSpan.ALIGN_BASELINE) }
            val sb = SpannableString("  $item")
            sb.setSpan(imageSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            builder.append(sb)
            builder.append("\n")
        }
        textVIew.text = builder

    }
}