package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float iXA;
    private float iXz;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.iXz = 0.6f;
        this.iXA = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iXz = 0.6f;
        this.iXA = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iXz = 0.6f;
        this.iXA = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.iXz = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == 0) {
                this.iXA = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.iXA <= 0.0f) {
            this.iXA = this.iXz * l.getEquipmentHeight(getContext());
        } else {
            this.iXA = Math.min(this.iXA, this.iXz * l.getEquipmentHeight(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.iXA) {
            size = (int) this.iXA;
        }
        if (mode == 0 && size > this.iXA) {
            size = (int) this.iXA;
        }
        if (mode == Integer.MIN_VALUE && size > this.iXA) {
            size = (int) this.iXA;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.iXA = i;
    }
}
