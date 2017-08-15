package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int avE;
    private int avF;
    private int avG;
    private int avH;
    private int avI;
    private int avJ;
    private int avK;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.avE = 0;
        this.avF = 0;
        this.avG = 0;
        this.avI = 0;
        this.avJ = 0;
        this.avK = 0;
        this.mContext = context;
        setOrientation(0);
        this.avF = k.g(context, d.f.ds24);
        this.avG = k.g(context, d.f.ds20);
        this.avJ = k.g(context, d.f.ds32);
        this.avH = k.ag(this.mContext) - (this.avJ * 2);
        this.avK = (int) this.mContext.getResources().getDimension(d.f.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avE = 0;
        this.avF = 0;
        this.avG = 0;
        this.avI = 0;
        this.avJ = 0;
        this.avK = 0;
        this.mContext = context;
        setOrientation(0);
        this.avF = k.g(context, d.f.ds24);
        this.avG = k.g(context, d.f.ds20);
        this.avJ = k.g(context, d.f.ds32);
        this.avH = k.ag(this.mContext) - (this.avJ * 2);
        this.avK = (int) this.mContext.getResources().getDimension(d.f.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(d.f.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.avF + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.avG;
                i7 += this.avG + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.avK, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.avE != 0 && this.avI != 0) {
            el(childCount);
        }
        if (this.avE != 0) {
            for (int i3 = 0; i3 < this.avI; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.avI = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.avE != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.avK * this.avE) + this.avF, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.avK * culumnsCount) + (this.avF * culumnsCount), i2));
        }
    }

    private void el(int i) {
        if (this.avI <= i) {
            removeViews(this.avI, i - this.avI);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.avK, 1073741824);
        int childCount = getChildCount();
        int i4 = this.avH;
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
                        this.avI = i5;
                    }
                    i = this.avG + measuredWidth + 0;
                } else {
                    i = this.avG + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.avH - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.avE = i;
    }

    public void setMarginRight(int i) {
        this.avG = i;
    }

    public void setParentWidth(int i) {
        this.avH = i;
    }

    public void setCellHeight(int i) {
        this.avK = i;
    }
}
