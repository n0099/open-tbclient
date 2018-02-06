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
    private float dPb;
    private float dPc;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.dPb = 0.6f;
        this.dPc = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dPb = 0.6f;
        this.dPc = 0.0f;
        e(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dPb = 0.6f;
        this.dPc = 0.0f;
        e(context, attributeSet);
        init();
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == d.l.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.dPb = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == d.l.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.dPc = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.dPc <= 0.0f) {
            this.dPc = this.dPb * l.aq(getContext());
        } else {
            this.dPc = Math.min(this.dPc, this.dPb * l.aq(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.dPc) {
            size = (int) this.dPc;
        }
        if (mode == 0 && size > this.dPc) {
            size = (int) this.dPc;
        }
        if (mode == Integer.MIN_VALUE && size > this.dPc) {
            size = (int) this.dPc;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.dPc = i;
    }
}
