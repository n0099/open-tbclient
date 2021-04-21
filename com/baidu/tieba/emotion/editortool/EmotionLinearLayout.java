package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes4.dex */
public class EmotionLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f14987e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14988f;

    public EmotionLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f14988f) {
            canvas.save();
            canvas.translate(this.f14987e.getLeft(), this.f14987e.getTop());
            this.f14987e.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.f14987e == null || childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth() - this.f14987e.getMeasuredWidth();
        View view = this.f14987e;
        view.layout(measuredWidth, 0, view.getMeasuredWidth() + measuredWidth, this.f14987e.getMeasuredHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.f14987e;
        if (view != null) {
            this.f14987e.measure(LinearLayout.getChildMeasureSpec(i, 0, view.getLayoutParams().width), LinearLayout.getChildMeasureSpec(i2, 0, this.f14987e.getLayoutParams().height));
        }
    }

    public void setNewView(View view) {
        this.f14987e = view;
    }

    public void setNewViewVisible(boolean z) {
        this.f14988f = z;
        invalidate();
    }

    public EmotionLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
