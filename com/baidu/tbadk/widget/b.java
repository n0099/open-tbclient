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
    protected final Paint bgX = new Paint();
    protected final Paint bgY = new Paint();
    private int bgZ;
    private int bha;
    private int bhb;
    private int bhc;
    private int bhd;
    private int bhe;
    private int bhf;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.bgZ = 16;
        this.bha = 16;
        this.bhb = -1;
        this.bhc = 1711276032;
        this.bhd = 20;
        this.bhe = 16;
        this.bhf = 32;
        this.view = view;
        this.bhc = getContext().getResources().getColor(e.d.black_alpha40);
        this.bgY.setColor(this.bhc);
        this.bgY.setAntiAlias(true);
        this.bhd = (int) getContext().getResources().getDimension(e.C0200e.tbfontsize26);
        this.bhb = getContext().getResources().getColor(e.d.cp_cont_i);
        this.bgX.setColor(this.bhb);
        this.bgX.setTextSize(this.bhd);
        this.bgX.setAntiAlias(true);
        this.bgZ = l.h(getContext(), e.C0200e.tbds20);
        this.bha = l.h(getContext(), e.C0200e.tbds20);
        this.bhe = l.h(getContext(), e.C0200e.ds16);
        this.bhf = l.h(getContext(), e.C0200e.tbds40);
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
            float measureText = this.bgX.measureText(str);
            float f = this.bhf + measureText;
            float f2 = this.bhd + this.bhe;
            canvas.translate((((right - left) - paddingRight) - f) - this.bha, (((bottom - top) - paddingBottom) - f2) - this.bgZ);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.bgY);
            Paint.FontMetrics fontMetrics = this.bgX.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.bgX);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.bha = i;
        this.bgZ = i2;
        invalidate();
    }

    public void gd(int i) {
        this.bhb = i;
        this.bgX.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.bhd = i;
        this.bgX.setTextSize(i);
        invalidate();
    }

    public float iB(String str) {
        return l.b(this.bgX, str).height() + this.bhe;
    }

    public float iC(String str) {
        return l.a(this.bgX, str) + this.bhf;
    }

    public void N(int i, int i2) {
        this.bhf = i;
        this.bhe = i2;
    }
}
