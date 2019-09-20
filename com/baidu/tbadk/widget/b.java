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
    private int cGA;
    protected final Paint cGs = new Paint();
    protected final Paint cGt = new Paint();
    private int cGu;
    private int cGv;
    private int cGw;
    private int cGx;
    private int cGy;
    private int cGz;
    private int radius;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.cGu = 16;
        this.cGv = 16;
        this.cGw = -1;
        this.cGx = 1711276032;
        this.cGy = 20;
        this.cGz = 20;
        this.cGA = 36;
        this.radius = 0;
        this.view = view;
        this.cGx = getContext().getResources().getColor(R.color.black_alpha40);
        this.cGt.setColor(this.cGx);
        this.cGt.setAntiAlias(true);
        this.cGy = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.cGw = getContext().getResources().getColor(R.color.cp_cont_a);
        this.cGs.setColor(this.cGw);
        this.cGs.setTextSize(this.cGy);
        this.cGs.setAntiAlias(true);
        this.cGu = l.g(getContext(), R.dimen.tbds16);
        this.cGv = l.g(getContext(), R.dimen.tbds16);
        this.cGz = l.g(getContext(), R.dimen.tbds22);
        this.cGA = l.g(getContext(), R.dimen.tbds40);
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
            float measureText = this.cGs.measureText(str);
            float f = this.cGA + measureText;
            float f2 = this.cGy + this.cGz;
            canvas.translate((((right - left) - paddingRight) - f) - this.cGv, (((bottom - top) - paddingBottom) - f2) - this.cGu);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.cGt);
            Paint.FontMetrics fontMetrics = this.cGs.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.cGs);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.cGv = i;
        this.cGu = i2;
        invalidate();
    }

    public void lf(int i) {
        this.cGw = i;
        this.cGs.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.cGy = i;
        this.cGs.setTextSize(i);
        invalidate();
    }

    public float rG(String str) {
        return l.b(this.cGs, str).height() + this.cGz;
    }

    public float rH(String str) {
        return l.a(this.cGs, str) + this.cGA;
    }
}
