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
    private int extraHeight;
    private int extraWidth;
    private int fPL;
    private int fPM;
    private int fPN;
    private int fPO;
    private float[] fPP;
    private int fPQ;
    private int fPR;
    private float radius;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint fPF = new Paint();
    protected final Paint fPG = new Paint();
    protected final Paint fPH = new Paint();
    protected final Paint fPI = new Paint();
    private int mSkinType = 3;
    private int fPJ = R.color.CAM_X0101;
    private int fPK = R.color.CAM_X0305;

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
        this.fPL = 20;
        this.fPM = 20;
        this.fPN = 36;
        this.fPO = 0;
        this.fPQ = 0;
        this.fPR = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.fPG.setColor(this.tagBGColor);
        this.fPG.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fPF.setColor(this.tagTextColor);
        this.fPF.setTextSize(this.tagTextSize);
        this.fPF.setAntiAlias(true);
        this.fPF.setTypeface(com.baidu.tbadk.core.elementsMaven.a.Az(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.radius = com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X01)[0];
        this.fPL = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.fPH.setTextSize(this.fPL);
        this.fPF.setAntiAlias(true);
        this.fPI.setAntiAlias(true);
        this.fPM = l.getDimens(getContext(), R.dimen.tbds16);
        this.fPN = l.getDimens(getContext(), R.dimen.tbds22);
        this.fPO = l.getDimens(getContext(), R.dimen.tbds5);
        this.fPQ = l.getDimens(getContext(), R.dimen.M_W_X006);
        this.fPR = l.getDimens(getContext(), R.dimen.M_H_X004);
        rJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.fPK = i;
                this.fPI.setColor(ap.getColor(this.fPK));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.fPH.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.fPN + measureText, this.fPL + this.fPM);
            canvas.drawRoundRect(rectF, this.fPO, this.fPO, this.fPI);
            Paint.FontMetrics fontMetrics = this.fPH.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fPH);
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
            float measureText = this.fPF.measureText(str);
            Paint.FontMetrics fontMetrics = this.fPF.getFontMetrics();
            if (z) {
                if (this.fPP == null) {
                    this.fPP = com.baidu.tbadk.core.elementsMaven.a.nO(R.array.S_O_X001);
                }
                if (this.fPP != null && this.fPP.length >= 4) {
                    this.fPF.setShadowLayer(this.fPP[1], this.fPP[2], this.fPP[3], (int) this.fPP[0]);
                }
                canvas.drawText(str, (((right - left) - paddingRight) - this.fPQ) - measureText, (((bottom - top) - paddingBottom) - this.fPQ) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fPF);
            } else {
                float f = this.extraWidth + measureText;
                float f2 = this.tagTextSize + this.extraHeight;
                canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
                RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                if (this.radius < 1.0f) {
                    this.radius *= f2;
                }
                canvas.drawRoundRect(rectF, this.radius, this.radius, this.fPG);
                float height = (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
                this.fPF.clearShadowLayer();
                canvas.drawText(str, (rectF.width() - measureText) / 2.0f, height, this.fPF);
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
        this.fPF.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.fPF.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.fPF, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.fPF, str) + this.extraWidth;
    }

    public void rJ(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.fPH.setColor(ap.getColor(i, this.fPJ));
            this.fPI.setColor(ap.getColor(i, this.fPK));
        }
    }
}
