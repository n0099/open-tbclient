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
    private int fRl;
    private int fRm;
    private int fRn;
    private int fRo;
    private float[] fRp;
    private int fRq;
    private int fRr;
    private float radius;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint fRf = new Paint();
    protected final Paint fRg = new Paint();
    protected final Paint fRh = new Paint();
    protected final Paint fRi = new Paint();
    private int mSkinType = 3;
    private int fRj = R.color.CAM_X0101;
    private int fRk = R.color.CAM_X0305;

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
        this.fRl = 20;
        this.fRm = 20;
        this.fRn = 36;
        this.fRo = 0;
        this.fRq = 0;
        this.fRr = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.fRg.setColor(this.tagBGColor);
        this.fRg.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fRf.setColor(this.tagTextColor);
        this.fRf.setTextSize(this.tagTextSize);
        this.fRf.setAntiAlias(true);
        this.fRf.setTypeface(com.baidu.tbadk.core.elementsMaven.a.AG(com.baidu.tbadk.core.elementsMaven.a.getString(R.string.F_X02)));
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.radius = com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X01)[0];
        this.fRl = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.fRh.setTextSize(this.fRl);
        this.fRf.setAntiAlias(true);
        this.fRi.setAntiAlias(true);
        this.fRm = l.getDimens(getContext(), R.dimen.tbds16);
        this.fRn = l.getDimens(getContext(), R.dimen.tbds22);
        this.fRo = l.getDimens(getContext(), R.dimen.tbds5);
        this.fRq = l.getDimens(getContext(), R.dimen.M_W_X006);
        this.fRr = l.getDimens(getContext(), R.dimen.M_H_X004);
        rL(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.fRk = i;
                this.fRi.setColor(ap.getColor(this.fRk));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.fRh.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.fRn + measureText, this.fRl + this.fRm);
            canvas.drawRoundRect(rectF, this.fRo, this.fRo, this.fRi);
            Paint.FontMetrics fontMetrics = this.fRh.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fRh);
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
            float measureText = this.fRf.measureText(str);
            Paint.FontMetrics fontMetrics = this.fRf.getFontMetrics();
            if (z) {
                if (this.fRp == null) {
                    this.fRp = com.baidu.tbadk.core.elementsMaven.a.nP(R.array.S_O_X001);
                }
                if (this.fRp != null && this.fRp.length >= 4) {
                    this.fRf.setShadowLayer(this.fRp[1], this.fRp[2], this.fRp[3], (int) this.fRp[0]);
                }
                canvas.drawText(str, (((right - left) - paddingRight) - this.fRq) - measureText, (((bottom - top) - paddingBottom) - this.fRq) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fRf);
            } else {
                float f = this.extraWidth + measureText;
                float f2 = this.tagTextSize + this.extraHeight;
                canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
                RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                if (this.radius < 1.0f) {
                    this.radius *= f2;
                }
                canvas.drawRoundRect(rectF, this.radius, this.radius, this.fRg);
                float height = (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
                this.fRf.clearShadowLayer();
                canvas.drawText(str, (rectF.width() - measureText) / 2.0f, height, this.fRf);
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
        this.fRf.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.fRf.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.fRf, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.fRf, str) + this.extraWidth;
    }

    public void rL(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.fRh.setColor(ap.getColor(i, this.fRj));
            this.fRi.setColor(ap.getColor(i, this.fRk));
        }
    }
}
