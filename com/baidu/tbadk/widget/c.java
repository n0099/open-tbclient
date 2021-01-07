package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private int extraHeight;
    private int extraWidth;
    private int fSf;
    private int fSg;
    private int fSh;
    private int fSi;
    private float[] fSj;
    private int fSk;
    private int fSl;
    private float radius;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint fRZ = new Paint();
    protected final Paint fSa = new Paint();
    protected final Paint fSb = new Paint();
    protected final Paint fSc = new Paint();
    private int mSkinType = 3;
    private int fSd = R.color.CAM_X0101;
    private int fSe = R.color.CAM_X0305;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public c(View view) {
        this.tagDisY = 16;
        this.tagDisX = 16;
        this.tagTextColor = -1;
        this.tagBGColor = 1711276032;
        this.tagTextSize = 20;
        this.extraHeight = 20;
        this.extraWidth = 36;
        this.radius = 0.0f;
        this.fSf = 20;
        this.fSg = 20;
        this.fSh = 36;
        this.fSi = 0;
        this.fSk = 0;
        this.fSl = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.fSa.setColor(this.tagBGColor);
        this.fSa.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fRZ.setColor(this.tagTextColor);
        this.fRZ.setTextSize(this.tagTextSize);
        this.fRZ.setAntiAlias(true);
        this.fRZ.setTypeface(com.baidu.tbadk.core.elementsMaven.a.Bt(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.radius = com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X01)[0];
        this.fSf = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.fSb.setTextSize(this.fSf);
        this.fRZ.setAntiAlias(true);
        this.fSc.setAntiAlias(true);
        this.fSg = l.getDimens(getContext(), R.dimen.tbds16);
        this.fSh = l.getDimens(getContext(), R.dimen.tbds22);
        this.fSi = l.getDimens(getContext(), R.dimen.tbds5);
        this.fSk = l.getDimens(getContext(), R.dimen.M_W_X006);
        this.fSl = l.getDimens(getContext(), R.dimen.M_H_X004);
        tk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.fSe = i;
                this.fSc.setColor(ao.getColor(this.fSe));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.fSb.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.fSh + measureText, this.fSf + this.fSg);
            canvas.drawRoundRect(rectF, this.fSi, this.fSi, this.fSc);
            Paint.FontMetrics fontMetrics = this.fSb.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fSb);
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
        }
    }

    public void a(Canvas canvas, String str, boolean z) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            int save = canvas.save();
            this.view.getPaddingLeft();
            int paddingRight = this.view.getPaddingRight();
            this.view.getPaddingTop();
            int paddingBottom = this.view.getPaddingBottom();
            int left = this.view.getLeft();
            int right = this.view.getRight();
            int top = this.view.getTop();
            int bottom = this.view.getBottom();
            float measureText = this.fRZ.measureText(str);
            Paint.FontMetrics fontMetrics = this.fRZ.getFontMetrics();
            if (z) {
                if (this.fSj == null) {
                    this.fSj = com.baidu.tbadk.core.elementsMaven.a.ps(R.array.S_O_X001);
                }
                if (this.fSj != null && this.fSj.length >= 4) {
                    this.fRZ.setShadowLayer(this.fSj[1], this.fSj[2], this.fSj[3], (int) this.fSj[0]);
                }
                canvas.drawText(str, (((right - left) - paddingRight) - this.fSk) - measureText, (((bottom - top) - paddingBottom) - this.fSk) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fRZ);
            } else {
                float f = this.extraWidth + measureText;
                float f2 = this.tagTextSize + this.extraHeight;
                canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
                RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                if (this.radius < 1.0f) {
                    this.radius *= f2;
                }
                canvas.drawRoundRect(rectF, this.radius, this.radius, this.fSa);
                float height = (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
                this.fRZ.clearShadowLayer();
                canvas.drawText(str, (rectF.width() - measureText) / 2.0f, height, this.fRZ);
            }
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.tagDisX = i;
        this.tagDisY = i2;
        invalidate();
    }

    public void setTagTextColor(int i) {
        this.tagTextColor = i;
        this.fRZ.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.fRZ.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.fRZ, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.fRZ, str) + this.extraWidth;
    }

    public void tk(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.fSb.setColor(ao.getColor(i, this.fSd));
            this.fSc.setColor(ao.getColor(i, this.fSe));
        }
    }
}
