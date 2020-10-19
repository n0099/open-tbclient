package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes13.dex */
public class EmotionLinearLayout extends LinearLayout {
    private View fcQ;
    private boolean visible;

    public EmotionLinearLayout(Context context) {
        super(context);
    }

    public EmotionLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fcQ != null) {
            this.fcQ.measure(getChildMeasureSpec(i, 0, this.fcQ.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.fcQ.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.fcQ != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.fcQ.getMeasuredWidth();
            this.fcQ.layout(measuredWidth, 0, this.fcQ.getMeasuredWidth() + measuredWidth, this.fcQ.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.fcQ = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.fcQ.getLeft(), this.fcQ.getTop());
            this.fcQ.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
