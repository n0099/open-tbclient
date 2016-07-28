package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private View aut;
    private boolean visible;

    public h(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aut != null) {
            this.aut.measure(getChildMeasureSpec(i, 0, this.aut.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.aut.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.aut != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.aut.getMeasuredWidth();
            this.aut.layout(measuredWidth, 0, this.aut.getMeasuredWidth() + measuredWidth, this.aut.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.aut = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.aut.getLeft(), this.aut.getTop());
            this.aut.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
