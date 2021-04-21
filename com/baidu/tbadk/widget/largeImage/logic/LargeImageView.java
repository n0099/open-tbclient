package com.baidu.tbadk.widget.largeImage.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.DragImageView;
import d.b.i0.b1.i.b.b;
/* loaded from: classes3.dex */
public class LargeImageView extends DragImageView {
    public b s0;

    public LargeImageView(Context context) {
        super(context);
        this.s0 = new b(this);
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public void T() {
        this.s0.Q(getImageBitmap(), getImageData());
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public float U(Bitmap bitmap) {
        return this.s0.y();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void computeScroll() {
        this.s0.t();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public float getMinScaleValue() {
        return this.s0.z();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public float j0(Bitmap bitmap) {
        return this.s0.N();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.s0.O();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.s0.J(canvas)) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.s0.M(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public LargeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s0 = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s0 = new b(this);
    }
}
