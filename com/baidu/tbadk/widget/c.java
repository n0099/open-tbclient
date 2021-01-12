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
    private int fNA;
    private int fNB;
    private float[] fNC;
    private int fND;
    private int fNE;
    private int fNy;
    private int fNz;
    private float radius;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint fNs = new Paint();
    protected final Paint fNt = new Paint();
    protected final Paint fNu = new Paint();
    protected final Paint fNv = new Paint();
    private int mSkinType = 3;
    private int fNw = R.color.CAM_X0101;
    private int fNx = R.color.CAM_X0305;

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
        this.fNy = 20;
        this.fNz = 20;
        this.fNA = 36;
        this.fNB = 0;
        this.fND = 0;
        this.fNE = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.fNt.setColor(this.tagBGColor);
        this.fNt.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fNs.setColor(this.tagTextColor);
        this.fNs.setTextSize(this.tagTextSize);
        this.fNs.setAntiAlias(true);
        this.fNs.setTypeface(com.baidu.tbadk.core.elementsMaven.a.Ai(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.radius = com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X01)[0];
        this.fNy = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.fNu.setTextSize(this.fNy);
        this.fNs.setAntiAlias(true);
        this.fNv.setAntiAlias(true);
        this.fNz = l.getDimens(getContext(), R.dimen.tbds16);
        this.fNA = l.getDimens(getContext(), R.dimen.tbds22);
        this.fNB = l.getDimens(getContext(), R.dimen.tbds5);
        this.fND = l.getDimens(getContext(), R.dimen.M_W_X006);
        this.fNE = l.getDimens(getContext(), R.dimen.M_H_X004);
        rE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.fNx = i;
                this.fNv.setColor(ao.getColor(this.fNx));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.fNu.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.fNA + measureText, this.fNy + this.fNz);
            canvas.drawRoundRect(rectF, this.fNB, this.fNB, this.fNv);
            Paint.FontMetrics fontMetrics = this.fNu.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fNu);
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
            float measureText = this.fNs.measureText(str);
            Paint.FontMetrics fontMetrics = this.fNs.getFontMetrics();
            if (z) {
                if (this.fNC == null) {
                    this.fNC = com.baidu.tbadk.core.elementsMaven.a.nL(R.array.S_O_X001);
                }
                if (this.fNC != null && this.fNC.length >= 4) {
                    this.fNs.setShadowLayer(this.fNC[1], this.fNC[2], this.fNC[3], (int) this.fNC[0]);
                }
                canvas.drawText(str, (((right - left) - paddingRight) - this.fND) - measureText, (((bottom - top) - paddingBottom) - this.fND) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fNs);
            } else {
                float f = this.extraWidth + measureText;
                float f2 = this.tagTextSize + this.extraHeight;
                canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
                RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                if (this.radius < 1.0f) {
                    this.radius *= f2;
                }
                canvas.drawRoundRect(rectF, this.radius, this.radius, this.fNt);
                float height = (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
                this.fNs.clearShadowLayer();
                canvas.drawText(str, (rectF.width() - measureText) / 2.0f, height, this.fNs);
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
        this.fNs.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.fNs.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.fNs, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.fNs, str) + this.extraWidth;
    }

    public void rE(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.fNu.setColor(ao.getColor(i, this.fNw));
            this.fNv.setColor(ao.getColor(i, this.fNx));
        }
    }
}
