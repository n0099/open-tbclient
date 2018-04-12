package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int axo;
    private int axp;
    private int axq;
    private int axr;
    private int axs;
    private int axt;
    private int axu;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.axo = 0;
        this.axp = 0;
        this.axq = 0;
        this.axs = 0;
        this.axt = 0;
        this.axu = 0;
        this.mContext = context;
        setOrientation(0);
        this.axp = l.e(context, d.e.ds24);
        this.axq = l.e(context, d.e.ds20);
        this.axt = l.e(context, d.e.ds32);
        this.axr = l.af(this.mContext) - (this.axt * 2);
        this.axu = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axo = 0;
        this.axp = 0;
        this.axq = 0;
        this.axs = 0;
        this.axt = 0;
        this.axu = 0;
        this.mContext = context;
        setOrientation(0);
        this.axp = l.e(context, d.e.ds24);
        this.axq = l.e(context, d.e.ds20);
        this.axt = l.e(context, d.e.ds32);
        this.axr = l.af(this.mContext) - (this.axt * 2);
        this.axu = (int) this.mContext.getResources().getDimension(d.e.ds60);
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
                    dimension += this.axp + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.axq;
                i7 += this.axq + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.axu, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.axo != 0 && this.axs != 0) {
            en(childCount);
        }
        if (this.axo != 0) {
            for (int i3 = 0; i3 < this.axs; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.axs = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.axo != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.axu * this.axo) + this.axp, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.axu * culumnsCount) + (this.axp * culumnsCount), i2));
        }
    }

    private void en(int i) {
        if (this.axs <= i) {
            removeViews(this.axs, i - this.axs);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.axu, 1073741824);
        int childCount = getChildCount();
        int i4 = this.axr;
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
                        this.axs = i5;
                    }
                    i = this.axq + measuredWidth + 0;
                } else {
                    i = this.axq + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.axr - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.axo = i;
    }

    public void setMarginRight(int i) {
        this.axq = i;
    }

    public void setParentWidth(int i) {
        this.axr = i;
    }

    public void setCellHeight(int i) {
        this.axu = i;
    }
}
