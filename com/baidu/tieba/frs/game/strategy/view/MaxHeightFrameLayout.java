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
    private float dEw;
    private float dEx;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.dEw = 0.6f;
        this.dEx = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEw = 0.6f;
        this.dEx = 0.0f;
        e(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEw = 0.6f;
        this.dEx = 0.0f;
        e(context, attributeSet);
        init();
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == e.l.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.dEw = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == e.l.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.dEx = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.dEx <= 0.0f) {
            this.dEx = this.dEw * l.aQ(getContext());
        } else {
            this.dEx = Math.min(this.dEx, this.dEw * l.aQ(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.dEx) {
            size = (int) this.dEx;
        }
        if (mode == 0 && size > this.dEx) {
            size = (int) this.dEx;
        }
        if (mode == Integer.MIN_VALUE && size > this.dEx) {
            size = (int) this.dEx;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.dEx = i;
    }
}
