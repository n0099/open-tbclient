package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int anb;
    private int anc;
    private int and;
    private int ane;
    private int anf;
    private int ang;
    private int anh;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.anb = 0;
        this.anc = 0;
        this.and = 0;
        this.anf = 0;
        this.ang = 0;
        this.anh = 0;
        this.mContext = context;
        setOrientation(0);
        this.anc = com.baidu.adp.lib.util.k.c(context, t.e.ds24);
        this.and = com.baidu.adp.lib.util.k.c(context, t.e.ds20);
        this.ang = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.ane = com.baidu.adp.lib.util.k.K(this.mContext) - (this.ang * 2);
        this.anh = (int) this.mContext.getResources().getDimension(t.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anb = 0;
        this.anc = 0;
        this.and = 0;
        this.anf = 0;
        this.ang = 0;
        this.anh = 0;
        this.mContext = context;
        setOrientation(0);
        this.anc = com.baidu.adp.lib.util.k.c(context, t.e.ds24);
        this.and = com.baidu.adp.lib.util.k.c(context, t.e.ds20);
        this.ang = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.ane = com.baidu.adp.lib.util.k.K(this.mContext) - (this.ang * 2);
        this.anh = (int) this.mContext.getResources().getDimension(t.e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(t.e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.anc + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.and;
                i7 += this.and + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.anh, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.anb != 0 && this.anf != 0) {
            eg(childCount);
        }
        if (this.anb != 0) {
            for (int i3 = 0; i3 < this.anf; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.anf = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.anb != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.anh * this.anb) + this.anc, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.anh * culumnsCount) + (this.anc * culumnsCount), i2));
        }
    }

    private void eg(int i) {
        if (this.anf <= i) {
            removeViews(this.anf, i - this.anf);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.anh, 1073741824);
        int childCount = getChildCount();
        int i4 = this.ane;
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
                        this.anf = i5;
                    }
                    i = this.and + measuredWidth + 0;
                } else {
                    i = this.and + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.ane - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.anb = i;
    }

    public void setMarginRight(int i) {
        this.and = i;
    }

    public void setParentWidth(int i) {
        this.ane = i;
    }

    public void setCellHeight(int i) {
        this.anh = i;
    }
}
