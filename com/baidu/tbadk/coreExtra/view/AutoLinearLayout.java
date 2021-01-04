package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int Yn;
    private int fyd;
    private int fye;
    private int fyf;
    private int fyg;
    private int fyh;
    private int fyi;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.fyd = 0;
        this.Yn = 0;
        this.fye = 0;
        this.fyg = 0;
        this.fyh = 0;
        this.fyi = 0;
        this.mContext = context;
        setOrientation(0);
        this.Yn = l.getDimens(context, R.dimen.ds24);
        this.fye = l.getDimens(context, R.dimen.ds20);
        this.fyh = l.getDimens(context, R.dimen.ds32);
        this.fyf = l.getEquipmentWidth(this.mContext) - (this.fyh * 2);
        this.fyi = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyd = 0;
        this.Yn = 0;
        this.fye = 0;
        this.fyg = 0;
        this.fyh = 0;
        this.fyi = 0;
        this.mContext = context;
        setOrientation(0);
        this.Yn = l.getDimens(context, R.dimen.ds24);
        this.fye = l.getDimens(context, R.dimen.ds20);
        this.fyh = l.getDimens(context, R.dimen.ds32);
        this.fyf = l.getEquipmentWidth(this.mContext) - (this.fyh * 2);
        this.fyi = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ds24);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i6 != 0 && i5 < measuredWidth) {
                    dimension += this.Yn + measuredHeight;
                    i6 = 0;
                }
                childAt.layout(i6, dimension, i6 + measuredWidth, measuredHeight + dimension);
                i5 = (((i3 - i) - i6) - measuredWidth) - this.fye;
                i6 += this.fye + measuredWidth;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.fyi, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.fyd != 0 && this.fyg != 0) {
            sc(childCount);
        }
        if (this.fyd != 0) {
            for (int i3 = 0; i3 < this.fyg; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.fyg = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.fyd != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.fyi * this.fyd) + this.Yn, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.fyi * culumnsCount) + (this.Yn * culumnsCount), i2));
        }
    }

    private void sc(int i) {
        if (this.fyg <= i) {
            removeViews(this.fyg, i - this.fyg);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.fyi, 1073741824);
        int childCount = getChildCount();
        int i3 = this.fyf;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt == null) {
                i2 = i3;
            } else {
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                if (i3 < measuredWidth) {
                    i6++;
                    if (i6 == 1) {
                        this.fyg = i4;
                    }
                    i = this.fye + measuredWidth + 0;
                } else {
                    i = this.fye + measuredWidth + i5;
                }
                i2 = this.fyf - i;
                i5 = i;
            }
            i4++;
            i3 = i2;
        }
        return i6 + 1;
    }

    public void setShowColumns(int i) {
        this.fyd = i;
    }

    public void setMarginRight(int i) {
        this.fye = i;
    }

    public void setParentWidth(int i) {
        this.fyf = i;
    }

    public void setCellHeight(int i) {
        this.fyi = i;
    }
}
