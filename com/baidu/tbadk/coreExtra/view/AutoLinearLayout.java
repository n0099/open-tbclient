package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int cyG;
    private int cyH;
    private int cyI;
    private int cyJ;
    private int cyK;
    private int cyL;
    private int cyM;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.cyG = 0;
        this.cyH = 0;
        this.cyI = 0;
        this.cyK = 0;
        this.cyL = 0;
        this.cyM = 0;
        this.mContext = context;
        setOrientation(0);
        this.cyH = l.getDimens(context, R.dimen.ds24);
        this.cyI = l.getDimens(context, R.dimen.ds20);
        this.cyL = l.getDimens(context, R.dimen.ds32);
        this.cyJ = l.getEquipmentWidth(this.mContext) - (this.cyL * 2);
        this.cyM = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyG = 0;
        this.cyH = 0;
        this.cyI = 0;
        this.cyK = 0;
        this.cyL = 0;
        this.cyM = 0;
        this.mContext = context;
        setOrientation(0);
        this.cyH = l.getDimens(context, R.dimen.ds24);
        this.cyI = l.getDimens(context, R.dimen.ds20);
        this.cyL = l.getDimens(context, R.dimen.ds32);
        this.cyJ = l.getEquipmentWidth(this.mContext) - (this.cyL * 2);
        this.cyM = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.cyH + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.cyI;
                i7 += this.cyI + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.cyM, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.cyG != 0 && this.cyK != 0) {
            jq(childCount);
        }
        if (this.cyG != 0) {
            for (int i3 = 0; i3 < this.cyK; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.cyK = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.cyG != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.cyM * this.cyG) + this.cyH, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.cyM * culumnsCount) + (this.cyH * culumnsCount), i2));
        }
    }

    private void jq(int i) {
        if (this.cyK <= i) {
            removeViews(this.cyK, i - this.cyK);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.cyM, 1073741824);
        int childCount = getChildCount();
        int i4 = this.cyJ;
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
                        this.cyK = i5;
                    }
                    i = this.cyI + measuredWidth + 0;
                } else {
                    i = this.cyI + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.cyJ - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.cyG = i;
    }

    public void setMarginRight(int i) {
        this.cyI = i;
    }

    public void setParentWidth(int i) {
        this.cyJ = i;
    }

    public void setCellHeight(int i) {
        this.cyM = i;
    }
}
