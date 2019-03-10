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
    protected final Paint cvQ = new Paint();
    protected final Paint cvR = new Paint();
    private int cvS;
    private int cvT;
    private int cvU;
    private int cvV;
    private int cvW;
    private int cvX;
    private int cvY;
    private int radius;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.cvS = 16;
        this.cvT = 16;
        this.cvU = -1;
        this.cvV = 1711276032;
        this.cvW = 20;
        this.cvX = 20;
        this.cvY = 36;
        this.radius = 0;
        this.view = view;
        this.cvV = getContext().getResources().getColor(d.C0236d.black_alpha40);
        this.cvR.setColor(this.cvV);
        this.cvR.setAntiAlias(true);
        this.cvW = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.cvU = getContext().getResources().getColor(d.C0236d.cp_btn_a);
        this.cvQ.setColor(this.cvU);
        this.cvQ.setTextSize(this.cvW);
        this.cvQ.setAntiAlias(true);
        this.cvS = l.h(getContext(), d.e.tbds16);
        this.cvT = l.h(getContext(), d.e.tbds16);
        this.cvX = l.h(getContext(), d.e.tbds22);
        this.cvY = l.h(getContext(), d.e.tbds40);
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
            float measureText = this.cvQ.measureText(str);
            float f = this.cvY + measureText;
            float f2 = this.cvW + this.cvX;
            canvas.translate((((right - left) - paddingRight) - f) - this.cvT, (((bottom - top) - paddingBottom) - f2) - this.cvS);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.cvR);
            Paint.FontMetrics fontMetrics = this.cvQ.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.cvQ);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.cvT = i;
        this.cvS = i2;
        invalidate();
    }

    public void kg(int i) {
        this.cvU = i;
        this.cvQ.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.cvW = i;
        this.cvQ.setTextSize(i);
        invalidate();
    }

    public float pW(String str) {
        return l.b(this.cvQ, str).height() + this.cvX;
    }

    public float pX(String str) {
        return l.a(this.cvQ, str) + this.cvY;
    }
}
