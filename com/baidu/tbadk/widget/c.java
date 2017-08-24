package com.baidu.tbadk.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class c extends ImageSpan {
    private WeakReference<Drawable> Hu;
    private int aOM;
    private int paddingLeft;
    private int paddingRight;

    public c(Drawable drawable) {
        super(drawable);
        this.aOM = 0;
    }

    public void fq(int i) {
        this.paddingLeft = i;
    }

    public void fr(int i) {
        this.paddingRight = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Drawable kA = kA();
        if (kA == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        Rect bounds = kA.getBounds();
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
        Drawable kA = kA();
        if (kA != null) {
            canvas.save();
            canvas.translate(this.paddingLeft + f, ((((i5 - i3) - kA.getBounds().bottom) / 2) + i3) - this.aOM);
            kA.draw(canvas);
            canvas.restore();
        }
    }

    private Drawable kA() {
        WeakReference<Drawable> weakReference = this.Hu;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.Hu = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void setVerticalOffset(int i) {
        this.aOM = i;
    }
}
