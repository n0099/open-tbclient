package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private View aFh;
    private boolean visible;

    public a(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aFh != null) {
            this.aFh.measure(getChildMeasureSpec(i, 0, this.aFh.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.aFh.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.aFh != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.aFh.getMeasuredWidth();
            this.aFh.layout(measuredWidth, 0, this.aFh.getMeasuredWidth() + measuredWidth, this.aFh.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.aFh = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.aFh.getLeft(), this.aFh.getTop());
            this.aFh.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
