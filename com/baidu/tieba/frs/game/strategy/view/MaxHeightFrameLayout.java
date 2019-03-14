package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float flc;
    private float fld;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.flc = 0.6f;
        this.fld = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flc = 0.6f;
        this.fld = 0.0f;
        c(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flc = 0.6f;
        this.fld = 0.0f;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == d.l.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.flc = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == d.l.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.fld = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.fld <= 0.0f) {
            this.fld = this.flc * l.aQ(getContext());
        } else {
            this.fld = Math.min(this.fld, this.flc * l.aQ(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.fld) {
            size = (int) this.fld;
        }
        if (mode == 0 && size > this.fld) {
            size = (int) this.fld;
        }
        if (mode == Integer.MIN_VALUE && size > this.fld) {
            size = (int) this.fld;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.fld = i;
    }
}
