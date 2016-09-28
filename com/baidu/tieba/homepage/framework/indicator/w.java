package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    public static final int cDM = r.d.cp_cont_f;
    private final int cDN;
    private final Paint cDO;
    private final Paint cDP;
    private boolean cDQ;
    private final int cDR;
    private int cDS;
    private int cDT;
    private int csC;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cDQ = true;
        setWillNotDraw(false);
        this.cDN = getResources().getDimensionPixelSize(r.e.ds6);
        this.cDO = new Paint();
        this.cDO.setColor(av.d((Resources) null, r.d.cp_link_tip_a));
        this.cDP = new Paint();
        this.cDP.setColor(av.getColor(r.d.cp_bg_line_b));
        this.cDR = getResources().getDimensionPixelSize(r.e.ds1);
    }

    public void c(int i, float f) {
        d(i, f);
        invalidate();
    }

    private void d(int i, float f) {
        View childAt = getChildAt(i);
        this.cDS = childAt.getLeft();
        this.cDT = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.cDS = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.cDS));
            this.cDT = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.cDT));
        }
    }

    public void e(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.csC);
        int left = childAt.getLeft();
        this.cDS = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.cDT = width + ((int) ((childAt2.getWidth() - width) * f)) + this.cDS;
        invalidate();
    }

    public void ay(int i, int i2) {
        if (i != i2) {
            this.csC = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof x) {
                    av.c(((x) childAt).getTextView(), r.d.cp_link_tip_a, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof x) {
                    av.c(((x) childAt2).getTextView(), cDM, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cDQ = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cDQ) {
                canvas.drawRect(0.0f, height - this.cDR, getRight(), height, this.cDP);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.cDT <= 0 && this.csC >= 0 && this.csC < getChildCount()) {
            this.cDT = getChildAt(this.csC).getRight();
        }
        canvas.drawRect(this.cDS, i - this.cDN, this.cDT, i, this.cDO);
    }

    public void onChangeSkinType(int i) {
        this.cDO.setColor(av.d((Resources) null, r.d.cp_link_tip_a));
        this.cDP.setColor(av.getColor(r.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.tx();
                    if (i2 == this.csC) {
                        av.c(xVar.getTextView(), r.d.cp_link_tip_a, 1);
                    } else {
                        av.c(xVar.getTextView(), cDM, 1);
                    }
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
