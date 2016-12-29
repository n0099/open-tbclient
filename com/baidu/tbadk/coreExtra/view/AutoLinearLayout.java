package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int anJ;
    private int anK;
    private int anL;
    private int anM;
    private int anN;
    private int anO;
    private int anP;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.anJ = 0;
        this.anK = 0;
        this.anL = 0;
        this.anN = 0;
        this.anO = 0;
        this.anP = 0;
        this.mContext = context;
        setOrientation(0);
        this.anK = com.baidu.adp.lib.util.k.e(context, r.e.ds24);
        this.anL = com.baidu.adp.lib.util.k.e(context, r.e.ds20);
        this.anO = com.baidu.adp.lib.util.k.e(context, r.e.ds32);
        this.anM = com.baidu.adp.lib.util.k.I(this.mContext) - (this.anO * 2);
        this.anP = (int) this.mContext.getResources().getDimension(r.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anJ = 0;
        this.anK = 0;
        this.anL = 0;
        this.anN = 0;
        this.anO = 0;
        this.anP = 0;
        this.mContext = context;
        setOrientation(0);
        this.anK = com.baidu.adp.lib.util.k.e(context, r.e.ds24);
        this.anL = com.baidu.adp.lib.util.k.e(context, r.e.ds20);
        this.anO = com.baidu.adp.lib.util.k.e(context, r.e.ds32);
        this.anM = com.baidu.adp.lib.util.k.I(this.mContext) - (this.anO * 2);
        this.anP = (int) this.mContext.getResources().getDimension(r.e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(r.e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.anK + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.anL;
                i7 += this.anL + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.anP, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.anJ != 0 && this.anN != 0) {
            eh(childCount);
        }
        if (this.anJ != 0) {
            for (int i3 = 0; i3 < this.anN; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.anN = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.anJ != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.anP * this.anJ) + this.anK, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.anP * culumnsCount) + (this.anK * culumnsCount), i2));
        }
    }

    private void eh(int i) {
        if (this.anN <= i) {
            removeViews(this.anN, i - this.anN);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.anP, 1073741824);
        int childCount = getChildCount();
        int i4 = this.anM;
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
                        this.anN = i5;
                    }
                    i = this.anL + measuredWidth + 0;
                } else {
                    i = this.anL + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.anM - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.anJ = i;
    }

    public void setMarginRight(int i) {
        this.anL = i;
    }

    public void setParentWidth(int i) {
        this.anM = i;
    }

    public void setCellHeight(int i) {
        this.anP = i;
    }
}
