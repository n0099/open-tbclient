package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float dhA;
    private float dhB;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.dhA = 0.6f;
        this.dhB = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhA = 0.6f;
        this.dhB = 0.0f;
        h(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhA = 0.6f;
        this.dhB = 0.0f;
        h(context, attributeSet);
        init();
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == d.m.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.dhA = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == d.m.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.dhB = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.dhB <= 0.0f) {
            this.dhB = this.dhA * l.ah(getContext());
        } else {
            this.dhB = Math.min(this.dhB, this.dhA * l.ah(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.dhB) {
            size = (int) this.dhB;
        }
        if (mode == 0 && size > this.dhB) {
            size = (int) this.dhB;
        }
        if (mode == Integer.MIN_VALUE && size > this.dhB) {
            size = (int) this.dhB;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.dhB = i;
    }
}
