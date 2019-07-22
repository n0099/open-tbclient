package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    private float fGi;
    private float fGj;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.fGi = 0.6f;
        this.fGj = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGi = 0.6f;
        this.fGj = 0.0f;
        c(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGi = 0.6f;
        this.fGj = 0.0f;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.fGi = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == 0) {
                this.fGj = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.fGj <= 0.0f) {
            this.fGj = this.fGi * l.ah(getContext());
        } else {
            this.fGj = Math.min(this.fGj, this.fGi * l.ah(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.fGj) {
            size = (int) this.fGj;
        }
        if (mode == 0 && size > this.fGj) {
            size = (int) this.fGj;
        }
        if (mode == Integer.MIN_VALUE && size > this.fGj) {
            size = (int) this.fGj;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.fGj = i;
    }
}
