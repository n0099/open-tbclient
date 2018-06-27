package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int aGA;
    private int aGB;
    private int aGv;
    private int aGw;
    private int aGx;
    private int aGy;
    private int aGz;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.aGv = 0;
        this.aGw = 0;
        this.aGx = 0;
        this.aGz = 0;
        this.aGA = 0;
        this.aGB = 0;
        this.mContext = context;
        setOrientation(0);
        this.aGw = l.e(context, d.e.ds24);
        this.aGx = l.e(context, d.e.ds20);
        this.aGA = l.e(context, d.e.ds32);
        this.aGy = l.ah(this.mContext) - (this.aGA * 2);
        this.aGB = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGv = 0;
        this.aGw = 0;
        this.aGx = 0;
        this.aGz = 0;
        this.aGA = 0;
        this.aGB = 0;
        this.mContext = context;
        setOrientation(0);
        this.aGw = l.e(context, d.e.ds24);
        this.aGx = l.e(context, d.e.ds20);
        this.aGA = l.e(context, d.e.ds32);
        this.aGy = l.ah(this.mContext) - (this.aGA * 2);
        this.aGB = (int) this.mContext.getResources().getDimension(d.e.ds60);
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
                    dimension += this.aGw + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.aGx;
                i7 += this.aGx + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aGB, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.aGv != 0 && this.aGz != 0) {
            eq(childCount);
        }
        if (this.aGv != 0) {
            for (int i3 = 0; i3 < this.aGz; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aGz = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.aGv != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aGB * this.aGv) + this.aGw, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aGB * culumnsCount) + (this.aGw * culumnsCount), i2));
        }
    }

    private void eq(int i) {
        if (this.aGz <= i) {
            removeViews(this.aGz, i - this.aGz);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aGB, 1073741824);
        int childCount = getChildCount();
        int i4 = this.aGy;
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
                        this.aGz = i5;
                    }
                    i = this.aGx + measuredWidth + 0;
                } else {
                    i = this.aGx + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aGy - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.aGv = i;
    }

    public void setMarginRight(int i) {
        this.aGx = i;
    }

    public void setParentWidth(int i) {
        this.aGy = i;
    }

    public void setCellHeight(int i) {
        this.aGB = i;
    }
}
