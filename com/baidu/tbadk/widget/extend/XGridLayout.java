package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fxN;
    private int fxO;
    private int fxP;
    private int fxQ;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fxN = 1;
        this.fxO = 0;
        this.fxP = 0;
        this.fxQ = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fxN = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fxN);
        this.fxO = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.fxO);
        this.fxP = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fxP);
        this.fxQ = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fxQ);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.fxO * (this.fxN - 1))) / this.fxN;
        int min = Math.min(getChildCount(), this.fxQ);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fxN == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fxP;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fxQ);
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
                    i5 += this.fxO + measuredWidth;
                    if ((i6 + 1) % this.fxN == 0) {
                        i5 = getPaddingLeft();
                        paddingTop += this.fxP + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bCz() {
        if (this.fxK != null) {
            removeAllViews();
            int min = Math.min(this.fxK.getCount(), this.fxQ);
            for (int i = 0; i < min; i++) {
                addView(this.fxK.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fxQ = i;
    }

    public void setGridSpan(int i) {
        this.fxN = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fxN = i;
    }

    public void setVerticalSpace(int i) {
        this.fxP = i;
    }

    public void setHorizontalSpace(int i) {
        this.fxO = i;
    }

    public void onChangeSkinType() {
        if (this.fxK != null) {
            this.fxK.notifyDataSetChanged();
        }
    }
}
