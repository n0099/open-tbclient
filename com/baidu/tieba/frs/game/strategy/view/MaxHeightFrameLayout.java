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
    private float dvc;
    private float dvd;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.dvc = 0.6f;
        this.dvd = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvc = 0.6f;
        this.dvd = 0.0f;
        h(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dvc = 0.6f;
        this.dvd = 0.0f;
        h(context, attributeSet);
        init();
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == d.m.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.dvc = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == d.m.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.dvd = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.dvd <= 0.0f) {
            this.dvd = this.dvc * l.aj(getContext());
        } else {
            this.dvd = Math.min(this.dvd, this.dvc * l.aj(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.dvd) {
            size = (int) this.dvd;
        }
        if (mode == 0 && size > this.dvd) {
            size = (int) this.dvd;
        }
        if (mode == Integer.MIN_VALUE && size > this.dvd) {
            size = (int) this.dvd;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.dvd = i;
    }
}
