package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int atK;
    private int atL;
    private int atM;
    private int atN;
    private int atO;
    private int atP;
    private int atQ;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.atK = 0;
        this.atL = 0;
        this.atM = 0;
        this.atO = 0;
        this.atP = 0;
        this.atQ = 0;
        this.mContext = context;
        setOrientation(0);
        this.atL = l.f(context, d.f.ds24);
        this.atM = l.f(context, d.f.ds20);
        this.atP = l.f(context, d.f.ds32);
        this.atN = l.ad(this.mContext) - (this.atP * 2);
        this.atQ = (int) this.mContext.getResources().getDimension(d.f.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atK = 0;
        this.atL = 0;
        this.atM = 0;
        this.atO = 0;
        this.atP = 0;
        this.atQ = 0;
        this.mContext = context;
        setOrientation(0);
        this.atL = l.f(context, d.f.ds24);
        this.atM = l.f(context, d.f.ds20);
        this.atP = l.f(context, d.f.ds32);
        this.atN = l.ad(this.mContext) - (this.atP * 2);
        this.atQ = (int) this.mContext.getResources().getDimension(d.f.ds60);
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
                    dimension += this.atL + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.atM;
                i7 += this.atM + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.atQ, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.atK != 0 && this.atO != 0) {
            et(childCount);
        }
        if (this.atK != 0) {
            for (int i3 = 0; i3 < this.atO; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.atO = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.atK != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.atQ * this.atK) + this.atL, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.atQ * culumnsCount) + (this.atL * culumnsCount), i2));
        }
    }

    private void et(int i) {
        if (this.atO <= i) {
            removeViews(this.atO, i - this.atO);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.atQ, 1073741824);
        int childCount = getChildCount();
        int i4 = this.atN;
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
                        this.atO = i5;
                    }
                    i = this.atM + measuredWidth + 0;
                } else {
                    i = this.atM + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.atN - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.atK = i;
    }

    public void setMarginRight(int i) {
        this.atM = i;
    }

    public void setParentWidth(int i) {
        this.atN = i;
    }

    public void setCellHeight(int i) {
        this.atQ = i;
    }
}
