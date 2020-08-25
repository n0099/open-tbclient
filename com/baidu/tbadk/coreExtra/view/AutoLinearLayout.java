package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class AutoLinearLayout extends LinearLayout {
    private int WE;
    private int eFh;
    private int eFi;
    private int eFj;
    private int eFk;
    private int eFl;
    private int eFm;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.eFh = 0;
        this.WE = 0;
        this.eFi = 0;
        this.eFk = 0;
        this.eFl = 0;
        this.eFm = 0;
        this.mContext = context;
        setOrientation(0);
        this.WE = l.getDimens(context, R.dimen.ds24);
        this.eFi = l.getDimens(context, R.dimen.ds20);
        this.eFl = l.getDimens(context, R.dimen.ds32);
        this.eFj = l.getEquipmentWidth(this.mContext) - (this.eFl * 2);
        this.eFm = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFh = 0;
        this.WE = 0;
        this.eFi = 0;
        this.eFk = 0;
        this.eFl = 0;
        this.eFm = 0;
        this.mContext = context;
        setOrientation(0);
        this.WE = l.getDimens(context, R.dimen.ds24);
        this.eFi = l.getDimens(context, R.dimen.ds20);
        this.eFl = l.getDimens(context, R.dimen.ds32);
        this.eFj = l.getEquipmentWidth(this.mContext) - (this.eFl * 2);
        this.eFm = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.WE + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.eFi;
                i7 += this.eFi + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.eFm, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.eFh != 0 && this.eFk != 0) {
            pL(childCount);
        }
        if (this.eFh != 0) {
            for (int i3 = 0; i3 < this.eFk; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.eFk = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.eFh != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.eFm * this.eFh) + this.WE, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.eFm * culumnsCount) + (this.WE * culumnsCount), i2));
        }
    }

    private void pL(int i) {
        if (this.eFk <= i) {
            removeViews(this.eFk, i - this.eFk);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.eFm, 1073741824);
        int childCount = getChildCount();
        int i4 = this.eFj;
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
                        this.eFk = i5;
                    }
                    i = this.eFi + measuredWidth + 0;
                } else {
                    i = this.eFi + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.eFj - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.eFh = i;
    }

    public void setMarginRight(int i) {
        this.eFi = i;
    }

    public void setParentWidth(int i) {
        this.eFj = i;
    }

    public void setCellHeight(int i) {
        this.eFm = i;
    }
}
