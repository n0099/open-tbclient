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
/* loaded from: classes11.dex */
public class SceneLoadingView extends View {
    private ValueAnimator dwJ;
    private int hCN;
    private ValueAnimator.AnimatorUpdateListener hCO;
    private int hxm;
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
        this.hCN = 0;
        this.hCO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.SceneLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SceneLoadingView.this.hCN = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SceneLoadingView.this.invalidate();
            }
        };
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SceneLoadingView, i, 0);
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(a.j.SceneLoadingView_loading_view_size, vy(32));
        this.hxm = obtainStyledAttributes.getInt(a.j.SceneLoadingView_android_color, -1);
        obtainStyledAttributes.recycle();
        rX();
    }

    protected int vy(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private void rX() {
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hxm);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setColor(int i) {
        this.hxm = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setSize(int i) {
        this.mSize = i;
        requestLayout();
    }

    public void start() {
        if (this.dwJ == null) {
            this.dwJ = ValueAnimator.ofInt(0, 11);
            this.dwJ.addUpdateListener(this.hCO);
            this.dwJ.setDuration(600L);
            this.dwJ.setRepeatMode(1);
            this.dwJ.setRepeatCount(-1);
            this.dwJ.setInterpolator(new LinearInterpolator());
            this.dwJ.start();
        } else if (!this.dwJ.isStarted()) {
            this.dwJ.start();
        }
    }

    public void stop() {
        if (this.dwJ != null) {
            this.dwJ.removeUpdateListener(this.hCO);
            this.dwJ.removeAllUpdateListeners();
            this.dwJ.cancel();
            this.dwJ = null;
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
        b(canvas, this.hCN * 30);
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
