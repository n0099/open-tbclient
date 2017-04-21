package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    public static final int cxM = w.e.cp_cont_f;
    private int clD;
    private final int cxN;
    private final Paint cxO;
    private final Paint cxP;
    private boolean cxQ;
    private final int cxR;
    private int cxS;
    private int cxT;
    private int cxU;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxQ = true;
        setWillNotDraw(false);
        this.cxN = getResources().getDimensionPixelSize(w.f.ds6);
        this.cxS = getResources().getDimensionPixelSize(w.f.ds20);
        this.cxO = new Paint();
        this.cxO.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
        this.cxP = new Paint();
        this.cxP.setColor(aq.getColor(w.e.cp_bg_line_b));
        this.cxR = getResources().getDimensionPixelSize(w.f.ds1);
    }

    public void e(int i, float f) {
        f(i, f);
        invalidate();
    }

    private void f(int i, float f) {
        View childAt = getChildAt(i);
        this.cxT = childAt.getLeft();
        this.cxU = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.cxT = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.cxT));
            this.cxU = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.cxU));
        }
    }

    public void g(int i, float f) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.clD);
        if (childAt != null) {
            i3 = childAt.getLeft();
            i2 = childAt.getWidth();
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (childAt2 != null) {
            i4 = childAt2.getLeft();
            i5 = childAt2.getWidth();
        } else {
            i4 = 0;
        }
        this.cxT = (int) (((i4 - i3) * f) + i3);
        this.cxU = ((int) ((i5 - i2) * f)) + i2 + this.cxT;
        invalidate();
    }

    public void av(int i, int i2) {
        if (i != i2) {
            this.clD = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof x) {
                    aq.c(((x) childAt).getTextView(), w.e.cp_link_tip_a, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof x) {
                    aq.c(((x) childAt2).getTextView(), cxM, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cxQ = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cxQ) {
                canvas.drawRect(0.0f, height - this.cxR, getRight(), height, this.cxP);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.cxU <= 0 && this.clD >= 0 && this.clD < getChildCount()) {
            this.cxU = getChildAt(this.clD).getRight();
        }
        int i2 = (((this.cxU - this.cxT) / 2) + this.cxT) - (this.cxS / 2);
        canvas.drawRect(i2, i - this.cxN, i2 + this.cxS, i, this.cxO);
    }

    public void onChangeSkinType(int i) {
        this.cxO.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
        this.cxP.setColor(aq.getColor(w.e.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.onChangeSkinType();
                    if (i2 == this.clD) {
                        aq.c(xVar.getTextView(), w.e.cp_link_tip_a, 1);
                    } else {
                        aq.c(xVar.getTextView(), cxM, 1);
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
