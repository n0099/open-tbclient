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
public class e {
    protected final Paint bFf = new Paint();
    protected final Paint bFg = new Paint();
    private int bFh;
    private int bFi;
    private int bFj;
    private int bFk;
    private int bFl;
    private int bFm;
    private int bFn;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public e(View view) {
        this.bFh = 16;
        this.bFi = 16;
        this.bFj = -1;
        this.bFk = 1711276032;
        this.bFl = 20;
        this.bFm = 16;
        this.bFn = 32;
        this.view = view;
        this.bFk = getContext().getResources().getColor(d.C0140d.black_alpha40);
        this.bFg.setColor(this.bFk);
        this.bFg.setAntiAlias(true);
        this.bFl = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.bFj = getContext().getResources().getColor(d.C0140d.cp_cont_i);
        this.bFf.setColor(this.bFj);
        this.bFf.setTextSize(this.bFl);
        this.bFf.setAntiAlias(true);
        this.bFh = l.t(getContext(), d.e.tbds20);
        this.bFi = l.t(getContext(), d.e.tbds20);
        this.bFm = l.t(getContext(), d.e.ds16);
        this.bFn = l.t(getContext(), d.e.tbds40);
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
            float measureText = this.bFf.measureText(str);
            float f = this.bFn + measureText;
            float f2 = this.bFl + this.bFm;
            canvas.translate((((right - left) - paddingRight) - f) - this.bFi, (((bottom - top) - paddingBottom) - f2) - this.bFh);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bFg);
            Paint.FontMetrics fontMetrics = this.bFf.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bFf);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bFi = i;
        this.bFh = i2;
        invalidate();
    }

    public void ir(int i) {
        this.bFj = i;
        this.bFf.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bFl = i;
        this.bFf.setTextSize(i);
        invalidate();
    }

    public float hy(String str) {
        return l.b(this.bFf, str).height() + this.bFm;
    }

    public float hz(String str) {
        return l.a(this.bFf, str) + this.bFn;
    }

    public void aN(int i, int i2) {
        this.bFn = i;
        this.bFm = i2;
    }
}
