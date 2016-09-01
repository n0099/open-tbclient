package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private View axA;
    private boolean visible;

    public f(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.axA != null) {
            this.axA.measure(getChildMeasureSpec(i, 0, this.axA.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.axA.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.axA != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.axA.getMeasuredWidth();
            this.axA.layout(measuredWidth, 0, this.axA.getMeasuredWidth() + measuredWidth, this.axA.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.axA = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.axA.getLeft(), this.axA.getTop());
            this.axA.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
