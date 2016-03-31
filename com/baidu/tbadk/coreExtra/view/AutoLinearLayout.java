package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int ans;
    private int ant;
    private int anu;
    private int anv;
    private int anw;
    private int anx;
    private int any;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.ans = 0;
        this.ant = 0;
        this.anu = 0;
        this.anw = 0;
        this.anx = 0;
        this.any = 0;
        this.mContext = context;
        setOrientation(0);
        this.ant = com.baidu.adp.lib.util.k.c(context, t.e.ds24);
        this.anu = com.baidu.adp.lib.util.k.c(context, t.e.ds20);
        this.anx = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.anv = com.baidu.adp.lib.util.k.B(this.mContext) - (this.anx * 2);
        this.any = (int) this.mContext.getResources().getDimension(t.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ans = 0;
        this.ant = 0;
        this.anu = 0;
        this.anw = 0;
        this.anx = 0;
        this.any = 0;
        this.mContext = context;
        setOrientation(0);
        this.ant = com.baidu.adp.lib.util.k.c(context, t.e.ds24);
        this.anu = com.baidu.adp.lib.util.k.c(context, t.e.ds20);
        this.anx = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.anv = com.baidu.adp.lib.util.k.B(this.mContext) - (this.anx * 2);
        this.any = (int) this.mContext.getResources().getDimension(t.e.ds60);
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
                    dimension += this.ant + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.anu;
                i7 += this.anu + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.any, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.ans != 0 && this.anw != 0) {
            ej(childCount);
        }
        if (this.ans != 0) {
            for (int i3 = 0; i3 < this.anw; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.anw = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.ans != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.any * this.ans) + this.ant, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.any * culumnsCount) + (this.ant * culumnsCount), i2));
        }
    }

    private void ej(int i) {
        if (this.anw <= i) {
            removeViews(this.anw, i - this.anw);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.any, 1073741824);
        int childCount = getChildCount();
        int i4 = this.anv;
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
                        this.anw = i5;
                    }
                    i = this.anu + measuredWidth + 0;
                } else {
                    i = this.anu + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.anv - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.ans = i;
    }

    public void setMarginRight(int i) {
        this.anu = i;
    }

    public void setParentWidth(int i) {
        this.anv = i;
    }

    public void setCellHeight(int i) {
        this.any = i;
    }
}
