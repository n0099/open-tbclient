package com.baidu.tbadk.widget.largeImage.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.DragImageView;
import d.a.n0.b1.i.b.b;
/* loaded from: classes3.dex */
public class LargeImageView extends DragImageView {
    public b x0;

    public LargeImageView(Context context) {
        super(context);
        this.x0 = new b(this);
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public void T() {
        this.x0.Q(getImageBitmap(), getImageData());
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public float U(Bitmap bitmap) {
        return this.x0.y();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void computeScroll() {
        this.x0.t();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public float getMinScaleValue() {
        return this.x0.z();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public float j0(Bitmap bitmap) {
        return this.x0.N();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.x0.O();
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.x0.J(canvas)) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.x0.M(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public LargeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x0 = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x0 = new b(this);
    }
}
