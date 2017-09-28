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
    protected final Paint aOm = new Paint();
    protected final Paint aOn = new Paint();
    private int aOo;
    private int aOp;
    private int aOq;
    private int aOr;
    private int aOs;
    private int aOt;
    private int aOu;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public d(View view) {
        this.aOo = 16;
        this.aOp = 16;
        this.aOq = -1;
        this.aOr = 1711276032;
        this.aOs = 20;
        this.aOt = 16;
        this.aOu = 32;
        this.view = view;
        this.aOr = getContext().getResources().getColor(d.e.black_alpha40);
        this.aOn.setColor(this.aOr);
        this.aOn.setAntiAlias(true);
        this.aOs = (int) getContext().getResources().getDimension(d.f.fontsize20);
        this.aOq = getContext().getResources().getColor(d.e.cp_cont_i);
        this.aOm.setColor(this.aOq);
        this.aOm.setTextSize(this.aOs);
        this.aOm.setAntiAlias(true);
        this.aOo = l.f(getContext(), d.f.ds16);
        this.aOp = l.f(getContext(), d.f.ds16);
        this.aOt = l.f(getContext(), d.f.ds16);
        this.aOu = l.f(getContext(), d.f.ds32);
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
            float measureText = this.aOm.measureText(str);
            float f = this.aOu + measureText;
            float f2 = this.aOs + this.aOt;
            canvas.translate((((right - left) - paddingRight) - f) - this.aOp, (((bottom - top) - paddingBottom) - f2) - this.aOo);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aOn);
            Paint.FontMetrics fontMetrics = this.aOm.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aOm);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void O(int i, int i2) {
        this.aOp = i;
        this.aOo = i2;
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aOs = i;
        this.aOm.setTextSize(i);
        invalidate();
    }

    public float gU(String str) {
        return l.b(this.aOm, str).height() + this.aOt;
    }

    public float gV(String str) {
        return l.a(this.aOm, str) + this.aOu;
    }

    public void R(int i, int i2) {
        this.aOu = i;
        this.aOt = i2;
    }
}
