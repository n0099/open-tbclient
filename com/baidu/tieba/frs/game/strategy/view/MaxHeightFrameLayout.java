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
    private float fGW;
    private float fGX;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.fGW = 0.6f;
        this.fGX = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGW = 0.6f;
        this.fGX = 0.0f;
        c(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGW = 0.6f;
        this.fGX = 0.0f;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.fGW = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == 0) {
                this.fGX = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.fGX <= 0.0f) {
            this.fGX = this.fGW * l.ah(getContext());
        } else {
            this.fGX = Math.min(this.fGX, this.fGW * l.ah(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.fGX) {
            size = (int) this.fGX;
        }
        if (mode == 0 && size > this.fGX) {
            size = (int) this.fGX;
        }
        if (mode == Integer.MIN_VALUE && size > this.fGX) {
            size = (int) this.fGX;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.fGX = i;
    }
}
