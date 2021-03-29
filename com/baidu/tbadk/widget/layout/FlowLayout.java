package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f14185e;

    /* renamed from: f  reason: collision with root package name */
    public int f14186f;

    /* renamed from: g  reason: collision with root package name */
    public int f14187g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14188h;

    public FlowLayout(Context context) {
        super(context);
        this.f14185e = 0;
        this.f14186f = 0;
        this.f14187g = 0;
        this.f14188h = false;
        h(context, null);
    }

    public final Paint a(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    public final void b(Canvas canvas, View view) {
        if (this.f14188h) {
            Paint a2 = a(-256);
            Paint a3 = a(-16711936);
            Paint a4 = a(-65536);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f14192c > 0) {
                float right = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right, top, right + layoutParams.f14192c, top, a2);
                canvas.drawLine((layoutParams.f14192c + right) - 4.0f, top - 4.0f, right + layoutParams.f14192c, top, a2);
                canvas.drawLine((layoutParams.f14192c + right) - 4.0f, top + 4.0f, right + layoutParams.f14192c, top, a2);
            } else if (this.f14185e > 0) {
                float right2 = view.getRight();
                float top2 = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right2, top2, right2 + this.f14185e, top2, a3);
                int i = this.f14185e;
                canvas.drawLine((i + right2) - 4.0f, top2 - 4.0f, right2 + i, top2, a3);
                int i2 = this.f14185e;
                canvas.drawLine((i2 + right2) - 4.0f, top2 + 4.0f, right2 + i2, top2, a3);
            }
            if (layoutParams.f14193d > 0) {
                float left = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom = view.getBottom();
                canvas.drawLine(left, bottom, left, bottom + layoutParams.f14193d, a2);
                canvas.drawLine(left - 4.0f, (layoutParams.f14193d + bottom) - 4.0f, left, bottom + layoutParams.f14193d, a2);
                canvas.drawLine(left + 4.0f, (layoutParams.f14193d + bottom) - 4.0f, left, bottom + layoutParams.f14193d, a2);
            } else if (this.f14186f > 0) {
                float left2 = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom2 = view.getBottom();
                canvas.drawLine(left2, bottom2, left2, bottom2 + this.f14186f, a3);
                int i3 = this.f14186f;
                canvas.drawLine(left2 - 4.0f, (i3 + bottom2) - 4.0f, left2, bottom2 + i3, a3);
                int i4 = this.f14186f;
                canvas.drawLine(left2 + 4.0f, (i4 + bottom2) - 4.0f, left2, bottom2 + i4, a3);
            }
            if (layoutParams.f14194e) {
                if (this.f14187g == 0) {
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
            return layoutParams.f14192c;
        }
        return this.f14185e;
    }

    public final int g(LayoutParams layoutParams) {
        if (layoutParams.i()) {
            return layoutParams.f14193d;
        }
        return this.f14186f;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout);
        try {
            this.f14185e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_horizontalSpacing, 0);
            this.f14186f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_verticalSpacing, 0);
            this.f14187g = obtainStyledAttributes.getInteger(R$styleable.FlowLayout_orientation, 0);
            this.f14188h = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_debugDraw, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.f14190a, layoutParams.f14191b, layoutParams.f14190a + childAt.getMeasuredWidth(), layoutParams.f14191b + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int paddingBottom;
        int paddingLeft;
        int paddingRight;
        int i3;
        int i4;
        int i5;
        int paddingLeft2;
        int paddingTop;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.f14187g != 0) {
            size = size2;
            mode = mode2;
        }
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i3 = childCount;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i3 = childCount;
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((ViewGroup.LayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), ((ViewGroup.LayoutParams) layoutParams).height));
                int f2 = f(layoutParams);
                int g2 = g(layoutParams);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = f2;
                if (this.f14187g == 0) {
                    i4 = i13;
                    i13 = g2;
                    i5 = measuredHeight;
                } else {
                    i4 = g2;
                    i5 = measuredWidth;
                    measuredWidth = measuredHeight;
                }
                int i14 = i9 + measuredWidth;
                int i15 = i14 + i4;
                if (layoutParams.f14194e || (mode != 0 && i14 > size)) {
                    i12 += i10;
                    i10 = i5 + i13;
                    i15 = i4 + measuredWidth;
                    i11 = i5;
                    i14 = measuredWidth;
                }
                i10 = Math.max(i10, i5 + i13);
                i11 = Math.max(i11, i5);
                if (this.f14187g == 0) {
                    paddingLeft2 = (getPaddingLeft() + i14) - measuredWidth;
                    paddingTop = getPaddingTop() + i12;
                } else {
                    paddingLeft2 = getPaddingLeft() + i12;
                    paddingTop = (getPaddingTop() + i14) - measuredHeight;
                }
                layoutParams.h(paddingLeft2, paddingTop);
                i7 = Math.max(i7, i14);
                i8 = i12 + i11;
                i9 = i15;
            }
            i6++;
            childCount = i3;
        }
        if (this.f14187g == 0) {
            paddingBottom = i7 + getPaddingLeft() + getPaddingRight();
            paddingLeft = getPaddingBottom();
            paddingRight = getPaddingTop();
        } else {
            paddingBottom = i7 + getPaddingBottom() + getPaddingTop();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i16 = i8 + paddingLeft + paddingRight;
        if (this.f14187g == 0) {
            setMeasuredDimension(ViewGroup.resolveSize(paddingBottom, i), ViewGroup.resolveSize(i16, i2));
        } else {
            setMeasuredDimension(ViewGroup.resolveSize(i16, i), ViewGroup.resolveSize(paddingBottom, i2));
        }
    }

    public void setHorizontalSpacing(int i) {
        this.f14185e = i;
    }

    public void setVerticalSpacing(int i) {
        this.f14186f = i;
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: f  reason: collision with root package name */
        public static int f14189f = -1;

        /* renamed from: a  reason: collision with root package name */
        public int f14190a;

        /* renamed from: b  reason: collision with root package name */
        public int f14191b;

        /* renamed from: c  reason: collision with root package name */
        public int f14192c;

        /* renamed from: d  reason: collision with root package name */
        public int f14193d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14194e;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i = f14189f;
            this.f14192c = i;
            this.f14193d = i;
            this.f14194e = false;
            g(context, attributeSet);
        }

        public boolean f() {
            return this.f14192c != f14189f;
        }

        public final void g(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout_LayoutParams);
            try {
                this.f14192c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, f14189f);
                this.f14193d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_LayoutParams_layout_verticalSpacing, f14189f);
                this.f14194e = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_LayoutParams_layout_newLine, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public void h(int i, int i2) {
            this.f14190a = i;
            this.f14191b = i2;
        }

        public boolean i() {
            return this.f14193d != f14189f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            int i3 = f14189f;
            this.f14192c = i3;
            this.f14193d = i3;
            this.f14194e = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            int i = f14189f;
            this.f14192c = i;
            this.f14193d = i;
            this.f14194e = false;
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14185e = 0;
        this.f14186f = 0;
        this.f14187g = 0;
        this.f14188h = false;
        h(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14185e = 0;
        this.f14186f = 0;
        this.f14187g = 0;
        this.f14188h = false;
        h(context, attributeSet);
    }
}
