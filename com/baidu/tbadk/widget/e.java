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
    protected final Paint bDb = new Paint();
    protected final Paint bDc = new Paint();
    private int bDd;
    private int bDe;
    private int bDf;
    private int bDg;
    private int bDh;
    private int bDi;
    private int bDj;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public e(View view) {
        this.bDd = 16;
        this.bDe = 16;
        this.bDf = -1;
        this.bDg = 1711276032;
        this.bDh = 20;
        this.bDi = 16;
        this.bDj = 32;
        this.view = view;
        this.bDg = getContext().getResources().getColor(d.C0108d.black_alpha40);
        this.bDc.setColor(this.bDg);
        this.bDc.setAntiAlias(true);
        this.bDh = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.bDf = getContext().getResources().getColor(d.C0108d.cp_cont_i);
        this.bDb.setColor(this.bDf);
        this.bDb.setTextSize(this.bDh);
        this.bDb.setAntiAlias(true);
        this.bDd = l.s(getContext(), d.e.tbds20);
        this.bDe = l.s(getContext(), d.e.tbds20);
        this.bDi = l.s(getContext(), d.e.ds16);
        this.bDj = l.s(getContext(), d.e.tbds40);
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
            float measureText = this.bDb.measureText(str);
            float f = this.bDj + measureText;
            float f2 = this.bDh + this.bDi;
            canvas.translate((((right - left) - paddingRight) - f) - this.bDe, (((bottom - top) - paddingBottom) - f2) - this.bDd);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bDc);
            Paint.FontMetrics fontMetrics = this.bDb.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bDb);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bDe = i;
        this.bDd = i2;
        invalidate();
    }

    public void iu(int i) {
        this.bDf = i;
        this.bDb.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bDh = i;
        this.bDb.setTextSize(i);
        invalidate();
    }

    public float hp(String str) {
        return l.b(this.bDb, str).height() + this.bDi;
    }

    public float hq(String str) {
        return l.a(this.bDb, str) + this.bDj;
    }

    public void aN(int i, int i2) {
        this.bDj = i;
        this.bDi = i2;
    }
}
