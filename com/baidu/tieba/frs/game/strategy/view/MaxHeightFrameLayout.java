package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float hlC;
    private float hlD;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.hlC = 0.6f;
        this.hlD = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlC = 0.6f;
        this.hlD = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlC = 0.6f;
        this.hlD = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.hlC = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == 0) {
                this.hlD = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.hlD <= 0.0f) {
            this.hlD = this.hlC * l.getEquipmentHeight(getContext());
        } else {
            this.hlD = Math.min(this.hlD, this.hlC * l.getEquipmentHeight(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.hlD) {
            size = (int) this.hlD;
        }
        if (mode == 0 && size > this.hlD) {
            size = (int) this.hlD;
        }
        if (mode == Integer.MIN_VALUE && size > this.hlD) {
            size = (int) this.hlD;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.hlD = i;
    }
}
