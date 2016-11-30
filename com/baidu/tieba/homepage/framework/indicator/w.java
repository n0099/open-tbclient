package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    public static final int cIZ = r.d.cp_cont_f;
    private final int cJa;
    private final Paint cJb;
    private final Paint cJc;
    private boolean cJd;
    private final int cJe;
    private int cJf;
    private int cJg;
    private int cJh;
    private int cxH;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJd = true;
        setWillNotDraw(false);
        this.cJa = getResources().getDimensionPixelSize(r.e.ds6);
        this.cJf = getResources().getDimensionPixelSize(r.e.ds20);
        this.cJb = new Paint();
        this.cJb.setColor(at.d((Resources) null, r.d.cp_link_tip_a));
        this.cJc = new Paint();
        this.cJc.setColor(at.getColor(r.d.cp_bg_line_b));
        this.cJe = getResources().getDimensionPixelSize(r.e.ds1);
    }

    public void c(int i, float f) {
        d(i, f);
        invalidate();
    }

    private void d(int i, float f) {
        View childAt = getChildAt(i);
        this.cJg = childAt.getLeft();
        this.cJh = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.cJg = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.cJg));
            this.cJh = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.cJh));
        }
    }

    public void e(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.cxH);
        int left = childAt.getLeft();
        this.cJg = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.cJh = width + ((int) ((childAt2.getWidth() - width) * f)) + this.cJg;
        invalidate();
    }

    public void az(int i, int i2) {
        if (i != i2) {
            this.cxH = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof x) {
                    at.c(((x) childAt).getTextView(), r.d.cp_link_tip_a, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof x) {
                    at.c(((x) childAt2).getTextView(), cIZ, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cJd = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cJd) {
                canvas.drawRect(0.0f, height - this.cJe, getRight(), height, this.cJc);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.cJh <= 0 && this.cxH >= 0 && this.cxH < getChildCount()) {
            this.cJh = getChildAt(this.cxH).getRight();
        }
        int i2 = (((this.cJh - this.cJg) / 2) + this.cJg) - (this.cJf / 2);
        canvas.drawRect(i2, i - this.cJa, i2 + this.cJf, i, this.cJb);
    }

    public void onChangeSkinType(int i) {
        this.cJb.setColor(at.d((Resources) null, r.d.cp_link_tip_a));
        this.cJc.setColor(at.getColor(r.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x) {
                    x xVar = (x) childAt;
                    xVar.tB();
                    if (i2 == this.cxH) {
                        at.c(xVar.getTextView(), r.d.cp_link_tip_a, 1);
                    } else {
                        at.c(xVar.getTextView(), cIZ, 1);
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
