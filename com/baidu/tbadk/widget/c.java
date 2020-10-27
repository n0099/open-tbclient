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
    private int fvA;
    private int fvB;
    private int fvy;
    private int fvz;
    private int radius;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint fvs = new Paint();
    protected final Paint fvt = new Paint();
    protected final Paint fvu = new Paint();
    protected final Paint fvv = new Paint();
    private int mSkinType = 3;
    private int fvw = R.color.cp_cont_a;
    private int fvx = R.color.cp_link_tip_d;

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
        this.fvy = 20;
        this.fvz = 20;
        this.fvA = 36;
        this.fvB = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.fvt.setColor(this.tagBGColor);
        this.fvt.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.cp_cont_a);
        this.fvs.setColor(this.tagTextColor);
        this.fvs.setTextSize(this.tagTextSize);
        this.fvs.setAntiAlias(true);
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.radius = l.getDimens(getContext(), R.dimen.tbds10);
        this.fvy = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.fvu.setTextSize(this.fvy);
        this.fvs.setAntiAlias(true);
        this.fvv.setAntiAlias(true);
        this.fvz = l.getDimens(getContext(), R.dimen.tbds16);
        this.fvA = l.getDimens(getContext(), R.dimen.tbds22);
        this.fvB = l.getDimens(getContext(), R.dimen.tbds5);
        rO(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.fvx = i;
                this.fvv.setColor(ap.getColor(this.fvx));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.fvu.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.fvA + measureText, this.fvy + this.fvz);
            canvas.drawRoundRect(rectF, this.fvB, this.fvB, this.fvv);
            Paint.FontMetrics fontMetrics = this.fvu.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fvu);
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
            float measureText = this.fvs.measureText(str);
            float f = this.extraWidth + measureText;
            float f2 = this.tagTextSize + this.extraHeight;
            canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.fvt);
            Paint.FontMetrics fontMetrics = this.fvs.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.fvs);
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
        this.fvs.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.fvs.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.fvs, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.fvs, str) + this.extraWidth;
    }

    public void rO(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.fvu.setColor(ap.getColor(i, this.fvw));
            this.fvv.setColor(ap.getColor(i, this.fvx));
        }
    }
}
