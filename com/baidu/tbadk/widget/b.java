package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class b {
    protected final Paint bln = new Paint();
    protected final Paint blo = new Paint();
    private int blp;
    private int blq;
    private int blr;
    private int bls;
    private int blt;
    private int blu;
    private int blv;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.blp = 16;
        this.blq = 16;
        this.blr = -1;
        this.bls = 1711276032;
        this.blt = 20;
        this.blu = 16;
        this.blv = 32;
        this.view = view;
        this.bls = getContext().getResources().getColor(e.d.black_alpha40);
        this.blo.setColor(this.bls);
        this.blo.setAntiAlias(true);
        this.blt = (int) getContext().getResources().getDimension(e.C0210e.tbfontsize26);
        this.blr = getContext().getResources().getColor(e.d.cp_cont_i);
        this.bln.setColor(this.blr);
        this.bln.setTextSize(this.blt);
        this.bln.setAntiAlias(true);
        this.blp = l.h(getContext(), e.C0210e.tbds20);
        this.blq = l.h(getContext(), e.C0210e.tbds20);
        this.blu = l.h(getContext(), e.C0210e.ds16);
        this.blv = l.h(getContext(), e.C0210e.tbds40);
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
            float measureText = this.bln.measureText(str);
            float f = this.blv + measureText;
            float f2 = this.blt + this.blu;
            canvas.translate((((right - left) - paddingRight) - f) - this.blq, (((bottom - top) - paddingBottom) - f2) - this.blp);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.blo);
            Paint.FontMetrics fontMetrics = this.bln.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bln);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.blq = i;
        this.blp = i2;
        invalidate();
    }

    public void gs(int i) {
        this.blr = i;
        this.bln.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.blt = i;
        this.bln.setTextSize(i);
        invalidate();
    }

    public float jk(String str) {
        return l.b(this.bln, str).height() + this.blu;
    }

    public float jl(String str) {
        return l.a(this.bln, str) + this.blv;
    }

    public void O(int i, int i2) {
        this.blv = i;
        this.blu = i2;
    }
}
