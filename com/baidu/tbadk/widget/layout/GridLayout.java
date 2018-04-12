package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class GridLayout extends ViewGroup {
    private int aTR;
    private int aTS;
    private int aTT;
    private int aTU;
    private boolean aTV;
    private boolean aTW;
    private int aTX;
    private int aTY;

    public GridLayout(Context context) {
        this(context, null);
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTR = -1;
        this.aTS = -1;
        this.aTT = 0;
        this.aTU = 0;
        this.aTV = true;
        this.aTW = false;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.GridLayout);
        try {
            this.aTT = obtainStyledAttributes.getDimensionPixelSize(d.m.GridLayout_gridHorizontalSpacing, 0);
            this.aTU = obtainStyledAttributes.getDimensionPixelSize(d.m.GridLayout_gridVerticalSpacing, 0);
            this.aTR = obtainStyledAttributes.getInteger(d.m.GridLayout_gridHorizontalNum, -1);
            this.aTS = obtainStyledAttributes.getInteger(d.m.GridLayout_gridVerticalNum, -1);
            this.aTV = obtainStyledAttributes.getInteger(d.m.GridLayout_gridMainOrientation, 0) == 0;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        View[] needLayoutChild = getNeedLayoutChild();
        if (this.aTW) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                measureChild(getChildAt(i5), i, i2);
            }
        } else {
            for (View view2 : needLayoutChild) {
                measureChild(view2, i, i2);
            }
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            int i6 = paddingLeft;
            int i7 = paddingLeft;
            for (int i8 = 0; i8 < needLayoutChild.length; i8++) {
                View view3 = needLayoutChild[i8];
                a aVar = (a) view3.getLayoutParams();
                i6 = i6 + this.aTT + view3.getMeasuredWidth() + aVar.leftMargin + aVar.rightMargin;
                if ((i8 + 1) % this.aTY == 0 || i8 + 1 == needLayoutChild.length) {
                    i7 = Math.max(getMeasuredWidth(), i6);
                    i6 = getPaddingRight() + getPaddingLeft();
                }
            }
            i3 = i7;
        } else {
            i3 = getMeasuredWidth();
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            int i9 = 0;
            i4 = paddingTop;
            for (int i10 = 0; i10 < needLayoutChild.length; i10++) {
                View view4 = needLayoutChild[i10];
                a aVar2 = (a) view4.getLayoutParams();
                i9 = Math.max(i9, aVar2.bottomMargin + view4.getMeasuredHeight() + aVar2.topMargin);
                if ((i10 + 1) % this.aTY == 0 || i10 + 1 == needLayoutChild.length) {
                    i4 += i9;
                    i9 = getPaddingBottom() + getPaddingTop();
                }
            }
        } else {
            i4 = getMeasuredHeight();
        }
        setMeasuredDimension(i3, i4);
        int measuredWidth = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.aTR * this.aTT)) + this.aTT;
        int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - (this.aTS * this.aTU)) + this.aTU;
        int i11 = measuredWidth / this.aTR;
        int i12 = measuredHeight / this.aTS;
        for (View view5 : needLayoutChild) {
            a aVar3 = (a) view5.getLayoutParams();
            int measuredWidth2 = view5.getMeasuredWidth();
            int measuredHeight2 = view5.getMeasuredHeight();
            if (aVar3.width == -1) {
                measuredWidth2 = (i11 - aVar3.leftMargin) - aVar3.rightMargin;
            }
            view5.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(aVar3.height == -1 ? (i12 - aVar3.topMargin) - aVar3.bottomMargin : measuredHeight2, 1073741824));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        View[] needLayoutChild = getNeedLayoutChild();
        int measuredWidth = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.aTR * this.aTT)) + this.aTT;
        int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - (this.aTS * this.aTU)) + this.aTU;
        int i7 = measuredWidth / this.aTR;
        int i8 = measuredHeight / this.aTS;
        int i9 = 0;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        while (true) {
            int i10 = i9;
            if (i10 < needLayoutChild.length) {
                View view2 = needLayoutChild[i10];
                a aVar = (a) view2.getLayoutParams();
                int measuredWidth2 = view2.getMeasuredWidth();
                int measuredHeight2 = view2.getMeasuredHeight();
                int i11 = aVar.leftMargin;
                int i12 = aVar.topMargin;
                switch (aVar.gravity & 7) {
                    case 1:
                        i5 = i11 + ((i7 - measuredWidth2) / 2);
                        break;
                    case 5:
                        i5 = i11 + (i7 - measuredWidth2);
                        break;
                    default:
                        i5 = i11 + 0;
                        break;
                }
                switch (aVar.gravity & 112) {
                    case 16:
                        i6 = ((i8 - measuredHeight2) / 2) + i12;
                        break;
                    case 80:
                        i6 = (i8 - measuredHeight2) + i12;
                        break;
                    default:
                        i6 = i12 + 0;
                        break;
                }
                view2.layout(paddingLeft + i5, paddingTop + i6, i5 + measuredWidth2 + paddingLeft, i6 + paddingTop + measuredHeight2);
                paddingLeft += this.aTT + i7;
                if ((i10 + 1) % this.aTY == 0 || i10 + 1 == needLayoutChild.length) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += this.aTU + i8;
                }
                i9 = i10 + 1;
            } else {
                return;
            }
        }
    }

    private View[] getNeedLayoutChild() {
        int i = 0;
        this.aTY = this.aTR;
        this.aTX = this.aTS;
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt == null || childAt.getVisibility() == 8) {
                childCount2--;
            }
        }
        if (this.aTY > 0 && this.aTX > 0) {
            childCount = this.aTY * this.aTX;
        } else if (this.aTY > 0) {
            if (childCount % this.aTY == 0) {
                this.aTX = childCount / this.aTY;
            } else {
                this.aTX = (childCount / this.aTY) + 1;
            }
        } else if (this.aTX > 0) {
            if (childCount % this.aTX == 0) {
                this.aTY = childCount / this.aTX;
            } else {
                this.aTY = (childCount / this.aTX) + 1;
            }
        } else if (this.aTV) {
            this.aTY = childCount;
            this.aTX = 1;
        } else {
            this.aTY = 1;
            this.aTX = childCount;
        }
        View[] viewArr = new View[Math.min(childCount, childCount2)];
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt2 = getChildAt(i3);
            if (childAt2 != null && childAt2.getVisibility() != 8 && i < viewArr.length) {
                viewArr[i] = childAt2;
                i++;
            }
        }
        return viewArr;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: Ju */
    public a generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: e */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: c */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public void setMeasureAllChild(boolean z) {
        this.aTW = z;
    }

    public int getHorNum() {
        return this.aTR;
    }

    public void setHorNum(int i) {
        boolean z = false;
        if (this.aTR != i) {
            z = true;
        }
        this.aTR = i;
        if (z) {
            forceLayout();
        }
    }

    public int getVerNum() {
        return this.aTS;
    }

    public void setVerNum(int i) {
        boolean z = false;
        if (this.aTS != i) {
            z = true;
        }
        this.aTS = i;
        if (z) {
            forceLayout();
        }
    }

    public int getHorSpace() {
        return this.aTT;
    }

    public void setHorSpace(int i) {
        boolean z = false;
        if (this.aTT != i) {
            z = true;
        }
        this.aTT = i;
        if (z) {
            forceLayout();
        }
    }

    public int getVerSpace() {
        return this.aTU;
    }

    public void setVerSpace(int i) {
        boolean z = false;
        if (this.aTU != i) {
            z = true;
        }
        this.aTU = i;
        if (z) {
            forceLayout();
        }
    }

    public void setOrientionHor(boolean z) {
        this.aTV = z;
    }

    /* loaded from: classes.dex */
    public static class a extends FrameLayout.LayoutParams {
        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 17;
        }

        public a(int i, int i2) {
            super(i, i2);
            this.gravity = 17;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 17;
        }
    }
}
