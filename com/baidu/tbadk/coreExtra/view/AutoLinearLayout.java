package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int ami;
    private int amj;
    private int amk;
    private int aml;
    private int amm;
    private int amn;
    private int amo;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.ami = 0;
        this.amj = 0;
        this.amk = 0;
        this.amm = 0;
        this.amn = 0;
        this.amo = 0;
        this.mContext = context;
        setOrientation(0);
        this.amj = com.baidu.adp.lib.util.k.d(context, n.e.ds24);
        this.amk = com.baidu.adp.lib.util.k.d(context, n.e.ds20);
        this.amn = com.baidu.adp.lib.util.k.d(context, n.e.ds32);
        this.aml = com.baidu.adp.lib.util.k.K(this.mContext) - (this.amn * 2);
        this.amo = (int) this.mContext.getResources().getDimension(n.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ami = 0;
        this.amj = 0;
        this.amk = 0;
        this.amm = 0;
        this.amn = 0;
        this.amo = 0;
        this.mContext = context;
        setOrientation(0);
        this.amj = com.baidu.adp.lib.util.k.d(context, n.e.ds24);
        this.amk = com.baidu.adp.lib.util.k.d(context, n.e.ds20);
        this.amn = com.baidu.adp.lib.util.k.d(context, n.e.ds32);
        this.aml = com.baidu.adp.lib.util.k.K(this.mContext) - (this.amn * 2);
        this.amo = (int) this.mContext.getResources().getDimension(n.e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(n.e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.amj + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.amk;
                i7 += this.amk + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.amo, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.ami != 0 && this.amm != 0) {
            dL(childCount);
        }
        if (this.ami != 0) {
            for (int i3 = 0; i3 < this.amm; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.amm = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.ami != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.amo * this.ami) + this.amj, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.amo * culumnsCount) + (this.amj * culumnsCount), i2));
        }
    }

    private void dL(int i) {
        if (this.amm <= i) {
            removeViews(this.amm, i - this.amm);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.amo, 1073741824);
        int childCount = getChildCount();
        int i4 = this.aml;
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
                        this.amm = i5;
                    }
                    i = this.amk + measuredWidth + 0;
                } else {
                    i = this.amk + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aml - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.ami = i;
    }

    public void setMarginRight(int i) {
        this.amk = i;
    }

    public void setParentWidth(int i) {
        this.aml = i;
    }

    public void setCellHeight(int i) {
        this.amo = i;
    }
}
