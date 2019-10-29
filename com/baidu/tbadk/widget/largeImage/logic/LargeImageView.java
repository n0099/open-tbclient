package com.baidu.tbadk.widget.largeImage.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.DragImageView;
/* loaded from: classes.dex */
public class LargeImageView extends DragImageView {
    private b cTy;

    public LargeImageView(Context context) {
        super(context);
        this.cTy = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cTy = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cTy = new b(this);
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cTy.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.cTy.onDraw(canvas)) {
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void computeScroll() {
        this.cTy.computeScroll();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float reInitScaleValue(Bitmap bitmap) {
        return this.cTy.reInitScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float getMinScaleValue() {
        return this.cTy.getMinScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float getMaxScaleValue(Bitmap bitmap) {
        return this.cTy.getMaxScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public void createLargeImageDelegate() {
        this.cTy.setImageDatas(getImageBitmap(), getImageData());
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.cTy.release();
        super.onDetachedFromWindow();
    }
}
