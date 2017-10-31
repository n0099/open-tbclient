package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int auh;
    private int aui;
    private int auj;
    private int auk;
    private int aul;
    private int aum;
    private int aun;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.auh = 0;
        this.aui = 0;
        this.auj = 0;
        this.aul = 0;
        this.aum = 0;
        this.aun = 0;
        this.mContext = context;
        setOrientation(0);
        this.aui = l.f(context, d.e.ds24);
        this.auj = l.f(context, d.e.ds20);
        this.aum = l.f(context, d.e.ds32);
        this.auk = l.ac(this.mContext) - (this.aum * 2);
        this.aun = (int) this.mContext.getResources().getDimension(d.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auh = 0;
        this.aui = 0;
        this.auj = 0;
        this.aul = 0;
        this.aum = 0;
        this.aun = 0;
        this.mContext = context;
        setOrientation(0);
        this.aui = l.f(context, d.e.ds24);
        this.auj = l.f(context, d.e.ds20);
        this.aum = l.f(context, d.e.ds32);
        this.auk = l.ac(this.mContext) - (this.aum * 2);
        this.aun = (int) this.mContext.getResources().getDimension(d.e.ds60);
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
                    dimension += this.aui + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.auj;
                i7 += this.auj + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aun, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.auh != 0 && this.aul != 0) {
            eu(childCount);
        }
        if (this.auh != 0) {
            for (int i3 = 0; i3 < this.aul; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aul = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.auh != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aun * this.auh) + this.aui, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aun * culumnsCount) + (this.aui * culumnsCount), i2));
        }
    }

    private void eu(int i) {
        if (this.aul <= i) {
            removeViews(this.aul, i - this.aul);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aun, 1073741824);
        int childCount = getChildCount();
        int i4 = this.auk;
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
                        this.aul = i5;
                    }
                    i = this.auj + measuredWidth + 0;
                } else {
                    i = this.auj + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.auk - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.auh = i;
    }

    public void setMarginRight(int i) {
        this.auj = i;
    }

    public void setParentWidth(int i) {
        this.auk = i;
    }

    public void setCellHeight(int i) {
        this.aun = i;
    }
}
