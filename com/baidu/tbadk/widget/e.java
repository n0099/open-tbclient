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
    protected final Paint bEV = new Paint();
    protected final Paint bEW = new Paint();
    private int bEX;
    private int bEY;
    private int bEZ;
    private int bFa;
    private int bFb;
    private int bFc;
    private int bFd;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public e(View view) {
        this.bEX = 16;
        this.bEY = 16;
        this.bEZ = -1;
        this.bFa = 1711276032;
        this.bFb = 20;
        this.bFc = 16;
        this.bFd = 32;
        this.view = view;
        this.bFa = getContext().getResources().getColor(d.C0141d.black_alpha40);
        this.bEW.setColor(this.bFa);
        this.bEW.setAntiAlias(true);
        this.bFb = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.bEZ = getContext().getResources().getColor(d.C0141d.cp_cont_i);
        this.bEV.setColor(this.bEZ);
        this.bEV.setTextSize(this.bFb);
        this.bEV.setAntiAlias(true);
        this.bEX = l.t(getContext(), d.e.tbds20);
        this.bEY = l.t(getContext(), d.e.tbds20);
        this.bFc = l.t(getContext(), d.e.ds16);
        this.bFd = l.t(getContext(), d.e.tbds40);
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
            float measureText = this.bEV.measureText(str);
            float f = this.bFd + measureText;
            float f2 = this.bFb + this.bFc;
            canvas.translate((((right - left) - paddingRight) - f) - this.bEY, (((bottom - top) - paddingBottom) - f2) - this.bEX);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bEW);
            Paint.FontMetrics fontMetrics = this.bEV.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bEV);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bEY = i;
        this.bEX = i2;
        invalidate();
    }

    public void ir(int i) {
        this.bEZ = i;
        this.bEV.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bFb = i;
        this.bEV.setTextSize(i);
        invalidate();
    }

    public float hy(String str) {
        return l.b(this.bEV, str).height() + this.bFc;
    }

    public float hz(String str) {
        return l.a(this.bEV, str) + this.bFd;
    }

    public void aN(int i, int i2) {
        this.bFd = i;
        this.bFc = i2;
    }
}
