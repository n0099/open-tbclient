package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private float bKG;
    private int extraHeight;
    private int extraWidth;
    private int fAO;
    private int fAP;
    private int fAQ;
    private int fAR;
    private float[] fAS;
    private int fAT;
    private int fAU;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint fAI = new Paint();
    protected final Paint fAJ = new Paint();
    protected final Paint fAK = new Paint();
    protected final Paint fAL = new Paint();
    private int mSkinType = 3;
    private int fAM = R.color.CAM_X0101;
    private int fAN = R.color.CAM_X0305;

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
        this.bKG = 0.0f;
        this.fAO = 20;
        this.fAP = 20;
        this.fAQ = 36;
        this.fAR = 0;
        this.fAT = 0;
        this.fAU = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.fAJ.setColor(this.tagBGColor);
        this.fAJ.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fAI.setColor(this.tagTextColor);
        this.fAI.setTextSize(this.tagTextSize);
        this.fAI.setAntiAlias(true);
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.bKG = com.baidu.tbadk.core.elementsMaven.a.aD(R.string.J_X01)[0];
        this.fAO = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.fAK.setTextSize(this.fAO);
        this.fAI.setAntiAlias(true);
        this.fAL.setAntiAlias(true);
        this.fAP = l.getDimens(getContext(), R.dimen.tbds16);
        this.fAQ = l.getDimens(getContext(), R.dimen.tbds22);
        this.fAR = l.getDimens(getContext(), R.dimen.tbds5);
        this.fAT = l.getDimens(getContext(), R.dimen.M_W_X006);
        this.fAU = l.getDimens(getContext(), R.dimen.M_H_X004);
        sw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.fAN = i;
                this.fAL.setColor(ap.getColor(this.fAN));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.fAK.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.fAQ + measureText, this.fAO + this.fAP);
            canvas.drawRoundRect(rectF, this.fAR, this.fAR, this.fAL);
            Paint.FontMetrics fontMetrics = this.fAK.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fAK);
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
            float measureText = this.fAI.measureText(str);
            Paint.FontMetrics fontMetrics = this.fAI.getFontMetrics();
            if (z) {
                if (this.fAS == null) {
                    this.fAS = com.baidu.tbadk.core.elementsMaven.a.oJ(R.array.S_O_X001);
                }
                if (this.fAS != null && this.fAS.length >= 4) {
                    this.fAI.setShadowLayer(this.fAS[1], this.fAS[2], this.fAS[3], (int) this.fAS[0]);
                }
                canvas.drawText(str, (((right - left) - paddingRight) - this.fAT) - measureText, (((bottom - top) - paddingBottom) - this.fAT) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fAI);
            } else {
                float f = this.extraWidth + measureText;
                float f2 = this.tagTextSize + this.extraHeight;
                canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
                RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                if (this.bKG < 1.0f) {
                    this.bKG *= f2;
                }
                canvas.drawRoundRect(rectF, this.bKG, this.bKG, this.fAJ);
                float height = (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
                this.fAI.clearShadowLayer();
                canvas.drawText(str, (rectF.width() - measureText) / 2.0f, height, this.fAI);
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
        this.fAI.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.fAI.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.fAI, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.fAI, str) + this.extraWidth;
    }

    public void sw(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.fAK.setColor(ap.getColor(i, this.fAM));
            this.fAL.setColor(ap.getColor(i, this.fAN));
        }
    }
}
