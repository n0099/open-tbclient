package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fUA;
    private int fUB;
    private int fUy;
    private int fUz;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fUy = 1;
        this.fUz = 0;
        this.fUA = 0;
        this.fUB = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fUy = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fUy);
        this.fUz = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.fUz);
        this.fUA = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fUA);
        this.fUB = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fUB);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.fUz * (this.fUy - 1))) / this.fUy;
        int min = Math.min(getChildCount(), this.fUB);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fUy == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fUA;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fUB);
        if (min > 0) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    paddingLeft += this.fUz + measuredWidth;
                    if ((i5 + 1) % this.fUy == 0) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.fUA + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bKm() {
        if (this.fUv != null) {
            removeAllViews();
            int min = Math.min(this.fUv.getCount(), this.fUB);
            for (int i = 0; i < min; i++) {
                addView(this.fUv.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fUB = i;
    }

    public void setGridSpan(int i) {
        this.fUy = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fUy = i;
    }

    public void setVerticalSpace(int i) {
        this.fUA = i;
    }

    public void setHorizontalSpace(int i) {
        this.fUz = i;
    }

    public void onChangeSkinType() {
        if (this.fUv != null) {
            this.fUv.notifyDataSetChanged();
        }
    }
}
