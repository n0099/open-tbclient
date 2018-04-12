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
    protected final Paint aPv = new Paint();
    protected final Paint aPw = new Paint();
    private int aPx;
    private int aPy;
    private int aPz;

    /* renamed from: view  reason: collision with root package name */
    protected final View f8view;

    private Context getContext() {
        return (this.f8view == null || this.f8view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.f8view.getContext();
    }

    public b(View view2) {
        this.aPx = 16;
        this.aPy = 16;
        this.aPz = -1;
        this.aPA = 1711276032;
        this.aPB = 20;
        this.aPC = 16;
        this.aPD = 32;
        this.f8view = view2;
        this.aPA = getContext().getResources().getColor(d.C0126d.black_alpha40);
        this.aPw.setColor(this.aPA);
        this.aPw.setAntiAlias(true);
        this.aPB = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.aPz = getContext().getResources().getColor(d.C0126d.cp_cont_i);
        this.aPv.setColor(this.aPz);
        this.aPv.setTextSize(this.aPB);
        this.aPv.setAntiAlias(true);
        this.aPx = l.e(getContext(), d.e.tbds20);
        this.aPy = l.e(getContext(), d.e.tbds20);
        this.aPC = l.e(getContext(), d.e.ds16);
        this.aPD = l.e(getContext(), d.e.tbds40);
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
            float measureText = this.aPv.measureText(str);
            float f = this.aPD + measureText;
            float f2 = this.aPB + this.aPC;
            canvas.translate((((right - left) - paddingRight) - f) - this.aPy, (((bottom - top) - paddingBottom) - f2) - this.aPx);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.aPw);
            Paint.FontMetrics fontMetrics = this.aPv.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.aPv);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.f8view != null) {
            this.f8view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.aPy = i;
        this.aPx = i2;
        invalidate();
    }

    public void fs(int i) {
        this.aPz = i;
        this.aPv.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.aPB = i;
        this.aPv.setTextSize(i);
        invalidate();
    }

    public float hr(String str) {
        return l.b(this.aPv, str).height() + this.aPC;
    }

    public float hs(String str) {
        return l.a(this.aPv, str) + this.aPD;
    }

    public void J(int i, int i2) {
        this.aPD = i;
        this.aPC = i2;
    }
}
