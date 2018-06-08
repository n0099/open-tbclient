package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int aFC;
    private int aFD;
    private int aFE;
    private int aFF;
    private int aFG;
    private int aFH;
    private int aFI;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.aFC = 0;
        this.aFD = 0;
        this.aFE = 0;
        this.aFG = 0;
        this.aFH = 0;
        this.aFI = 0;
        this.mContext = context;
        setOrientation(0);
        this.aFD = l.e(context, d.e.ds24);
        this.aFE = l.e(context, d.e.ds20);
        this.aFH = l.e(context, d.e.ds32);
        this.aFF = l.ah(this.mContext) - (this.aFH * 2);
        this.aFI = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFC = 0;
        this.aFD = 0;
        this.aFE = 0;
        this.aFG = 0;
        this.aFH = 0;
        this.aFI = 0;
        this.mContext = context;
        setOrientation(0);
        this.aFD = l.e(context, d.e.ds24);
        this.aFE = l.e(context, d.e.ds20);
        this.aFH = l.e(context, d.e.ds32);
        this.aFF = l.ah(this.mContext) - (this.aFH * 2);
        this.aFI = (int) this.mContext.getResources().getDimension(d.e.ds60);
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
                    dimension += this.aFD + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.aFE;
                i7 += this.aFE + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aFI, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.aFC != 0 && this.aFG != 0) {
            ep(childCount);
        }
        if (this.aFC != 0) {
            for (int i3 = 0; i3 < this.aFG; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aFG = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.aFC != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aFI * this.aFC) + this.aFD, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aFI * culumnsCount) + (this.aFD * culumnsCount), i2));
        }
    }

    private void ep(int i) {
        if (this.aFG <= i) {
            removeViews(this.aFG, i - this.aFG);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aFI, 1073741824);
        int childCount = getChildCount();
        int i4 = this.aFF;
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
                        this.aFG = i5;
                    }
                    i = this.aFE + measuredWidth + 0;
                } else {
                    i = this.aFE + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aFF - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.aFC = i;
    }

    public void setMarginRight(int i) {
        this.aFE = i;
    }

    public void setParentWidth(int i) {
        this.aFF = i;
    }

    public void setCellHeight(int i) {
        this.aFI = i;
    }
}
