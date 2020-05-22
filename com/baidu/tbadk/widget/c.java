package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private int extraHeight;
    private int extraWidth;
    private int exv;
    private int exw;
    private int exx;
    private int exy;
    private int radius;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint exo = new Paint();
    protected final Paint exp = new Paint();
    protected final Paint exq = new Paint();
    protected final Paint exr = new Paint();
    private int mSkinType = 3;
    private int exs = R.color.cp_cont_a;
    private int exu = R.color.cp_link_tip_d;

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
        this.exv = 20;
        this.exw = 20;
        this.exx = 36;
        this.exy = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.exp.setColor(this.tagBGColor);
        this.exp.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.cp_cont_a);
        this.exo.setColor(this.tagTextColor);
        this.exo.setTextSize(this.tagTextSize);
        this.exo.setAntiAlias(true);
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.radius = l.getDimens(getContext(), R.dimen.tbds10);
        this.exv = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.exq.setTextSize(this.exv);
        this.exo.setAntiAlias(true);
        this.exr.setAntiAlias(true);
        this.exw = l.getDimens(getContext(), R.dimen.tbds16);
        this.exx = l.getDimens(getContext(), R.dimen.tbds22);
        this.exy = l.getDimens(getContext(), R.dimen.tbds5);
        nL(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.exu = i;
                this.exr.setColor(am.getColor(this.exu));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.exq.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.exx + measureText, this.exv + this.exw);
            canvas.drawRoundRect(rectF, this.exy, this.exy, this.exr);
            Paint.FontMetrics fontMetrics = this.exq.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.exq);
            canvas.restoreToCount(save);
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
            int top2 = this.view.getTop();
            int bottom = this.view.getBottom();
            float measureText = this.exo.measureText(str);
            float f = this.extraWidth + measureText;
            float f2 = this.tagTextSize + this.extraHeight;
            canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top2) - paddingBottom) - f2) - this.tagDisY);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.exp);
            Paint.FontMetrics fontMetrics = this.exo.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.exo);
            canvas.restoreToCount(save);
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
        this.exo.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.exo.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.exo, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.exo, str) + this.extraWidth;
    }

    public void nL(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.exq.setColor(am.getColor(i, this.exs));
            this.exr.setColor(am.getColor(i, this.exu));
        }
    }
}
