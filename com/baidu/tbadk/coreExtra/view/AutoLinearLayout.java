package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int cca;
    private int ccb;
    private int ccc;
    private int ccd;
    private int cce;
    private int ccf;
    private int ccg;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.cca = 0;
        this.ccb = 0;
        this.ccc = 0;
        this.cce = 0;
        this.ccf = 0;
        this.ccg = 0;
        this.mContext = context;
        setOrientation(0);
        this.ccb = l.h(context, d.e.ds24);
        this.ccc = l.h(context, d.e.ds20);
        this.ccf = l.h(context, d.e.ds32);
        this.ccd = l.aO(this.mContext) - (this.ccf * 2);
        this.ccg = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cca = 0;
        this.ccb = 0;
        this.ccc = 0;
        this.cce = 0;
        this.ccf = 0;
        this.ccg = 0;
        this.mContext = context;
        setOrientation(0);
        this.ccb = l.h(context, d.e.ds24);
        this.ccc = l.h(context, d.e.ds20);
        this.ccf = l.h(context, d.e.ds32);
        this.ccd = l.aO(this.mContext) - (this.ccf * 2);
        this.ccg = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(d.e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.ccb + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.ccc;
                i7 += this.ccc + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ccg, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.cca != 0 && this.cce != 0) {
            iX(childCount);
        }
        if (this.cca != 0) {
            for (int i3 = 0; i3 < this.cce; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.cce = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.cca != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ccg * this.cca) + this.ccb, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ccg * culumnsCount) + (this.ccb * culumnsCount), i2));
        }
    }

    private void iX(int i) {
        if (this.cce <= i) {
            removeViews(this.cce, i - this.cce);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ccg, 1073741824);
        int childCount = getChildCount();
        int i4 = this.ccd;
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
                        this.cce = i5;
                    }
                    i = this.ccc + measuredWidth + 0;
                } else {
                    i = this.ccc + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.ccd - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.cca = i;
    }

    public void setMarginRight(int i) {
        this.ccc = i;
    }

    public void setParentWidth(int i) {
        this.ccd = i;
    }

    public void setCellHeight(int i) {
        this.ccg = i;
    }
}
