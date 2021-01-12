package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int Yl;
    private int ftA;
    private int ftv;
    private int ftw;
    private int ftx;
    private int fty;
    private int ftz;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.ftv = 0;
        this.Yl = 0;
        this.ftw = 0;
        this.fty = 0;
        this.ftz = 0;
        this.ftA = 0;
        this.mContext = context;
        setOrientation(0);
        this.Yl = l.getDimens(context, R.dimen.ds24);
        this.ftw = l.getDimens(context, R.dimen.ds20);
        this.ftz = l.getDimens(context, R.dimen.ds32);
        this.ftx = l.getEquipmentWidth(this.mContext) - (this.ftz * 2);
        this.ftA = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftv = 0;
        this.Yl = 0;
        this.ftw = 0;
        this.fty = 0;
        this.ftz = 0;
        this.ftA = 0;
        this.mContext = context;
        setOrientation(0);
        this.Yl = l.getDimens(context, R.dimen.ds24);
        this.ftw = l.getDimens(context, R.dimen.ds20);
        this.ftz = l.getDimens(context, R.dimen.ds32);
        this.ftx = l.getEquipmentWidth(this.mContext) - (this.ftz * 2);
        this.ftA = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
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
                    dimension += this.Yl + measuredHeight;
                    i6 = 0;
                }
                childAt.layout(i6, dimension, i6 + measuredWidth, measuredHeight + dimension);
                i5 = (((i3 - i) - i6) - measuredWidth) - this.ftw;
                i6 += this.ftw + measuredWidth;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ftA, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.ftv != 0 && this.fty != 0) {
            qw(childCount);
        }
        if (this.ftv != 0) {
            for (int i3 = 0; i3 < this.fty; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.fty = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.ftv != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ftA * this.ftv) + this.Yl, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.ftA * culumnsCount) + (this.Yl * culumnsCount), i2));
        }
    }

    private void qw(int i) {
        if (this.fty <= i) {
            removeViews(this.fty, i - this.fty);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.ftA, 1073741824);
        int childCount = getChildCount();
        int i3 = this.ftx;
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
                        this.fty = i4;
                    }
                    i = this.ftw + measuredWidth + 0;
                } else {
                    i = this.ftw + measuredWidth + i5;
                }
                i2 = this.ftx - i;
                i5 = i;
            }
            i4++;
            i3 = i2;
        }
        return i6 + 1;
    }

    public void setShowColumns(int i) {
        this.ftv = i;
    }

    public void setMarginRight(int i) {
        this.ftw = i;
    }

    public void setParentWidth(int i) {
        this.ftx = i;
    }

    public void setCellHeight(int i) {
        this.ftA = i;
    }
}
