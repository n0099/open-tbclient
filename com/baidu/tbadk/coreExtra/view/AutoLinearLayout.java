package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int atA;
    private int atu;
    private int atv;
    private int atw;
    private int atx;
    private int aty;
    private int atz;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.atu = 0;
        this.atv = 0;
        this.atw = 0;
        this.aty = 0;
        this.atz = 0;
        this.atA = 0;
        this.mContext = context;
        setOrientation(0);
        this.atv = com.baidu.adp.lib.util.k.g(context, w.f.ds24);
        this.atw = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.atz = com.baidu.adp.lib.util.k.g(context, w.f.ds32);
        this.atx = com.baidu.adp.lib.util.k.af(this.mContext) - (this.atz * 2);
        this.atA = (int) this.mContext.getResources().getDimension(w.f.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atu = 0;
        this.atv = 0;
        this.atw = 0;
        this.aty = 0;
        this.atz = 0;
        this.atA = 0;
        this.mContext = context;
        setOrientation(0);
        this.atv = com.baidu.adp.lib.util.k.g(context, w.f.ds24);
        this.atw = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.atz = com.baidu.adp.lib.util.k.g(context, w.f.ds32);
        this.atx = com.baidu.adp.lib.util.k.af(this.mContext) - (this.atz * 2);
        this.atA = (int) this.mContext.getResources().getDimension(w.f.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(w.f.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.atv + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.atw;
                i7 += this.atw + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.atA, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.atu != 0 && this.aty != 0) {
            eh(childCount);
        }
        if (this.atu != 0) {
            for (int i3 = 0; i3 < this.aty; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aty = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.atu != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.atA * this.atu) + this.atv, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.atA * culumnsCount) + (this.atv * culumnsCount), i2));
        }
    }

    private void eh(int i) {
        if (this.aty <= i) {
            removeViews(this.aty, i - this.aty);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.atA, 1073741824);
        int childCount = getChildCount();
        int i4 = this.atx;
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
                        this.aty = i5;
                    }
                    i = this.atw + measuredWidth + 0;
                } else {
                    i = this.atw + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.atx - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.atu = i;
    }

    public void setMarginRight(int i) {
        this.atw = i;
    }

    public void setParentWidth(int i) {
        this.atx = i;
    }

    public void setCellHeight(int i) {
        this.atA = i;
    }
}
