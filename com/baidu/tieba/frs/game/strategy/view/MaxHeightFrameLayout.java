package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.R$styleable;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class MaxHeightFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f15540e;

    /* renamed from: f  reason: collision with root package name */
    public float f15541f;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.f15540e = 0.6f;
        this.f15541f = 0.0f;
        a();
    }

    public final void a() {
        float f2 = this.f15541f;
        if (f2 <= 0.0f) {
            this.f15541f = this.f15540e * l.i(getContext());
        } else {
            this.f15541f = Math.min(f2, this.f15540e * l.i(getContext()));
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R$styleable.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.f15540e = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == R$styleable.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.f15541f = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            float f2 = this.f15541f;
            if (size > f2) {
                size = (int) f2;
            }
        }
        if (mode == 0) {
            float f3 = this.f15541f;
            if (size > f3) {
                size = (int) f3;
            }
        }
        if (mode == Integer.MIN_VALUE) {
            float f4 = this.f15541f;
            if (size > f4) {
                size = (int) f4;
            }
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i2) {
        this.f15541f = i2;
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15540e = 0.6f;
        this.f15541f = 0.0f;
        b(context, attributeSet);
        a();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15540e = 0.6f;
        this.f15541f = 0.0f;
        b(context, attributeSet);
        a();
    }
}
