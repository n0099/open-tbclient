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
    protected final Paint aOg = new Paint();
    protected final Paint aOh = new Paint();
    private int aOi;
    private int aOj;
    private int aOk;
    private int aOl;
    private int aOm;
    private int aOn;
    private int aOo;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public d(View view) {
        this.aOi = 16;
        this.aOj = 16;
        this.aOk = -1;
        this.aOl = 1711276032;
        this.aOm = 20;
        this.aOn = 16;
        this.aOo = 32;
        this.view = view;
        this.aOl = getContext().getResources().getColor(d.C0080d.black_alpha40);
        this.aOh.setColor(this.aOl);
        this.aOh.setAntiAlias(true);
        this.aOm = (int) getContext().getResources().getDimension(d.e.fontsize20);
        this.aOk = getContext().getResources().getColor(d.C0080d.cp_cont_i);
        this.aOg.setColor(this.aOk);
        this.aOg.setTextSize(this.aOm);
        this.aOg.setAntiAlias(true);
        this.aOi = l.f(getContext(), d.e.ds16);
        this.aOj = l.f(getContext(), d.e.ds16);
        this.aOn = l.f(getContext(), d.e.ds16);
        this.aOo = l.f(getContext(), d.e.ds32);
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
            float measureText = this.aOg.measureText(str);
            float f = this.aOo + measureText;
            float f2 = this.aOm + this.aOn;
            canvas.translate((((right - left) - paddingRight) - f) - this.aOj, (((bottom - top) - paddingBottom) - f2) - this.aOi);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aOh);
            Paint.FontMetrics fontMetrics = this.aOg.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aOg);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aOj = i;
        this.aOi = i2;
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aOm = i;
        this.aOg.setTextSize(i);
        invalidate();
    }

    public float hb(String str) {
        return l.b(this.aOg, str).height() + this.aOn;
    }

    public float hc(String str) {
        return l.a(this.aOg, str) + this.aOo;
    }

    public void P(int i, int i2) {
        this.aOo = i;
        this.aOn = i2;
    }
}
