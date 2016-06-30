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
public class p extends LinearLayout {
    public static final int cpB = u.d.cp_cont_f;
    private int ceR;
    private final int cpC;
    private final Paint cpD;
    private final Paint cpE;
    private boolean cpF;
    private final int cpG;
    private int cpH;
    private int cpI;

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cpF = true;
        setWillNotDraw(false);
        this.cpC = getResources().getDimensionPixelSize(u.e.ds6);
        this.cpD = new Paint();
        this.cpD.setColor(av.d((Resources) null, u.d.cp_link_tip_a));
        this.cpE = new Paint();
        this.cpE.setColor(av.getColor(u.d.cp_bg_line_b));
        this.cpG = getResources().getDimensionPixelSize(u.e.ds1);
    }

    public void c(int i, float f) {
        d(i, f);
        invalidate();
    }

    private void d(int i, float f) {
        View childAt = getChildAt(i);
        this.cpH = childAt.getLeft();
        this.cpI = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.cpH = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.cpH));
            this.cpI = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.cpI));
        }
    }

    public void e(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.ceR);
        int left = childAt.getLeft();
        this.cpH = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.cpI = width + ((int) ((childAt2.getWidth() - width) * f)) + this.cpH;
        invalidate();
    }

    public void aq(int i, int i2) {
        if (i != i2) {
            this.ceR = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof q) {
                    av.c(((q) childAt).getTextView(), u.d.cp_link_tip_a, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof q) {
                    av.c(((q) childAt2).getTextView(), cpB, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cpF = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cpF) {
                canvas.drawRect(0.0f, height - this.cpG, getRight(), height, this.cpE);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.cpI <= 0 && this.ceR >= 0 && this.ceR < getChildCount()) {
            this.cpI = getChildAt(this.ceR).getRight();
        }
        canvas.drawRect(this.cpH, i - this.cpC, this.cpI, i, this.cpD);
    }

    public void onChangeSkinType(int i) {
        this.cpD.setColor(av.d((Resources) null, u.d.cp_link_tip_a));
        this.cpE.setColor(av.getColor(u.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof q) {
                    q qVar = (q) childAt;
                    qVar.se();
                    if (i2 == this.ceR) {
                        av.c(qVar.getTextView(), u.d.cp_link_tip_a, 1);
                    } else {
                        av.c(qVar.getTextView(), cpB, 1);
                    }
                }
            }
        }
    }
}
