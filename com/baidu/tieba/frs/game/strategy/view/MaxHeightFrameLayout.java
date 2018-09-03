package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float dxM;
    private float dxN;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.dxM = 0.6f;
        this.dxN = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxM = 0.6f;
        this.dxN = 0.0f;
        e(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxM = 0.6f;
        this.dxN = 0.0f;
        e(context, attributeSet);
        init();
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == f.l.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.dxM = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == f.l.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.dxN = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.dxN <= 0.0f) {
            this.dxN = this.dxM * l.aj(getContext());
        } else {
            this.dxN = Math.min(this.dxN, this.dxM * l.aj(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.dxN) {
            size = (int) this.dxN;
        }
        if (mode == 0 && size > this.dxN) {
            size = (int) this.dxN;
        }
        if (mode == Integer.MIN_VALUE && size > this.dxN) {
            size = (int) this.dxN;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.dxN = i;
    }
}
