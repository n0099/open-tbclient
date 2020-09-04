package com.baidu.tieba.ala.liveroom.exclusive;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class SceneLoadingView extends View {
    private int gsN;
    private int gyO;
    private ValueAnimator.AnimatorUpdateListener gyP;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private int mSize;

    public SceneLoadingView(Context context) {
        this(context, null);
    }

    public SceneLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SceneLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gyO = 0;
        this.gyP = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.SceneLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SceneLoadingView.this.gyO = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SceneLoadingView.this.invalidate();
            }
        };
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.SceneLoadingView, i, 0);
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(a.k.SceneLoadingView_loading_view_size, ua(32));
        this.gsN = obtainStyledAttributes.getInt(a.k.SceneLoadingView_android_color, -1);
        obtainStyledAttributes.recycle();
        sr();
    }

    protected int ua(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private void sr() {
        this.mPaint = new Paint();
        this.mPaint.setColor(this.gsN);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setColor(int i) {
        this.gsN = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setSize(int i) {
        this.mSize = i;
        requestLayout();
    }

    public void start() {
        if (this.mAnimator == null) {
            this.mAnimator = ValueAnimator.ofInt(0, 11);
            this.mAnimator.addUpdateListener(this.gyP);
            this.mAnimator.setDuration(600L);
            this.mAnimator.setRepeatMode(1);
            this.mAnimator.setRepeatCount(-1);
            this.mAnimator.setInterpolator(new LinearInterpolator());
            this.mAnimator.start();
        } else if (!this.mAnimator.isStarted()) {
            this.mAnimator.start();
        }
    }

    public void stop() {
        if (this.mAnimator != null) {
            this.mAnimator.removeUpdateListener(this.gyP);
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
    }

    private void a(Canvas canvas, int i) {
        int i2 = this.mSize / 12;
        int i3 = this.mSize / 6;
        this.mPaint.setStrokeWidth(i2);
        canvas.rotate(i, this.mSize / 2, this.mSize / 2);
        canvas.translate(this.mSize / 2, this.mSize / 2);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < 12) {
                canvas.rotate(30.0f);
                this.mPaint.setAlpha((int) ((255.0f * (i5 + 1)) / 12.0f));
                canvas.translate(0.0f, ((-this.mSize) / 2) + (i2 / 2));
                canvas.drawLine(0.0f, 0.0f, 0.0f, i3, this.mPaint);
                canvas.translate(0.0f, (this.mSize / 2) - (i2 / 2));
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mSize, this.mSize);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        a(canvas, this.gyO * 30);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            start();
        } else {
            stop();
        }
    }
}
