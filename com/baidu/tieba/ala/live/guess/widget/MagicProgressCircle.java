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
    private float bPB;
    private float cHr;
    private Paint dTZ;
    private Paint dUa;
    private int dUk;
    private float dUo;
    private float dUp;
    private int heT;
    private float heU;
    private boolean heV;
    private float heW;
    private float heX;
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
        this.dUo = 0.0f;
        this.dUp = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.heU = 100.0f;
        this.heV = true;
        this.bPB = 0.0f;
        this.mHeight = 0.0f;
        this.heW = 10.0f;
        this.heX = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value, 100);
        this.heU = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dUk = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.heT = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_animate_duration, -1);
        this.cHr = uE(obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_circle_sweep_angle, 0));
        this.heW = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.heX = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        sa();
    }

    private float uE(int i) {
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
        this.bPB = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.dUo = this.bPB / 2.0f;
        this.dUp = this.bPB / 2.0f;
        float min = Math.min(this.dUo, this.dUp);
        if (this.dUo != this.dUp) {
            this.dUp = min;
            this.dUp = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.heW, this.heX);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g(canvas);
    }

    private void sa() {
        bWW();
        bWV();
    }

    private void bWV() {
        if (this.dTZ == null) {
            this.dTZ = new Paint();
            this.dTZ.setColor(this.mProgressColor);
            this.dTZ.setStyle(Paint.Style.STROKE);
            this.dTZ.setStrokeCap(Paint.Cap.ROUND);
            this.dTZ.setStrokeWidth(this.heX);
            this.dTZ.setAntiAlias(true);
        }
    }

    private void bWW() {
        if (this.dUa == null) {
            this.dUa = new Paint();
            this.dUa.setColor(this.heT);
            this.dUa.setStyle(Paint.Style.STROKE);
            this.dUa.setStrokeCap(Paint.Cap.ROUND);
            this.dUa.setStrokeWidth(this.heW);
            this.dUa.setAntiAlias(true);
        }
    }

    private void g(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.heU < 3000.0f / this.mDuration) {
                bWV();
                this.dTZ.setColor(this.dUk);
            } else {
                this.dTZ.setColor(this.mProgressColor);
            }
        } else {
            this.dTZ.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dUo, this.dUp, this.mRadius, this.dUa);
        canvas.drawArc(this.mRect, this.cHr, 360.0f * (-(this.mProgress / this.heU)), false, this.dTZ);
    }

    public MagicProgressCircle ay(float f) {
        this.mProgress = f;
        az(f);
        return this;
    }

    public MagicProgressCircle uF(int i) {
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
    public MagicProgressCircle az(float f) {
        this.mProgress = f;
        bWU();
        return this;
    }

    private void bWU() {
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
        if (this.heV) {
            this.mValueAnimator = ValueAnimator.ofFloat(this.mProgress, 0.0f);
        } else {
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, this.mProgress);
        }
        this.mValueAnimator.setDuration(this.mDuration);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.live.guess.widget.MagicProgressCircle.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MagicProgressCircle.this.az(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }
}
