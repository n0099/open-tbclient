package com.baidu.tbadk.widget.largeImage.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.DragImageView;
/* loaded from: classes.dex */
public class LargeImageView extends DragImageView {
    private b bci;

    public LargeImageView(Context context) {
        super(context);
        this.bci = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bci = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bci = new b(this);
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bci.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.bci.j(canvas)) {
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void computeScroll() {
        this.bci.MN();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float g(Bitmap bitmap) {
        return this.bci.MQ();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float getMinScaleValue() {
        return this.bci.getMinScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float h(Bitmap bitmap) {
        return this.bci.MR();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public void LO() {
        this.bci.a(getImageBitmap(), getImageData());
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.bci.release();
        super.onDetachedFromWindow();
    }
}
