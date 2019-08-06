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
    protected final Paint cFB = new Paint();
    protected final Paint cFC = new Paint();
    private int cFD;
    private int cFE;
    private int cFF;
    private int cFG;
    private int cFH;
    private int cFI;
    private int cFJ;
    private int radius;
    protected final View view;

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public b(View view) {
        this.cFD = 16;
        this.cFE = 16;
        this.cFF = -1;
        this.cFG = 1711276032;
        this.cFH = 20;
        this.cFI = 20;
        this.cFJ = 36;
        this.radius = 0;
        this.view = view;
        this.cFG = getContext().getResources().getColor(R.color.black_alpha40);
        this.cFC.setColor(this.cFG);
        this.cFC.setAntiAlias(true);
        this.cFH = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.cFF = getContext().getResources().getColor(R.color.cp_btn_a);
        this.cFB.setColor(this.cFF);
        this.cFB.setTextSize(this.cFH);
        this.cFB.setAntiAlias(true);
        this.cFD = l.g(getContext(), R.dimen.tbds16);
        this.cFE = l.g(getContext(), R.dimen.tbds16);
        this.cFI = l.g(getContext(), R.dimen.tbds22);
        this.cFJ = l.g(getContext(), R.dimen.tbds40);
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
            float measureText = this.cFB.measureText(str);
            float f = this.cFJ + measureText;
            float f2 = this.cFH + this.cFI;
            canvas.translate((((right - left) - paddingRight) - f) - this.cFE, (((bottom - top) - paddingBottom) - f2) - this.cFD);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.cFC);
            Paint.FontMetrics fontMetrics = this.cFB.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.cFB);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.cFE = i;
        this.cFD = i2;
        invalidate();
    }

    public void lb(int i) {
        this.cFF = i;
        this.cFB.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.cFH = i;
        this.cFB.setTextSize(i);
        invalidate();
    }

    public float rv(String str) {
        return l.b(this.cFB, str).height() + this.cFI;
    }

    public float rw(String str) {
        return l.a(this.cFB, str) + this.cFJ;
    }
}
