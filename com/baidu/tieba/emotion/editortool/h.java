package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private View avo;
    private boolean visible;

    public h(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.avo != null) {
            this.avo.measure(getChildMeasureSpec(i, 0, this.avo.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.avo.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.avo != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.avo.getMeasuredWidth();
            this.avo.layout(measuredWidth, 0, this.avo.getMeasuredWidth() + measuredWidth, this.avo.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.avo = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.avo.getLeft(), this.avo.getTop());
            this.avo.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
