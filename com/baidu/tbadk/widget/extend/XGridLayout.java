package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R$styleable;
import d.b.h0.b1.f.a.b;
import java.util.List;
/* loaded from: classes3.dex */
public class XGridLayout extends AdapterLayout {

    /* renamed from: h  reason: collision with root package name */
    public int f14126h;
    public int i;
    public int j;
    public int k;

    public XGridLayout(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    public void b() {
        if (this.f14120e == null) {
            return;
        }
        removeAllViews();
        int min = Math.min(this.f14120e.a(), this.k);
        for (int i = 0; i < min; i++) {
            addView(this.f14120e.b(i, this));
        }
    }

    public void d() {
        b bVar = this.f14120e;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(getChildCount(), this.k);
        if (min <= 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < min; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                paddingLeft += measuredWidth + this.i;
                if ((i5 + 1) % this.f14126h == 0) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += measuredHeight + this.j;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i3 = this.i;
        int i4 = this.f14126h;
        int i5 = (paddingLeft - (i3 * (i4 - 1))) / i4;
        int min = Math.min(getChildCount(), this.k);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < min; i7++) {
            View childAt = getChildAt(i7);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i2);
            if (i7 != 0) {
                if (i7 % this.f14126h == 0) {
                    measuredHeight = childAt.getMeasuredHeight() + this.j;
                }
            } else {
                measuredHeight = childAt.getMeasuredHeight();
            }
            i6 += measuredHeight;
        }
        setMeasuredDimension(size, i6 + getPaddingTop() + getPaddingBottom());
    }

    public void setAutoGridSpan(List<?> list, int i) {
        if (list.size() < i) {
            i = list.size() % i;
        }
        this.f14126h = i;
    }

    public void setGridSpan(int i) {
        this.f14126h = i;
    }

    public void setHorizontalSpace(int i) {
        this.i = i;
    }

    public void setMaxItem(int i) {
        this.k = i;
    }

    public void setVerticalSpace(int i) {
        this.j = i;
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14126h = 1;
        this.i = 0;
        this.j = 0;
        this.k = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XGridLayout);
        this.f14126h = obtainStyledAttributes.getInteger(R$styleable.XGridLayout_gridSpan, this.f14126h);
        this.i = (int) obtainStyledAttributes.getDimension(R$styleable.XGridLayout_gridHorizontalSpace, this.i);
        this.j = (int) obtainStyledAttributes.getDimension(R$styleable.XGridLayout_gridVerticalSpace, this.j);
        this.k = obtainStyledAttributes.getInteger(R$styleable.XGridLayout_gridMaxItem, this.k);
        obtainStyledAttributes.recycle();
    }
}
