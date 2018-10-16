package com.baidu.tbadk.widget.largeImage.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.DragImageView;
/* loaded from: classes.dex */
public class LargeImageView extends DragImageView {
    private b bjS;

    public LargeImageView(Context context) {
        super(context);
        this.bjS = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjS = new b(this);
    }

    public LargeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bjS = new b(this);
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bjS.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.bjS.j(canvas)) {
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.view.View
    public void computeScroll() {
        this.bjS.Qb();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float h(Bitmap bitmap) {
        return this.bjS.Qe();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float getMinScaleValue() {
        return this.bjS.getMinScaleValue();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    protected float i(Bitmap bitmap) {
        return this.bjS.Qf();
    }

    @Override // com.baidu.tbadk.widget.DragImageView
    public void Pe() {
        this.bjS.a(getImageBitmap(), getImageData());
    }

    @Override // com.baidu.tbadk.widget.DragImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.bjS.release();
        super.onDetachedFromWindow();
    }
}
