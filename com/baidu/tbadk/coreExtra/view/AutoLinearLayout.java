package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int amQ;
    private int amR;
    private int amS;
    private int amT;
    private int amU;
    private int amV;
    private int amW;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.amQ = 0;
        this.amR = 0;
        this.amS = 0;
        this.amU = 0;
        this.amV = 0;
        this.amW = 0;
        this.mContext = context;
        setOrientation(0);
        this.amR = com.baidu.adp.lib.util.k.e(context, r.f.ds24);
        this.amS = com.baidu.adp.lib.util.k.e(context, r.f.ds20);
        this.amV = com.baidu.adp.lib.util.k.e(context, r.f.ds32);
        this.amT = com.baidu.adp.lib.util.k.I(this.mContext) - (this.amV * 2);
        this.amW = (int) this.mContext.getResources().getDimension(r.f.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amQ = 0;
        this.amR = 0;
        this.amS = 0;
        this.amU = 0;
        this.amV = 0;
        this.amW = 0;
        this.mContext = context;
        setOrientation(0);
        this.amR = com.baidu.adp.lib.util.k.e(context, r.f.ds24);
        this.amS = com.baidu.adp.lib.util.k.e(context, r.f.ds20);
        this.amV = com.baidu.adp.lib.util.k.e(context, r.f.ds32);
        this.amT = com.baidu.adp.lib.util.k.I(this.mContext) - (this.amV * 2);
        this.amW = (int) this.mContext.getResources().getDimension(r.f.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(r.f.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.amR + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.amS;
                i7 += this.amS + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.amW, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.amQ != 0 && this.amU != 0) {
            ei(childCount);
        }
        if (this.amQ != 0) {
            for (int i3 = 0; i3 < this.amU; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.amU = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.amQ != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.amW * this.amQ) + this.amR, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.amW * culumnsCount) + (this.amR * culumnsCount), i2));
        }
    }

    private void ei(int i) {
        if (this.amU <= i) {
            removeViews(this.amU, i - this.amU);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.amW, 1073741824);
        int childCount = getChildCount();
        int i4 = this.amT;
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
                        this.amU = i5;
                    }
                    i = this.amS + measuredWidth + 0;
                } else {
                    i = this.amS + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.amT - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.amQ = i;
    }

    public void setMarginRight(int i) {
        this.amS = i;
    }

    public void setParentWidth(int i) {
        this.amT = i;
    }

    public void setCellHeight(int i) {
        this.amW = i;
    }
}
