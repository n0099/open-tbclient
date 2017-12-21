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
    protected final Paint aOV = new Paint();
    protected final Paint aOW = new Paint();
    private int aOX;
    private int aOY;
    private int aOZ;
    private int aPa;
    private int aPb;
    private int aPc;
    private int aPd;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public d(View view) {
        this.aOX = 16;
        this.aOY = 16;
        this.aOZ = -1;
        this.aPa = 1711276032;
        this.aPb = 20;
        this.aPc = 16;
        this.aPd = 32;
        this.view = view;
        this.aPa = getContext().getResources().getColor(d.C0095d.black_alpha40);
        this.aOW.setColor(this.aPa);
        this.aOW.setAntiAlias(true);
        this.aPb = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.aOZ = getContext().getResources().getColor(d.C0095d.cp_cont_i);
        this.aOV.setColor(this.aOZ);
        this.aOV.setTextSize(this.aPb);
        this.aOV.setAntiAlias(true);
        this.aOX = l.f(getContext(), d.e.tbds20);
        this.aOY = l.f(getContext(), d.e.tbds20);
        this.aPc = l.f(getContext(), d.e.ds16);
        this.aPd = l.f(getContext(), d.e.tbds40);
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
            float measureText = this.aOV.measureText(str);
            float f = this.aPd + measureText;
            float f2 = this.aPb + this.aPc;
            canvas.translate((((right - left) - paddingRight) - f) - this.aOY, (((bottom - top) - paddingBottom) - f2) - this.aOX);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aOW);
            Paint.FontMetrics fontMetrics = this.aOV.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aOV);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aOY = i;
        this.aOX = i2;
        invalidate();
    }

    public void fz(int i) {
        this.aOZ = i;
        this.aOV.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aPb = i;
        this.aOV.setTextSize(i);
        invalidate();
    }

    public float hd(String str) {
        return l.b(this.aOV, str).height() + this.aPc;
    }

    public float he(String str) {
        return l.a(this.aOV, str) + this.aPd;
    }

    public void O(int i, int i2) {
        this.aPd = i;
        this.aPc = i2;
    }
}
