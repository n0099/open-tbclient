package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e extends LinearLayout {
    private View awg;
    private boolean visible;

    public e(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.awg != null) {
            this.awg.measure(getChildMeasureSpec(i, 0, this.awg.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.awg.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.awg != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.awg.getMeasuredWidth();
            this.awg.layout(measuredWidth, 0, this.awg.getMeasuredWidth() + measuredWidth, this.awg.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.awg = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.awg.getLeft(), this.awg.getTop());
            this.awg.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
