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
/* loaded from: classes11.dex */
public class MagicProgressCircle extends View {
    private static final String TAG = MagicProgressCircle.class.getSimpleName();
    private float bTr;
    private float cJL;
    private Paint dWf;
    private Paint dWg;
    private int dWq;
    private float dWu;
    private float dWv;
    private float hjA;
    private float hjB;
    private int hjx;
    private float hjy;
    private boolean hjz;
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
        this.dWu = 0.0f;
        this.dWv = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.hjy = 100.0f;
        this.hjz = true;
        this.bTr = 0.0f;
        this.mHeight = 0.0f;
        this.hjA = 10.0f;
        this.hjB = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value, 100);
        this.hjy = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dWq = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.hjx = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_animate_duration, -1);
        this.cJL = uO(obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_circle_sweep_angle, 0));
        this.hjA = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.hjB = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        rX();
    }

    private float uO(int i) {
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
        this.bTr = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.dWu = this.bTr / 2.0f;
        this.dWv = this.bTr / 2.0f;
        float min = Math.min(this.dWu, this.dWv);
        if (this.dWu != this.dWv) {
            this.dWv = min;
            this.dWv = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.hjA, this.hjB);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g(canvas);
    }

    private void rX() {
        bYd();
        bYc();
    }

    private void bYc() {
        if (this.dWf == null) {
            this.dWf = new Paint();
            this.dWf.setColor(this.mProgressColor);
            this.dWf.setStyle(Paint.Style.STROKE);
            this.dWf.setStrokeCap(Paint.Cap.ROUND);
            this.dWf.setStrokeWidth(this.hjB);
            this.dWf.setAntiAlias(true);
        }
    }

    private void bYd() {
        if (this.dWg == null) {
            this.dWg = new Paint();
            this.dWg.setColor(this.hjx);
            this.dWg.setStyle(Paint.Style.STROKE);
            this.dWg.setStrokeCap(Paint.Cap.ROUND);
            this.dWg.setStrokeWidth(this.hjA);
            this.dWg.setAntiAlias(true);
        }
    }

    private void g(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.hjy < 3000.0f / this.mDuration) {
                bYc();
                this.dWf.setColor(this.dWq);
            } else {
                this.dWf.setColor(this.mProgressColor);
            }
        } else {
            this.dWf.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dWu, this.dWv, this.mRadius, this.dWg);
        canvas.drawArc(this.mRect, this.cJL, 360.0f * (-(this.mProgress / this.hjy)), false, this.dWf);
    }

    public MagicProgressCircle aA(float f) {
        this.mProgress = f;
        aB(f);
        return this;
    }

    public MagicProgressCircle uP(int i) {
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
    public MagicProgressCircle aB(float f) {
        this.mProgress = f;
        bYb();
        return this;
    }

    private void bYb() {
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
        if (this.hjz) {
            this.mValueAnimator = ValueAnimator.ofFloat(this.mProgress, 0.0f);
        } else {
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, this.mProgress);
        }
        this.mValueAnimator.setDuration(this.mDuration);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.live.guess.widget.MagicProgressCircle.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MagicProgressCircle.this.aB(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }
}
