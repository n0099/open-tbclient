package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class DeskLinearLayout extends LinearLayout {
    private View bcb;
    private boolean visible;

    public DeskLinearLayout(Context context) {
        super(context);
    }

    public DeskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.bcb != null) {
            this.bcb.measure(getChildMeasureSpec(i, 0, this.bcb.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.bcb.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.bcb != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.bcb.getMeasuredWidth();
            this.bcb.layout(measuredWidth, 0, this.bcb.getMeasuredWidth() + measuredWidth, this.bcb.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.bcb = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.bcb.getLeft(), this.bcb.getTop());
            this.bcb.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
