package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private View axU;
    private boolean visible;

    public f(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.axU != null) {
            this.axU.measure(getChildMeasureSpec(i, 0, this.axU.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.axU.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.axU != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.axU.getMeasuredWidth();
            this.axU.layout(measuredWidth, 0, this.axU.getMeasuredWidth() + measuredWidth, this.axU.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.axU = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.axU.getLeft(), this.axU.getTop());
            this.axU.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
