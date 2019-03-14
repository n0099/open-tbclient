package com.baidu.tieba.channel.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
/* loaded from: classes6.dex */
public class a extends ReplacementSpan {
    private Drawable mDrawable;
    private int mHeight;
    private int mWidth;
    private int padding;

    public a(Drawable drawable, int i, int i2, int i3) {
        this.mDrawable = drawable;
        this.mWidth = i;
        this.mHeight = i2;
        this.padding = i3;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return this.mWidth + this.padding;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        this.mDrawable.setBounds(((int) f) + this.padding, (int) (i3 + paint.descent()), ((int) f) + this.mWidth + this.padding, (int) (i3 + paint.descent() + this.mHeight));
        this.mDrawable.draw(canvas);
    }
}
