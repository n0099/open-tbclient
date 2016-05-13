package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int ajg;
    private int ajh;
    private int aji;
    private int ajj;
    private int ajk;
    private int ajl;
    private int ajm;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.ajg = 0;
        this.ajh = 0;
        this.aji = 0;
        this.ajk = 0;
        this.ajl = 0;
        this.ajm = 0;
        this.mContext = context;
        setOrientation(0);
        this.ajh = com.baidu.adp.lib.util.k.c(context, t.e.ds24);
        this.aji = com.baidu.adp.lib.util.k.c(context, t.e.ds20);
        this.ajl = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.ajj = com.baidu.adp.lib.util.k.B(this.mContext) - (this.ajl * 2);
        this.ajm = (int) this.mContext.getResources().getDimension(t.e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajg = 0;
        this.ajh = 0;
        this.aji = 0;
        this.ajk = 0;
        this.ajl = 0;
        this.ajm = 0;
        this.mContext = context;
        setOrientation(0);
        this.ajh = com.baidu.adp.lib.util.k.c(context, t.e.ds24);
        this.aji = com.baidu.adp.lib.util.k.c(context, t.e.ds20);
        this.ajl = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.ajj = com.baidu.adp.lib.util.k.B(this.mContext) - (this.ajl * 2);
        this.ajm = (int) this.mContext.getResources().getDimension(t.e.ds60);
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
                    dimension += this.ajh + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.aji;
                i7 += this.aji + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ajm, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.ajg != 0 && this.ajk != 0) {
            dO(childCount);
        }
        if (this.ajg != 0) {
            for (int i3 = 0; i3 < this.ajk; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.ajk = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.ajg != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ajm * this.ajg) + this.ajh, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ajm * culumnsCount) + (this.ajh * culumnsCount), i2));
        }
    }

    private void dO(int i) {
        if (this.ajk <= i) {
            removeViews(this.ajk, i - this.ajk);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ajm, 1073741824);
        int childCount = getChildCount();
        int i4 = this.ajj;
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
                        this.ajk = i5;
                    }
                    i = this.aji + measuredWidth + 0;
                } else {
                    i = this.aji + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.ajj - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.ajg = i;
    }

    public void setMarginRight(int i) {
        this.aji = i;
    }

    public void setParentWidth(int i) {
        this.ajj = i;
    }

    public void setCellHeight(int i) {
        this.ajm = i;
    }
}
