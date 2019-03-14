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
    protected final Paint cvN = new Paint();
    protected final Paint cvO = new Paint();
    private int cvP;
    private int cvQ;
    private int cvR;
    private int cvS;
    private int cvT;
    private int cvU;
    private int cvV;
    private int radius;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.cvP = 16;
        this.cvQ = 16;
        this.cvR = -1;
        this.cvS = 1711276032;
        this.cvT = 20;
        this.cvU = 20;
        this.cvV = 36;
        this.radius = 0;
        this.view = view;
        this.cvS = getContext().getResources().getColor(d.C0277d.black_alpha40);
        this.cvO.setColor(this.cvS);
        this.cvO.setAntiAlias(true);
        this.cvT = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.cvR = getContext().getResources().getColor(d.C0277d.cp_btn_a);
        this.cvN.setColor(this.cvR);
        this.cvN.setTextSize(this.cvT);
        this.cvN.setAntiAlias(true);
        this.cvP = l.h(getContext(), d.e.tbds16);
        this.cvQ = l.h(getContext(), d.e.tbds16);
        this.cvU = l.h(getContext(), d.e.tbds22);
        this.cvV = l.h(getContext(), d.e.tbds40);
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
            float measureText = this.cvN.measureText(str);
            float f = this.cvV + measureText;
            float f2 = this.cvT + this.cvU;
            canvas.translate((((right - left) - paddingRight) - f) - this.cvQ, (((bottom - top) - paddingBottom) - f2) - this.cvP);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.cvO);
            Paint.FontMetrics fontMetrics = this.cvN.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.cvN);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.cvQ = i;
        this.cvP = i2;
        invalidate();
    }

    public void kg(int i) {
        this.cvR = i;
        this.cvN.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.cvT = i;
        this.cvN.setTextSize(i);
        invalidate();
    }

    public float pU(String str) {
        return l.b(this.cvN, str).height() + this.cvU;
    }

    public float pV(String str) {
        return l.a(this.cvN, str) + this.cvV;
    }
}
