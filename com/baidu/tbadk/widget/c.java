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
/* loaded from: classes2.dex */
public class c {
    private int eXP;
    private int eXQ;
    private int eXR;
    private int eXS;
    private int extraHeight;
    private int extraWidth;
    private int radius;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint eXJ = new Paint();
    protected final Paint eXK = new Paint();
    protected final Paint eXL = new Paint();
    protected final Paint eXM = new Paint();
    private int mSkinType = 3;
    private int eXN = R.color.cp_cont_a;
    private int eXO = R.color.cp_link_tip_d;

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
        this.eXP = 20;
        this.eXQ = 20;
        this.eXR = 36;
        this.eXS = 0;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(R.color.black_alpha40);
        this.eXK.setColor(this.tagBGColor);
        this.eXK.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(R.color.cp_cont_a);
        this.eXJ.setColor(this.tagTextColor);
        this.eXJ.setTextSize(this.tagTextSize);
        this.eXJ.setAntiAlias(true);
        this.tagDisY = l.getDimens(getContext(), R.dimen.tbds16);
        this.tagDisX = l.getDimens(getContext(), R.dimen.tbds16);
        this.extraHeight = l.getDimens(getContext(), R.dimen.tbds22);
        this.extraWidth = l.getDimens(getContext(), R.dimen.tbds40);
        this.radius = l.getDimens(getContext(), R.dimen.tbds10);
        this.eXP = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.eXL.setTextSize(this.eXP);
        this.eXJ.setAntiAlias(true);
        this.eXM.setAntiAlias(true);
        this.eXQ = l.getDimens(getContext(), R.dimen.tbds16);
        this.eXR = l.getDimens(getContext(), R.dimen.tbds22);
        this.eXS = l.getDimens(getContext(), R.dimen.tbds5);
        qO(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(Canvas canvas, String str, int i) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.eXO = i;
                this.eXM.setColor(ap.getColor(this.eXO));
            }
            int save = canvas.save();
            int paddingLeft = this.view.getPaddingLeft();
            this.view.getPaddingRight();
            int paddingTop = this.view.getPaddingTop();
            this.view.getPaddingBottom();
            float measureText = this.eXL.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.eXR + measureText, this.eXP + this.eXQ);
            canvas.drawRoundRect(rectF, this.eXS, this.eXS, this.eXM);
            Paint.FontMetrics fontMetrics = this.eXL.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.eXL);
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
            float measureText = this.eXJ.measureText(str);
            float f = this.extraWidth + measureText;
            float f2 = this.tagTextSize + this.extraHeight;
            canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.eXK);
            Paint.FontMetrics fontMetrics = this.eXJ.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.eXJ);
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
        this.eXJ.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.eXJ.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return l.measureText(this.eXJ, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return l.measureTextWidth(this.eXJ, str) + this.extraWidth;
    }

    public void qO(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.eXL.setColor(ap.getColor(i, this.eXN));
            this.eXM.setColor(ap.getColor(i, this.eXO));
        }
    }
}
