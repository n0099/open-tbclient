package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int asr;
    private int ass;
    private int ast;
    private int asu;
    private int asv;
    private int asw;
    private int asx;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.asr = 0;
        this.ass = 0;
        this.ast = 0;
        this.asv = 0;
        this.asw = 0;
        this.asx = 0;
        this.mContext = context;
        setOrientation(0);
        this.ass = com.baidu.adp.lib.util.k.g(context, w.f.ds24);
        this.ast = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.asw = com.baidu.adp.lib.util.k.g(context, w.f.ds32);
        this.asu = com.baidu.adp.lib.util.k.af(this.mContext) - (this.asw * 2);
        this.asx = (int) this.mContext.getResources().getDimension(w.f.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asr = 0;
        this.ass = 0;
        this.ast = 0;
        this.asv = 0;
        this.asw = 0;
        this.asx = 0;
        this.mContext = context;
        setOrientation(0);
        this.ass = com.baidu.adp.lib.util.k.g(context, w.f.ds24);
        this.ast = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.asw = com.baidu.adp.lib.util.k.g(context, w.f.ds32);
        this.asu = com.baidu.adp.lib.util.k.af(this.mContext) - (this.asw * 2);
        this.asx = (int) this.mContext.getResources().getDimension(w.f.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(w.f.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.ass + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.ast;
                i7 += this.ast + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.asx, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.asr != 0 && this.asv != 0) {
            ef(childCount);
        }
        if (this.asr != 0) {
            for (int i3 = 0; i3 < this.asv; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.asv = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.asr != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.asx * this.asr) + this.ass, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.asx * culumnsCount) + (this.ass * culumnsCount), i2));
        }
    }

    private void ef(int i) {
        if (this.asv <= i) {
            removeViews(this.asv, i - this.asv);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.asx, 1073741824);
        int childCount = getChildCount();
        int i4 = this.asu;
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
                        this.asv = i5;
                    }
                    i = this.ast + measuredWidth + 0;
                } else {
                    i = this.ast + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.asu - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.asr = i;
    }

    public void setMarginRight(int i) {
        this.ast = i;
    }

    public void setParentWidth(int i) {
        this.asu = i;
    }

    public void setCellHeight(int i) {
        this.asx = i;
    }
}
