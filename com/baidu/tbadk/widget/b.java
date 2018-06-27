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
    protected final Paint aYm = new Paint();
    protected final Paint aYn = new Paint();
    private int aYo;
    private int aYp;
    private int aYq;
    private int aYr;
    private int aYs;
    private int aYt;
    private int aYu;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.aYo = 16;
        this.aYp = 16;
        this.aYq = -1;
        this.aYr = 1711276032;
        this.aYs = 20;
        this.aYt = 16;
        this.aYu = 32;
        this.view = view;
        this.aYr = getContext().getResources().getColor(d.C0142d.black_alpha40);
        this.aYn.setColor(this.aYr);
        this.aYn.setAntiAlias(true);
        this.aYs = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.aYq = getContext().getResources().getColor(d.C0142d.cp_cont_i);
        this.aYm.setColor(this.aYq);
        this.aYm.setTextSize(this.aYs);
        this.aYm.setAntiAlias(true);
        this.aYo = l.e(getContext(), d.e.tbds20);
        this.aYp = l.e(getContext(), d.e.tbds20);
        this.aYt = l.e(getContext(), d.e.ds16);
        this.aYu = l.e(getContext(), d.e.tbds40);
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
            float measureText = this.aYm.measureText(str);
            float f = this.aYu + measureText;
            float f2 = this.aYs + this.aYt;
            canvas.translate((((right - left) - paddingRight) - f) - this.aYp, (((bottom - top) - paddingBottom) - f2) - this.aYo);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aYn);
            Paint.FontMetrics fontMetrics = this.aYm.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aYm);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aYp = i;
        this.aYo = i2;
        invalidate();
    }

    public void fu(int i) {
        this.aYq = i;
        this.aYm.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aYs = i;
        this.aYm.setTextSize(i);
        invalidate();
    }

    public float hR(String str) {
        return l.b(this.aYm, str).height() + this.aYt;
    }

    public float hS(String str) {
        return l.a(this.aYm, str) + this.aYu;
    }

    public void K(int i, int i2) {
        this.aYu = i;
        this.aYt = i2;
    }
}
