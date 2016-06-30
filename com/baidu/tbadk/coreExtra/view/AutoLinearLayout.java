package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int ajM;
    private int ajN;
    private int ajO;
    private int ajP;
    private int ajQ;
    private int ajR;
    private int ajS;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.ajM = 0;
        this.ajN = 0;
        this.ajO = 0;
        this.ajQ = 0;
        this.ajR = 0;
        this.ajS = 0;
        this.mContext = context;
        setOrientation(0);
        this.ajN = com.baidu.adp.lib.util.k.c(context, u.e.ds24);
        this.ajO = com.baidu.adp.lib.util.k.c(context, u.e.ds20);
        this.ajR = com.baidu.adp.lib.util.k.c(context, u.e.ds32);
        this.ajP = com.baidu.adp.lib.util.k.A(this.mContext) - (this.ajR * 2);
        this.ajS = (int) this.mContext.getResources().getDimension(u.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajM = 0;
        this.ajN = 0;
        this.ajO = 0;
        this.ajQ = 0;
        this.ajR = 0;
        this.ajS = 0;
        this.mContext = context;
        setOrientation(0);
        this.ajN = com.baidu.adp.lib.util.k.c(context, u.e.ds24);
        this.ajO = com.baidu.adp.lib.util.k.c(context, u.e.ds20);
        this.ajR = com.baidu.adp.lib.util.k.c(context, u.e.ds32);
        this.ajP = com.baidu.adp.lib.util.k.A(this.mContext) - (this.ajR * 2);
        this.ajS = (int) this.mContext.getResources().getDimension(u.e.ds60);
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
                    dimension += this.ajN + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.ajO;
                i7 += this.ajO + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ajS, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.ajM != 0 && this.ajQ != 0) {
            dQ(childCount);
        }
        if (this.ajM != 0) {
            for (int i3 = 0; i3 < this.ajQ; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.ajQ = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.ajM != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ajS * this.ajM) + this.ajN, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ajS * culumnsCount) + (this.ajN * culumnsCount), i2));
        }
    }

    private void dQ(int i) {
        if (this.ajQ <= i) {
            removeViews(this.ajQ, i - this.ajQ);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ajS, 1073741824);
        int childCount = getChildCount();
        int i4 = this.ajP;
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
                        this.ajQ = i5;
                    }
                    i = this.ajO + measuredWidth + 0;
                } else {
                    i = this.ajO + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.ajP - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.ajM = i;
    }

    public void setMarginRight(int i) {
        this.ajO = i;
    }

    public void setParentWidth(int i) {
        this.ajP = i;
    }

    public void setCellHeight(int i) {
        this.ajS = i;
    }
}
