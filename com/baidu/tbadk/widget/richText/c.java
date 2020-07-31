package com.baidu.tbadk.widget.richText;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends ReplacementSpan {
    private static final int eTX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
    private static final int eTY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
    private static final int eTZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
    private static final int eUa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private int aOl;
    private int eUb;
    private int enc;
    private int mBgColor;
    private int mHeight;
    private int mOffset;
    private int mPadding;
    private int mRadius;
    private int mTextColor;

    public c(b bVar) {
        this.mTextColor = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.mBgColor = R.color.cp_link_tip_d;
        this.mRadius = eTX;
        this.mPadding = eTY;
        this.mHeight = eUa;
        this.aOl = 0;
        this.enc = eTZ;
        this.mOffset = 0;
        if (bVar != null) {
            this.mTextColor = bVar.textColor;
            this.mBgColor = bVar.bgColor;
            this.mRadius = bVar.radius;
            this.mHeight = bVar.height;
            this.mPadding = bVar.padding;
            this.aOl = bVar.leftMargin;
            this.enc = bVar.rightMargin;
            this.mOffset = bVar.offset;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        this.eUb = (int) paint.measureText(charSequence, i, i2);
        return this.eUb + (this.mPadding * 2) + this.aOl + this.enc;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.mOffset);
        paint.setColor(ao.getColor(this.mBgColor));
        paint.setAntiAlias(true);
        float descent = this.mHeight - (paint.descent() - paint.ascent());
        canvas.drawRoundRect(new RectF(this.aOl + f, (i4 + paint.ascent()) - descent, this.aOl + f + this.eUb + (this.mPadding * 2), i4 + paint.descent()), this.mRadius, this.mRadius, paint);
        paint.setColor(this.mTextColor);
        canvas.drawText(charSequence, i, i2, this.mPadding + f + this.aOl, i4 - (descent / 2.0f), paint);
        canvas.restore();
    }
}
