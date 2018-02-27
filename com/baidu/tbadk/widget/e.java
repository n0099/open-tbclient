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
    protected final Paint bES = new Paint();
    protected final Paint bET = new Paint();
    private int bEU;
    private int bEV;
    private int bEW;
    private int bEX;
    private int bEY;
    private int bEZ;
    private int bFa;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public e(View view) {
        this.bEU = 16;
        this.bEV = 16;
        this.bEW = -1;
        this.bEX = 1711276032;
        this.bEY = 20;
        this.bEZ = 16;
        this.bFa = 32;
        this.view = view;
        this.bEX = getContext().getResources().getColor(d.C0141d.black_alpha40);
        this.bET.setColor(this.bEX);
        this.bET.setAntiAlias(true);
        this.bEY = (int) getContext().getResources().getDimension(d.e.tbfontsize26);
        this.bEW = getContext().getResources().getColor(d.C0141d.cp_cont_i);
        this.bES.setColor(this.bEW);
        this.bES.setTextSize(this.bEY);
        this.bES.setAntiAlias(true);
        this.bEU = l.t(getContext(), d.e.tbds20);
        this.bEV = l.t(getContext(), d.e.tbds20);
        this.bEZ = l.t(getContext(), d.e.ds16);
        this.bFa = l.t(getContext(), d.e.tbds40);
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
            float measureText = this.bES.measureText(str);
            float f = this.bFa + measureText;
            float f2 = this.bEY + this.bEZ;
            canvas.translate((((right - left) - paddingRight) - f) - this.bEV, (((bottom - top) - paddingBottom) - f2) - this.bEU);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bET);
            Paint.FontMetrics fontMetrics = this.bES.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bES);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bEV = i;
        this.bEU = i2;
        invalidate();
    }

    public void ir(int i) {
        this.bEW = i;
        this.bES.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bEY = i;
        this.bES.setTextSize(i);
        invalidate();
    }

    public float hy(String str) {
        return l.b(this.bES, str).height() + this.bEZ;
    }

    public float hz(String str) {
        return l.a(this.bES, str) + this.bFa;
    }

    public void aN(int i, int i2) {
        this.bFa = i;
        this.bEZ = i2;
    }
}
