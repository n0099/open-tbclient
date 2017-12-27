package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    protected final Paint bCK = new Paint();
    protected final Paint bCL = new Paint();
    private int bCM;
    private int bCN;
    private int bCO;
    private int bCP;
    private int bCQ;
    private int bCR;
    private int bCS;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public e(View view) {
        this.bCM = 16;
        this.bCN = 16;
        this.bCO = -1;
        this.bCP = 1711276032;
        this.bCQ = 20;
        this.bCR = 16;
        this.bCS = 32;
        this.view = view;
        this.bCP = getContext().getResources().getColor(d.C0108d.black_alpha40);
        this.bCL.setColor(this.bCP);
        this.bCL.setAntiAlias(true);
        this.bCQ = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.bCO = getContext().getResources().getColor(d.C0108d.cp_cont_i);
        this.bCK.setColor(this.bCO);
        this.bCK.setTextSize(this.bCQ);
        this.bCK.setAntiAlias(true);
        this.bCM = l.s(getContext(), d.e.tbds20);
        this.bCN = l.s(getContext(), d.e.tbds20);
        this.bCR = l.s(getContext(), d.e.ds16);
        this.bCS = l.s(getContext(), d.e.tbds40);
    }

    public void c(Canvas canvas, String str) {
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
            float measureText = this.bCK.measureText(str);
            float f = this.bCS + measureText;
            float f2 = this.bCQ + this.bCR;
            canvas.translate((((right - left) - paddingRight) - f) - this.bCN, (((bottom - top) - paddingBottom) - f2) - this.bCM);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bCL);
            Paint.FontMetrics fontMetrics = this.bCK.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bCK);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bCN = i;
        this.bCM = i2;
        invalidate();
    }

    public void iy(int i) {
        this.bCO = i;
        this.bCK.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bCQ = i;
        this.bCK.setTextSize(i);
        invalidate();
    }

    public float hg(String str) {
        return l.b(this.bCK, str).height() + this.bCR;
    }

    public float hh(String str) {
        return l.a(this.bCK, str) + this.bCS;
    }

    public void aN(int i, int i2) {
        this.bCS = i;
        this.bCR = i2;
    }
}
