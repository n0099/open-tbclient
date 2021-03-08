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
/* loaded from: classes7.dex */
public class SlidingTabStrip extends LinearLayout {
    private final Paint aaK;
    private final int kBf;
    private final Paint kBg;
    private int kBh;
    private int kBi;
    private int mSelectedPosition;

    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.kBf = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.aaK = new Paint();
        this.aaK.setColor(ap.getSkinColor(null, R.color.CAM_X0105));
        this.kBg = new Paint();
        this.kBg.setColor(ap.getColor(R.color.CAM_X0204));
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
            this.kBh = childAt.getLeft();
        } else {
            this.kBh = childAt.getLeft() + dimensionPixelSize2;
        }
        this.kBi = this.kBh + dimensionPixelSize;
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.kBh = (int) (((childAt2.getLeft() + dimensionPixelSize2) * f) + ((1.0f - f) * this.kBh));
            this.kBi = (int) (((childAt2.getLeft() + dimensionPixelSize2 + dimensionPixelSize) * f) + ((1.0f - f) * this.kBi));
        }
    }

    public void k(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds14);
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.mSelectedPosition);
        int left = childAt.getLeft();
        float left2 = (childAt2.getLeft() - left) * f;
        if (this.mSelectedPosition == 0) {
            this.kBh = (int) (left + left2);
        } else {
            this.kBh = (int) (dimensionPixelSize + left + left2);
        }
        this.kBi = getResources().getDimensionPixelSize(R.dimen.ds64) + this.kBh;
        invalidate();
    }

    public void cO(int i, int i2) {
        if (i != i2) {
            this.mSelectedPosition = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof TabItemView) {
                    ap.setViewTextColor(((TabItemView) childAt).getTextView(), R.color.CAM_X0105, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof TabItemView) {
                    ap.setViewTextColor(((TabItemView) childAt2).getTextView(), R.color.CAM_X0107, 1);
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
        if (this.kBi <= 0 && this.mSelectedPosition >= 0 && this.mSelectedPosition < getChildCount()) {
            this.kBi = getChildAt(this.mSelectedPosition).getRight() - getResources().getDimensionPixelSize(R.dimen.ds14);
        }
        canvas.drawRoundRect(new RectF(this.kBh, i - this.kBf, this.kBi, i), 10.0f, 10.0f, this.aaK);
    }

    public void onChangeSkinType(int i) {
        this.aaK.setColor(ap.getSkinColor(null, R.color.CAM_X0105));
        this.kBg.setColor(ap.getColor(R.color.CAM_X0204));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    tabItemView.onChangeSkinType();
                    if (i2 == this.mSelectedPosition) {
                        ap.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
                    } else {
                        ap.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
                    }
                }
            }
        }
    }
}
