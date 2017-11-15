package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private View aEB;
    private boolean visible;

    public c(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aEB != null) {
            this.aEB.measure(getChildMeasureSpec(i, 0, this.aEB.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.aEB.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.aEB != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.aEB.getMeasuredWidth();
            this.aEB.layout(measuredWidth, 0, this.aEB.getMeasuredWidth() + measuredWidth, this.aEB.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.aEB = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.aEB.getLeft(), this.aEB.getTop());
            this.aEB.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
