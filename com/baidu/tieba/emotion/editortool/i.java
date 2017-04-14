package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private View aCg;
    private boolean visible;

    public i(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aCg != null) {
            this.aCg.measure(getChildMeasureSpec(i, 0, this.aCg.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.aCg.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.aCg != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.aCg.getMeasuredWidth();
            this.aCg.layout(measuredWidth, 0, this.aCg.getMeasuredWidth() + measuredWidth, this.aCg.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.aCg = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.aCg.getLeft(), this.aCg.getTop());
            this.aCg.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
