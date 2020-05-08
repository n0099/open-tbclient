package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class DeskLinearLayout extends LinearLayout {
    private View dZV;
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
        if (this.dZV != null) {
            this.dZV.measure(getChildMeasureSpec(i, 0, this.dZV.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.dZV.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.dZV != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.dZV.getMeasuredWidth();
            this.dZV.layout(measuredWidth, 0, this.dZV.getMeasuredWidth() + measuredWidth, this.dZV.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.dZV = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.dZV.getLeft(), this.dZV.getTop());
            this.dZV.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
