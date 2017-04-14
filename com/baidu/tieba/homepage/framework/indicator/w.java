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
    public static final int cvv = w.e.cp_cont_f;
    private int cjm;
    private final int cvA;
    private int cvB;
    private int cvC;
    private int cvD;
    private final int cvw;
    private final Paint cvx;
    private final Paint cvy;
    private boolean cvz;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvz = true;
        setWillNotDraw(false);
        this.cvw = getResources().getDimensionPixelSize(w.f.ds6);
        this.cvB = getResources().getDimensionPixelSize(w.f.ds20);
        this.cvx = new Paint();
        this.cvx.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
        this.cvy = new Paint();
        this.cvy.setColor(aq.getColor(w.e.cp_bg_line_b));
        this.cvA = getResources().getDimensionPixelSize(w.f.ds1);
    }

    public void e(int i, float f) {
        f(i, f);
        invalidate();
    }

    private void f(int i, float f) {
        View childAt = getChildAt(i);
        this.cvC = childAt.getLeft();
        this.cvD = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.cvC = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.cvC));
            this.cvD = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.cvD));
        }
    }

    public void g(int i, float f) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.cjm);
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
        this.cvC = (int) (((i4 - i3) * f) + i3);
        this.cvD = ((int) ((i5 - i2) * f)) + i2 + this.cvC;
        invalidate();
    }

    public void av(int i, int i2) {
        if (i != i2) {
            this.cjm = i;
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
                    aq.c(((x) childAt2).getTextView(), cvv, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cvz = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cvz) {
                canvas.drawRect(0.0f, height - this.cvA, getRight(), height, this.cvy);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.cvD <= 0 && this.cjm >= 0 && this.cjm < getChildCount()) {
            this.cvD = getChildAt(this.cjm).getRight();
        }
        int i2 = (((this.cvD - this.cvC) / 2) + this.cvC) - (this.cvB / 2);
        canvas.drawRect(i2, i - this.cvw, i2 + this.cvB, i, this.cvx);
    }

    public void onChangeSkinType(int i) {
        this.cvx.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
        this.cvy.setColor(aq.getColor(w.e.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.onChangeSkinType();
                    if (i2 == this.cjm) {
                        aq.c(xVar.getTextView(), w.e.cp_link_tip_a, 1);
                    } else {
                        aq.c(xVar.getTextView(), cvv, 1);
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
