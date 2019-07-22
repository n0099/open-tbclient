package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int clA;
    private int clB;
    private int clv;
    private int clw;
    private int clx;
    private int cly;
    private int clz;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.clv = 0;
        this.clw = 0;
        this.clx = 0;
        this.clz = 0;
        this.clA = 0;
        this.clB = 0;
        this.mContext = context;
        setOrientation(0);
        this.clw = l.g(context, R.dimen.ds24);
        this.clx = l.g(context, R.dimen.ds20);
        this.clA = l.g(context, R.dimen.ds32);
        this.cly = l.af(this.mContext) - (this.clA * 2);
        this.clB = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clv = 0;
        this.clw = 0;
        this.clx = 0;
        this.clz = 0;
        this.clA = 0;
        this.clB = 0;
        this.mContext = context;
        setOrientation(0);
        this.clw = l.g(context, R.dimen.ds24);
        this.clx = l.g(context, R.dimen.ds20);
        this.clA = l.g(context, R.dimen.ds32);
        this.cly = l.af(this.mContext) - (this.clA * 2);
        this.clB = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.clw + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.clx;
                i7 += this.clx + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.clB, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.clv != 0 && this.clz != 0) {
            jQ(childCount);
        }
        if (this.clv != 0) {
            for (int i3 = 0; i3 < this.clz; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.clz = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.clv != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.clB * this.clv) + this.clw, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.clB * culumnsCount) + (this.clw * culumnsCount), i2));
        }
    }

    private void jQ(int i) {
        if (this.clz <= i) {
            removeViews(this.clz, i - this.clz);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.clB, 1073741824);
        int childCount = getChildCount();
        int i4 = this.cly;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt == null) {
                int i8 = i6;
                i2 = i7;
                i3 = i8;
            } else {
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                if (i4 < measuredWidth) {
                    i7++;
                    if (i7 == 1) {
                        this.clz = i5;
                    }
                    i = this.clx + measuredWidth + 0;
                } else {
                    i = this.clx + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.cly - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.clv = i;
    }

    public void setMarginRight(int i) {
        this.clx = i;
    }

    public void setParentWidth(int i) {
        this.cly = i;
    }

    public void setCellHeight(int i) {
        this.clB = i;
    }
}
