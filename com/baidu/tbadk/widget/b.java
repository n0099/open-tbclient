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
    protected final Paint aXr = new Paint();
    protected final Paint aXs = new Paint();
    private int aXt;
    private int aXu;
    private int aXv;
    private int aXw;
    private int aXx;
    private int aXy;
    private int aXz;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.aXt = 16;
        this.aXu = 16;
        this.aXv = -1;
        this.aXw = 1711276032;
        this.aXx = 20;
        this.aXy = 16;
        this.aXz = 32;
        this.view = view;
        this.aXw = getContext().getResources().getColor(d.C0141d.black_alpha40);
        this.aXs.setColor(this.aXw);
        this.aXs.setAntiAlias(true);
        this.aXx = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.aXv = getContext().getResources().getColor(d.C0141d.cp_cont_i);
        this.aXr.setColor(this.aXv);
        this.aXr.setTextSize(this.aXx);
        this.aXr.setAntiAlias(true);
        this.aXt = l.e(getContext(), d.e.tbds20);
        this.aXu = l.e(getContext(), d.e.tbds20);
        this.aXy = l.e(getContext(), d.e.ds16);
        this.aXz = l.e(getContext(), d.e.tbds40);
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
            float measureText = this.aXr.measureText(str);
            float f = this.aXz + measureText;
            float f2 = this.aXx + this.aXy;
            canvas.translate((((right - left) - paddingRight) - f) - this.aXu, (((bottom - top) - paddingBottom) - f2) - this.aXt);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aXs);
            Paint.FontMetrics fontMetrics = this.aXr.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aXr);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aXu = i;
        this.aXt = i2;
        invalidate();
    }

    public void ft(int i) {
        this.aXv = i;
        this.aXr.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aXx = i;
        this.aXr.setTextSize(i);
        invalidate();
    }

    public float hN(String str) {
        return l.b(this.aXr, str).height() + this.aXy;
    }

    public float hO(String str) {
        return l.a(this.aXr, str) + this.aXz;
    }

    public void K(int i, int i2) {
        this.aXz = i;
        this.aXy = i2;
    }
}
