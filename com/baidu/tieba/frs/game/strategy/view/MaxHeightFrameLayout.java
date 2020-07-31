package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float hUk;
    private float hUl;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.hUk = 0.6f;
        this.hUl = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hUk = 0.6f;
        this.hUl = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hUk = 0.6f;
        this.hUl = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.hUk = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == R.styleable.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.hUl = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.hUl <= 0.0f) {
            this.hUl = this.hUk * l.getEquipmentHeight(getContext());
        } else {
            this.hUl = Math.min(this.hUl, this.hUk * l.getEquipmentHeight(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.hUl) {
            size = (int) this.hUl;
        }
        if (mode == 0 && size > this.hUl) {
            size = (int) this.hUl;
        }
        if (mode == Integer.MIN_VALUE && size > this.hUl) {
            size = (int) this.hUl;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.hUl = i;
    }
}
