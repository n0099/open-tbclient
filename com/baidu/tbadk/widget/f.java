package com.baidu.tbadk.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f extends ImageSpan {
    private WeakReference<Drawable> Ge;
    private int aFZ;
    private int paddingLeft;
    private int paddingRight;

    public f(Drawable drawable) {
        super(drawable);
        this.aFZ = 0;
    }

    public void fp(int i) {
        this.paddingLeft = i;
    }

    public void fq(int i) {
        this.paddingRight = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Drawable mn = mn();
        if (mn == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        Rect bounds = mn.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = bounds.bottom - bounds.top;
            int i5 = (i4 / 2) - (i3 / 4);
            int i6 = (i3 / 4) + (i4 / 2);
            fontMetricsInt.ascent = -i6;
            fontMetricsInt.top = -i6;
            fontMetricsInt.bottom = i5;
            fontMetricsInt.descent = i5;
        }
        return bounds.right + this.paddingLeft + this.paddingRight;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable mn = mn();
        if (mn != null) {
            canvas.save();
            canvas.translate(this.paddingLeft + f, ((((i5 - i3) - mn.getBounds().bottom) / 2) + i3) - this.aFZ);
            mn.draw(canvas);
            canvas.restore();
        }
    }

    private Drawable mn() {
        WeakReference<Drawable> weakReference = this.Ge;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.Ge = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void setVerticalOffset(int i) {
        this.aFZ = i;
    }
}
