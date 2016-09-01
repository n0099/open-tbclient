package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    public static final int cDi = t.d.cp_cont_f;
    private final int cDj;
    private final Paint cDk;
    private final Paint cDl;
    private boolean cDm;
    private final int cDn;
    private int cDo;
    private int cDp;
    private int csf;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cDm = true;
        setWillNotDraw(false);
        this.cDj = getResources().getDimensionPixelSize(t.e.ds6);
        this.cDk = new Paint();
        this.cDk.setColor(av.d((Resources) null, t.d.cp_link_tip_a));
        this.cDl = new Paint();
        this.cDl.setColor(av.getColor(t.d.cp_bg_line_b));
        this.cDn = getResources().getDimensionPixelSize(t.e.ds1);
    }

    public void c(int i, float f) {
        d(i, f);
        invalidate();
    }

    private void d(int i, float f) {
        View childAt = getChildAt(i);
        this.cDo = childAt.getLeft();
        this.cDp = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.cDo = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.cDo));
            this.cDp = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.cDp));
        }
    }

    public void e(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.csf);
        int left = childAt.getLeft();
        this.cDo = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.cDp = width + ((int) ((childAt2.getWidth() - width) * f)) + this.cDo;
        invalidate();
    }

    public void ax(int i, int i2) {
        if (i != i2) {
            this.csf = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof x) {
                    av.c(((x) childAt).getTextView(), t.d.cp_link_tip_a, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof x) {
                    av.c(((x) childAt2).getTextView(), cDi, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cDm = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cDm) {
                canvas.drawRect(0.0f, height - this.cDn, getRight(), height, this.cDl);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.cDp <= 0 && this.csf >= 0 && this.csf < getChildCount()) {
            this.cDp = getChildAt(this.csf).getRight();
        }
        canvas.drawRect(this.cDo, i - this.cDj, this.cDp, i, this.cDk);
    }

    public void onChangeSkinType(int i) {
        this.cDk.setColor(av.d((Resources) null, t.d.cp_link_tip_a));
        this.cDl.setColor(av.getColor(t.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.ti();
                    if (i2 == this.csf) {
                        av.c(xVar.getTextView(), t.d.cp_link_tip_a, 1);
                    } else {
                        av.c(xVar.getTextView(), cDi, 1);
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
