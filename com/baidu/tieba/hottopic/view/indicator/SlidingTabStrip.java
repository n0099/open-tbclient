package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class SlidingTabStrip extends LinearLayout {
    private final int jdG;
    private final Paint jdH;
    private int jdI;
    private int jdJ;
    private final Paint mSelectedIndicatorPaint;
    private int mSelectedPosition;

    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.jdG = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.mSelectedIndicatorPaint = new Paint();
        this.mSelectedIndicatorPaint.setColor(ap.getSkinColor(null, R.color.cp_cont_b));
        this.jdH = new Paint();
        this.jdH.setColor(ap.getColor(R.color.cp_bg_line_c));
    }

    public void i(int i, float f) {
        j(i, f);
        invalidate();
    }

    private void j(int i, float f) {
        View childAt = getChildAt(i);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        if (i == 0) {
            this.jdI = childAt.getLeft();
        } else {
            this.jdI = childAt.getLeft() + dimensionPixelSize2;
        }
        this.jdJ = this.jdI + dimensionPixelSize;
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.jdI = (int) (((childAt2.getLeft() + dimensionPixelSize2) * f) + ((1.0f - f) * this.jdI));
            this.jdJ = (int) (((childAt2.getLeft() + dimensionPixelSize2 + dimensionPixelSize) * f) + ((1.0f - f) * this.jdJ));
        }
    }

    public void k(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds14);
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.mSelectedPosition);
        int left = childAt.getLeft();
        float left2 = (childAt2.getLeft() - left) * f;
        if (this.mSelectedPosition == 0) {
            this.jdI = (int) (left + left2);
        } else {
            this.jdI = (int) (dimensionPixelSize + left + left2);
        }
        this.jdJ = getResources().getDimensionPixelSize(R.dimen.ds64) + this.jdI;
        invalidate();
    }

    public void cG(int i, int i2) {
        if (i != i2) {
            this.mSelectedPosition = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof TabItemView) {
                    ap.setViewTextColor(((TabItemView) childAt).getTextView(), R.color.cp_cont_b, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof TabItemView) {
                    ap.setViewTextColor(((TabItemView) childAt2).getTextView(), R.color.cp_cont_j, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int childCount = getChildCount();
        if (canvas != null && childCount > 0) {
            b(canvas, getHeight());
        }
    }

    private void b(Canvas canvas, int i) {
        if (this.jdJ <= 0 && this.mSelectedPosition >= 0 && this.mSelectedPosition < getChildCount()) {
            this.jdJ = getChildAt(this.mSelectedPosition).getRight() - getResources().getDimensionPixelSize(R.dimen.ds14);
        }
        canvas.drawRoundRect(new RectF(this.jdI, i - this.jdG, this.jdJ, i), 10.0f, 10.0f, this.mSelectedIndicatorPaint);
    }

    public void onChangeSkinType(int i) {
        this.mSelectedIndicatorPaint.setColor(ap.getSkinColor(null, R.color.cp_cont_b));
        this.jdH.setColor(ap.getColor(R.color.cp_bg_line_c));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    tabItemView.onChangeSkinType();
                    if (i2 == this.mSelectedPosition) {
                        ap.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_b, 1);
                    } else {
                        ap.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_j, 1);
                    }
                }
            }
        }
    }
}
