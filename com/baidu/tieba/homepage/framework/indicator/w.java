package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    public static final int cou = r.d.cp_cont_f;
    private int ccS;
    private int coA;
    private int coB;
    private int coC;
    private final int cov;
    private final Paint cow;
    private final Paint cox;
    private boolean coy;
    private final int coz;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coy = true;
        setWillNotDraw(false);
        this.cov = getResources().getDimensionPixelSize(r.e.ds6);
        this.coA = getResources().getDimensionPixelSize(r.e.ds20);
        this.cow = new Paint();
        this.cow.setColor(ar.d((Resources) null, r.d.cp_link_tip_a));
        this.cox = new Paint();
        this.cox.setColor(ar.getColor(r.d.cp_bg_line_b));
        this.coz = getResources().getDimensionPixelSize(r.e.ds1);
    }

    public void d(int i, float f) {
        e(i, f);
        invalidate();
    }

    private void e(int i, float f) {
        View childAt = getChildAt(i);
        this.coB = childAt.getLeft();
        this.coC = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.coB = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.coB));
            this.coC = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.coC));
        }
    }

    public void f(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.ccS);
        int left = childAt.getLeft();
        this.coB = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.coC = width + ((int) ((childAt2.getWidth() - width) * f)) + this.coB;
        invalidate();
    }

    public void au(int i, int i2) {
        if (i != i2) {
            this.ccS = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof x) {
                    ar.c(((x) childAt).getTextView(), r.d.cp_link_tip_a, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof x) {
                    ar.c(((x) childAt2).getTextView(), cou, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.coy = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.coy) {
                canvas.drawRect(0.0f, height - this.coz, getRight(), height, this.cox);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.coC <= 0 && this.ccS >= 0 && this.ccS < getChildCount()) {
            this.coC = getChildAt(this.ccS).getRight();
        }
        int i2 = (((this.coC - this.coB) / 2) + this.coB) - (this.coA / 2);
        canvas.drawRect(i2, i - this.cov, i2 + this.coA, i, this.cow);
    }

    public void onChangeSkinType(int i) {
        this.cow.setColor(ar.d((Resources) null, r.d.cp_link_tip_a));
        this.cox.setColor(ar.getColor(r.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.tm();
                    if (i2 == this.ccS) {
                        ar.c(xVar.getTextView(), r.d.cp_link_tip_a, 1);
                    } else {
                        ar.c(xVar.getTextView(), cou, 1);
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
