package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class XGridLayout extends AdapterLayout {
    private int fTE;
    private int fTF;
    private int fTG;
    private int fTH;

    public XGridLayout(Context context) {
        this(context, null);
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fTE = 1;
        this.fTF = 0;
        this.fTG = 0;
        this.fTH = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XGridLayout);
        this.fTE = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridSpan, this.fTE);
        this.fTF = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridHorizontalSpace, this.fTF);
        this.fTG = (int) obtainStyledAttributes.getDimension(R.styleable.XGridLayout_gridVerticalSpace, this.fTG);
        this.fTH = obtainStyledAttributes.getInteger(R.styleable.XGridLayout_gridMaxItem, this.fTH);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (((size - getPaddingLeft()) - getPaddingRight()) - (this.fTF * (this.fTE - 1))) / this.fTE;
        int min = Math.min(getChildCount(), this.fTH);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), i2);
            if (i4 != 0) {
                if (i4 % this.fTE == 0) {
                    i3 += childAt.getMeasuredHeight() + this.fTG;
                }
            } else {
                i3 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.fTH);
        if (min > 0) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            for (int i5 = 0; i5 < min; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    paddingLeft += this.fTF + measuredWidth;
                    if ((i5 + 1) % this.fTE == 0) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.fTG + measuredHeight;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    protected void bGT() {
        if (this.fTB != null) {
            removeAllViews();
            int min = Math.min(this.fTB.getCount(), this.fTH);
            for (int i = 0; i < min; i++) {
                addView(this.fTB.getView(i, this));
            }
        }
    }

    public void setMaxItem(int i) {
        this.fTH = i;
    }

    public void setGridSpan(int i) {
        this.fTE = i;
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.fTE = i;
    }

    public void setVerticalSpace(int i) {
        this.fTG = i;
    }

    public void setHorizontalSpace(int i) {
        this.fTF = i;
    }

    public void onChangeSkinType() {
        if (this.fTB != null) {
            this.fTB.notifyDataSetChanged();
        }
    }
}
