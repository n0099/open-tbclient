package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b {
    protected final Paint cEa = new Paint();
    protected final Paint cEb = new Paint();
    private int cEc;
    private int cEd;
    private int cEe;
    private int cEf;
    private int cEg;
    private int cEh;
    private int cEi;
    private int radius;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.cEc = 16;
        this.cEd = 16;
        this.cEe = -1;
        this.cEf = 1711276032;
        this.cEg = 20;
        this.cEh = 20;
        this.cEi = 36;
        this.radius = 0;
        this.view = view;
        this.cEf = getContext().getResources().getColor(R.color.black_alpha40);
        this.cEb.setColor(this.cEf);
        this.cEb.setAntiAlias(true);
        this.cEg = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.cEe = getContext().getResources().getColor(R.color.cp_btn_a);
        this.cEa.setColor(this.cEe);
        this.cEa.setTextSize(this.cEg);
        this.cEa.setAntiAlias(true);
        this.cEc = l.g(getContext(), R.dimen.tbds16);
        this.cEd = l.g(getContext(), R.dimen.tbds16);
        this.cEh = l.g(getContext(), R.dimen.tbds22);
        this.cEi = l.g(getContext(), R.dimen.tbds40);
        this.radius = l.g(getContext(), R.dimen.tbds10);
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
            float measureText = this.cEa.measureText(str);
            float f = this.cEi + measureText;
            float f2 = this.cEg + this.cEh;
            canvas.translate((((right - left) - paddingRight) - f) - this.cEd, (((bottom - top) - paddingBottom) - f2) - this.cEc);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.cEb);
            Paint.FontMetrics fontMetrics = this.cEa.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.cEa);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.cEd = i;
        this.cEc = i2;
        invalidate();
    }

    public void kU(int i) {
        this.cEe = i;
        this.cEa.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.cEg = i;
        this.cEa.setTextSize(i);
        invalidate();
    }

    public float rd(String str) {
        return l.b(this.cEa, str).height() + this.cEh;
    }

    public float re(String str) {
        return l.a(this.cEa, str) + this.cEi;
    }
}
