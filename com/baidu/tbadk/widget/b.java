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
public class b {
    protected final Paint cvP = new Paint();
    protected final Paint cvQ = new Paint();
    private int cvR;
    private int cvS;
    private int cvT;
    private int cvU;
    private int cvV;
    private int cvW;
    private int cvX;
    private int radius;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.cvR = 16;
        this.cvS = 16;
        this.cvT = -1;
        this.cvU = 1711276032;
        this.cvV = 20;
        this.cvW = 20;
        this.cvX = 36;
        this.radius = 0;
        this.view = view;
        this.cvU = getContext().getResources().getColor(d.C0277d.black_alpha40);
        this.cvQ.setColor(this.cvU);
        this.cvQ.setAntiAlias(true);
        this.cvV = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.cvT = getContext().getResources().getColor(d.C0277d.cp_btn_a);
        this.cvP.setColor(this.cvT);
        this.cvP.setTextSize(this.cvV);
        this.cvP.setAntiAlias(true);
        this.cvR = l.h(getContext(), d.e.tbds16);
        this.cvS = l.h(getContext(), d.e.tbds16);
        this.cvW = l.h(getContext(), d.e.tbds22);
        this.cvX = l.h(getContext(), d.e.tbds40);
        this.radius = l.h(getContext(), d.e.tbds10);
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
            float measureText = this.cvP.measureText(str);
            float f = this.cvX + measureText;
            float f2 = this.cvV + this.cvW;
            canvas.translate((((right - left) - paddingRight) - f) - this.cvS, (((bottom - top) - paddingBottom) - f2) - this.cvR);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.cvQ);
            Paint.FontMetrics fontMetrics = this.cvP.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.cvP);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.cvS = i;
        this.cvR = i2;
        invalidate();
    }

    public void kf(int i) {
        this.cvT = i;
        this.cvP.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.cvV = i;
        this.cvP.setTextSize(i);
        invalidate();
    }

    public float pV(String str) {
        return l.b(this.cvP, str).height() + this.cvW;
    }

    public float pW(String str) {
        return l.a(this.cvP, str) + this.cvX;
    }
}
