package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.R$styleable;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class MaxHeightFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f16354e;

    /* renamed from: f  reason: collision with root package name */
    public float f16355f;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.f16354e = 0.6f;
        this.f16355f = 0.0f;
        a();
    }

    public final void a() {
        float f2 = this.f16355f;
        if (f2 <= 0.0f) {
            this.f16355f = this.f16354e * l.i(getContext());
        } else {
            this.f16355f = Math.min(f2, this.f16354e * l.i(getContext()));
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R$styleable.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.f16354e = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == R$styleable.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.f16355f = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            float f2 = this.f16355f;
            if (size > f2) {
                size = (int) f2;
            }
        }
        if (mode == 0) {
            float f3 = this.f16355f;
            if (size > f3) {
                size = (int) f3;
            }
        }
        if (mode == Integer.MIN_VALUE) {
            float f4 = this.f16355f;
            if (size > f4) {
                size = (int) f4;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.f16355f = i;
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16354e = 0.6f;
        this.f16355f = 0.0f;
        b(context, attributeSet);
        a();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16354e = 0.6f;
        this.f16355f = 0.0f;
        b(context, attributeSet);
        a();
    }
}
