package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private View axr;
    private boolean visible;

    public h(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.axr != null) {
            this.axr.measure(getChildMeasureSpec(i, 0, this.axr.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.axr.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.axr != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.axr.getMeasuredWidth();
            this.axr.layout(measuredWidth, 0, this.axr.getMeasuredWidth() + measuredWidth, this.axr.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.axr = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.axr.getLeft(), this.axr.getTop());
            this.axr.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
