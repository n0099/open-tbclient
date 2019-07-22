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
    private int cFA;
    private int cFB;
    private int cFC;
    protected final Paint cFu = new Paint();
    protected final Paint cFv = new Paint();
    private int cFw;
    private int cFx;
    private int cFy;
    private int cFz;
    private int radius;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.cFw = 16;
        this.cFx = 16;
        this.cFy = -1;
        this.cFz = 1711276032;
        this.cFA = 20;
        this.cFB = 20;
        this.cFC = 36;
        this.radius = 0;
        this.view = view;
        this.cFz = getContext().getResources().getColor(R.color.black_alpha40);
        this.cFv.setColor(this.cFz);
        this.cFv.setAntiAlias(true);
        this.cFA = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.cFy = getContext().getResources().getColor(R.color.cp_btn_a);
        this.cFu.setColor(this.cFy);
        this.cFu.setTextSize(this.cFA);
        this.cFu.setAntiAlias(true);
        this.cFw = l.g(getContext(), R.dimen.tbds16);
        this.cFx = l.g(getContext(), R.dimen.tbds16);
        this.cFB = l.g(getContext(), R.dimen.tbds22);
        this.cFC = l.g(getContext(), R.dimen.tbds40);
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
            float measureText = this.cFu.measureText(str);
            float f = this.cFC + measureText;
            float f2 = this.cFA + this.cFB;
            canvas.translate((((right - left) - paddingRight) - f) - this.cFx, (((bottom - top) - paddingBottom) - f2) - this.cFw);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.cFv);
            Paint.FontMetrics fontMetrics = this.cFu.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.cFu);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.cFx = i;
        this.cFw = i2;
        invalidate();
    }

    public void la(int i) {
        this.cFy = i;
        this.cFu.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.cFA = i;
        this.cFu.setTextSize(i);
        invalidate();
    }

    public float rv(String str) {
        return l.b(this.cFu, str).height() + this.cFB;
    }

    public float rw(String str) {
        return l.a(this.cFu, str) + this.cFC;
    }
}
