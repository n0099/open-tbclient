package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    public static final int cvw = r.e.cp_cont_f;
    private int cjp;
    private boolean cvA;
    private final int cvB;
    private int cvC;
    private int cvD;
    private int cvE;
    private final int cvx;
    private final Paint cvy;
    private final Paint cvz;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvA = true;
        setWillNotDraw(false);
        this.cvx = getResources().getDimensionPixelSize(r.f.ds6);
        this.cvC = getResources().getDimensionPixelSize(r.f.ds20);
        this.cvy = new Paint();
        this.cvy.setColor(ap.d((Resources) null, r.e.cp_link_tip_a));
        this.cvz = new Paint();
        this.cvz.setColor(ap.getColor(r.e.cp_bg_line_b));
        this.cvB = getResources().getDimensionPixelSize(r.f.ds1);
    }

    public void e(int i, float f) {
        f(i, f);
        invalidate();
    }

    private void f(int i, float f) {
        View childAt = getChildAt(i);
        this.cvD = childAt.getLeft();
        this.cvE = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.cvD = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.cvD));
            this.cvE = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.cvE));
        }
    }

    public void g(int i, float f) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.cjp);
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
        this.cvD = (int) (((i4 - i3) * f) + i3);
        this.cvE = ((int) ((i5 - i2) * f)) + i2 + this.cvD;
        invalidate();
    }

    public void au(int i, int i2) {
        if (i != i2) {
            this.cjp = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof x) {
                    ap.c(((x) childAt).getTextView(), r.e.cp_link_tip_a, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof x) {
                    ap.c(((x) childAt2).getTextView(), cvw, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cvA = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cvA) {
                canvas.drawRect(0.0f, height - this.cvB, getRight(), height, this.cvz);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.cvE <= 0 && this.cjp >= 0 && this.cjp < getChildCount()) {
            this.cvE = getChildAt(this.cjp).getRight();
        }
        int i2 = (((this.cvE - this.cvD) / 2) + this.cvD) - (this.cvC / 2);
        canvas.drawRect(i2, i - this.cvx, i2 + this.cvC, i, this.cvy);
    }

    public void onChangeSkinType(int i) {
        this.cvy.setColor(ap.d((Resources) null, r.e.cp_link_tip_a));
        this.cvz.setColor(ap.getColor(r.e.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.tg();
                    if (i2 == this.cjp) {
                        ap.c(xVar.getTextView(), r.e.cp_link_tip_a, 1);
                    } else {
                        ap.c(xVar.getTextView(), cvw, 1);
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
