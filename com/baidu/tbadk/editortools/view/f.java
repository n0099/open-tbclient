package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private View asO;
    private boolean visible;

    public f(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.asO != null) {
            this.asO.measure(getChildMeasureSpec(i, 0, this.asO.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.asO.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.asO != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.asO.getMeasuredWidth();
            this.asO.layout(measuredWidth, 0, this.asO.getMeasuredWidth() + measuredWidth, this.asO.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.asO = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.asO.getLeft(), this.asO.getTop());
            this.asO.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
