package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private View btc;
    private boolean visible;

    public a(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.btc != null) {
            this.btc.measure(getChildMeasureSpec(i, 0, this.btc.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.btc.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.btc != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.btc.getMeasuredWidth();
            this.btc.layout(measuredWidth, 0, this.btc.getMeasuredWidth() + measuredWidth, this.btc.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.btc = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.btc.getLeft(), this.btc.getTop());
            this.btc.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
