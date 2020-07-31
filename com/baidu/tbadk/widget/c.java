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
    private int eNj;
    private int eNk;
    private int eNl;
    private int eNm;
    private int extraHeight;
    private int extraWidth;
    private int radius;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint eNd = new Paint();
    protected final Paint eNe = new Paint();
    protected final Paint eNf = new Paint();
    protected final Paint eNg = new Paint();
    private int mSkinType = 3;
    private int eNh = R.color.cp_cont_a;
    private int eNi = R.color.cp_link_tip_d;

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
        this.radius = 0;
        this.eNj = 20;
        this.eNk = 20;
        this.eNl = 36;
        this.eNm = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.eNe.setColor(this.tagBGColor);
        this.eNe.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.cp_cont_a);
        this.eNd.setColor(this.tagTextColor);
        this.eNd.setTextSize(this.tagTextSize);
        this.eNd.setAntiAlias(true);
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.radius = l.getDimens(getContext(), R.dimen.tbds10);
        this.eNj = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.eNf.setTextSize(this.eNj);
        this.eNd.setAntiAlias(true);
        this.eNg.setAntiAlias(true);
        this.eNk = l.getDimens(getContext(), R.dimen.tbds16);
        this.eNl = l.getDimens(getContext(), R.dimen.tbds22);
        this.eNm = l.getDimens(getContext(), R.dimen.tbds5);
        oC(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.eNi = i;
                this.eNg.setColor(ao.getColor(this.eNi));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.eNf.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.eNl + measureText, this.eNj + this.eNk);
            canvas.drawRoundRect(rectF, this.eNm, this.eNm, this.eNg);
            Paint.FontMetrics fontMetrics = this.eNf.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.eNf);
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
        }
    }

    public void drawBottomRightTag(Canvas canvas, String str) {
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
            float measureText = this.eNd.measureText(str);
            float f = this.extraWidth + measureText;
            float f2 = this.tagTextSize + this.extraHeight;
            canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.eNe);
            Paint.FontMetrics fontMetrics = this.eNd.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.eNd);
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
        this.eNd.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.eNd.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.eNd, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.eNd, str) + this.extraWidth;
    }

    public void oC(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.eNf.setColor(ao.getColor(i, this.eNh));
            this.eNg.setColor(ao.getColor(i, this.eNi));
        }
    }
}
