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
public class d {
    protected final Paint aOo = new Paint();
    protected final Paint aOp = new Paint();
    private int aOq;
    private int aOr;
    private int aOs;
    private int aOt;
    private int aOu;
    private int aOv;
    private int aOw;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public d(View view) {
        this.aOq = 16;
        this.aOr = 16;
        this.aOs = -1;
        this.aOt = 1711276032;
        this.aOu = 20;
        this.aOv = 16;
        this.aOw = 32;
        this.view = view;
        this.aOt = getContext().getResources().getColor(d.C0080d.black_alpha40);
        this.aOp.setColor(this.aOt);
        this.aOp.setAntiAlias(true);
        this.aOu = (int) getContext().getResources().getDimension(d.e.fontsize20);
        this.aOs = getContext().getResources().getColor(d.C0080d.cp_cont_i);
        this.aOo.setColor(this.aOs);
        this.aOo.setTextSize(this.aOu);
        this.aOo.setAntiAlias(true);
        this.aOq = l.f(getContext(), d.e.ds16);
        this.aOr = l.f(getContext(), d.e.ds16);
        this.aOv = l.f(getContext(), d.e.ds16);
        this.aOw = l.f(getContext(), d.e.ds32);
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
            float measureText = this.aOo.measureText(str);
            float f = this.aOw + measureText;
            float f2 = this.aOu + this.aOv;
            canvas.translate((((right - left) - paddingRight) - f) - this.aOr, (((bottom - top) - paddingBottom) - f2) - this.aOq);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aOp);
            Paint.FontMetrics fontMetrics = this.aOo.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aOo);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aOr = i;
        this.aOq = i2;
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aOu = i;
        this.aOo.setTextSize(i);
        invalidate();
    }

    public float hc(String str) {
        return l.b(this.aOo, str).height() + this.aOv;
    }

    public float hd(String str) {
        return l.a(this.aOo, str) + this.aOw;
    }

    public void P(int i, int i2) {
        this.aOw = i;
        this.aOv = i2;
    }
}
