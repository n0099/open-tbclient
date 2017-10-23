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
    protected final Paint aNZ = new Paint();
    protected final Paint aOa = new Paint();
    private int aOb;
    private int aOc;
    private int aOd;
    private int aOe;
    private int aOf;
    private int aOg;
    private int aOh;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public d(View view) {
        this.aOb = 16;
        this.aOc = 16;
        this.aOd = -1;
        this.aOe = 1711276032;
        this.aOf = 20;
        this.aOg = 16;
        this.aOh = 32;
        this.view = view;
        this.aOe = getContext().getResources().getColor(d.e.black_alpha40);
        this.aOa.setColor(this.aOe);
        this.aOa.setAntiAlias(true);
        this.aOf = (int) getContext().getResources().getDimension(d.f.fontsize20);
        this.aOd = getContext().getResources().getColor(d.e.cp_cont_i);
        this.aNZ.setColor(this.aOd);
        this.aNZ.setTextSize(this.aOf);
        this.aNZ.setAntiAlias(true);
        this.aOb = l.f(getContext(), d.f.ds16);
        this.aOc = l.f(getContext(), d.f.ds16);
        this.aOg = l.f(getContext(), d.f.ds16);
        this.aOh = l.f(getContext(), d.f.ds32);
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
            float measureText = this.aNZ.measureText(str);
            float f = this.aOh + measureText;
            float f2 = this.aOf + this.aOg;
            canvas.translate((((right - left) - paddingRight) - f) - this.aOc, (((bottom - top) - paddingBottom) - f2) - this.aOb);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aOa);
            Paint.FontMetrics fontMetrics = this.aNZ.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aNZ);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void O(int i, int i2) {
        this.aOc = i;
        this.aOb = i2;
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aOf = i;
        this.aNZ.setTextSize(i);
        invalidate();
    }

    public float gT(String str) {
        return l.b(this.aNZ, str).height() + this.aOg;
    }

    public float gU(String str) {
        return l.a(this.aNZ, str) + this.aOh;
    }

    public void R(int i, int i2) {
        this.aOh = i;
        this.aOg = i2;
    }
}
