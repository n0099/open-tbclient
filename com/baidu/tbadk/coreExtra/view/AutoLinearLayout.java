package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int aSA;
    private int aSB;
    private int aSC;
    private int aSD;
    private int aSE;
    private int aSF;
    private int aSz;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.aSz = 0;
        this.aSA = 0;
        this.aSB = 0;
        this.aSD = 0;
        this.aSE = 0;
        this.aSF = 0;
        this.mContext = context;
        setOrientation(0);
        this.aSA = l.h(context, e.C0210e.ds24);
        this.aSB = l.h(context, e.C0210e.ds20);
        this.aSE = l.h(context, e.C0210e.ds32);
        this.aSC = l.aO(this.mContext) - (this.aSE * 2);
        this.aSF = (int) this.mContext.getResources().getDimension(e.C0210e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSz = 0;
        this.aSA = 0;
        this.aSB = 0;
        this.aSD = 0;
        this.aSE = 0;
        this.aSF = 0;
        this.mContext = context;
        setOrientation(0);
        this.aSA = l.h(context, e.C0210e.ds24);
        this.aSB = l.h(context, e.C0210e.ds20);
        this.aSE = l.h(context, e.C0210e.ds32);
        this.aSC = l.aO(this.mContext) - (this.aSE * 2);
        this.aSF = (int) this.mContext.getResources().getDimension(e.C0210e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(e.C0210e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.aSA + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.aSB;
                i7 += this.aSB + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aSF, AiAppsFileUtils.GB);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.aSz != 0 && this.aSD != 0) {
            fp(childCount);
        }
        if (this.aSz != 0) {
            for (int i3 = 0; i3 < this.aSD; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aSD = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.aSz != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aSF * this.aSz) + this.aSA, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aSF * culumnsCount) + (this.aSA * culumnsCount), i2));
        }
    }

    private void fp(int i) {
        if (this.aSD <= i) {
            removeViews(this.aSD, i - this.aSD);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aSF, AiAppsFileUtils.GB);
        int childCount = getChildCount();
        int i4 = this.aSC;
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
                        this.aSD = i5;
                    }
                    i = this.aSB + measuredWidth + 0;
                } else {
                    i = this.aSB + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aSC - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.aSz = i;
    }

    public void setMarginRight(int i) {
        this.aSB = i;
    }

    public void setParentWidth(int i) {
        this.aSC = i;
    }

    public void setCellHeight(int i) {
        this.aSF = i;
    }
}
