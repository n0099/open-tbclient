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
    private int bkB;
    private int bkC;
    private int bkD;
    private int bkE;
    private int bkF;
    private int bkG;
    private int bkH;
    protected final View view;
    protected final Paint bkz = new Paint();
    protected final Paint bkA = new Paint();

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.bkB = 16;
        this.bkC = 16;
        this.bkD = -1;
        this.bkE = 1711276032;
        this.bkF = 20;
        this.bkG = 16;
        this.bkH = 32;
        this.view = view;
        this.bkE = getContext().getResources().getColor(e.d.black_alpha40);
        this.bkA.setColor(this.bkE);
        this.bkA.setAntiAlias(true);
        this.bkF = (int) getContext().getResources().getDimension(e.C0210e.tbfontsize26);
        this.bkD = getContext().getResources().getColor(e.d.cp_cont_i);
        this.bkz.setColor(this.bkD);
        this.bkz.setTextSize(this.bkF);
        this.bkz.setAntiAlias(true);
        this.bkB = l.h(getContext(), e.C0210e.tbds20);
        this.bkC = l.h(getContext(), e.C0210e.tbds20);
        this.bkG = l.h(getContext(), e.C0210e.ds16);
        this.bkH = l.h(getContext(), e.C0210e.tbds40);
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
            float measureText = this.bkz.measureText(str);
            float f = this.bkH + measureText;
            float f2 = this.bkF + this.bkG;
            canvas.translate((((right - left) - paddingRight) - f) - this.bkC, (((bottom - top) - paddingBottom) - f2) - this.bkB);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bkA);
            Paint.FontMetrics fontMetrics = this.bkz.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bkz);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bkC = i;
        this.bkB = i2;
        invalidate();
    }

    public void gs(int i) {
        this.bkD = i;
        this.bkz.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bkF = i;
        this.bkz.setTextSize(i);
        invalidate();
    }

    public float iU(String str) {
        return l.b(this.bkz, str).height() + this.bkG;
    }

    public float iV(String str) {
        return l.a(this.bkz, str) + this.bkH;
    }

    public void O(int i, int i2) {
        this.bkH = i;
        this.bkG = i2;
    }
}
