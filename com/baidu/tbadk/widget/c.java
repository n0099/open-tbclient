package com.baidu.tbadk.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class c extends ImageSpan {
    private WeakReference<Drawable> ate;
    private int bCE;
    private int bCF;

    public c(Drawable drawable, int i) {
        super(drawable);
        this.bCE = 0;
        this.bCF = 1;
        this.bCF = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Drawable rN = rN();
        if (rN == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        Rect bounds = rN.getBounds();
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
        return bounds.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable rN;
        float f2;
        if (rN() != null) {
            switch (this.bCF) {
                case 0:
                    f2 = 0.1f;
                    break;
                case 1:
                    f2 = 0.15f;
                    break;
                case 2:
                    f2 = 0.2f;
                    break;
                default:
                    f2 = 0.0f;
                    break;
            }
            float height = f2 != 0.0f ? ((i4 - i5) + (f2 * rN.getBounds().height())) - this.bCE : 0.0f;
            canvas.save();
            canvas.translate(rN.getBounds().width() * 0.15f, height);
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
            canvas.restore();
        }
    }

    private Drawable rN() {
        WeakReference<Drawable> weakReference = this.ate;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.ate = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }
}
