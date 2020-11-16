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
/* loaded from: classes4.dex */
public class MagicProgressCircle extends View {
    private static final String TAG = MagicProgressCircle.class.getSimpleName();
    private float bKb;
    private float cAu;
    private Paint dIR;
    private Paint dIS;
    private int dJb;
    private float dJf;
    private float dJg;
    private float gOA;
    private int gOx;
    private float gOy;
    private float gOz;
    private int mDuration;
    private float mHeight;
    private float mProgress;
    private int mProgressColor;
    private float mRadius;
    private RectF mRect;
    private boolean mReverse;
    private ValueAnimator mValueAnimator;

    public MagicProgressCircle(Context context) {
        this(context, null);
    }

    public MagicProgressCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MagicProgressCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJf = 0.0f;
        this.dJg = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.gOy = 100.0f;
        this.mReverse = true;
        this.bKb = 0.0f;
        this.mHeight = 0.0f;
        this.gOz = 10.0f;
        this.gOA = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value, 100);
        this.gOy = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dJb = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.gOx = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_animate_duration, -1);
        this.cAu = vs(obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_circle_sweep_angle, 0));
        this.gOz = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.gOA = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        sw();
    }

    private float vs(int i) {
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
        this.bKb = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.dJf = this.bKb / 2.0f;
        this.dJg = this.bKb / 2.0f;
        float min = Math.min(this.dJf, this.dJg);
        if (this.dJf != this.dJg) {
            this.dJg = min;
            this.dJg = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.gOz, this.gOA);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
    }

    private void sw() {
        bUy();
        bUx();
    }

    private void bUx() {
        if (this.dIR == null) {
            this.dIR = new Paint();
            this.dIR.setColor(this.mProgressColor);
            this.dIR.setStyle(Paint.Style.STROKE);
            this.dIR.setStrokeCap(Paint.Cap.ROUND);
            this.dIR.setStrokeWidth(this.gOA);
            this.dIR.setAntiAlias(true);
        }
    }

    private void bUy() {
        if (this.dIS == null) {
            this.dIS = new Paint();
            this.dIS.setColor(this.gOx);
            this.dIS.setStyle(Paint.Style.STROKE);
            this.dIS.setStrokeCap(Paint.Cap.ROUND);
            this.dIS.setStrokeWidth(this.gOz);
            this.dIS.setAntiAlias(true);
        }
    }

    private void f(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.gOy < 3000.0f / this.mDuration) {
                bUx();
                this.dIR.setColor(this.dJb);
            } else {
                this.dIR.setColor(this.mProgressColor);
            }
        } else {
            this.dIR.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dJf, this.dJg, this.mRadius, this.dIS);
        canvas.drawArc(this.mRect, this.cAu, 360.0f * (-(this.mProgress / this.gOy)), false, this.dIR);
    }

    public MagicProgressCircle av(float f) {
        this.mProgress = f;
        aw(f);
        return this;
    }

    public MagicProgressCircle vt(int i) {
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
    public MagicProgressCircle aw(float f) {
        this.mProgress = f;
        bUw();
        return this;
    }

    private void bUw() {
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
        if (this.mReverse) {
            this.mValueAnimator = ValueAnimator.ofFloat(this.mProgress, 0.0f);
        } else {
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, this.mProgress);
        }
        this.mValueAnimator.setDuration(this.mDuration);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.live.guess.widget.MagicProgressCircle.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MagicProgressCircle.this.aw(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }
}
