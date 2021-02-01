package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {
    private boolean fTR;
    private int horizontalSpacing;
    private int orientation;
    private int verticalSpacing;

    public FlowLayout(Context context) {
        super(context);
        this.horizontalSpacing = 0;
        this.verticalSpacing = 0;
        this.orientation = 0;
        this.fTR = false;
        i(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.horizontalSpacing = 0;
        this.verticalSpacing = 0;
        this.orientation = 0;
        this.fTR = false;
        i(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.horizontalSpacing = 0;
        this.verticalSpacing = 0;
        this.orientation = 0;
        this.fTR = false;
        i(context, attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingBottom;
        int paddingLeft;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft2;
        int paddingTop;
        int max;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.orientation == 0) {
            mode2 = mode;
        } else {
            size = size2;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int childCount = getChildCount();
        int i15 = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                max = i13;
                i8 = i11;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                int b2 = b(layoutParams);
                int a2 = a(layoutParams);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (this.orientation == 0) {
                    i3 = a2;
                    i4 = b2;
                    i5 = measuredHeight;
                    i6 = measuredWidth;
                } else {
                    i3 = b2;
                    i4 = a2;
                    i5 = measuredWidth;
                    i6 = measuredHeight;
                }
                int i16 = i11 + i6;
                int i17 = i16 + i4;
                if (layoutParams.fTT || (mode2 != 0 && i16 > size)) {
                    i7 = i12 + i9;
                    i8 = i4 + i6;
                    i16 = i6;
                    i10 = i5;
                    i9 = i5 + i3;
                } else {
                    i7 = i12;
                    i8 = i17;
                }
                i9 = Math.max(i9, i3 + i5);
                i10 = Math.max(i10, i5);
                if (this.orientation == 0) {
                    paddingLeft2 = (getPaddingLeft() + i16) - i6;
                    paddingTop = getPaddingTop() + i7;
                } else {
                    paddingLeft2 = getPaddingLeft() + i7;
                    paddingTop = (getPaddingTop() + i16) - measuredHeight;
                }
                layoutParams.bl(paddingLeft2, paddingTop);
                max = Math.max(i13, i16);
                i14 = i7 + i10;
                i12 = i7;
            }
            i15++;
            i13 = max;
            i11 = i8;
        }
        if (this.orientation == 0) {
            paddingBottom = getPaddingLeft() + getPaddingRight() + i13;
            paddingLeft = i14 + getPaddingBottom() + getPaddingTop();
        } else {
            paddingBottom = getPaddingBottom() + getPaddingTop() + i13;
            paddingLeft = i14 + getPaddingLeft() + getPaddingRight();
        }
        if (this.orientation == 0) {
            setMeasuredDimension(resolveSize(paddingBottom, i), resolveSize(paddingLeft, i2));
        } else {
            setMeasuredDimension(resolveSize(paddingLeft, i), resolveSize(paddingBottom, i2));
        }
    }

    private int a(LayoutParams layoutParams) {
        if (!layoutParams.bHh()) {
            return this.verticalSpacing;
        }
        return layoutParams.verticalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    private int b(LayoutParams layoutParams) {
        if (!layoutParams.bHg()) {
            return this.horizontalSpacing;
        }
        return layoutParams.horizontalSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.x, layoutParams.y, layoutParams.x + childAt.getMeasuredWidth(), layoutParams.y + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        a(canvas, view);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: bHf */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: i */
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

    private void i(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout);
        try {
            this.horizontalSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_horizontalSpacing, 0);
            this.verticalSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_verticalSpacing, 0);
            this.orientation = obtainStyledAttributes.getInteger(R.styleable.FlowLayout_orientation, 0);
            this.fTR = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_debugDraw, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void a(Canvas canvas, View view) {
        if (this.fTR) {
            Paint rV = rV(InputDeviceCompat.SOURCE_ANY);
            Paint rV2 = rV(-16711936);
            Paint rV3 = rV(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.horizontalSpacing > 0) {
                float right = view.getRight();
                float height = (view.getHeight() / 2.0f) + view.getTop();
                canvas.drawLine(right, height, right + layoutParams.horizontalSpacing, height, rV);
                canvas.drawLine((layoutParams.horizontalSpacing + right) - 4.0f, height - 4.0f, right + layoutParams.horizontalSpacing, height, rV);
                canvas.drawLine((layoutParams.horizontalSpacing + right) - 4.0f, height + 4.0f, right + layoutParams.horizontalSpacing, height, rV);
            } else if (this.horizontalSpacing > 0) {
                float right2 = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right2, top, right2 + this.horizontalSpacing, top, rV2);
                canvas.drawLine((this.horizontalSpacing + right2) - 4.0f, top - 4.0f, right2 + this.horizontalSpacing, top, rV2);
                canvas.drawLine((this.horizontalSpacing + right2) - 4.0f, top + 4.0f, right2 + this.horizontalSpacing, top, rV2);
            }
            if (layoutParams.verticalSpacing > 0) {
                float width = (view.getWidth() / 2.0f) + view.getLeft();
                float bottom = view.getBottom();
                canvas.drawLine(width, bottom, width, bottom + layoutParams.verticalSpacing, rV);
                canvas.drawLine(width - 4.0f, (layoutParams.verticalSpacing + bottom) - 4.0f, width, bottom + layoutParams.verticalSpacing, rV);
                canvas.drawLine(width + 4.0f, (layoutParams.verticalSpacing + bottom) - 4.0f, width, bottom + layoutParams.verticalSpacing, rV);
            } else if (this.verticalSpacing > 0) {
                float left = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom2 = view.getBottom();
                canvas.drawLine(left, bottom2, left, bottom2 + this.verticalSpacing, rV2);
                canvas.drawLine(left - 4.0f, (this.verticalSpacing + bottom2) - 4.0f, left, bottom2 + this.verticalSpacing, rV2);
                canvas.drawLine(left + 4.0f, (this.verticalSpacing + bottom2) - 4.0f, left, bottom2 + this.verticalSpacing, rV2);
            }
            if (layoutParams.fTT) {
                if (this.orientation == 0) {
                    float left2 = view.getLeft();
                    float top2 = view.getTop() + (view.getHeight() / 2.0f);
                    canvas.drawLine(left2, top2 - 6.0f, left2, top2 + 6.0f, rV3);
                    return;
                }
                float left3 = view.getLeft() + (view.getWidth() / 2.0f);
                float top3 = view.getTop();
                canvas.drawLine(left3 - 6.0f, top3, 6.0f + left3, top3, rV3);
            }
        }
    }

    private Paint rV(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        private static int fTS = -1;
        private boolean fTT;
        private int horizontalSpacing;
        private int verticalSpacing;
        private int x;
        private int y;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.horizontalSpacing = fTS;
            this.verticalSpacing = fTS;
            this.fTT = false;
            i(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.horizontalSpacing = fTS;
            this.verticalSpacing = fTS;
            this.fTT = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.horizontalSpacing = fTS;
            this.verticalSpacing = fTS;
            this.fTT = false;
        }

        public boolean bHg() {
            return this.horizontalSpacing != fTS;
        }

        public boolean bHh() {
            return this.verticalSpacing != fTS;
        }

        public void bl(int i, int i2) {
            this.x = i;
            this.y = i2;
        }

        private void i(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout_LayoutParams);
            try {
                this.horizontalSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, fTS);
                this.verticalSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_LayoutParams_layout_verticalSpacing, fTS);
                this.fTT = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_LayoutParams_layout_newLine, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
