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
    private int bkA;
    private int bkB;
    private int bkC;
    private int bkD;
    private int bkE;
    protected final Paint bkw = new Paint();
    protected final Paint bkx = new Paint();
    private int bky;
    private int bkz;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.bky = 16;
        this.bkz = 16;
        this.bkA = -1;
        this.bkB = 1711276032;
        this.bkC = 20;
        this.bkD = 16;
        this.bkE = 32;
        this.view = view;
        this.bkB = getContext().getResources().getColor(e.d.black_alpha40);
        this.bkx.setColor(this.bkB);
        this.bkx.setAntiAlias(true);
        this.bkC = (int) getContext().getResources().getDimension(e.C0210e.tbfontsize26);
        this.bkA = getContext().getResources().getColor(e.d.cp_cont_i);
        this.bkw.setColor(this.bkA);
        this.bkw.setTextSize(this.bkC);
        this.bkw.setAntiAlias(true);
        this.bky = l.h(getContext(), e.C0210e.tbds20);
        this.bkz = l.h(getContext(), e.C0210e.tbds20);
        this.bkD = l.h(getContext(), e.C0210e.ds16);
        this.bkE = l.h(getContext(), e.C0210e.tbds40);
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
            float measureText = this.bkw.measureText(str);
            float f = this.bkE + measureText;
            float f2 = this.bkC + this.bkD;
            canvas.translate((((right - left) - paddingRight) - f) - this.bkz, (((bottom - top) - paddingBottom) - f2) - this.bky);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bkx);
            Paint.FontMetrics fontMetrics = this.bkw.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bkw);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bkz = i;
        this.bky = i2;
        invalidate();
    }

    public void gr(int i) {
        this.bkA = i;
        this.bkw.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bkC = i;
        this.bkw.setTextSize(i);
        invalidate();
    }

    public float iT(String str) {
        return l.b(this.bkw, str).height() + this.bkD;
    }

    public float iU(String str) {
        return l.a(this.bkw, str) + this.bkE;
    }

    public void O(int i, int i2) {
        this.bkE = i;
        this.bkD = i2;
    }
}
