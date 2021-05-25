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
    public int f13163e;

    /* renamed from: f  reason: collision with root package name */
    public int f13164f;

    /* renamed from: g  reason: collision with root package name */
    public int f13165g;

    /* renamed from: h  reason: collision with root package name */
    public int f13166h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13167i;
    public boolean j;
    public int k;
    public int l;

    public GridLayout(Context context) {
        this(context, null);
    }

    private View[] getNeedLayoutChild() {
        int i2;
        this.l = this.f13163e;
        this.k = this.f13164f;
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.getVisibility() == 8) {
                childCount2--;
            }
        }
        int i4 = this.l;
        if (i4 <= 0 || (i2 = this.k) <= 0) {
            int i5 = this.l;
            if (i5 > 0) {
                if (childCount % i5 == 0) {
                    this.k = childCount / i5;
                } else {
                    this.k = (childCount / i5) + 1;
                }
            } else {
                int i6 = this.k;
                if (i6 > 0) {
                    if (childCount % i6 == 0) {
                        this.l = childCount / i6;
                    } else {
                        this.l = (childCount / i6) + 1;
                    }
                } else if (this.f13167i) {
                    this.l = childCount;
                    this.k = 1;
                } else {
                    this.l = 1;
                    this.k = childCount;
                }
            }
        } else {
            childCount = i4 * i2;
        }
        int min = Math.min(childCount, childCount2);
        View[] viewArr = new View[min];
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt2 = getChildAt(i8);
            if (childAt2 != null && childAt2.getVisibility() != 8 && i7 < min) {
                viewArr[i7] = childAt2;
                i7++;
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

    public final void d(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GridLayout);
        try {
            this.f13165g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.GridLayout_gridHorizontalSpacing, 0);
            this.f13166h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.GridLayout_gridVerticalSpacing, 0);
            this.f13163e = obtainStyledAttributes.getInteger(R$styleable.GridLayout_gridHorizontalNum, -1);
            this.f13164f = obtainStyledAttributes.getInteger(R$styleable.GridLayout_gridVerticalNum, -1);
            this.f13167i = obtainStyledAttributes.getInteger(R$styleable.GridLayout_gridMainOrientation, 0) == 0;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public int getHorNum() {
        return this.f13163e;
    }

    public int getHorSpace() {
        return this.f13165g;
    }

    public int getVerNum() {
        return this.f13164f;
    }

    public int getVerSpace() {
        return this.f13166h;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a A[ADDED_TO_REGION, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        View[] needLayoutChild = getNeedLayoutChild();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int i11 = this.f13163e;
        int i12 = this.f13165g;
        int i13 = (measuredWidth - (i11 * i12)) + i12;
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int i14 = this.f13164f;
        int i15 = this.f13166h;
        int i16 = i13 / this.f13163e;
        int i17 = ((measuredHeight - (i14 * i15)) + i15) / i14;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i18 = 0;
        while (i18 < needLayoutChild.length) {
            View view = needLayoutChild[i18];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight2 = view.getMeasuredHeight();
            int i19 = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
            int i20 = ((FrameLayout.LayoutParams) layoutParams).topMargin;
            int i21 = ((FrameLayout.LayoutParams) layoutParams).gravity & 7;
            if (i21 == 1) {
                i6 = (i16 - measuredWidth2) / 2;
            } else if (i21 != 5) {
                i7 = i19 + 0;
                i8 = ((FrameLayout.LayoutParams) layoutParams).gravity & 112;
                if (i8 != 16) {
                    i9 = (i17 - measuredHeight2) / 2;
                } else if (i8 != 80) {
                    i10 = i20 + 0;
                    view.layout(paddingLeft + i7, paddingTop + i10, measuredWidth2 + paddingLeft + i7, measuredHeight2 + paddingTop + i10);
                    paddingLeft += this.f13165g + i16;
                    i18++;
                    if (i18 % this.l == 0 || i18 == needLayoutChild.length) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.f13166h + i17;
                    }
                } else {
                    i9 = i17 - measuredHeight2;
                }
                i10 = i20 + i9;
                view.layout(paddingLeft + i7, paddingTop + i10, measuredWidth2 + paddingLeft + i7, measuredHeight2 + paddingTop + i10);
                paddingLeft += this.f13165g + i16;
                i18++;
                if (i18 % this.l == 0) {
                }
                paddingLeft = getPaddingLeft();
                paddingTop += this.f13166h + i17;
            } else {
                i6 = i16 - measuredWidth2;
            }
            i7 = i19 + i6;
            i8 = ((FrameLayout.LayoutParams) layoutParams).gravity & 112;
            if (i8 != 16) {
            }
            i10 = i20 + i9;
            view.layout(paddingLeft + i7, paddingTop + i10, measuredWidth2 + paddingLeft + i7, measuredHeight2 + paddingTop + i10);
            paddingLeft += this.f13165g + i16;
            i18++;
            if (i18 % this.l == 0) {
            }
            paddingLeft = getPaddingLeft();
            paddingTop += this.f13166h + i17;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getSize(i3);
        View[] needLayoutChild = getNeedLayoutChild();
        if (this.j) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                measureChild(getChildAt(i5), i2, i3);
            }
        } else {
            for (View view : needLayoutChild) {
                measureChild(view, i2, i3);
            }
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (mode != 0 && mode != Integer.MIN_VALUE) {
            i4 = getMeasuredWidth();
        } else {
            int i6 = paddingLeft;
            int i7 = 0;
            while (i7 < needLayoutChild.length) {
                View view2 = needLayoutChild[i7];
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                paddingLeft = paddingLeft + this.f13165g + view2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams).leftMargin + ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                i7++;
                if (i7 % this.l == 0 || i7 == needLayoutChild.length) {
                    i6 = Math.max(getMeasuredWidth(), paddingLeft);
                    paddingLeft = getPaddingLeft() + getPaddingRight();
                }
            }
            i4 = i6;
        }
        if (mode2 != 0 && mode2 != Integer.MIN_VALUE) {
            paddingTop = getMeasuredHeight();
        } else {
            int i8 = 0;
            int i9 = 0;
            while (i8 < needLayoutChild.length) {
                View view3 = needLayoutChild[i8];
                LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                i9 = Math.max(i9, view3.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).topMargin + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin);
                i8++;
                if (i8 % this.l == 0 || i8 == needLayoutChild.length) {
                    paddingTop += i9;
                    i9 = getPaddingTop() + getPaddingBottom();
                }
            }
        }
        setMeasuredDimension(i4, paddingTop);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int i10 = this.f13163e;
        int i11 = this.f13165g;
        int i12 = (measuredWidth - (i10 * i11)) + i11;
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int i13 = this.f13164f;
        int i14 = this.f13166h;
        int i15 = i12 / this.f13163e;
        int i16 = ((measuredHeight - (i13 * i14)) + i14) / i13;
        for (View view4 : needLayoutChild) {
            LayoutParams layoutParams3 = (LayoutParams) view4.getLayoutParams();
            int measuredWidth2 = view4.getMeasuredWidth();
            int measuredHeight2 = view4.getMeasuredHeight();
            if (((FrameLayout.LayoutParams) layoutParams3).width == -1) {
                measuredWidth2 = (i15 - ((FrameLayout.LayoutParams) layoutParams3).leftMargin) - ((FrameLayout.LayoutParams) layoutParams3).rightMargin;
            }
            if (((FrameLayout.LayoutParams) layoutParams3).height == -1) {
                measuredHeight2 = (i16 - ((FrameLayout.LayoutParams) layoutParams3).topMargin) - ((FrameLayout.LayoutParams) layoutParams3).bottomMargin;
            }
            view4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
        }
    }

    public void setHorNum(int i2) {
        boolean z = this.f13163e != i2;
        this.f13163e = i2;
        if (z) {
            forceLayout();
        }
    }

    public void setHorSpace(int i2) {
        boolean z = this.f13165g != i2;
        this.f13165g = i2;
        if (z) {
            forceLayout();
        }
    }

    public void setMeasureAllChild(boolean z) {
        this.j = z;
    }

    public void setOrientionHor(boolean z) {
        this.f13167i = z;
    }

    public void setVerNum(int i2) {
        boolean z = this.f13164f != i2;
        this.f13164f = i2;
        if (z) {
            forceLayout();
        }
    }

    public void setVerSpace(int i2) {
        boolean z = this.f13166h != i2;
        this.f13166h = i2;
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

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
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

    public GridLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13163e = -1;
        this.f13164f = -1;
        this.f13165g = 0;
        this.f13166h = 0;
        this.f13167i = true;
        this.j = false;
        d(context, attributeSet, i2);
    }
}
