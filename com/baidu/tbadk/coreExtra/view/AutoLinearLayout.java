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
    private int aOk;
    private int aOl;
    private int aOm;
    private int aOn;
    private int aOo;
    private int aOp;
    private int aOq;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.aOk = 0;
        this.aOl = 0;
        this.aOm = 0;
        this.aOo = 0;
        this.aOp = 0;
        this.aOq = 0;
        this.mContext = context;
        setOrientation(0);
        this.aOl = l.h(context, e.C0175e.ds24);
        this.aOm = l.h(context, e.C0175e.ds20);
        this.aOp = l.h(context, e.C0175e.ds32);
        this.aOn = l.aO(this.mContext) - (this.aOp * 2);
        this.aOq = (int) this.mContext.getResources().getDimension(e.C0175e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOk = 0;
        this.aOl = 0;
        this.aOm = 0;
        this.aOo = 0;
        this.aOp = 0;
        this.aOq = 0;
        this.mContext = context;
        setOrientation(0);
        this.aOl = l.h(context, e.C0175e.ds24);
        this.aOm = l.h(context, e.C0175e.ds20);
        this.aOp = l.h(context, e.C0175e.ds32);
        this.aOn = l.aO(this.mContext) - (this.aOp * 2);
        this.aOq = (int) this.mContext.getResources().getDimension(e.C0175e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(e.C0175e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.aOl + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.aOm;
                i7 += this.aOm + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aOq, AiAppsFileUtils.GB);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.aOk != 0 && this.aOo != 0) {
            eN(childCount);
        }
        if (this.aOk != 0) {
            for (int i3 = 0; i3 < this.aOo; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aOo = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.aOk != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aOq * this.aOk) + this.aOl, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aOq * culumnsCount) + (this.aOl * culumnsCount), i2));
        }
    }

    private void eN(int i) {
        if (this.aOo <= i) {
            removeViews(this.aOo, i - this.aOo);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aOq, AiAppsFileUtils.GB);
        int childCount = getChildCount();
        int i4 = this.aOn;
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
                        this.aOo = i5;
                    }
                    i = this.aOm + measuredWidth + 0;
                } else {
                    i = this.aOm + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aOn - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.aOk = i;
    }

    public void setMarginRight(int i) {
        this.aOm = i;
    }

    public void setParentWidth(int i) {
        this.aOn = i;
    }

    public void setCellHeight(int i) {
        this.aOq = i;
    }
}
