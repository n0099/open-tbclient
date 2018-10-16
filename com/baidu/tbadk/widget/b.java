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
    protected final Paint bgl = new Paint();
    protected final Paint bgm = new Paint();
    private int bgn;
    private int bgo;
    private int bgp;
    private int bgq;
    private int bgr;
    private int bgt;
    private int bgu;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.bgn = 16;
        this.bgo = 16;
        this.bgp = -1;
        this.bgq = 1711276032;
        this.bgr = 20;
        this.bgt = 16;
        this.bgu = 32;
        this.view = view;
        this.bgq = getContext().getResources().getColor(e.d.black_alpha40);
        this.bgm.setColor(this.bgq);
        this.bgm.setAntiAlias(true);
        this.bgr = (int) getContext().getResources().getDimension(e.C0175e.tbfontsize26);
        this.bgp = getContext().getResources().getColor(e.d.cp_cont_i);
        this.bgl.setColor(this.bgp);
        this.bgl.setTextSize(this.bgr);
        this.bgl.setAntiAlias(true);
        this.bgn = l.h(getContext(), e.C0175e.tbds20);
        this.bgo = l.h(getContext(), e.C0175e.tbds20);
        this.bgt = l.h(getContext(), e.C0175e.ds16);
        this.bgu = l.h(getContext(), e.C0175e.tbds40);
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
            float measureText = this.bgl.measureText(str);
            float f = this.bgu + measureText;
            float f2 = this.bgr + this.bgt;
            canvas.translate((((right - left) - paddingRight) - f) - this.bgo, (((bottom - top) - paddingBottom) - f2) - this.bgn);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bgm);
            Paint.FontMetrics fontMetrics = this.bgl.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bgl);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bgo = i;
        this.bgn = i2;
        invalidate();
    }

    public void fP(int i) {
        this.bgp = i;
        this.bgl.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bgr = i;
        this.bgl.setTextSize(i);
        invalidate();
    }

    public float iz(String str) {
        return l.b(this.bgl, str).height() + this.bgt;
    }

    public float iA(String str) {
        return l.a(this.bgl, str) + this.bgu;
    }

    public void N(int i, int i2) {
        this.bgu = i;
        this.bgt = i2;
    }
}
