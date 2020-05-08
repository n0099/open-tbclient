package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int dRo;
    private int dRp;
    private int dRq;
    private int dRr;
    private int dRs;
    private int dRt;
    private int dRu;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.dRo = 0;
        this.dRp = 0;
        this.dRq = 0;
        this.dRs = 0;
        this.dRt = 0;
        this.dRu = 0;
        this.mContext = context;
        setOrientation(0);
        this.dRp = l.getDimens(context, R.dimen.ds24);
        this.dRq = l.getDimens(context, R.dimen.ds20);
        this.dRt = l.getDimens(context, R.dimen.ds32);
        this.dRr = l.getEquipmentWidth(this.mContext) - (this.dRt * 2);
        this.dRu = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRo = 0;
        this.dRp = 0;
        this.dRq = 0;
        this.dRs = 0;
        this.dRt = 0;
        this.dRu = 0;
        this.mContext = context;
        setOrientation(0);
        this.dRp = l.getDimens(context, R.dimen.ds24);
        this.dRq = l.getDimens(context, R.dimen.ds20);
        this.dRt = l.getDimens(context, R.dimen.ds32);
        this.dRr = l.getEquipmentWidth(this.mContext) - (this.dRt * 2);
        this.dRu = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.dRp + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.dRq;
                i7 += this.dRq + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.dRu, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.dRo != 0 && this.dRs != 0) {
            mj(childCount);
        }
        if (this.dRo != 0) {
            for (int i3 = 0; i3 < this.dRs; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.dRs = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.dRo != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.dRu * this.dRo) + this.dRp, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.dRu * culumnsCount) + (this.dRp * culumnsCount), i2));
        }
    }

    private void mj(int i) {
        if (this.dRs <= i) {
            removeViews(this.dRs, i - this.dRs);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.dRu, 1073741824);
        int childCount = getChildCount();
        int i4 = this.dRr;
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
                        this.dRs = i5;
                    }
                    i = this.dRq + measuredWidth + 0;
                } else {
                    i = this.dRq + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.dRr - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.dRo = i;
    }

    public void setMarginRight(int i) {
        this.dRq = i;
    }

    public void setParentWidth(int i) {
        this.dRr = i;
    }

    public void setCellHeight(int i) {
        this.dRu = i;
    }
}
