package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R$styleable;
import d.a.n0.b1.f.a.b;
import java.util.List;
/* loaded from: classes3.dex */
public class XGridLayout extends AdapterLayout {

    /* renamed from: h  reason: collision with root package name */
    public int f13216h;

    /* renamed from: i  reason: collision with root package name */
    public int f13217i;
    public int j;
    public int k;

    public XGridLayout(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    public void b() {
        if (this.f13210e == null) {
            return;
        }
        removeAllViews();
        int min = Math.min(this.f13210e.a(), this.k);
        for (int i2 = 0; i2 < min; i2++) {
            addView(this.f13210e.b(i2, this));
        }
    }

    public void d() {
        b bVar = this.f13210e;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int min = Math.min(getChildCount(), this.k);
        if (min <= 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < min; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                paddingLeft += measuredWidth + this.f13217i;
                if ((i6 + 1) % this.f13216h == 0) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += measuredHeight + this.j;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i4 = this.f13217i;
        int i5 = this.f13216h;
        int i6 = (paddingLeft - (i4 * (i5 - 1))) / i5;
        int min = Math.min(getChildCount(), this.k);
        if (min <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < min; i8++) {
            View childAt = getChildAt(i8);
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i3);
            if (i8 != 0) {
                if (i8 % this.f13216h == 0) {
                    measuredHeight = childAt.getMeasuredHeight() + this.j;
                }
            } else {
                measuredHeight = childAt.getMeasuredHeight();
            }
            i7 += measuredHeight;
        }
        setMeasuredDimension(size, i7 + getPaddingTop() + getPaddingBottom());
    }

    public void setAutoGridSpan(List<?> list, int i2) {
        if (list.size() < i2) {
            i2 = list.size() % i2;
        }
        this.f13216h = i2;
    }

    public void setGridSpan(int i2) {
        this.f13216h = i2;
    }

    public void setHorizontalSpace(int i2) {
        this.f13217i = i2;
    }

    public void setMaxItem(int i2) {
        this.k = i2;
    }

    public void setVerticalSpace(int i2) {
        this.j = i2;
    }

    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XGridLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13216h = 1;
        this.f13217i = 0;
        this.j = 0;
        this.k = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XGridLayout);
        this.f13216h = obtainStyledAttributes.getInteger(R$styleable.XGridLayout_gridSpan, this.f13216h);
        this.f13217i = (int) obtainStyledAttributes.getDimension(R$styleable.XGridLayout_gridHorizontalSpace, this.f13217i);
        this.j = (int) obtainStyledAttributes.getDimension(R$styleable.XGridLayout_gridVerticalSpace, this.j);
        this.k = obtainStyledAttributes.getInteger(R$styleable.XGridLayout_gridMaxItem, this.k);
        obtainStyledAttributes.recycle();
    }
}
