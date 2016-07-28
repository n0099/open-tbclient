package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int akB;
    private int akC;
    private int akD;
    private int akE;
    private int akF;
    private int akG;
    private int akH;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.akB = 0;
        this.akC = 0;
        this.akD = 0;
        this.akF = 0;
        this.akG = 0;
        this.akH = 0;
        this.mContext = context;
        setOrientation(0);
        this.akC = com.baidu.adp.lib.util.k.c(context, u.e.ds24);
        this.akD = com.baidu.adp.lib.util.k.c(context, u.e.ds20);
        this.akG = com.baidu.adp.lib.util.k.c(context, u.e.ds32);
        this.akE = com.baidu.adp.lib.util.k.A(this.mContext) - (this.akG * 2);
        this.akH = (int) this.mContext.getResources().getDimension(u.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akB = 0;
        this.akC = 0;
        this.akD = 0;
        this.akF = 0;
        this.akG = 0;
        this.akH = 0;
        this.mContext = context;
        setOrientation(0);
        this.akC = com.baidu.adp.lib.util.k.c(context, u.e.ds24);
        this.akD = com.baidu.adp.lib.util.k.c(context, u.e.ds20);
        this.akG = com.baidu.adp.lib.util.k.c(context, u.e.ds32);
        this.akE = com.baidu.adp.lib.util.k.A(this.mContext) - (this.akG * 2);
        this.akH = (int) this.mContext.getResources().getDimension(u.e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(u.e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.akC + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.akD;
                i7 += this.akD + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.akH, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.akB != 0 && this.akF != 0) {
            dQ(childCount);
        }
        if (this.akB != 0) {
            for (int i3 = 0; i3 < this.akF; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.akF = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.akB != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.akH * this.akB) + this.akC, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.akH * culumnsCount) + (this.akC * culumnsCount), i2));
        }
    }

    private void dQ(int i) {
        if (this.akF <= i) {
            removeViews(this.akF, i - this.akF);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.akH, 1073741824);
        int childCount = getChildCount();
        int i4 = this.akE;
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
                        this.akF = i5;
                    }
                    i = this.akD + measuredWidth + 0;
                } else {
                    i = this.akD + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.akE - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.akB = i;
    }

    public void setMarginRight(int i) {
        this.akD = i;
    }

    public void setParentWidth(int i) {
        this.akE = i;
    }

    public void setCellHeight(int i) {
        this.akH = i;
    }
}
