package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int ckj;
    private int ckk;
    private int ckl;
    private int ckm;
    private int ckn;
    private int cko;
    private int ckp;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.ckj = 0;
        this.ckk = 0;
        this.ckl = 0;
        this.ckn = 0;
        this.cko = 0;
        this.ckp = 0;
        this.mContext = context;
        setOrientation(0);
        this.ckk = l.g(context, R.dimen.ds24);
        this.ckl = l.g(context, R.dimen.ds20);
        this.cko = l.g(context, R.dimen.ds32);
        this.ckm = l.af(this.mContext) - (this.cko * 2);
        this.ckp = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckj = 0;
        this.ckk = 0;
        this.ckl = 0;
        this.ckn = 0;
        this.cko = 0;
        this.ckp = 0;
        this.mContext = context;
        setOrientation(0);
        this.ckk = l.g(context, R.dimen.ds24);
        this.ckl = l.g(context, R.dimen.ds20);
        this.cko = l.g(context, R.dimen.ds32);
        this.ckm = l.af(this.mContext) - (this.cko * 2);
        this.ckp = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.ckk + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.ckl;
                i7 += this.ckl + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ckp, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.ckj != 0 && this.ckn != 0) {
            jK(childCount);
        }
        if (this.ckj != 0) {
            for (int i3 = 0; i3 < this.ckn; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.ckn = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.ckj != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ckp * this.ckj) + this.ckk, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ckp * culumnsCount) + (this.ckk * culumnsCount), i2));
        }
    }

    private void jK(int i) {
        if (this.ckn <= i) {
            removeViews(this.ckn, i - this.ckn);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ckp, 1073741824);
        int childCount = getChildCount();
        int i4 = this.ckm;
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
                        this.ckn = i5;
                    }
                    i = this.ckl + measuredWidth + 0;
                } else {
                    i = this.ckl + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.ckm - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.ckj = i;
    }

    public void setMarginRight(int i) {
        this.ckl = i;
    }

    public void setParentWidth(int i) {
        this.ckm = i;
    }

    public void setCellHeight(int i) {
        this.ckp = i;
    }
}
