package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class DeskLinearLayout extends LinearLayout {
    private View dzH;
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
        if (this.dzH != null) {
            this.dzH.measure(getChildMeasureSpec(i, 0, this.dzH.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.dzH.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.dzH != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.dzH.getMeasuredWidth();
            this.dzH.layout(measuredWidth, 0, this.dzH.getMeasuredWidth() + measuredWidth, this.dzH.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.dzH = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.dzH.getLeft(), this.dzH.getTop());
            this.dzH.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
