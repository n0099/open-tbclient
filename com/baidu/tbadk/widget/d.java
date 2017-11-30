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
    protected final Paint aOP = new Paint();
    protected final Paint aOQ = new Paint();
    private int aOR;
    private int aOS;
    private int aOT;
    private int aOU;
    private int aOV;
    private int aOW;
    private int aOX;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public d(View view) {
        this.aOR = 16;
        this.aOS = 16;
        this.aOT = -1;
        this.aOU = 1711276032;
        this.aOV = 20;
        this.aOW = 16;
        this.aOX = 32;
        this.view = view;
        this.aOU = getContext().getResources().getColor(d.C0082d.black_alpha40);
        this.aOQ.setColor(this.aOU);
        this.aOQ.setAntiAlias(true);
        this.aOV = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.aOT = getContext().getResources().getColor(d.C0082d.cp_cont_i);
        this.aOP.setColor(this.aOT);
        this.aOP.setTextSize(this.aOV);
        this.aOP.setAntiAlias(true);
        this.aOR = l.f(getContext(), d.e.tbds20);
        this.aOS = l.f(getContext(), d.e.tbds20);
        this.aOW = l.f(getContext(), d.e.ds16);
        this.aOX = l.f(getContext(), d.e.tbds40);
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
            float measureText = this.aOP.measureText(str);
            float f = this.aOX + measureText;
            float f2 = this.aOV + this.aOW;
            canvas.translate((((right - left) - paddingRight) - f) - this.aOS, (((bottom - top) - paddingBottom) - f2) - this.aOR);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aOQ);
            Paint.FontMetrics fontMetrics = this.aOP.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aOP);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aOS = i;
        this.aOR = i2;
        invalidate();
    }

    public void fz(int i) {
        this.aOT = i;
        this.aOP.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aOV = i;
        this.aOP.setTextSize(i);
        invalidate();
    }

    public float hf(String str) {
        return l.b(this.aOP, str).height() + this.aOW;
    }

    public float hg(String str) {
        return l.a(this.aOP, str) + this.aOX;
    }

    public void N(int i, int i2) {
        this.aOX = i;
        this.aOW = i2;
    }
}
