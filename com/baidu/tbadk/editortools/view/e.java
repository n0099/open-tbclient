package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e extends LinearLayout {
    private View apx;
    private boolean visible;

    public e(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.apx != null) {
            this.apx.measure(getChildMeasureSpec(i, 0, this.apx.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.apx.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.apx != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.apx.getMeasuredWidth();
            this.apx.layout(measuredWidth, 0, this.apx.getMeasuredWidth() + measuredWidth, this.apx.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.apx = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.apx.getLeft(), this.apx.getTop());
            this.apx.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
