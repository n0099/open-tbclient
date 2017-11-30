package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private View aFc;
    private boolean visible;

    public c(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aFc != null) {
            this.aFc.measure(getChildMeasureSpec(i, 0, this.aFc.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.aFc.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.aFc != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.aFc.getMeasuredWidth();
            this.aFc.layout(measuredWidth, 0, this.aFc.getMeasuredWidth() + measuredWidth, this.aFc.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.aFc = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.aFc.getLeft(), this.aFc.getTop());
            this.aFc.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
