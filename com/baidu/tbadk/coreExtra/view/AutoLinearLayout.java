package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int czA;
    private int czB;
    private int czC;
    private int czD;
    private int czx;
    private int czy;
    private int czz;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.czx = 0;
        this.czy = 0;
        this.czz = 0;
        this.czB = 0;
        this.czC = 0;
        this.czD = 0;
        this.mContext = context;
        setOrientation(0);
        this.czy = l.getDimens(context, R.dimen.ds24);
        this.czz = l.getDimens(context, R.dimen.ds20);
        this.czC = l.getDimens(context, R.dimen.ds32);
        this.czA = l.getEquipmentWidth(this.mContext) - (this.czC * 2);
        this.czD = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czx = 0;
        this.czy = 0;
        this.czz = 0;
        this.czB = 0;
        this.czC = 0;
        this.czD = 0;
        this.mContext = context;
        setOrientation(0);
        this.czy = l.getDimens(context, R.dimen.ds24);
        this.czz = l.getDimens(context, R.dimen.ds20);
        this.czC = l.getDimens(context, R.dimen.ds32);
        this.czA = l.getEquipmentWidth(this.mContext) - (this.czC * 2);
        this.czD = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.czy + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.czz;
                i7 += this.czz + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.czD, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.czx != 0 && this.czB != 0) {
            jr(childCount);
        }
        if (this.czx != 0) {
            for (int i3 = 0; i3 < this.czB; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.czB = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.czx != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.czD * this.czx) + this.czy, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.czD * culumnsCount) + (this.czy * culumnsCount), i2));
        }
    }

    private void jr(int i) {
        if (this.czB <= i) {
            removeViews(this.czB, i - this.czB);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.czD, 1073741824);
        int childCount = getChildCount();
        int i4 = this.czA;
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
                        this.czB = i5;
                    }
                    i = this.czz + measuredWidth + 0;
                } else {
                    i = this.czz + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.czA - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.czx = i;
    }

    public void setMarginRight(int i) {
        this.czz = i;
    }

    public void setParentWidth(int i) {
        this.czA = i;
    }

    public void setCellHeight(int i) {
        this.czD = i;
    }
}
