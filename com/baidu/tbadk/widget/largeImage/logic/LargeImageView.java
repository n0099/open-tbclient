package com.baidu.tbadk.widget.largeImage.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.DragImageView;
/* loaded from: classes.dex */
public class LargeImageView extends DragImageView {
    private b dLP;

    public LargeImageView(Context context) {
        super(context);
        this.dLP = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLP = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLP = new b(this);
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dLP.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.dLP.onDraw(canvas)) {
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void computeScroll() {
        this.dLP.computeScroll();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float reInitScaleValue(Bitmap bitmap) {
        return this.dLP.reInitScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float getMinScaleValue() {
        return this.dLP.getMinScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float getMaxScaleValue(Bitmap bitmap) {
        return this.dLP.getMaxScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public void createLargeImageDelegate() {
        this.dLP.setImageDatas(getImageBitmap(), getImageData());
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.dLP.release();
        super.onDetachedFromWindow();
    }
}
