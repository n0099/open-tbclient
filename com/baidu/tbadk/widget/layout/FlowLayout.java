package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f13134e;

    /* renamed from: f  reason: collision with root package name */
    public int f13135f;

    /* renamed from: g  reason: collision with root package name */
    public int f13136g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13137h;

    public FlowLayout(Context context) {
        super(context);
        this.f13134e = 0;
        this.f13135f = 0;
        this.f13136g = 0;
        this.f13137h = false;
        h(context, null);
    }

    public final Paint a(int i2) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    public final void b(Canvas canvas, View view) {
        if (this.f13137h) {
            Paint a2 = a(-256);
            Paint a3 = a(-16711936);
            Paint a4 = a(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f13141c > 0) {
                float right = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right, top, right + layoutParams.f13141c, top, a2);
                canvas.drawLine((layoutParams.f13141c + right) - 4.0f, top - 4.0f, right + layoutParams.f13141c, top, a2);
                canvas.drawLine((layoutParams.f13141c + right) - 4.0f, top + 4.0f, right + layoutParams.f13141c, top, a2);
            } else if (this.f13134e > 0) {
                float right2 = view.getRight();
                float top2 = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right2, top2, right2 + this.f13134e, top2, a3);
                int i2 = this.f13134e;
                canvas.drawLine((i2 + right2) - 4.0f, top2 - 4.0f, right2 + i2, top2, a3);
                int i3 = this.f13134e;
                canvas.drawLine((i3 + right2) - 4.0f, top2 + 4.0f, right2 + i3, top2, a3);
            }
            if (layoutParams.f13142d > 0) {
                float left = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom = view.getBottom();
                canvas.drawLine(left, bottom, left, bottom + layoutParams.f13142d, a2);
                canvas.drawLine(left - 4.0f, (layoutParams.f13142d + bottom) - 4.0f, left, bottom + layoutParams.f13142d, a2);
                canvas.drawLine(left + 4.0f, (layoutParams.f13142d + bottom) - 4.0f, left, bottom + layoutParams.f13142d, a2);
            } else if (this.f13135f > 0) {
                float left2 = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom2 = view.getBottom();
                canvas.drawLine(left2, bottom2, left2, bottom2 + this.f13135f, a3);
                int i4 = this.f13135f;
                canvas.drawLine(left2 - 4.0f, (i4 + bottom2) - 4.0f, left2, bottom2 + i4, a3);
                int i5 = this.f13135f;
                canvas.drawLine(left2 + 4.0f, (i5 + bottom2) - 4.0f, left2, bottom2 + i5, a3);
            }
            if (layoutParams.f13143e) {
                if (this.f13136g == 0) {
                    float left3 = view.getLeft();
                    float top3 = view.getTop() + (view.getHeight() / 2.0f);
                    canvas.drawLine(left3, top3 - 6.0f, left3, top3 + 6.0f, a4);
                    return;
                }
                float left4 = view.getLeft() + (view.getWidth() / 2.0f);
                float top4 = view.getTop();
                canvas.drawLine(left4 - 6.0f, top4, left4 + 6.0f, top4, a4);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: d */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        b(canvas, view);
        return drawChild;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public final int f(LayoutParams layoutParams) {
        if (layoutParams.f()) {
            return layoutParams.f13141c;
        }
        return this.f13134e;
    }

    public final int g(LayoutParams layoutParams) {
        if (layoutParams.i()) {
            return layoutParams.f13142d;
        }
        return this.f13135f;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout);
        try {
            this.f13134e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_horizontalSpacing, 0);
            this.f13135f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_verticalSpacing, 0);
            this.f13136g = obtainStyledAttributes.getInteger(R$styleable.FlowLayout_orientation, 0);
            this.f13137h = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_debugDraw, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.f13139a, layoutParams.f13140b, layoutParams.f13139a + childAt.getMeasuredWidth(), layoutParams.f13140b + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int paddingBottom;
        int paddingLeft;
        int paddingRight;
        int i4;
        int i5;
        int i6;
        int paddingLeft2;
        int paddingTop;
        int size = (View.MeasureSpec.getSize(i2) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i3) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (this.f13136g != 0) {
            size = size2;
            mode = mode2;
        }
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                i4 = childCount;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i4 = childCount;
                childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), ((ViewGroup.LayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), ((ViewGroup.LayoutParams) layoutParams).height));
                int f2 = f(layoutParams);
                int g2 = g(layoutParams);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i14 = f2;
                if (this.f13136g == 0) {
                    i5 = i14;
                    i14 = g2;
                    i6 = measuredHeight;
                } else {
                    i5 = g2;
                    i6 = measuredWidth;
                    measuredWidth = measuredHeight;
                }
                int i15 = i10 + measuredWidth;
                int i16 = i15 + i5;
                if (layoutParams.f13143e || (mode != 0 && i15 > size)) {
                    i13 += i11;
                    i11 = i6 + i14;
                    i16 = i5 + measuredWidth;
                    i12 = i6;
                    i15 = measuredWidth;
                }
                i11 = Math.max(i11, i6 + i14);
                i12 = Math.max(i12, i6);
                if (this.f13136g == 0) {
                    paddingLeft2 = (getPaddingLeft() + i15) - measuredWidth;
                    paddingTop = getPaddingTop() + i13;
                } else {
                    paddingLeft2 = getPaddingLeft() + i13;
                    paddingTop = (getPaddingTop() + i15) - measuredHeight;
                }
                layoutParams.h(paddingLeft2, paddingTop);
                i8 = Math.max(i8, i15);
                i9 = i13 + i12;
                i10 = i16;
            }
            i7++;
            childCount = i4;
        }
        if (this.f13136g == 0) {
            paddingBottom = i8 + getPaddingLeft() + getPaddingRight();
            paddingLeft = getPaddingBottom();
            paddingRight = getPaddingTop();
        } else {
            paddingBottom = i8 + getPaddingBottom() + getPaddingTop();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i17 = i9 + paddingLeft + paddingRight;
        if (this.f13136g == 0) {
            setMeasuredDimension(ViewGroup.resolveSize(paddingBottom, i2), ViewGroup.resolveSize(i17, i3));
        } else {
            setMeasuredDimension(ViewGroup.resolveSize(i17, i2), ViewGroup.resolveSize(paddingBottom, i3));
        }
    }

    public void setHorizontalSpacing(int i2) {
        this.f13134e = i2;
    }

    public void setVerticalSpacing(int i2) {
        this.f13135f = i2;
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: f  reason: collision with root package name */
        public static int f13138f = -1;

        /* renamed from: a  reason: collision with root package name */
        public int f13139a;

        /* renamed from: b  reason: collision with root package name */
        public int f13140b;

        /* renamed from: c  reason: collision with root package name */
        public int f13141c;

        /* renamed from: d  reason: collision with root package name */
        public int f13142d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13143e;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2 = f13138f;
            this.f13141c = i2;
            this.f13142d = i2;
            this.f13143e = false;
            g(context, attributeSet);
        }

        public boolean f() {
            return this.f13141c != f13138f;
        }

        public final void g(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout_LayoutParams);
            try {
                this.f13141c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, f13138f);
                this.f13142d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_LayoutParams_layout_verticalSpacing, f13138f);
                this.f13143e = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_LayoutParams_layout_newLine, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public void h(int i2, int i3) {
            this.f13139a = i2;
            this.f13140b = i3;
        }

        public boolean i() {
            return this.f13142d != f13138f;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            int i4 = f13138f;
            this.f13141c = i4;
            this.f13142d = i4;
            this.f13143e = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            int i2 = f13138f;
            this.f13141c = i2;
            this.f13142d = i2;
            this.f13143e = false;
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13134e = 0;
        this.f13135f = 0;
        this.f13136g = 0;
        this.f13137h = false;
        h(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13134e = 0;
        this.f13135f = 0;
        this.f13136g = 0;
        this.f13137h = false;
        h(context, attributeSet);
    }
}
