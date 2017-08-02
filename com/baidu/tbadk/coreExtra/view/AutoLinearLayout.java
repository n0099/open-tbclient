package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int aum;
    private int aun;
    private int auo;
    private int aup;
    private int auq;
    private int aur;
    private int aus;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.aum = 0;
        this.aun = 0;
        this.auo = 0;
        this.auq = 0;
        this.aur = 0;
        this.aus = 0;
        this.mContext = context;
        setOrientation(0);
        this.aun = k.g(context, d.f.ds24);
        this.auo = k.g(context, d.f.ds20);
        this.aur = k.g(context, d.f.ds32);
        this.aup = k.af(this.mContext) - (this.aur * 2);
        this.aus = (int) this.mContext.getResources().getDimension(d.f.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aum = 0;
        this.aun = 0;
        this.auo = 0;
        this.auq = 0;
        this.aur = 0;
        this.aus = 0;
        this.mContext = context;
        setOrientation(0);
        this.aun = k.g(context, d.f.ds24);
        this.auo = k.g(context, d.f.ds20);
        this.aur = k.g(context, d.f.ds32);
        this.aup = k.af(this.mContext) - (this.aur * 2);
        this.aus = (int) this.mContext.getResources().getDimension(d.f.ds60);
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
                    dimension += this.aun + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.auo;
                i7 += this.auo + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aus, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.aum != 0 && this.auq != 0) {
            ej(childCount);
        }
        if (this.aum != 0) {
            for (int i3 = 0; i3 < this.auq; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.auq = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.aum != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aus * this.aum) + this.aun, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.aus * culumnsCount) + (this.aun * culumnsCount), i2));
        }
    }

    private void ej(int i) {
        if (this.auq <= i) {
            removeViews(this.auq, i - this.auq);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aus, 1073741824);
        int childCount = getChildCount();
        int i4 = this.aup;
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
                        this.auq = i5;
                    }
                    i = this.auo + measuredWidth + 0;
                } else {
                    i = this.auo + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aup - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.aum = i;
    }

    public void setMarginRight(int i) {
        this.auo = i;
    }

    public void setParentWidth(int i) {
        this.aup = i;
    }

    public void setCellHeight(int i) {
        this.aus = i;
    }
}
