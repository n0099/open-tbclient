package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int eJc;
    private int eJd;
    private int eJe;
    private int eJf;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eJc = 1;
        this.eJd = 0;
        this.eJe = 0;
        this.eJf = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.eJc = obtainStyledAttributes.getInteger(1, this.eJc);
        this.eJd = (int) obtainStyledAttributes.getDimension(2, this.eJd);
        this.eJe = (int) obtainStyledAttributes.getDimension(0, this.eJe);
        this.eJf = obtainStyledAttributes.getInteger(3, this.eJf);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.eJd * (this.eJc - 1))) / this.eJc;
        int min = Math.min(getChildCount(), this.eJf);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.eJc == 0) {
                    i3 += childAt.getMeasuredHeight() + this.eJe;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.eJf);
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
                    i5 += this.eJd + measuredWidth;
                    if ((i6 + 1) % this.eJc == 0) {
                        i5 = getPaddingLeft();
                        paddingTop += this.eJe + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bkf() {
        if (this.eIZ != null) {
            removeAllViews();
            int min = Math.min(this.eIZ.getCount(), this.eJf);
            for (int i = 0; i < min; i++) {
                addView(this.eIZ.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.eJf = i;
    }

    public void setGridSpan(int i) {
        this.eJc = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.eJc = i;
    }

    public void setVerticalSpace(int i) {
        this.eJe = i;
    }

    public void setHorizontalSpace(int i) {
        this.eJd = i;
    }

    public void onChangeSkinType() {
        if (this.eIZ != null) {
            this.eIZ.notifyDataSetChanged();
        }
    }
}
