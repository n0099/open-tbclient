package com.baidu.tieba.ala.liveroom.exclusive;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class SceneLoadingView extends View {
    private ValueAnimator dyk;
    private int hEK;
    private ValueAnimator.AnimatorUpdateListener hEL;
    private int hzj;
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
        this.hEK = 0;
        this.hEL = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.SceneLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SceneLoadingView.this.hEK = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SceneLoadingView.this.invalidate();
            }
        };
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SceneLoadingView, i, 0);
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(a.j.SceneLoadingView_loading_view_size, vA(32));
        this.hzj = obtainStyledAttributes.getInt(a.j.SceneLoadingView_android_color, -1);
        obtainStyledAttributes.recycle();
        rX();
    }

    protected int vA(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private void rX() {
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hzj);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setColor(int i) {
        this.hzj = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setSize(int i) {
        this.mSize = i;
        requestLayout();
    }

    public void start() {
        if (this.dyk == null) {
            this.dyk = ValueAnimator.ofInt(0, 11);
            this.dyk.addUpdateListener(this.hEL);
            this.dyk.setDuration(600L);
            this.dyk.setRepeatMode(1);
            this.dyk.setRepeatCount(-1);
            this.dyk.setInterpolator(new LinearInterpolator());
            this.dyk.start();
        } else if (!this.dyk.isStarted()) {
            this.dyk.start();
        }
    }

    public void stop() {
        if (this.dyk != null) {
            this.dyk.removeUpdateListener(this.hEL);
            this.dyk.removeAllUpdateListeners();
            this.dyk.cancel();
            this.dyk = null;
        }
    }

    private void b(Canvas canvas, int i) {
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
        b(canvas, this.hEK * 30);
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
