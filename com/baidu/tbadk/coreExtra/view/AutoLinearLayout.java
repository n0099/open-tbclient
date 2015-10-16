package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int ajj;
    private int ajk;
    private int ajl;
    private int ajm;
    private int ajn;
    private int ajo;
    private int ajp;
    private int ajq;
    private int ajr;
    private int ajs;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.ajj = 0;
        this.ajk = 0;
        this.ajl = 0;
        this.ajn = 0;
        this.ajo = 0;
        this.ajp = 0;
        this.ajq = 0;
        this.ajr = 0;
        this.ajs = 0;
        this.mContext = context;
        setOrientation(0);
        this.ajk = com.baidu.adp.lib.util.k.d(context, i.d.ds24);
        this.ajl = com.baidu.adp.lib.util.k.d(context, i.d.ds20);
        this.ajp = com.baidu.adp.lib.util.k.d(context, i.d.ds32);
        this.ajm = com.baidu.adp.lib.util.k.K(this.mContext) - (this.ajp * 2);
        this.ajo = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        this.ajq = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds28);
        this.ajr = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        this.ajs = (int) this.mContext.getResources().getDimension(i.d.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajj = 0;
        this.ajk = 0;
        this.ajl = 0;
        this.ajn = 0;
        this.ajo = 0;
        this.ajp = 0;
        this.ajq = 0;
        this.ajr = 0;
        this.ajs = 0;
        this.mContext = context;
        setOrientation(0);
        this.ajk = com.baidu.adp.lib.util.k.d(context, i.d.ds24);
        this.ajl = com.baidu.adp.lib.util.k.d(context, i.d.ds20);
        this.ajp = com.baidu.adp.lib.util.k.d(context, i.d.ds32);
        this.ajm = com.baidu.adp.lib.util.k.K(this.mContext) - (this.ajp * 2);
        this.ajo = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds8);
        this.ajq = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds28);
        this.ajr = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds16);
        this.ajs = (int) this.mContext.getResources().getDimension(i.d.ds60);
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
                    dimension += this.ajk + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.ajl;
                i7 += this.ajl + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int dimension = (int) this.mContext.getResources().getDimension(i.d.ds40);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.ajj != 0 && this.ajn != 0) {
            dC(childCount);
        }
        if (this.ajj != 0) {
            for (int i3 = 0; i3 < this.ajn; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.ajn = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.ajj != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ajs * this.ajj) + dimension + this.ajk, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ajs * culumnsCount) + (this.ajk * culumnsCount) + this.ajo + this.ajq + this.ajr, i2));
        }
    }

    private void dC(int i) {
        if (this.ajn <= i) {
            removeViews(this.ajn, i - this.ajn);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int childCount = getChildCount();
        int i4 = this.ajm;
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
                        this.ajn = i5;
                    }
                    i = this.ajl + measuredWidth + 0;
                } else {
                    i = this.ajl + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.ajm - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.ajj = i;
    }

    public void setMarginRight(int i) {
        this.ajl = i;
    }

    public void setParentWidth(int i) {
        this.ajm = i;
    }

    public void setCellHeight(int i) {
        this.ajs = i;
    }
}
