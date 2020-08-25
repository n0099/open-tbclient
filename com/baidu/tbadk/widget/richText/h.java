package com.baidu.tbadk.widget.richText;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h extends ReplacementSpan {
    private int ffA;
    private int mPaddingRight;

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.ffA = (int) ((paint.getFontMetricsInt().descent - paint.getFontMetricsInt().ascent) * 0.8d);
        return this.ffA + this.mPaddingRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable = ap.getDrawable(R.drawable.pic_post_link16);
        drawable.setBounds(0, 0, this.ffA, this.ffA);
        canvas.save();
        canvas.translate(f, (((paint.getFontMetricsInt().descent - paint.getFontMetricsInt().ascent) / 2) - ((drawable.getBounds().top + drawable.getBounds().bottom) / 2)) + i3);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
    }
}
