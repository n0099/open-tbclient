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
    private float fIL;
    private float fIM;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.fIL = 0.6f;
        this.fIM = 0.0f;
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fIL = 0.6f;
        this.fIM = 0.0f;
        c(context, attributeSet);
        init();
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fIL = 0.6f;
        this.fIM = 0.0f;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.MaxHeightFrameLayout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.fIL = obtainStyledAttributes.getFloat(index, 0.6f);
            } else if (index == 0) {
                this.fIM = obtainStyledAttributes.getDimension(index, 0.0f);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void init() {
        if (this.fIM <= 0.0f) {
            this.fIM = this.fIL * l.ah(getContext());
        } else {
            this.fIM = Math.min(this.fIM, this.fIL * l.ah(getContext()));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > this.fIM) {
            size = (int) this.fIM;
        }
        if (mode == 0 && size > this.fIM) {
            size = (int) this.fIM;
        }
        if (mode == Integer.MIN_VALUE && size > this.fIM) {
            size = (int) this.fIM;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i) {
        this.fIM = i;
    }
}
