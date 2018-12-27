package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float dWT;
    private float dWU;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.dWT = 0.6f;
        this.dWU = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dWT = 0.6f;
        this.dWU = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dWT = 0.6f;
        this.dWU = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == e.l.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.dWT = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == e.l.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.dWU = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.dWU <= 0.0f) {
            this.dWU = this.dWT * l.aQ(getContext());
        } else {
            this.dWU = Math.min(this.dWU, this.dWT * l.aQ(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.dWU) {
            size = (int) this.dWU;
        }
        if (mode == 0 && size > this.dWU) {
            size = (int) this.dWU;
        }
        if (mode == Integer.MIN_VALUE && size > this.dWU) {
            size = (int) this.dWU;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.dWU = i;
    }
}
