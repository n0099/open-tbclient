package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes4.dex */
public class EmotionLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f14321e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14322f;

    public EmotionLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f14322f) {
            canvas.save();
            canvas.translate(this.f14321e.getLeft(), this.f14321e.getTop());
            this.f14321e.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View childAt = getChildAt(0);
        if (this.f14321e == null || childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth() - this.f14321e.getMeasuredWidth();
        View view = this.f14321e;
        view.layout(measuredWidth, 0, view.getMeasuredWidth() + measuredWidth, this.f14321e.getMeasuredHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.f14321e;
        if (view != null) {
            this.f14321e.measure(LinearLayout.getChildMeasureSpec(i2, 0, view.getLayoutParams().width), LinearLayout.getChildMeasureSpec(i3, 0, this.f14321e.getLayoutParams().height));
        }
    }

    public void setNewView(View view) {
        this.f14321e = view;
    }

    public void setNewViewVisible(boolean z) {
        this.f14322f = z;
        invalidate();
    }

    public EmotionLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
