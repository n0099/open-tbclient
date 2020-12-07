package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fKS;
    private int fKT;
    private int fKU;
    private int fKV;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fKS = 1;
        this.fKT = 0;
        this.fKU = 0;
        this.fKV = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fKS = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fKS);
        this.fKT = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.fKT);
        this.fKU = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fKU);
        this.fKV = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fKV);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.fKT * (this.fKS - 1))) / this.fKS;
        int min = Math.min(getChildCount(), this.fKV);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fKS == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fKU;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fKV);
        if (min > 0) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i5 = paddingLeft;
            for (int i6 = 0; i6 < min; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(i5, paddingTop, i5 + measuredWidth, paddingTop + measuredHeight);
                    i5 += this.fKT + measuredWidth;
                    if ((i6 + 1) % this.fKS == 0) {
                        i5 = getPaddingLeft();
                        paddingTop += this.fKU + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bHS() {
        if (this.fKP != null) {
            removeAllViews();
            int min = Math.min(this.fKP.getCount(), this.fKV);
            for (int i = 0; i < min; i++) {
                addView(this.fKP.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fKV = i;
    }

    public void setGridSpan(int i) {
        this.fKS = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fKS = i;
    }

    public void setVerticalSpace(int i) {
        this.fKU = i;
    }

    public void setHorizontalSpace(int i) {
        this.fKT = i;
    }

    public void onChangeSkinType() {
        if (this.fKP != null) {
            this.fKP.notifyDataSetChanged();
        }
    }
}
