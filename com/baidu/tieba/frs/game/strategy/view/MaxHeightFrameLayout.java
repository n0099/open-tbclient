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
    private float dUc;
    private float dUd;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.dUc = 0.6f;
        this.dUd = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dUc = 0.6f;
        this.dUd = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dUc = 0.6f;
        this.dUd = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == e.l.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.dUc = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == e.l.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.dUd = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.dUd <= 0.0f) {
            this.dUd = this.dUc * l.aQ(getContext());
        } else {
            this.dUd = Math.min(this.dUd, this.dUc * l.aQ(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.dUd) {
            size = (int) this.dUd;
        }
        if (mode == 0 && size > this.dUd) {
            size = (int) this.dUd;
        }
        if (mode == Integer.MIN_VALUE && size > this.dUd) {
            size = (int) this.dUd;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.dUd = i;
    }
}
