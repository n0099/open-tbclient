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
    private float dxP;
    private float dxQ;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.dxP = 0.6f;
        this.dxQ = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxP = 0.6f;
        this.dxQ = 0.0f;
        e(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxP = 0.6f;
        this.dxQ = 0.0f;
        e(context, attributeSet);
        init();
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == d.l.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.dxP = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == d.l.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.dxQ = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.dxQ <= 0.0f) {
            this.dxQ = this.dxP * l.aj(getContext());
        } else {
            this.dxQ = Math.min(this.dxQ, this.dxP * l.aj(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.dxQ) {
            size = (int) this.dxQ;
        }
        if (mode == 0 && size > this.dxQ) {
            size = (int) this.dxQ;
        }
        if (mode == Integer.MIN_VALUE && size > this.dxQ) {
            size = (int) this.dxQ;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.dxQ = i;
    }
}
