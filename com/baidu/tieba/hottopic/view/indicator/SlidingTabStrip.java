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
/* loaded from: classes8.dex */
public class SlidingTabStrip extends LinearLayout {
    private final Paint Zy;
    private final int kvn;
    private final Paint kvo;
    private int kvp;
    private int kvq;
    private int mSelectedPosition;

    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.kvn = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.Zy = new Paint();
        this.Zy.setColor(ao.getSkinColor(null, R.color.CAM_X0105));
        this.kvo = new Paint();
        this.kvo.setColor(ao.getColor(R.color.CAM_X0204));
    }

    public void j(int i, float f) {
        k(i, f);
        invalidate();
    }

    private void k(int i, float f) {
        View childAt = getChildAt(i);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        if (i == 0) {
            this.kvp = childAt.getLeft();
        } else {
            this.kvp = childAt.getLeft() + dimensionPixelSize2;
        }
        this.kvq = this.kvp + dimensionPixelSize;
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.kvp = (int) (((childAt2.getLeft() + dimensionPixelSize2) * f) + ((1.0f - f) * this.kvp));
            this.kvq = (int) (((childAt2.getLeft() + dimensionPixelSize2 + dimensionPixelSize) * f) + ((1.0f - f) * this.kvq));
        }
    }

    public void l(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds14);
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.mSelectedPosition);
        int left = childAt.getLeft();
        float left2 = (childAt2.getLeft() - left) * f;
        if (this.mSelectedPosition == 0) {
            this.kvp = (int) (left + left2);
        } else {
            this.kvp = (int) (dimensionPixelSize + left + left2);
        }
        this.kvq = getResources().getDimensionPixelSize(R.dimen.ds64) + this.kvp;
        invalidate();
    }

    public void cQ(int i, int i2) {
        if (i != i2) {
            this.mSelectedPosition = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof TabItemView) {
                    ao.setViewTextColor(((TabItemView) childAt).getTextView(), R.color.CAM_X0105, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof TabItemView) {
                    ao.setViewTextColor(((TabItemView) childAt2).getTextView(), R.color.CAM_X0107, 1);
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
            c(canvas, getHeight());
        }
    }

    private void c(Canvas canvas, int i) {
        if (this.kvq <= 0 && this.mSelectedPosition >= 0 && this.mSelectedPosition < getChildCount()) {
            this.kvq = getChildAt(this.mSelectedPosition).getRight() - getResources().getDimensionPixelSize(R.dimen.ds14);
        }
        canvas.drawRoundRect(new RectF(this.kvp, i - this.kvn, this.kvq, i), 10.0f, 10.0f, this.Zy);
    }

    public void onChangeSkinType(int i) {
        this.Zy.setColor(ao.getSkinColor(null, R.color.CAM_X0105));
        this.kvo.setColor(ao.getColor(R.color.CAM_X0204));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    tabItemView.onChangeSkinType();
                    if (i2 == this.mSelectedPosition) {
                        ao.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
                    } else {
                        ao.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
                    }
                }
            }
        }
    }
}
