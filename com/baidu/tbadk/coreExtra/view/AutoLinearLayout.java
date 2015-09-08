package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int akj;
    private int akk;
    private int akl;
    private int akm;
    private int akn;
    private int ako;
    private int akp;
    private int akq;
    private int akr;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.akj = 0;
        this.akk = 0;
        this.akl = 0;
        this.akn = 0;
        this.ako = 0;
        this.akp = 0;
        this.akq = 0;
        this.akr = 0;
        this.mContext = context;
        setOrientation(0);
        this.akk = com.baidu.adp.lib.util.k.d(context, i.d.ds24);
        this.akl = com.baidu.adp.lib.util.k.d(context, i.d.ds20);
        this.akp = com.baidu.adp.lib.util.k.d(context, i.d.ds32);
        this.akm = com.baidu.adp.lib.util.k.K(this.mContext) - (this.akp * 2);
        this.ako = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        this.akq = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds28);
        this.akr = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akj = 0;
        this.akk = 0;
        this.akl = 0;
        this.akn = 0;
        this.ako = 0;
        this.akp = 0;
        this.akq = 0;
        this.akr = 0;
        this.mContext = context;
        setOrientation(0);
        this.akk = com.baidu.adp.lib.util.k.d(context, i.d.ds24);
        this.akl = com.baidu.adp.lib.util.k.d(context, i.d.ds20);
        this.akp = com.baidu.adp.lib.util.k.d(context, i.d.ds32);
        this.akm = com.baidu.adp.lib.util.k.K(this.mContext) - (this.akp * 2);
        this.ako = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        this.akq = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds28);
        this.akr = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds16);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(i.d.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.akk + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.akl;
                i7 += this.akl + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int dimension = (int) this.mContext.getResources().getDimension(i.d.ds60);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int dimension2 = (int) this.mContext.getResources().getDimension(i.d.ds40);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.akj != 0 && this.akn != 0) {
            dB(childCount);
        }
        if (this.akj != 0) {
            for (int i3 = 0; i3 < this.akn; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.akn = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.akj != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.akj * dimension) + dimension2 + this.akk, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((dimension * culumnsCount) + (this.akk * culumnsCount) + this.ako + this.akq + this.akr, i2));
        }
    }

    private void dB(int i) {
        if (this.akn <= i) {
            removeViews(this.akn, i - this.akn);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int childCount = getChildCount();
        int i4 = this.akm;
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
                        this.akn = i5;
                    }
                    i = this.akl + measuredWidth + 0;
                } else {
                    i = this.akl + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.akm - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.akj = i;
    }

    public void setMarginRight(int i) {
        this.akl = i;
    }

    public void setParentWidth(int i) {
        this.akm = i;
    }
}
