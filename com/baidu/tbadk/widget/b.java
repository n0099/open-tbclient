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
    protected final Paint bbL = new Paint();
    protected final Paint bbM = new Paint();
    private int bbN;
    private int bbO;
    private int bbP;
    private int bbQ;
    private int bbR;
    private int bbS;
    private int bbT;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.bbN = 16;
        this.bbO = 16;
        this.bbP = -1;
        this.bbQ = 1711276032;
        this.bbR = 20;
        this.bbS = 16;
        this.bbT = 32;
        this.view = view;
        this.bbQ = getContext().getResources().getColor(e.d.black_alpha40);
        this.bbM.setColor(this.bbQ);
        this.bbM.setAntiAlias(true);
        this.bbR = (int) getContext().getResources().getDimension(e.C0141e.tbfontsize26);
        this.bbP = getContext().getResources().getColor(e.d.cp_cont_i);
        this.bbL.setColor(this.bbP);
        this.bbL.setTextSize(this.bbR);
        this.bbL.setAntiAlias(true);
        this.bbN = l.h(getContext(), e.C0141e.tbds20);
        this.bbO = l.h(getContext(), e.C0141e.tbds20);
        this.bbS = l.h(getContext(), e.C0141e.ds16);
        this.bbT = l.h(getContext(), e.C0141e.tbds40);
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
            float measureText = this.bbL.measureText(str);
            float f = this.bbT + measureText;
            float f2 = this.bbR + this.bbS;
            canvas.translate((((right - left) - paddingRight) - f) - this.bbO, (((bottom - top) - paddingBottom) - f2) - this.bbN);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bbM);
            Paint.FontMetrics fontMetrics = this.bbL.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bbL);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bbO = i;
        this.bbN = i2;
        invalidate();
    }

    public void fG(int i) {
        this.bbP = i;
        this.bbL.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bbR = i;
        this.bbL.setTextSize(i);
        invalidate();
    }

    public float im(String str) {
        return l.b(this.bbL, str).height() + this.bbS;
    }

    public float in(String str) {
        return l.a(this.bbL, str) + this.bbT;
    }

    public void N(int i, int i2) {
        this.bbT = i;
        this.bbS = i2;
    }
}
