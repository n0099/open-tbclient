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
    private float drT;
    private float drU;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.drT = 0.6f;
        this.drU = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drT = 0.6f;
        this.drU = 0.0f;
        h(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drT = 0.6f;
        this.drU = 0.0f;
        h(context, attributeSet);
        init();
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == d.m.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.drT = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == d.m.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.drU = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.drU <= 0.0f) {
            this.drU = this.drT * l.aj(getContext());
        } else {
            this.drU = Math.min(this.drU, this.drT * l.aj(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.drU) {
            size = (int) this.drU;
        }
        if (mode == 0 && size > this.drU) {
            size = (int) this.drU;
        }
        if (mode == Integer.MIN_VALUE && size > this.drU) {
            size = (int) this.drU;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.drU = i;
    }
}
