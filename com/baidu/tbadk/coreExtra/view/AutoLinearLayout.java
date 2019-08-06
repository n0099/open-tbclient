package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int clC;
    private int clD;
    private int clE;
    private int clF;
    private int clG;
    private int clH;
    private int clI;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.clC = 0;
        this.clD = 0;
        this.clE = 0;
        this.clG = 0;
        this.clH = 0;
        this.clI = 0;
        this.mContext = context;
        setOrientation(0);
        this.clD = l.g(context, R.dimen.ds24);
        this.clE = l.g(context, R.dimen.ds20);
        this.clH = l.g(context, R.dimen.ds32);
        this.clF = l.af(this.mContext) - (this.clH * 2);
        this.clI = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clC = 0;
        this.clD = 0;
        this.clE = 0;
        this.clG = 0;
        this.clH = 0;
        this.clI = 0;
        this.mContext = context;
        setOrientation(0);
        this.clD = l.g(context, R.dimen.ds24);
        this.clE = l.g(context, R.dimen.ds20);
        this.clH = l.g(context, R.dimen.ds32);
        this.clF = l.af(this.mContext) - (this.clH * 2);
        this.clI = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.clD + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.clE;
                i7 += this.clE + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.clI, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.clC != 0 && this.clG != 0) {
            jR(childCount);
        }
        if (this.clC != 0) {
            for (int i3 = 0; i3 < this.clG; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.clG = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.clC != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.clI * this.clC) + this.clD, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.clI * culumnsCount) + (this.clD * culumnsCount), i2));
        }
    }

    private void jR(int i) {
        if (this.clG <= i) {
            removeViews(this.clG, i - this.clG);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.clI, 1073741824);
        int childCount = getChildCount();
        int i4 = this.clF;
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
                        this.clG = i5;
                    }
                    i = this.clE + measuredWidth + 0;
                } else {
                    i = this.clE + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.clF - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.clC = i;
    }

    public void setMarginRight(int i) {
        this.clE = i;
    }

    public void setParentWidth(int i) {
        this.clF = i;
    }

    public void setCellHeight(int i) {
        this.clI = i;
    }
}
