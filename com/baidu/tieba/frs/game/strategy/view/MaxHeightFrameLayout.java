package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float iWN;
    private float iWO;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.iWN = 0.6f;
        this.iWO = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iWN = 0.6f;
        this.iWO = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iWN = 0.6f;
        this.iWO = 0.0f;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.iWN = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == 0) {
                this.iWO = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.iWO <= 0.0f) {
            this.iWO = this.iWN * l.getEquipmentHeight(getContext());
        } else {
            this.iWO = Math.min(this.iWO, this.iWN * l.getEquipmentHeight(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.iWO) {
            size = (int) this.iWO;
        }
        if (mode == 0 && size > this.iWO) {
            size = (int) this.iWO;
        }
        if (mode == Integer.MIN_VALUE && size > this.iWO) {
            size = (int) this.iWO;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.iWO = i;
    }
}
