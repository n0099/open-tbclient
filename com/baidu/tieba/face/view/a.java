package com.baidu.tieba.face.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends ImageSpan {
    private WeakReference<Drawable> mDrawableRef;
    private int mMarginRight;

    public a(@NonNull Drawable drawable, int i) {
        super(drawable, i);
    }

    public a(@NonNull Drawable drawable, int i, int i2) {
        super(drawable, i);
        this.mMarginRight = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.descent - fontMetricsInt2.ascent;
            int i4 = bounds.bottom - bounds.top;
            int i5 = fontMetricsInt2.ascent + (i3 / 2);
            fontMetricsInt.ascent = i5 - (i4 / 2);
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = i5 + (i4 / 2);
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
        return bounds.right + this.mMarginRight;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.translate(f, ((fontMetricsInt.descent + i4) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2)) - ((cachedDrawable.getBounds().bottom - cachedDrawable.getBounds().top) / 2));
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.mDrawableRef = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }
}
