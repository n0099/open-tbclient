package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fSe;
    private int fSf;
    private int fSg;
    private int fSh;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSe = 1;
        this.fSf = 0;
        this.fSg = 0;
        this.fSh = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fSe = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fSe);
        this.fSf = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.fSf);
        this.fSg = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fSg);
        this.fSh = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fSh);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.fSf * (this.fSe - 1))) / this.fSe;
        int min = Math.min(getChildCount(), this.fSh);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fSe == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fSg;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fSh);
        if (min > 0) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    paddingLeft += this.fSf + measuredWidth;
                    if ((i5 + 1) % this.fSe == 0) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.fSg + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bGP() {
        if (this.fSb != null) {
            removeAllViews();
            int min = Math.min(this.fSb.getCount(), this.fSh);
            for (int i = 0; i < min; i++) {
                addView(this.fSb.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fSh = i;
    }

    public void setGridSpan(int i) {
        this.fSe = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fSe = i;
    }

    public void setVerticalSpace(int i) {
        this.fSg = i;
    }

    public void setHorizontalSpace(int i) {
        this.fSf = i;
    }

    public void onChangeSkinType() {
        if (this.fSb != null) {
            this.fSb.notifyDataSetChanged();
        }
    }
}
