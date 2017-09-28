package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int atW;
    private int atX;
    private int atY;
    private int atZ;
    private int aua;
    private int aub;
    private int auc;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.atW = 0;
        this.atX = 0;
        this.atY = 0;
        this.aua = 0;
        this.aub = 0;
        this.auc = 0;
        this.mContext = context;
        setOrientation(0);
        this.atX = l.f(context, d.f.ds24);
        this.atY = l.f(context, d.f.ds20);
        this.aub = l.f(context, d.f.ds32);
        this.atZ = l.ad(this.mContext) - (this.aub * 2);
        this.auc = (int) this.mContext.getResources().getDimension(d.f.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atW = 0;
        this.atX = 0;
        this.atY = 0;
        this.aua = 0;
        this.aub = 0;
        this.auc = 0;
        this.mContext = context;
        setOrientation(0);
        this.atX = l.f(context, d.f.ds24);
        this.atY = l.f(context, d.f.ds20);
        this.aub = l.f(context, d.f.ds32);
        this.atZ = l.ad(this.mContext) - (this.aub * 2);
        this.auc = (int) this.mContext.getResources().getDimension(d.f.ds60);
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
                    dimension += this.atX + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.atY;
                i7 += this.atY + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.auc, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.atW != 0 && this.aua != 0) {
            eu(childCount);
        }
        if (this.atW != 0) {
            for (int i3 = 0; i3 < this.aua; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.aua = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.atW != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.auc * this.atW) + this.atX, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.auc * culumnsCount) + (this.atX * culumnsCount), i2));
        }
    }

    private void eu(int i) {
        if (this.aua <= i) {
            removeViews(this.aua, i - this.aua);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.auc, 1073741824);
        int childCount = getChildCount();
        int i4 = this.atZ;
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
                        this.aua = i5;
                    }
                    i = this.atY + measuredWidth + 0;
                } else {
                    i = this.atY + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.atZ - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.atW = i;
    }

    public void setMarginRight(int i) {
        this.atY = i;
    }

    public void setParentWidth(int i) {
        this.atZ = i;
    }

    public void setCellHeight(int i) {
        this.auc = i;
    }
}
