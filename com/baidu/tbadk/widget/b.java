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
    protected final Paint cDZ = new Paint();
    protected final Paint cEa = new Paint();
    private int cEb;
    private int cEc;
    private int cEd;
    private int cEe;
    private int cEf;
    private int cEg;
    private int cEh;
    private int radius;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.cEb = 16;
        this.cEc = 16;
        this.cEd = -1;
        this.cEe = 1711276032;
        this.cEf = 20;
        this.cEg = 20;
        this.cEh = 36;
        this.radius = 0;
        this.view = view;
        this.cEe = getContext().getResources().getColor(R.color.black_alpha40);
        this.cEa.setColor(this.cEe);
        this.cEa.setAntiAlias(true);
        this.cEf = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.cEd = getContext().getResources().getColor(R.color.cp_btn_a);
        this.cDZ.setColor(this.cEd);
        this.cDZ.setTextSize(this.cEf);
        this.cDZ.setAntiAlias(true);
        this.cEb = l.g(getContext(), R.dimen.tbds16);
        this.cEc = l.g(getContext(), R.dimen.tbds16);
        this.cEg = l.g(getContext(), R.dimen.tbds22);
        this.cEh = l.g(getContext(), R.dimen.tbds40);
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
            float measureText = this.cDZ.measureText(str);
            float f = this.cEh + measureText;
            float f2 = this.cEf + this.cEg;
            canvas.translate((((right - left) - paddingRight) - f) - this.cEc, (((bottom - top) - paddingBottom) - f2) - this.cEb);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.cEa);
            Paint.FontMetrics fontMetrics = this.cDZ.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.cDZ);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.cEc = i;
        this.cEb = i2;
        invalidate();
    }

    public void kU(int i) {
        this.cEd = i;
        this.cDZ.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.cEf = i;
        this.cDZ.setTextSize(i);
        invalidate();
    }

    public float re(String str) {
        return l.b(this.cDZ, str).height() + this.cEg;
    }

    public float rf(String str) {
        return l.a(this.cDZ, str) + this.cEh;
    }
}
