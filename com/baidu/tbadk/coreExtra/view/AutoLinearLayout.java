package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int bje;
    private int bjf;
    private int bjg;
    private int bjh;
    private int bji;
    private int bjj;
    private int bjk;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.bje = 0;
        this.bjf = 0;
        this.bjg = 0;
        this.bji = 0;
        this.bjj = 0;
        this.bjk = 0;
        this.mContext = context;
        setOrientation(0);
        this.bjf = l.s(context, d.e.ds24);
        this.bjg = l.s(context, d.e.ds20);
        this.bjj = l.s(context, d.e.ds32);
        this.bjh = l.ao(this.mContext) - (this.bjj * 2);
        this.bjk = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bje = 0;
        this.bjf = 0;
        this.bjg = 0;
        this.bji = 0;
        this.bjj = 0;
        this.bjk = 0;
        this.mContext = context;
        setOrientation(0);
        this.bjf = l.s(context, d.e.ds24);
        this.bjg = l.s(context, d.e.ds20);
        this.bjj = l.s(context, d.e.ds32);
        this.bjh = l.ao(this.mContext) - (this.bjj * 2);
        this.bjk = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(d.e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.bjf + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.bjg;
                i7 += this.bjg + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.bjk, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.bje != 0 && this.bji != 0) {
            hs(childCount);
        }
        if (this.bje != 0) {
            for (int i3 = 0; i3 < this.bji; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.bji = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.bje != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.bjk * this.bje) + this.bjf, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.bjk * culumnsCount) + (this.bjf * culumnsCount), i2));
        }
    }

    private void hs(int i) {
        if (this.bji <= i) {
            removeViews(this.bji, i - this.bji);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.bjk, 1073741824);
        int childCount = getChildCount();
        int i4 = this.bjh;
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
                        this.bji = i5;
                    }
                    i = this.bjg + measuredWidth + 0;
                } else {
                    i = this.bjg + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.bjh - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.bje = i;
    }

    public void setMarginRight(int i) {
        this.bjg = i;
    }

    public void setParentWidth(int i) {
        this.bjh = i;
    }

    public void setCellHeight(int i) {
        this.bjk = i;
    }
}
