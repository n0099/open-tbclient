package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class SlidingTabStrip extends LinearLayout {
    private final int iOH;
    private final Paint iOI;
    private int iOJ;
    private int iOK;
    private final Paint mSelectedIndicatorPaint;
    private int mSelectedPosition;

    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.iOH = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.mSelectedIndicatorPaint = new Paint();
        this.mSelectedIndicatorPaint.setColor(ao.getSkinColor(null, R.color.cp_cont_b));
        this.iOI = new Paint();
        this.iOI.setColor(ao.getColor(R.color.cp_bg_line_c));
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
            this.iOJ = childAt.getLeft();
        } else {
            this.iOJ = childAt.getLeft() + dimensionPixelSize2;
        }
        this.iOK = this.iOJ + dimensionPixelSize;
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.iOJ = (int) (((childAt2.getLeft() + dimensionPixelSize2) * f) + ((1.0f - f) * this.iOJ));
            this.iOK = (int) (((childAt2.getLeft() + dimensionPixelSize2 + dimensionPixelSize) * f) + ((1.0f - f) * this.iOK));
        }
    }

    public void k(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds14);
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.mSelectedPosition);
        int left = childAt.getLeft();
        float left2 = (childAt2.getLeft() - left) * f;
        if (this.mSelectedPosition == 0) {
            this.iOJ = (int) (left + left2);
        } else {
            this.iOJ = (int) (dimensionPixelSize + left + left2);
        }
        this.iOK = getResources().getDimensionPixelSize(R.dimen.ds64) + this.iOJ;
        invalidate();
    }

    public void cy(int i, int i2) {
        if (i != i2) {
            this.mSelectedPosition = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof TabItemView) {
                    ao.setViewTextColor(((TabItemView) childAt).getTextView(), R.color.cp_cont_b, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof TabItemView) {
                    ao.setViewTextColor(((TabItemView) childAt2).getTextView(), R.color.cp_cont_j, 1);
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
            a(canvas, getHeight());
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.iOK <= 0 && this.mSelectedPosition >= 0 && this.mSelectedPosition < getChildCount()) {
            this.iOK = getChildAt(this.mSelectedPosition).getRight() - getResources().getDimensionPixelSize(R.dimen.ds14);
        }
        canvas.drawRoundRect(new RectF(this.iOJ, i - this.iOH, this.iOK, i), 10.0f, 10.0f, this.mSelectedIndicatorPaint);
    }

    public void onChangeSkinType(int i) {
        this.mSelectedIndicatorPaint.setColor(ao.getSkinColor(null, R.color.cp_cont_b));
        this.iOI.setColor(ao.getColor(R.color.cp_bg_line_c));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    tabItemView.onChangeSkinType();
                    if (i2 == this.mSelectedPosition) {
                        ao.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_b, 1);
                    } else {
                        ao.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_j, 1);
                    }
                }
            }
        }
    }
}
