package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fPR;
    private int fPS;
    private int fPT;
    private int fPU;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPR = 1;
        this.fPS = 0;
        this.fPT = 0;
        this.fPU = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fPR = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fPR);
        this.fPS = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.fPS);
        this.fPT = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fPT);
        this.fPU = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fPU);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.fPS * (this.fPR - 1))) / this.fPR;
        int min = Math.min(getChildCount(), this.fPU);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fPR == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fPT;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fPU);
        if (min > 0) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    paddingLeft += this.fPS + measuredWidth;
                    if ((i5 + 1) % this.fPR == 0) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.fPT + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bGv() {
        if (this.fPO != null) {
            removeAllViews();
            int min = Math.min(this.fPO.getCount(), this.fPU);
            for (int i = 0; i < min; i++) {
                addView(this.fPO.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fPU = i;
    }

    public void setGridSpan(int i) {
        this.fPR = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fPR = i;
    }

    public void setVerticalSpace(int i) {
        this.fPT = i;
    }

    public void setHorizontalSpace(int i) {
        this.fPS = i;
    }

    public void onChangeSkinType() {
        if (this.fPO != null) {
            this.fPO.notifyDataSetChanged();
        }
    }
}
