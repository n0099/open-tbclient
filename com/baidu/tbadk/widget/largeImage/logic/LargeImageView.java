package com.baidu.tbadk.widget.largeImage.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.DragImageView;
/* loaded from: classes.dex */
public class LargeImageView extends DragImageView {
    private b bob;

    public LargeImageView(Context context) {
        super(context);
        this.bob = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bob = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bob = new b(this);
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bob.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.bob.j(canvas)) {
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void computeScroll() {
        this.bob.Rq();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float h(Bitmap bitmap) {
        return this.bob.Rt();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float getMinScaleValue() {
        return this.bob.getMinScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float i(Bitmap bitmap) {
        return this.bob.Ru();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public void Qt() {
        this.bob.a(getImageBitmap(), getImageData());
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.bob.release();
        super.onDetachedFromWindow();
    }
}
