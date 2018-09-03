package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class b {
    private int aYA;
    protected final Paint aYs = new Paint();
    protected final Paint aYt = new Paint();
    private int aYu;
    private int aYv;
    private int aYw;
    private int aYx;
    private int aYy;
    private int aYz;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.aYu = 16;
        this.aYv = 16;
        this.aYw = -1;
        this.aYx = 1711276032;
        this.aYy = 20;
        this.aYz = 16;
        this.aYA = 32;
        this.view = view;
        this.aYx = getContext().getResources().getColor(f.d.black_alpha40);
        this.aYt.setColor(this.aYx);
        this.aYt.setAntiAlias(true);
        this.aYy = (int) getContext().getResources().getDimension(f.e.tbfontsize26);
        this.aYw = getContext().getResources().getColor(f.d.cp_cont_i);
        this.aYs.setColor(this.aYw);
        this.aYs.setTextSize(this.aYy);
        this.aYs.setAntiAlias(true);
        this.aYu = l.f(getContext(), f.e.tbds20);
        this.aYv = l.f(getContext(), f.e.tbds20);
        this.aYz = l.f(getContext(), f.e.ds16);
        this.aYA = l.f(getContext(), f.e.tbds40);
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
            float measureText = this.aYs.measureText(str);
            float f = this.aYA + measureText;
            float f2 = this.aYy + this.aYz;
            canvas.translate((((right - left) - paddingRight) - f) - this.aYv, (((bottom - top) - paddingBottom) - f2) - this.aYu);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aYt);
            Paint.FontMetrics fontMetrics = this.aYs.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aYs);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aYv = i;
        this.aYu = i2;
        invalidate();
    }

    public void fu(int i) {
        this.aYw = i;
        this.aYs.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aYy = i;
        this.aYs.setTextSize(i);
        invalidate();
    }

    public float hO(String str) {
        return l.b(this.aYs, str).height() + this.aYz;
    }

    public float hP(String str) {
        return l.a(this.aYs, str) + this.aYA;
    }

    public void L(int i, int i2) {
        this.aYA = i;
        this.aYz = i2;
    }
}
