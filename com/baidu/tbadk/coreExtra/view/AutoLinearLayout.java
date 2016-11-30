package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int aoh;
    private int aoi;
    private int aoj;
    private int aok;
    private int aol;
    private int aom;
    private int aon;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.aoh = 0;
        this.aoi = 0;
        this.aoj = 0;
        this.aol = 0;
        this.aom = 0;
        this.aon = 0;
        this.mContext = context;
        setOrientation(0);
        this.aoi = com.baidu.adp.lib.util.k.e(context, r.e.ds24);
        this.aoj = com.baidu.adp.lib.util.k.e(context, r.e.ds20);
        this.aom = com.baidu.adp.lib.util.k.e(context, r.e.ds32);
        this.aok = com.baidu.adp.lib.util.k.K(this.mContext) - (this.aom * 2);
        this.aon = (int) this.mContext.getResources().getDimension(r.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoh = 0;
        this.aoi = 0;
        this.aoj = 0;
        this.aol = 0;
        this.aom = 0;
        this.aon = 0;
        this.mContext = context;
        setOrientation(0);
        this.aoi = com.baidu.adp.lib.util.k.e(context, r.e.ds24);
        this.aoj = com.baidu.adp.lib.util.k.e(context, r.e.ds20);
        this.aom = com.baidu.adp.lib.util.k.e(context, r.e.ds32);
        this.aok = com.baidu.adp.lib.util.k.K(this.mContext) - (this.aom * 2);
        this.aon = (int) this.mContext.getResources().getDimension(r.e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(r.e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.aoi + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.aoj;
                i7 += this.aoj + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aon, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.aoh != 0 && this.aol != 0) {
            eg(childCount);
        }
        if (this.aoh != 0) {
            for (int i3 = 0; i3 < this.aol; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aol = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.aoh != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aon * this.aoh) + this.aoi, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aon * culumnsCount) + (this.aoi * culumnsCount), i2));
        }
    }

    private void eg(int i) {
        if (this.aol <= i) {
            removeViews(this.aol, i - this.aol);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aon, 1073741824);
        int childCount = getChildCount();
        int i4 = this.aok;
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
                        this.aol = i5;
                    }
                    i = this.aoj + measuredWidth + 0;
                } else {
                    i = this.aoj + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aok - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.aoh = i;
    }

    public void setMarginRight(int i) {
        this.aoj = i;
    }

    public void setParentWidth(int i) {
        this.aok = i;
    }

    public void setCellHeight(int i) {
        this.aon = i;
    }
}
