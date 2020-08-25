package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class XGridLayout extends AdapterLayout {
    private int fae;
    private int faf;
    private int fag;
    private int fah;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fae = 1;
        this.faf = 0;
        this.fag = 0;
        this.fah = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fae = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fae);
        this.faf = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.faf);
        this.fag = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fag);
        this.fah = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fah);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.faf * (this.fae - 1))) / this.fae;
        int min = Math.min(getChildCount(), this.fah);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fae == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fag;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fah);
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
                    i5 += this.faf + measuredWidth;
                    if ((i6 + 1) % this.fae == 0) {
                        i5 = getPaddingLeft();
                        paddingTop += this.fag + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bwM() {
        if (this.fab != null) {
            removeAllViews();
            int min = Math.min(this.fab.getCount(), this.fah);
            for (int i = 0; i < min; i++) {
                addView(this.fab.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fah = i;
    }

    public void setGridSpan(int i) {
        this.fae = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fae = i;
    }

    public void setVerticalSpace(int i) {
        this.fag = i;
    }

    public void setHorizontalSpace(int i) {
        this.faf = i;
    }

    public void onChangeSkinType() {
        if (this.fab != null) {
            this.fab.notifyDataSetChanged();
        }
    }
}
