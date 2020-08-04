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
    private float hUm;
    private float hUn;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.hUm = 0.6f;
        this.hUn = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hUm = 0.6f;
        this.hUn = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hUm = 0.6f;
        this.hUn = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.MaxHeightFrameLayout_mhf_HeightRatio) {
                this.hUm = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == R.styleable.MaxHeightFrameLayout_mhf_HeightDimen) {
                this.hUn = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.hUn <= 0.0f) {
            this.hUn = this.hUm * l.getEquipmentHeight(getContext());
        } else {
            this.hUn = Math.min(this.hUn, this.hUm * l.getEquipmentHeight(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.hUn) {
            size = (int) this.hUn;
        }
        if (mode == 0 && size > this.hUn) {
            size = (int) this.hUn;
        }
        if (mode == Integer.MIN_VALUE && size > this.hUn) {
            size = (int) this.hUn;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.hUn = i;
    }
}
