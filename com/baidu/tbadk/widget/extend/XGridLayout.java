package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fai;
    private int faj;
    private int fak;
    private int fal;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fai = 1;
        this.faj = 0;
        this.fak = 0;
        this.fal = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fai = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fai);
        this.faj = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.faj);
        this.fak = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fak);
        this.fal = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fal);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.faj * (this.fai - 1))) / this.fai;
        int min = Math.min(getChildCount(), this.fal);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fai == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fak;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fal);
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
                    i5 += this.faj + measuredWidth;
                    if ((i6 + 1) % this.fai == 0) {
                        i5 = getPaddingLeft();
                        paddingTop += this.fak + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bwN() {
        if (this.faf != null) {
            removeAllViews();
            int min = Math.min(this.faf.getCount(), this.fal);
            for (int i = 0; i < min; i++) {
                addView(this.faf.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fal = i;
    }

    public void setGridSpan(int i) {
        this.fai = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fai = i;
    }

    public void setVerticalSpace(int i) {
        this.fak = i;
    }

    public void setHorizontalSpace(int i) {
        this.faj = i;
    }

    public void onChangeSkinType() {
        if (this.faf != null) {
            this.faf.notifyDataSetChanged();
        }
    }
}
