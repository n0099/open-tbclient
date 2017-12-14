package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int auV;
    private int auW;
    private int auX;
    private int auY;
    private int auZ;
    private int ava;
    private int avb;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.auV = 0;
        this.auW = 0;
        this.auX = 0;
        this.auZ = 0;
        this.ava = 0;
        this.avb = 0;
        this.mContext = context;
        setOrientation(0);
        this.auW = l.f(context, d.e.ds24);
        this.auX = l.f(context, d.e.ds20);
        this.ava = l.f(context, d.e.ds32);
        this.auY = l.ac(this.mContext) - (this.ava * 2);
        this.avb = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auV = 0;
        this.auW = 0;
        this.auX = 0;
        this.auZ = 0;
        this.ava = 0;
        this.avb = 0;
        this.mContext = context;
        setOrientation(0);
        this.auW = l.f(context, d.e.ds24);
        this.auX = l.f(context, d.e.ds20);
        this.ava = l.f(context, d.e.ds32);
        this.auY = l.ac(this.mContext) - (this.ava * 2);
        this.avb = (int) this.mContext.getResources().getDimension(d.e.ds60);
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
                    dimension += this.auW + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.auX;
                i7 += this.auX + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.avb, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.auV != 0 && this.auZ != 0) {
            eu(childCount);
        }
        if (this.auV != 0) {
            for (int i3 = 0; i3 < this.auZ; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.auZ = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.auV != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.avb * this.auV) + this.auW, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.avb * culumnsCount) + (this.auW * culumnsCount), i2));
        }
    }

    private void eu(int i) {
        if (this.auZ <= i) {
            removeViews(this.auZ, i - this.auZ);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.avb, 1073741824);
        int childCount = getChildCount();
        int i4 = this.auY;
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
                        this.auZ = i5;
                    }
                    i = this.auX + measuredWidth + 0;
                } else {
                    i = this.auX + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.auY - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.auV = i;
    }

    public void setMarginRight(int i) {
        this.auX = i;
    }

    public void setParentWidth(int i) {
        this.auY = i;
    }

    public void setCellHeight(int i) {
        this.avb = i;
    }
}
