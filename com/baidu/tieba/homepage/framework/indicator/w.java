package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    public static final int csa = u.d.cp_cont_f;
    private int cgS;
    private final int csb;
    private final Paint csc;
    private final Paint csd;
    private boolean cse;
    private final int csf;
    private int csg;
    private int csh;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cse = true;
        setWillNotDraw(false);
        this.csb = getResources().getDimensionPixelSize(u.e.ds6);
        this.csc = new Paint();
        this.csc.setColor(av.d((Resources) null, u.d.cp_link_tip_a));
        this.csd = new Paint();
        this.csd.setColor(av.getColor(u.d.cp_bg_line_b));
        this.csf = getResources().getDimensionPixelSize(u.e.ds1);
    }

    public void c(int i, float f) {
        d(i, f);
        invalidate();
    }

    private void d(int i, float f) {
        View childAt = getChildAt(i);
        this.csg = childAt.getLeft();
        this.csh = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.csg = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.csg));
            this.csh = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.csh));
        }
    }

    public void e(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.cgS);
        int left = childAt.getLeft();
        this.csg = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.csh = width + ((int) ((childAt2.getWidth() - width) * f)) + this.csg;
        invalidate();
    }

    public void at(int i, int i2) {
        if (i != i2) {
            this.cgS = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof x) {
                    av.c(((x) childAt).getTextView(), u.d.cp_link_tip_a, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof x) {
                    av.c(((x) childAt2).getTextView(), csa, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cse = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cse) {
                canvas.drawRect(0.0f, height - this.csf, getRight(), height, this.csd);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.csh <= 0 && this.cgS >= 0 && this.cgS < getChildCount()) {
            this.csh = getChildAt(this.cgS).getRight();
        }
        canvas.drawRect(this.csg, i - this.csb, this.csh, i, this.csc);
    }

    public void onChangeSkinType(int i) {
        this.csc.setColor(av.d((Resources) null, u.d.cp_link_tip_a));
        this.csd.setColor(av.getColor(u.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.sd();
                    if (i2 == this.cgS) {
                        av.c(xVar.getTextView(), u.d.cp_link_tip_a, 1);
                    } else {
                        av.c(xVar.getTextView(), csa, 1);
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
