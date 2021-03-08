package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int ZA;
    private int fxl;
    private int fxm;
    private int fxn;
    private int fxo;
    private int fxp;
    private Context mContext;
    private int parentWidth;

    public AutoLinearLayout(Context context) {
        super(context);
        this.fxl = 0;
        this.ZA = 0;
        this.fxm = 0;
        this.fxn = 0;
        this.fxo = 0;
        this.fxp = 0;
        this.mContext = context;
        setOrientation(0);
        this.ZA = l.getDimens(context, R.dimen.ds24);
        this.fxm = l.getDimens(context, R.dimen.ds20);
        this.fxo = l.getDimens(context, R.dimen.ds32);
        this.parentWidth = l.getEquipmentWidth(this.mContext) - (this.fxo * 2);
        this.fxp = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fxl = 0;
        this.ZA = 0;
        this.fxm = 0;
        this.fxn = 0;
        this.fxo = 0;
        this.fxp = 0;
        this.mContext = context;
        setOrientation(0);
        this.ZA = l.getDimens(context, R.dimen.ds24);
        this.fxm = l.getDimens(context, R.dimen.ds20);
        this.fxo = l.getDimens(context, R.dimen.ds32);
        this.parentWidth = l.getEquipmentWidth(this.mContext) - (this.fxo * 2);
        this.fxp = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ds24);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i6 != 0 && i5 < measuredWidth) {
                    dimension += this.ZA + measuredHeight;
                    i6 = 0;
                }
                childAt.layout(i6, dimension, i6 + measuredWidth, measuredHeight + dimension);
                i5 = (((i3 - i) - i6) - measuredWidth) - this.fxm;
                i6 += this.fxm + measuredWidth;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.fxp, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.fxl != 0 && this.fxn != 0) {
            qC(childCount);
        }
        if (this.fxl != 0) {
            for (int i3 = 0; i3 < this.fxn; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.fxn = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.fxl != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.fxp * this.fxl) + this.ZA, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.fxp * culumnsCount) + (this.ZA * culumnsCount), i2));
        }
    }

    private void qC(int i) {
        if (this.fxn <= i) {
            removeViews(this.fxn, i - this.fxn);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.fxp, 1073741824);
        int childCount = getChildCount();
        int i3 = this.parentWidth;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt == null) {
                i2 = i3;
            } else {
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                if (i3 < measuredWidth) {
                    i6++;
                    if (i6 == 1) {
                        this.fxn = i4;
                    }
                    i = this.fxm + measuredWidth + 0;
                } else {
                    i = this.fxm + measuredWidth + i5;
                }
                i2 = this.parentWidth - i;
                i5 = i;
            }
            i4++;
            i3 = i2;
        }
        return i6 + 1;
    }

    public void setShowColumns(int i) {
        this.fxl = i;
    }

    public void setMarginRight(int i) {
        this.fxm = i;
    }

    public void setParentWidth(int i) {
        this.parentWidth = i;
    }

    public void setCellHeight(int i) {
        this.fxp = i;
    }
}
