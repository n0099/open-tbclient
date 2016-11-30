package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {
    private boolean aHw;
    private int horizontalSpacing;
    private int orientation;
    private int verticalSpacing;

    public FlowLayout(Context context) {
        super(context);
        this.horizontalSpacing = 0;
        this.verticalSpacing = 0;
        this.orientation = 0;
        this.aHw = false;
        c(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.horizontalSpacing = 0;
        this.verticalSpacing = 0;
        this.orientation = 0;
        this.aHw = false;
        c(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.horizontalSpacing = 0;
        this.verticalSpacing = 0;
        this.orientation = 0;
        this.aHw = false;
        c(context, attributeSet);
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
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int childCount = getChildCount();
        int i13 = 0;
        int i14 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                max = i12;
            } else {
                a aVar = (a) childAt.getLayoutParams();
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), aVar.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), aVar.height));
                int b = b(aVar);
                int a2 = a(aVar);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (this.orientation == 0) {
                    i3 = measuredWidth;
                    measuredWidth = measuredHeight;
                } else {
                    i3 = measuredHeight;
                    a2 = b;
                    b = a2;
                }
                int i15 = i10 + i3;
                int i16 = i15 + b;
                if (aVar.aHy || (mode2 != 0 && i15 > size)) {
                    i6 = measuredWidth;
                    i7 = measuredWidth + a2;
                    i10 = b + i3;
                    i4 = i11 + i8;
                    i5 = i3;
                } else {
                    i4 = i11;
                    i5 = i15;
                    i10 = i16;
                    i6 = i9;
                    i7 = i8;
                }
                i8 = Math.max(i7, a2 + measuredWidth);
                i9 = Math.max(i6, measuredWidth);
                if (this.orientation == 0) {
                    paddingLeft2 = (getPaddingLeft() + i5) - i3;
                    paddingTop = getPaddingTop() + i4;
                } else {
                    paddingLeft2 = getPaddingLeft() + i4;
                    paddingTop = (getPaddingTop() + i5) - measuredHeight;
                }
                aVar.I(paddingLeft2, paddingTop);
                max = Math.max(i12, i5);
                i14 = i4 + i9;
                i11 = i4;
            }
            i13++;
            i12 = max;
        }
        if (this.orientation == 0) {
            paddingBottom = getPaddingLeft() + getPaddingRight() + i12;
            paddingLeft = i14 + getPaddingBottom() + getPaddingTop();
        } else {
            paddingBottom = getPaddingBottom() + getPaddingTop() + i12;
            paddingLeft = i14 + getPaddingLeft() + getPaddingRight();
        }
        if (this.orientation == 0) {
            setMeasuredDimension(resolveSize(paddingBottom, i), resolveSize(paddingLeft, i2));
        } else {
            setMeasuredDimension(resolveSize(paddingLeft, i), resolveSize(paddingBottom, i2));
        }
    }

    private int a(a aVar) {
        if (!aVar.HP()) {
            return this.verticalSpacing;
        }
        return aVar.verticalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    private int b(a aVar) {
        if (!aVar.HO()) {
            return this.horizontalSpacing;
        }
        return aVar.horizontalSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            childAt.layout(aVar.x, aVar.y, aVar.x + childAt.getMeasuredWidth(), aVar.y + childAt.getMeasuredHeight());
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
        return layoutParams instanceof a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: HN */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
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
    /* renamed from: b */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.FlowLayout);
        try {
            this.horizontalSpacing = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.verticalSpacing = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.orientation = obtainStyledAttributes.getInteger(2, 0);
            this.aHw = obtainStyledAttributes.getBoolean(3, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void a(Canvas canvas, View view) {
        if (this.aHw) {
            Paint fu = fu(-256);
            Paint fu2 = fu(-16711936);
            Paint fu3 = fu(SupportMenu.CATEGORY_MASK);
            a aVar = (a) view.getLayoutParams();
            if (aVar.horizontalSpacing > 0) {
                float right = view.getRight();
                float height = (view.getHeight() / 2.0f) + view.getTop();
                canvas.drawLine(right, height, right + aVar.horizontalSpacing, height, fu);
                canvas.drawLine((aVar.horizontalSpacing + right) - 4.0f, height - 4.0f, right + aVar.horizontalSpacing, height, fu);
                canvas.drawLine((aVar.horizontalSpacing + right) - 4.0f, height + 4.0f, right + aVar.horizontalSpacing, height, fu);
            } else if (this.horizontalSpacing > 0) {
                float right2 = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right2, top, right2 + this.horizontalSpacing, top, fu2);
                canvas.drawLine((this.horizontalSpacing + right2) - 4.0f, top - 4.0f, right2 + this.horizontalSpacing, top, fu2);
                canvas.drawLine((this.horizontalSpacing + right2) - 4.0f, top + 4.0f, right2 + this.horizontalSpacing, top, fu2);
            }
            if (aVar.verticalSpacing > 0) {
                float width = (view.getWidth() / 2.0f) + view.getLeft();
                float bottom = view.getBottom();
                canvas.drawLine(width, bottom, width, bottom + aVar.verticalSpacing, fu);
                canvas.drawLine(width - 4.0f, (aVar.verticalSpacing + bottom) - 4.0f, width, bottom + aVar.verticalSpacing, fu);
                canvas.drawLine(width + 4.0f, (aVar.verticalSpacing + bottom) - 4.0f, width, bottom + aVar.verticalSpacing, fu);
            } else if (this.verticalSpacing > 0) {
                float left = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom2 = view.getBottom();
                canvas.drawLine(left, bottom2, left, bottom2 + this.verticalSpacing, fu2);
                canvas.drawLine(left - 4.0f, (this.verticalSpacing + bottom2) - 4.0f, left, bottom2 + this.verticalSpacing, fu2);
                canvas.drawLine(left + 4.0f, (this.verticalSpacing + bottom2) - 4.0f, left, bottom2 + this.verticalSpacing, fu2);
            }
            if (aVar.aHy) {
                if (this.orientation == 0) {
                    float left2 = view.getLeft();
                    float top2 = view.getTop() + (view.getHeight() / 2.0f);
                    canvas.drawLine(left2, top2 - 6.0f, left2, top2 + 6.0f, fu3);
                    return;
                }
                float left3 = view.getLeft() + (view.getWidth() / 2.0f);
                float top3 = view.getTop();
                canvas.drawLine(left3 - 6.0f, top3, 6.0f + left3, top3, fu3);
            }
        }
    }

    private Paint fu(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.LayoutParams {
        private static int aHx = -1;
        private boolean aHy;
        private int horizontalSpacing;
        private int verticalSpacing;
        private int x;
        private int y;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.horizontalSpacing = aHx;
            this.verticalSpacing = aHx;
            this.aHy = false;
            c(context, attributeSet);
        }

        public a(int i, int i2) {
            super(i, i2);
            this.horizontalSpacing = aHx;
            this.verticalSpacing = aHx;
            this.aHy = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.horizontalSpacing = aHx;
            this.verticalSpacing = aHx;
            this.aHy = false;
        }

        public boolean HO() {
            return this.horizontalSpacing != aHx;
        }

        public boolean HP() {
            return this.verticalSpacing != aHx;
        }

        public void I(int i, int i2) {
            this.x = i;
            this.y = i2;
        }

        private void c(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.FlowLayout_LayoutParams);
            try {
                this.horizontalSpacing = obtainStyledAttributes.getDimensionPixelSize(1, aHx);
                this.verticalSpacing = obtainStyledAttributes.getDimensionPixelSize(2, aHx);
                this.aHy = obtainStyledAttributes.getBoolean(0, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
