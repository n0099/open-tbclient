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
public class b {
    private int aPA;
    private int aPB;
    private int aPC;
    private int aPD;
    private int aPE;
    protected final Paint aPw = new Paint();
    protected final Paint aPx = new Paint();
    private int aPy;
    private int aPz;

    /* renamed from: view  reason: collision with root package name */
    protected final View f8view;

    private Context getContext() {
        return (this.f8view == null || this.f8view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.f8view.getContext();
    }

    public b(View view2) {
        this.aPy = 16;
        this.aPz = 16;
        this.aPA = -1;
        this.aPB = 1711276032;
        this.aPC = 20;
        this.aPD = 16;
        this.aPE = 32;
        this.f8view = view2;
        this.aPB = getContext().getResources().getColor(d.C0126d.black_alpha40);
        this.aPx.setColor(this.aPB);
        this.aPx.setAntiAlias(true);
        this.aPC = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.aPA = getContext().getResources().getColor(d.C0126d.cp_cont_i);
        this.aPw.setColor(this.aPA);
        this.aPw.setTextSize(this.aPC);
        this.aPw.setAntiAlias(true);
        this.aPy = l.e(getContext(), d.e.tbds20);
        this.aPz = l.e(getContext(), d.e.tbds20);
        this.aPD = l.e(getContext(), d.e.ds16);
        this.aPE = l.e(getContext(), d.e.tbds40);
    }

    public void c(Canvas canvas, String str) {
        if (canvas != null && this.f8view != null && !TextUtils.isEmpty(str)) {
            int save = canvas.save();
            this.f8view.getPaddingLeft();
            int paddingRight = this.f8view.getPaddingRight();
            this.f8view.getPaddingTop();
            int paddingBottom = this.f8view.getPaddingBottom();
            int left = this.f8view.getLeft();
            int right = this.f8view.getRight();
            int top = this.f8view.getTop();
            int bottom = this.f8view.getBottom();
            float measureText = this.aPw.measureText(str);
            float f = this.aPE + measureText;
            float f2 = this.aPC + this.aPD;
            canvas.translate((((right - left) - paddingRight) - f) - this.aPz, (((bottom - top) - paddingBottom) - f2) - this.aPy);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aPx);
            Paint.FontMetrics fontMetrics = this.aPw.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aPw);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.f8view != null) {
            this.f8view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aPz = i;
        this.aPy = i2;
        invalidate();
    }

    public void fs(int i) {
        this.aPA = i;
        this.aPw.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aPC = i;
        this.aPw.setTextSize(i);
        invalidate();
    }

    public float hs(String str) {
        return l.b(this.aPw, str).height() + this.aPD;
    }

    public float ht(String str) {
        return l.a(this.aPw, str) + this.aPE;
    }

    public void J(int i, int i2) {
        this.aPE = i;
        this.aPD = i2;
    }
}
