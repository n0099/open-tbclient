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
    protected final Paint blo = new Paint();
    protected final Paint blp = new Paint();
    private int blq;
    private int blr;
    private int bls;
    private int blt;
    private int blu;
    private int blv;
    private int blw;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.blq = 16;
        this.blr = 16;
        this.bls = -1;
        this.blt = 1711276032;
        this.blu = 20;
        this.blv = 16;
        this.blw = 32;
        this.view = view;
        this.blt = getContext().getResources().getColor(e.d.black_alpha40);
        this.blp.setColor(this.blt);
        this.blp.setAntiAlias(true);
        this.blu = (int) getContext().getResources().getDimension(e.C0210e.tbfontsize26);
        this.bls = getContext().getResources().getColor(e.d.cp_cont_i);
        this.blo.setColor(this.bls);
        this.blo.setTextSize(this.blu);
        this.blo.setAntiAlias(true);
        this.blq = l.h(getContext(), e.C0210e.tbds20);
        this.blr = l.h(getContext(), e.C0210e.tbds20);
        this.blv = l.h(getContext(), e.C0210e.ds16);
        this.blw = l.h(getContext(), e.C0210e.tbds40);
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
            float measureText = this.blo.measureText(str);
            float f = this.blw + measureText;
            float f2 = this.blu + this.blv;
            canvas.translate((((right - left) - paddingRight) - f) - this.blr, (((bottom - top) - paddingBottom) - f2) - this.blq);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.blp);
            Paint.FontMetrics fontMetrics = this.blo.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.blo);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.blr = i;
        this.blq = i2;
        invalidate();
    }

    public void gs(int i) {
        this.bls = i;
        this.blo.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.blu = i;
        this.blo.setTextSize(i);
        invalidate();
    }

    public float jk(String str) {
        return l.b(this.blo, str).height() + this.blv;
    }

    public float jl(String str) {
        return l.a(this.blo, str) + this.blw;
    }

    public void O(int i, int i2) {
        this.blw = i;
        this.blv = i2;
    }
}
