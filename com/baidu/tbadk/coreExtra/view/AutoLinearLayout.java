package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int eot;
    private int eou;
    private int eov;
    private int eow;
    private int eox;
    private int eoy;
    private int eoz;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.eot = 0;
        this.eou = 0;
        this.eov = 0;
        this.eox = 0;
        this.eoy = 0;
        this.eoz = 0;
        this.mContext = context;
        setOrientation(0);
        this.eou = l.getDimens(context, R.dimen.ds24);
        this.eov = l.getDimens(context, R.dimen.ds20);
        this.eoy = l.getDimens(context, R.dimen.ds32);
        this.eow = l.getEquipmentWidth(this.mContext) - (this.eoy * 2);
        this.eoz = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eot = 0;
        this.eou = 0;
        this.eov = 0;
        this.eox = 0;
        this.eoy = 0;
        this.eoz = 0;
        this.mContext = context;
        setOrientation(0);
        this.eou = l.getDimens(context, R.dimen.ds24);
        this.eov = l.getDimens(context, R.dimen.ds20);
        this.eoy = l.getDimens(context, R.dimen.ds32);
        this.eow = l.getEquipmentWidth(this.mContext) - (this.eoy * 2);
        this.eoz = (int) this.mContext.getResources().getDimension(R.dimen.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.eou + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.eov;
                i7 += this.eov + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.eoz, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.eot != 0 && this.eox != 0) {
            ni(childCount);
        }
        if (this.eot != 0) {
            for (int i3 = 0; i3 < this.eox; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.eox = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.eot != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.eoz * this.eot) + this.eou, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.eoz * culumnsCount) + (this.eou * culumnsCount), i2));
        }
    }

    private void ni(int i) {
        if (this.eox <= i) {
            removeViews(this.eox, i - this.eox);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.eoz, 1073741824);
        int childCount = getChildCount();
        int i4 = this.eow;
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
                        this.eox = i5;
                    }
                    i = this.eov + measuredWidth + 0;
                } else {
                    i = this.eov + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.eow - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.eot = i;
    }

    public void setMarginRight(int i) {
        this.eov = i;
    }

    public void setParentWidth(int i) {
        this.eow = i;
    }

    public void setCellHeight(int i) {
        this.eoz = i;
    }
}
