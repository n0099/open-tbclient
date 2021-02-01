package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int Yh;
    private int fvM;
    private int fvN;
    private int fvO;
    private int fvP;
    private int fvQ;
    private Context mContext;
    private int parentWidth;

    public AutoLinearLayout(Context context) {
        super(context);
        this.fvM = 0;
        this.Yh = 0;
        this.fvN = 0;
        this.fvO = 0;
        this.fvP = 0;
        this.fvQ = 0;
        this.mContext = context;
        setOrientation(0);
        this.Yh = l.getDimens(context, R.dimen.ds24);
        this.fvN = l.getDimens(context, R.dimen.ds20);
        this.fvP = l.getDimens(context, R.dimen.ds32);
        this.parentWidth = l.getEquipmentWidth(this.mContext) - (this.fvP * 2);
        this.fvQ = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvM = 0;
        this.Yh = 0;
        this.fvN = 0;
        this.fvO = 0;
        this.fvP = 0;
        this.fvQ = 0;
        this.mContext = context;
        setOrientation(0);
        this.Yh = l.getDimens(context, R.dimen.ds24);
        this.fvN = l.getDimens(context, R.dimen.ds20);
        this.fvP = l.getDimens(context, R.dimen.ds32);
        this.parentWidth = l.getEquipmentWidth(this.mContext) - (this.fvP * 2);
        this.fvQ = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.Yh + measuredHeight;
                    i6 = 0;
                }
                childAt.layout(i6, dimension, i6 + measuredWidth, measuredHeight + dimension);
                i5 = (((i3 - i) - i6) - measuredWidth) - this.fvN;
                i6 += this.fvN + measuredWidth;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.fvQ, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.fvM != 0 && this.fvO != 0) {
            qB(childCount);
        }
        if (this.fvM != 0) {
            for (int i3 = 0; i3 < this.fvO; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.fvO = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.fvM != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.fvQ * this.fvM) + this.Yh, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.fvQ * culumnsCount) + (this.Yh * culumnsCount), i2));
        }
    }

    private void qB(int i) {
        if (this.fvO <= i) {
            removeViews(this.fvO, i - this.fvO);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.fvQ, 1073741824);
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
                        this.fvO = i4;
                    }
                    i = this.fvN + measuredWidth + 0;
                } else {
                    i = this.fvN + measuredWidth + i5;
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
        this.fvM = i;
    }

    public void setMarginRight(int i) {
        this.fvN = i;
    }

    public void setParentWidth(int i) {
        this.parentWidth = i;
    }

    public void setCellHeight(int i) {
        this.fvQ = i;
    }
}
