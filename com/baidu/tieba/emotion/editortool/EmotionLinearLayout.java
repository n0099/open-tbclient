package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes6.dex */
public class EmotionLinearLayout extends LinearLayout {
    private View dzV;
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
        if (this.dzV != null) {
            this.dzV.measure(getChildMeasureSpec(i, 0, this.dzV.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.dzV.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.dzV != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.dzV.getMeasuredWidth();
            this.dzV.layout(measuredWidth, 0, this.dzV.getMeasuredWidth() + measuredWidth, this.dzV.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.dzV = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.dzV.getLeft(), this.dzV.getTop());
            this.dzV.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
