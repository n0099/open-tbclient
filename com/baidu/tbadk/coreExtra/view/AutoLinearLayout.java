package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int dqL;
    private int dqM;
    private int dqN;
    private int dqO;
    private int dqP;
    private int dqQ;
    private int dqR;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.dqL = 0;
        this.dqM = 0;
        this.dqN = 0;
        this.dqP = 0;
        this.dqQ = 0;
        this.dqR = 0;
        this.mContext = context;
        setOrientation(0);
        this.dqM = l.getDimens(context, R.dimen.ds24);
        this.dqN = l.getDimens(context, R.dimen.ds20);
        this.dqQ = l.getDimens(context, R.dimen.ds32);
        this.dqO = l.getEquipmentWidth(this.mContext) - (this.dqQ * 2);
        this.dqR = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqL = 0;
        this.dqM = 0;
        this.dqN = 0;
        this.dqP = 0;
        this.dqQ = 0;
        this.dqR = 0;
        this.mContext = context;
        setOrientation(0);
        this.dqM = l.getDimens(context, R.dimen.ds24);
        this.dqN = l.getDimens(context, R.dimen.ds20);
        this.dqQ = l.getDimens(context, R.dimen.ds32);
        this.dqO = l.getEquipmentWidth(this.mContext) - (this.dqQ * 2);
        this.dqR = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.dqM + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.dqN;
                i7 += this.dqN + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.dqR, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.dqL != 0 && this.dqP != 0) {
            lV(childCount);
        }
        if (this.dqL != 0) {
            for (int i3 = 0; i3 < this.dqP; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.dqP = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.dqL != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.dqR * this.dqL) + this.dqM, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.dqR * culumnsCount) + (this.dqM * culumnsCount), i2));
        }
    }

    private void lV(int i) {
        if (this.dqP <= i) {
            removeViews(this.dqP, i - this.dqP);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.dqR, 1073741824);
        int childCount = getChildCount();
        int i4 = this.dqO;
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
                        this.dqP = i5;
                    }
                    i = this.dqN + measuredWidth + 0;
                } else {
                    i = this.dqN + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.dqO - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.dqL = i;
    }

    public void setMarginRight(int i) {
        this.dqN = i;
    }

    public void setParentWidth(int i) {
        this.dqO = i;
    }

    public void setCellHeight(int i) {
        this.dqR = i;
    }
}
