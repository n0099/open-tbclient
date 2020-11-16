package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fDg;
    private int fDh;
    private int fDi;
    private int fDj;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDg = 1;
        this.fDh = 0;
        this.fDi = 0;
        this.fDj = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fDg = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fDg);
        this.fDh = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.fDh);
        this.fDi = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fDi);
        this.fDj = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fDj);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.fDh * (this.fDg - 1))) / this.fDg;
        int min = Math.min(getChildCount(), this.fDj);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fDg == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fDi;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fDj);
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
                    i5 += this.fDh + measuredWidth;
                    if ((i6 + 1) % this.fDg == 0) {
                        i5 = getPaddingLeft();
                        paddingTop += this.fDi + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bEr() {
        if (this.fDd != null) {
            removeAllViews();
            int min = Math.min(this.fDd.getCount(), this.fDj);
            for (int i = 0; i < min; i++) {
                addView(this.fDd.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fDj = i;
    }

    public void setGridSpan(int i) {
        this.fDg = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fDg = i;
    }

    public void setVerticalSpace(int i) {
        this.fDi = i;
    }

    public void setHorizontalSpace(int i) {
        this.fDh = i;
    }

    public void onChangeSkinType() {
        if (this.fDd != null) {
            this.fDd.notifyDataSetChanged();
        }
    }
}
