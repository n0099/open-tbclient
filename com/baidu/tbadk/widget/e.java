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
    protected final Paint bCT = new Paint();
    protected final Paint bCU = new Paint();
    private int bCV;
    private int bCW;
    private int bCX;
    private int bCY;
    private int bCZ;
    private int bDa;
    private int bDb;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public e(View view) {
        this.bCV = 16;
        this.bCW = 16;
        this.bCX = -1;
        this.bCY = 1711276032;
        this.bCZ = 20;
        this.bDa = 16;
        this.bDb = 32;
        this.view = view;
        this.bCY = getContext().getResources().getColor(d.C0107d.black_alpha40);
        this.bCU.setColor(this.bCY);
        this.bCU.setAntiAlias(true);
        this.bCZ = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.bCX = getContext().getResources().getColor(d.C0107d.cp_cont_i);
        this.bCT.setColor(this.bCX);
        this.bCT.setTextSize(this.bCZ);
        this.bCT.setAntiAlias(true);
        this.bCV = l.s(getContext(), d.e.tbds20);
        this.bCW = l.s(getContext(), d.e.tbds20);
        this.bDa = l.s(getContext(), d.e.ds16);
        this.bDb = l.s(getContext(), d.e.tbds40);
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
            float measureText = this.bCT.measureText(str);
            float f = this.bDb + measureText;
            float f2 = this.bCZ + this.bDa;
            canvas.translate((((right - left) - paddingRight) - f) - this.bCW, (((bottom - top) - paddingBottom) - f2) - this.bCV);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bCU);
            Paint.FontMetrics fontMetrics = this.bCT.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bCT);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bCW = i;
        this.bCV = i2;
        invalidate();
    }

    public void iu(int i) {
        this.bCX = i;
        this.bCT.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bCZ = i;
        this.bCT.setTextSize(i);
        invalidate();
    }

    public float hh(String str) {
        return l.b(this.bCT, str).height() + this.bDa;
    }

    public float hi(String str) {
        return l.a(this.bCT, str) + this.bDb;
    }

    public void aN(int i, int i2) {
        this.bDb = i;
        this.bDa = i2;
    }
}
