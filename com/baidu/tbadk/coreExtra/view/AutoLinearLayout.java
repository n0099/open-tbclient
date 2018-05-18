package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int axp;
    private int axq;
    private int axr;
    private int axs;
    private int axt;
    private int axu;
    private int axv;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.axp = 0;
        this.axq = 0;
        this.axr = 0;
        this.axt = 0;
        this.axu = 0;
        this.axv = 0;
        this.mContext = context;
        setOrientation(0);
        this.axq = l.e(context, d.e.ds24);
        this.axr = l.e(context, d.e.ds20);
        this.axu = l.e(context, d.e.ds32);
        this.axs = l.af(this.mContext) - (this.axu * 2);
        this.axv = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axp = 0;
        this.axq = 0;
        this.axr = 0;
        this.axt = 0;
        this.axu = 0;
        this.axv = 0;
        this.mContext = context;
        setOrientation(0);
        this.axq = l.e(context, d.e.ds24);
        this.axr = l.e(context, d.e.ds20);
        this.axu = l.e(context, d.e.ds32);
        this.axs = l.af(this.mContext) - (this.axu * 2);
        this.axv = (int) this.mContext.getResources().getDimension(d.e.ds60);
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
                    dimension += this.axq + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.axr;
                i7 += this.axr + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.axv, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.axp != 0 && this.axt != 0) {
            en(childCount);
        }
        if (this.axp != 0) {
            for (int i3 = 0; i3 < this.axt; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.axt = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.axp != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.axv * this.axp) + this.axq, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.axv * culumnsCount) + (this.axq * culumnsCount), i2));
        }
    }

    private void en(int i) {
        if (this.axt <= i) {
            removeViews(this.axt, i - this.axt);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.axv, 1073741824);
        int childCount = getChildCount();
        int i4 = this.axs;
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
                        this.axt = i5;
                    }
                    i = this.axr + measuredWidth + 0;
                } else {
                    i = this.axr + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.axs - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.axp = i;
    }

    public void setMarginRight(int i) {
        this.axr = i;
    }

    public void setParentWidth(int i) {
        this.axs = i;
    }

    public void setCellHeight(int i) {
        this.axv = i;
    }
}
