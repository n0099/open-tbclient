package com.baidu.tieba.ala.live.guess.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class MagicProgressCircle extends View {
    private static final String TAG = MagicProgressCircle.class.getSimpleName();
    private float bUR;
    private float cLl;
    private Paint dXG;
    private Paint dXH;
    private int dXR;
    private float dXV;
    private float dXW;
    private int hlg;
    private float hlh;
    private boolean hli;
    private float hlj;
    private float hlk;
    private int mDuration;
    private float mHeight;
    private float mProgress;
    private int mProgressColor;
    private float mRadius;
    private RectF mRect;
    private ValueAnimator mValueAnimator;

    public MagicProgressCircle(Context context) {
        this(context, null);
    }

    public MagicProgressCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MagicProgressCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dXV = 0.0f;
        this.dXW = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.hlh = 100.0f;
        this.hli = true;
        this.bUR = 0.0f;
        this.mHeight = 0.0f;
        this.hlj = 10.0f;
        this.hlk = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value, 100);
        this.hlh = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dXR = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.hlg = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_animate_duration, -1);
        this.cLl = uQ(obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_circle_sweep_angle, 0));
        this.hlj = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.hlk = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        rX();
    }

    private float uQ(int i) {
        switch (i) {
            case 0:
                return 180.0f;
            case 1:
                return -90.0f;
            case 2:
            default:
                return 0.0f;
            case 3:
                return 90.0f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.bUR = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.dXV = this.bUR / 2.0f;
        this.dXW = this.bUR / 2.0f;
        float min = Math.min(this.dXV, this.dXW);
        if (this.dXV != this.dXW) {
            this.dXW = min;
            this.dXW = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.hlj, this.hlk);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g(canvas);
    }

    private void rX() {
        bYj();
        bYi();
    }

    private void bYi() {
        if (this.dXG == null) {
            this.dXG = new Paint();
            this.dXG.setColor(this.mProgressColor);
            this.dXG.setStyle(Paint.Style.STROKE);
            this.dXG.setStrokeCap(Paint.Cap.ROUND);
            this.dXG.setStrokeWidth(this.hlk);
            this.dXG.setAntiAlias(true);
        }
    }

    private void bYj() {
        if (this.dXH == null) {
            this.dXH = new Paint();
            this.dXH.setColor(this.hlg);
            this.dXH.setStyle(Paint.Style.STROKE);
            this.dXH.setStrokeCap(Paint.Cap.ROUND);
            this.dXH.setStrokeWidth(this.hlj);
            this.dXH.setAntiAlias(true);
        }
    }

    private void g(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.hlh < 3000.0f / this.mDuration) {
                bYi();
                this.dXG.setColor(this.dXR);
            } else {
                this.dXG.setColor(this.mProgressColor);
            }
        } else {
            this.dXG.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dXV, this.dXW, this.mRadius, this.dXH);
        canvas.drawArc(this.mRect, this.cLl, 360.0f * (-(this.mProgress / this.hlh)), false, this.dXG);
    }

    public MagicProgressCircle aE(float f) {
        this.mProgress = f;
        aF(f);
        return this;
    }

    public MagicProgressCircle uR(int i) {
        this.mDuration = i;
        return this;
    }

    public void startAnim() {
        initAnimation();
        if (this.mValueAnimator != null) {
            this.mValueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MagicProgressCircle aF(float f) {
        this.mProgress = f;
        bYh();
        return this;
    }

    private void bYh() {
        if (isMainThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    private boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private void initAnimation() {
        if (this.hli) {
            this.mValueAnimator = ValueAnimator.ofFloat(this.mProgress, 0.0f);
        } else {
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, this.mProgress);
        }
        this.mValueAnimator.setDuration(this.mDuration);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.live.guess.widget.MagicProgressCircle.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MagicProgressCircle.this.aF(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }
}
