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
    public static final int cwV = w.e.cp_cont_f;
    private int ckM;
    private final int cwW;
    private final Paint cwX;
    private final Paint cwY;
    private boolean cwZ;
    private final int cxa;
    private int cxb;
    private int cxc;
    private int cxd;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cwZ = true;
        setWillNotDraw(false);
        this.cwW = getResources().getDimensionPixelSize(w.f.ds6);
        this.cxb = getResources().getDimensionPixelSize(w.f.ds20);
        this.cwX = new Paint();
        this.cwX.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
        this.cwY = new Paint();
        this.cwY.setColor(aq.getColor(w.e.cp_bg_line_b));
        this.cxa = getResources().getDimensionPixelSize(w.f.ds1);
    }

    public void e(int i, float f) {
        f(i, f);
        invalidate();
    }

    private void f(int i, float f) {
        View childAt = getChildAt(i);
        this.cxc = childAt.getLeft();
        this.cxd = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.cxc = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.cxc));
            this.cxd = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.cxd));
        }
    }

    public void g(int i, float f) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.ckM);
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
        this.cxc = (int) (((i4 - i3) * f) + i3);
        this.cxd = ((int) ((i5 - i2) * f)) + i2 + this.cxc;
        invalidate();
    }

    public void ax(int i, int i2) {
        if (i != i2) {
            this.ckM = i;
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
                    aq.c(((x) childAt2).getTextView(), cwV, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cwZ = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cwZ) {
                canvas.drawRect(0.0f, height - this.cxa, getRight(), height, this.cwY);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.cxd <= 0 && this.ckM >= 0 && this.ckM < getChildCount()) {
            this.cxd = getChildAt(this.ckM).getRight();
        }
        int i2 = (((this.cxd - this.cxc) / 2) + this.cxc) - (this.cxb / 2);
        canvas.drawRect(i2, i - this.cwW, i2 + this.cxb, i, this.cwX);
    }

    public void onChangeSkinType(int i) {
        this.cwX.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
        this.cwY.setColor(aq.getColor(w.e.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.tD();
                    if (i2 == this.ckM) {
                        aq.c(xVar.getTextView(), w.e.cp_link_tip_a, 1);
                    } else {
                        aq.c(xVar.getTextView(), cwV, 1);
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
