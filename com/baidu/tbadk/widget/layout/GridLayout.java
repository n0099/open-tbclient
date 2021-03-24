package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public class GridLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f14211e;

    /* renamed from: f  reason: collision with root package name */
    public int f14212f;

    /* renamed from: g  reason: collision with root package name */
    public int f14213g;

    /* renamed from: h  reason: collision with root package name */
    public int f14214h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;

    public GridLayout(Context context) {
        this(context, null);
    }

    private View[] getNeedLayoutChild() {
        int i;
        this.l = this.f14211e;
        this.k = this.f14212f;
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt == null || childAt.getVisibility() == 8) {
                childCount2--;
            }
        }
        int i3 = this.l;
        if (i3 <= 0 || (i = this.k) <= 0) {
            int i4 = this.l;
            if (i4 > 0) {
                if (childCount % i4 == 0) {
                    this.k = childCount / i4;
                } else {
                    this.k = (childCount / i4) + 1;
                }
            } else {
                int i5 = this.k;
                if (i5 > 0) {
                    if (childCount % i5 == 0) {
                        this.l = childCount / i5;
                    } else {
                        this.l = (childCount / i5) + 1;
                    }
                } else if (this.i) {
                    this.l = childCount;
                    this.k = 1;
                } else {
                    this.l = 1;
                    this.k = childCount;
                }
            }
        } else {
            childCount = i3 * i;
        }
        int min = Math.min(childCount, childCount2);
        View[] viewArr = new View[min];
        int i6 = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt2 = getChildAt(i7);
            if (childAt2 != null && childAt2.getVisibility() != 8 && i6 < min) {
                viewArr[i6] = childAt2;
                i6++;
            }
        }
        return viewArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void d(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GridLayout);
        try {
            this.f14213g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.GridLayout_gridHorizontalSpacing, 0);
            this.f14214h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.GridLayout_gridVerticalSpacing, 0);
            this.f14211e = obtainStyledAttributes.getInteger(R$styleable.GridLayout_gridHorizontalNum, -1);
            this.f14212f = obtainStyledAttributes.getInteger(R$styleable.GridLayout_gridVerticalNum, -1);
            this.i = obtainStyledAttributes.getInteger(R$styleable.GridLayout_gridMainOrientation, 0) == 0;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public int getHorNum() {
        return this.f14211e;
    }

    public int getHorSpace() {
        return this.f14213g;
    }

    public int getVerNum() {
        return this.f14212f;
    }

    public int getVerSpace() {
        return this.f14214h;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a A[ADDED_TO_REGION, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        View[] needLayoutChild = getNeedLayoutChild();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int i10 = this.f14211e;
        int i11 = this.f14213g;
        int i12 = (measuredWidth - (i10 * i11)) + i11;
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int i13 = this.f14212f;
        int i14 = this.f14214h;
        int i15 = i12 / this.f14211e;
        int i16 = ((measuredHeight - (i13 * i14)) + i14) / i13;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i17 = 0;
        while (i17 < needLayoutChild.length) {
            View view = needLayoutChild[i17];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight2 = view.getMeasuredHeight();
            int i18 = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
            int i19 = ((FrameLayout.LayoutParams) layoutParams).topMargin;
            int i20 = ((FrameLayout.LayoutParams) layoutParams).gravity & 7;
            if (i20 == 1) {
                i5 = (i15 - measuredWidth2) / 2;
            } else if (i20 != 5) {
                i6 = i18 + 0;
                i7 = ((FrameLayout.LayoutParams) layoutParams).gravity & 112;
                if (i7 != 16) {
                    i8 = (i16 - measuredHeight2) / 2;
                } else if (i7 != 80) {
                    i9 = i19 + 0;
                    view.layout(paddingLeft + i6, paddingTop + i9, measuredWidth2 + paddingLeft + i6, measuredHeight2 + paddingTop + i9);
                    paddingLeft += this.f14213g + i15;
                    i17++;
                    if (i17 % this.l == 0 || i17 == needLayoutChild.length) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.f14214h + i16;
                    }
                } else {
                    i8 = i16 - measuredHeight2;
                }
                i9 = i19 + i8;
                view.layout(paddingLeft + i6, paddingTop + i9, measuredWidth2 + paddingLeft + i6, measuredHeight2 + paddingTop + i9);
                paddingLeft += this.f14213g + i15;
                i17++;
                if (i17 % this.l == 0) {
                }
                paddingLeft = getPaddingLeft();
                paddingTop += this.f14214h + i16;
            } else {
                i5 = i15 - measuredWidth2;
            }
            i6 = i18 + i5;
            i7 = ((FrameLayout.LayoutParams) layoutParams).gravity & 112;
            if (i7 != 16) {
            }
            i9 = i19 + i8;
            view.layout(paddingLeft + i6, paddingTop + i9, measuredWidth2 + paddingLeft + i6, measuredHeight2 + paddingTop + i9);
            paddingLeft += this.f14213g + i15;
            i17++;
            if (i17 % this.l == 0) {
            }
            paddingLeft = getPaddingLeft();
            paddingTop += this.f14214h + i16;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        View[] needLayoutChild = getNeedLayoutChild();
        if (this.j) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                measureChild(getChildAt(i4), i, i2);
            }
        } else {
            for (View view : needLayoutChild) {
                measureChild(view, i, i2);
            }
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (mode != 0 && mode != Integer.MIN_VALUE) {
            i3 = getMeasuredWidth();
        } else {
            int i5 = paddingLeft;
            int i6 = 0;
            while (i6 < needLayoutChild.length) {
                View view2 = needLayoutChild[i6];
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                paddingLeft = paddingLeft + this.f14213g + view2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams).leftMargin + ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                i6++;
                if (i6 % this.l == 0 || i6 == needLayoutChild.length) {
                    i5 = Math.max(getMeasuredWidth(), paddingLeft);
                    paddingLeft = getPaddingLeft() + getPaddingRight();
                }
            }
            i3 = i5;
        }
        if (mode2 != 0 && mode2 != Integer.MIN_VALUE) {
            paddingTop = getMeasuredHeight();
        } else {
            int i7 = 0;
            int i8 = 0;
            while (i7 < needLayoutChild.length) {
                View view3 = needLayoutChild[i7];
                LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                i8 = Math.max(i8, view3.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).topMargin + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin);
                i7++;
                if (i7 % this.l == 0 || i7 == needLayoutChild.length) {
                    paddingTop += i8;
                    i8 = getPaddingTop() + getPaddingBottom();
                }
            }
        }
        setMeasuredDimension(i3, paddingTop);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int i9 = this.f14211e;
        int i10 = this.f14213g;
        int i11 = (measuredWidth - (i9 * i10)) + i10;
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int i12 = this.f14212f;
        int i13 = this.f14214h;
        int i14 = i11 / this.f14211e;
        int i15 = ((measuredHeight - (i12 * i13)) + i13) / i12;
        for (View view4 : needLayoutChild) {
            LayoutParams layoutParams3 = (LayoutParams) view4.getLayoutParams();
            int measuredWidth2 = view4.getMeasuredWidth();
            int measuredHeight2 = view4.getMeasuredHeight();
            if (((FrameLayout.LayoutParams) layoutParams3).width == -1) {
                measuredWidth2 = (i14 - ((FrameLayout.LayoutParams) layoutParams3).leftMargin) - ((FrameLayout.LayoutParams) layoutParams3).rightMargin;
            }
            if (((FrameLayout.LayoutParams) layoutParams3).height == -1) {
                measuredHeight2 = (i15 - ((FrameLayout.LayoutParams) layoutParams3).topMargin) - ((FrameLayout.LayoutParams) layoutParams3).bottomMargin;
            }
            view4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
        }
    }

    public void setHorNum(int i) {
        boolean z = this.f14211e != i;
        this.f14211e = i;
        if (z) {
            forceLayout();
        }
    }

    public void setHorSpace(int i) {
        boolean z = this.f14213g != i;
        this.f14213g = i;
        if (z) {
            forceLayout();
        }
    }

    public void setMeasureAllChild(boolean z) {
        this.j = z;
    }

    public void setOrientionHor(boolean z) {
        this.i = z;
    }

    public void setVerNum(int i) {
        boolean z = this.f14212f != i;
        this.f14212f = i;
        if (z) {
            forceLayout();
        }
    }

    public void setVerSpace(int i) {
        boolean z = this.f14214h != i;
        this.f14214h = i;
        if (z) {
            forceLayout();
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            ((FrameLayout.LayoutParams) this).gravity = 17;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            ((FrameLayout.LayoutParams) this).gravity = 17;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ((FrameLayout.LayoutParams) this).gravity = 17;
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14211e = -1;
        this.f14212f = -1;
        this.f14213g = 0;
        this.f14214h = 0;
        this.i = true;
        this.j = false;
        d(context, attributeSet, i);
    }
}
