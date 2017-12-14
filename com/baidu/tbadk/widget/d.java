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
    protected final Paint aOS = new Paint();
    protected final Paint aOT = new Paint();
    private int aOU;
    private int aOV;
    private int aOW;
    private int aOX;
    private int aOY;
    private int aOZ;
    private int aPa;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public d(View view) {
        this.aOU = 16;
        this.aOV = 16;
        this.aOW = -1;
        this.aOX = 1711276032;
        this.aOY = 20;
        this.aOZ = 16;
        this.aPa = 32;
        this.view = view;
        this.aOX = getContext().getResources().getColor(d.C0096d.black_alpha40);
        this.aOT.setColor(this.aOX);
        this.aOT.setAntiAlias(true);
        this.aOY = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.aOW = getContext().getResources().getColor(d.C0096d.cp_cont_i);
        this.aOS.setColor(this.aOW);
        this.aOS.setTextSize(this.aOY);
        this.aOS.setAntiAlias(true);
        this.aOU = l.f(getContext(), d.e.tbds20);
        this.aOV = l.f(getContext(), d.e.tbds20);
        this.aOZ = l.f(getContext(), d.e.ds16);
        this.aPa = l.f(getContext(), d.e.tbds40);
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
            float measureText = this.aOS.measureText(str);
            float f = this.aPa + measureText;
            float f2 = this.aOY + this.aOZ;
            canvas.translate((((right - left) - paddingRight) - f) - this.aOV, (((bottom - top) - paddingBottom) - f2) - this.aOU);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aOT);
            Paint.FontMetrics fontMetrics = this.aOS.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aOS);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aOV = i;
        this.aOU = i2;
        invalidate();
    }

    public void fz(int i) {
        this.aOW = i;
        this.aOS.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aOY = i;
        this.aOS.setTextSize(i);
        invalidate();
    }

    public float hd(String str) {
        return l.b(this.aOS, str).height() + this.aOZ;
    }

    public float he(String str) {
        return l.a(this.aOS, str) + this.aPa;
    }

    public void O(int i, int i2) {
        this.aPa = i;
        this.aOZ = i2;
    }
}
