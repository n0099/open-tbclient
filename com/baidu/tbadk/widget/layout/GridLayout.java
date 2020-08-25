package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class GridLayout extends ViewGroup {
    private int fcA;
    private int fcB;
    private int fcC;
    private int fcD;
    private boolean fcE;
    private boolean fcF;
    private int fcG;
    private int fcH;

    public GridLayout(Context context) {
        this(context, null);
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fcA = -1;
        this.fcB = -1;
        this.fcC = 0;
        this.fcD = 0;
        this.fcE = true;
        this.fcF = false;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout);
        try {
            this.fcC = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GridLayout_gridHorizontalSpacing, 0);
            this.fcD = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GridLayout_gridVerticalSpacing, 0);
            this.fcA = obtainStyledAttributes.getInteger(R.styleable.GridLayout_gridHorizontalNum, -1);
            this.fcB = obtainStyledAttributes.getInteger(R.styleable.GridLayout_gridVerticalNum, -1);
            this.fcE = obtainStyledAttributes.getInteger(R.styleable.GridLayout_gridMainOrientation, 0) == 0;
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
        if (this.fcF) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                measureChild(getChildAt(i5), i, i2);
            }
        } else {
            for (View view : needLayoutChild) {
                measureChild(view, i, i2);
            }
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            int i6 = paddingLeft;
            int i7 = paddingLeft;
            for (int i8 = 0; i8 < needLayoutChild.length; i8++) {
                View view2 = needLayoutChild[i8];
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                i6 = i6 + this.fcC + view2.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                if ((i8 + 1) % this.fcH == 0 || i8 + 1 == needLayoutChild.length) {
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
                View view3 = needLayoutChild[i10];
                LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                i9 = Math.max(i9, layoutParams2.bottomMargin + view3.getMeasuredHeight() + layoutParams2.topMargin);
                if ((i10 + 1) % this.fcH == 0 || i10 + 1 == needLayoutChild.length) {
                    i4 += i9;
                    i9 = getPaddingBottom() + getPaddingTop();
                }
            }
        } else {
            i4 = getMeasuredHeight();
        }
        setMeasuredDimension(i3, i4);
        int measuredWidth = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.fcA * this.fcC)) + this.fcC;
        int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - (this.fcB * this.fcD)) + this.fcD;
        int i11 = measuredWidth / this.fcA;
        int i12 = measuredHeight / this.fcB;
        for (View view4 : needLayoutChild) {
            LayoutParams layoutParams3 = (LayoutParams) view4.getLayoutParams();
            int measuredWidth2 = view4.getMeasuredWidth();
            int measuredHeight2 = view4.getMeasuredHeight();
            if (layoutParams3.width == -1) {
                measuredWidth2 = (i11 - layoutParams3.leftMargin) - layoutParams3.rightMargin;
            }
            view4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams3.height == -1 ? (i12 - layoutParams3.topMargin) - layoutParams3.bottomMargin : measuredHeight2, 1073741824));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        View[] needLayoutChild = getNeedLayoutChild();
        int measuredWidth = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.fcA * this.fcC)) + this.fcC;
        int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - (this.fcB * this.fcD)) + this.fcD;
        int i7 = measuredWidth / this.fcA;
        int i8 = measuredHeight / this.fcB;
        int i9 = 0;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        while (true) {
            int i10 = i9;
            if (i10 < needLayoutChild.length) {
                View view = needLayoutChild[i10];
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                int i11 = layoutParams.leftMargin;
                int i12 = layoutParams.topMargin;
                switch (layoutParams.gravity & 7) {
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
                switch (layoutParams.gravity & 112) {
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
                view.layout(paddingLeft + i5, paddingTop + i6, i5 + measuredWidth2 + paddingLeft, i6 + paddingTop + measuredHeight2);
                paddingLeft += this.fcC + i7;
                if ((i10 + 1) % this.fcH == 0 || i10 + 1 == needLayoutChild.length) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += this.fcD + i8;
                }
                i9 = i10 + 1;
            } else {
                return;
            }
        }
    }

    private View[] getNeedLayoutChild() {
        int i = 0;
        this.fcH = this.fcA;
        this.fcG = this.fcB;
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt == null || childAt.getVisibility() == 8) {
                childCount2--;
            }
        }
        if (this.fcH > 0 && this.fcG > 0) {
            childCount = this.fcH * this.fcG;
        } else if (this.fcH > 0) {
            if (childCount % this.fcH == 0) {
                this.fcG = childCount / this.fcH;
            } else {
                this.fcG = (childCount / this.fcH) + 1;
            }
        } else if (this.fcG > 0) {
            if (childCount % this.fcG == 0) {
                this.fcH = childCount / this.fcG;
            } else {
                this.fcH = (childCount / this.fcG) + 1;
            }
        } else if (this.fcE) {
            this.fcH = childCount;
            this.fcG = 1;
        } else {
            this.fcH = 1;
            this.fcG = childCount;
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
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: bxl */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: g */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setMeasureAllChild(boolean z) {
        this.fcF = z;
    }

    public int getHorNum() {
        return this.fcA;
    }

    public void setHorNum(int i) {
        boolean z = false;
        if (this.fcA != i) {
            z = true;
        }
        this.fcA = i;
        if (z) {
            forceLayout();
        }
    }

    public int getVerNum() {
        return this.fcB;
    }

    public void setVerNum(int i) {
        boolean z = false;
        if (this.fcB != i) {
            z = true;
        }
        this.fcB = i;
        if (z) {
            forceLayout();
        }
    }

    public int getHorSpace() {
        return this.fcC;
    }

    public void setHorSpace(int i) {
        boolean z = false;
        if (this.fcC != i) {
            z = true;
        }
        this.fcC = i;
        if (z) {
            forceLayout();
        }
    }

    public int getVerSpace() {
        return this.fcD;
    }

    public void setVerSpace(int i) {
        boolean z = false;
        if (this.fcD != i) {
            z = true;
        }
        this.fcD = i;
        if (z) {
            forceLayout();
        }
    }

    public void setOrientionHor(boolean z) {
        this.fcE = z;
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 17;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 17;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 17;
        }
    }
}
