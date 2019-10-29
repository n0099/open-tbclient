package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float fIc;
    private float fId;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.fIc = 0.6f;
        this.fId = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fIc = 0.6f;
        this.fId = 0.0f;
        c(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fIc = 0.6f;
        this.fId = 0.0f;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.fIc = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == 0) {
                this.fId = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.fId <= 0.0f) {
            this.fId = this.fIc * l.getEquipmentHeight(getContext());
        } else {
            this.fId = Math.min(this.fId, this.fIc * l.getEquipmentHeight(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.fId) {
            size = (int) this.fId;
        }
        if (mode == 0 && size > this.fId) {
            size = (int) this.fId;
        }
        if (mode == Integer.MIN_VALUE && size > this.fId) {
            size = (int) this.fId;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.fId = i;
    }
}
