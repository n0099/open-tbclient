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
    private int aPa;
    private int aPb;
    private int aPc;
    private int aPd;
    private int aPe;
    private int aPf;
    private int aPg;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.aPa = 0;
        this.aPb = 0;
        this.aPc = 0;
        this.aPe = 0;
        this.aPf = 0;
        this.aPg = 0;
        this.mContext = context;
        setOrientation(0);
        this.aPb = l.h(context, e.C0200e.ds24);
        this.aPc = l.h(context, e.C0200e.ds20);
        this.aPf = l.h(context, e.C0200e.ds32);
        this.aPd = l.aO(this.mContext) - (this.aPf * 2);
        this.aPg = (int) this.mContext.getResources().getDimension(e.C0200e.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPa = 0;
        this.aPb = 0;
        this.aPc = 0;
        this.aPe = 0;
        this.aPf = 0;
        this.aPg = 0;
        this.mContext = context;
        setOrientation(0);
        this.aPb = l.h(context, e.C0200e.ds24);
        this.aPc = l.h(context, e.C0200e.ds20);
        this.aPf = l.h(context, e.C0200e.ds32);
        this.aPd = l.aO(this.mContext) - (this.aPf * 2);
        this.aPg = (int) this.mContext.getResources().getDimension(e.C0200e.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(e.C0200e.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.aPb + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.aPc;
                i7 += this.aPc + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aPg, AiAppsFileUtils.GB);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.aPa != 0 && this.aPe != 0) {
            fb(childCount);
        }
        if (this.aPa != 0) {
            for (int i3 = 0; i3 < this.aPe; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aPe = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.aPa != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aPg * this.aPa) + this.aPb, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aPg * culumnsCount) + (this.aPb * culumnsCount), i2));
        }
    }

    private void fb(int i) {
        if (this.aPe <= i) {
            removeViews(this.aPe, i - this.aPe);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aPg, AiAppsFileUtils.GB);
        int childCount = getChildCount();
        int i4 = this.aPd;
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
                        this.aPe = i5;
                    }
                    i = this.aPc + measuredWidth + 0;
                } else {
                    i = this.aPc + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aPd - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.aPa = i;
    }

    public void setMarginRight(int i) {
        this.aPc = i;
    }

    public void setParentWidth(int i) {
        this.aPd = i;
    }

    public void setCellHeight(int i) {
        this.aPg = i;
    }
}
