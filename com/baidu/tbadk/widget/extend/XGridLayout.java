package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fpn;
    private int fpo;
    private int fpp;
    private int fpq;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpn = 1;
        this.fpo = 0;
        this.fpp = 0;
        this.fpq = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fpn = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fpn);
        this.fpo = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.fpo);
        this.fpp = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fpp);
        this.fpq = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fpq);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.fpo * (this.fpn - 1))) / this.fpn;
        int min = Math.min(getChildCount(), this.fpq);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fpn == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fpp;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fpq);
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
                    i5 += this.fpo + measuredWidth;
                    if ((i6 + 1) % this.fpn == 0) {
                        i5 = getPaddingLeft();
                        paddingTop += this.fpp + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bAG() {
        if (this.fpk != null) {
            removeAllViews();
            int min = Math.min(this.fpk.getCount(), this.fpq);
            for (int i = 0; i < min; i++) {
                addView(this.fpk.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fpq = i;
    }

    public void setGridSpan(int i) {
        this.fpn = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fpn = i;
    }

    public void setVerticalSpace(int i) {
        this.fpp = i;
    }

    public void setHorizontalSpace(int i) {
        this.fpo = i;
    }

    public void onChangeSkinType() {
        if (this.fpk != null) {
            this.fpk.notifyDataSetChanged();
        }
    }
}
