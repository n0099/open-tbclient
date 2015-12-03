package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int alc;
    private int ald;
    private int ale;
    private int alf;
    private int alg;
    private int alh;
    private int ali;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.alc = 0;
        this.ald = 0;
        this.ale = 0;
        this.alg = 0;
        this.alh = 0;
        this.ali = 0;
        this.mContext = context;
        setOrientation(0);
        this.ald = com.baidu.adp.lib.util.k.d(context, n.d.ds24);
        this.ale = com.baidu.adp.lib.util.k.d(context, n.d.ds20);
        this.alh = com.baidu.adp.lib.util.k.d(context, n.d.ds32);
        this.alf = com.baidu.adp.lib.util.k.K(this.mContext) - (this.alh * 2);
        this.ali = (int) this.mContext.getResources().getDimension(n.d.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alc = 0;
        this.ald = 0;
        this.ale = 0;
        this.alg = 0;
        this.alh = 0;
        this.ali = 0;
        this.mContext = context;
        setOrientation(0);
        this.ald = com.baidu.adp.lib.util.k.d(context, n.d.ds24);
        this.ale = com.baidu.adp.lib.util.k.d(context, n.d.ds20);
        this.alh = com.baidu.adp.lib.util.k.d(context, n.d.ds32);
        this.alf = com.baidu.adp.lib.util.k.K(this.mContext) - (this.alh * 2);
        this.ali = (int) this.mContext.getResources().getDimension(n.d.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(n.d.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.ald + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.ale;
                i7 += this.ale + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ali, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.alc != 0 && this.alg != 0) {
            dR(childCount);
        }
        if (this.alc != 0) {
            for (int i3 = 0; i3 < this.alg; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.alg = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.alc != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ali * this.alc) + this.ald, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ali * culumnsCount) + (this.ald * culumnsCount), i2));
        }
    }

    private void dR(int i) {
        if (this.alg <= i) {
            removeViews(this.alg, i - this.alg);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ali, 1073741824);
        int childCount = getChildCount();
        int i4 = this.alf;
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
                        this.alg = i5;
                    }
                    i = this.ale + measuredWidth + 0;
                } else {
                    i = this.ale + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.alf - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.alc = i;
    }

    public void setMarginRight(int i) {
        this.ale = i;
    }

    public void setParentWidth(int i) {
        this.alf = i;
    }

    public void setCellHeight(int i) {
        this.ali = i;
    }
}
