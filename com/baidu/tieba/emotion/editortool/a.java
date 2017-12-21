package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private View aFk;
    private boolean visible;

    public a(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aFk != null) {
            this.aFk.measure(getChildMeasureSpec(i, 0, this.aFk.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.aFk.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.aFk != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.aFk.getMeasuredWidth();
            this.aFk.layout(measuredWidth, 0, this.aFk.getMeasuredWidth() + measuredWidth, this.aFk.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.aFk = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.aFk.getLeft(), this.aFk.getTop());
            this.aFk.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
