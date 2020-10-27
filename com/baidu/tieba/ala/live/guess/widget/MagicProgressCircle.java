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
    private float cwl;
    private Paint dEH;
    private Paint dEI;
    private int dER;
    private float dEV;
    private float dEW;
    private int gJe;
    private float gJf;
    private float gJg;
    private float gJh;
    private int mDuration;
    private float mHeight;
    private float mProgress;
    private int mProgressColor;
    private float mRadius;
    private RectF mRect;
    private boolean mReverse;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    public MagicProgressCircle(Context context) {
        this(context, null);
    }

    public MagicProgressCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MagicProgressCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEV = 0.0f;
        this.dEW = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.gJf = 100.0f;
        this.mReverse = true;
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.gJg = 10.0f;
        this.gJh = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.k.GuessCircleView_progress_value, 100);
        this.gJf = obtainStyledAttributes.getInteger(a.k.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.k.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dER = obtainStyledAttributes.getColor(a.k.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.gJe = obtainStyledAttributes.getColor(a.k.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.k.GuessCircleView_progress_animate_duration, -1);
        this.cwl = uK(obtainStyledAttributes.getInt(a.k.GuessCircleView_progress_circle_sweep_angle, 0));
        this.gJg = obtainStyledAttributes.getDimension(a.k.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.gJh = obtainStyledAttributes.getDimension(a.k.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        sw();
    }

    private float uK(int i) {
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
        this.mWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.dEV = this.mWidth / 2.0f;
        this.dEW = this.mWidth / 2.0f;
        float min = Math.min(this.dEV, this.dEW);
        if (this.dEV != this.dEW) {
            this.dEW = min;
            this.dEW = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.gJg, this.gJh);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
    }

    private void sw() {
        bSG();
        bSF();
    }

    private void bSF() {
        if (this.dEH == null) {
            this.dEH = new Paint();
            this.dEH.setColor(this.mProgressColor);
            this.dEH.setStyle(Paint.Style.STROKE);
            this.dEH.setStrokeCap(Paint.Cap.ROUND);
            this.dEH.setStrokeWidth(this.gJh);
            this.dEH.setAntiAlias(true);
        }
    }

    private void bSG() {
        if (this.dEI == null) {
            this.dEI = new Paint();
            this.dEI.setColor(this.gJe);
            this.dEI.setStyle(Paint.Style.STROKE);
            this.dEI.setStrokeCap(Paint.Cap.ROUND);
            this.dEI.setStrokeWidth(this.gJg);
            this.dEI.setAntiAlias(true);
        }
    }

    private void f(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.gJf < 3000.0f / this.mDuration) {
                bSF();
                this.dEH.setColor(this.dER);
            } else {
                this.dEH.setColor(this.mProgressColor);
            }
        } else {
            this.dEH.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dEV, this.dEW, this.mRadius, this.dEI);
        canvas.drawArc(this.mRect, this.cwl, 360.0f * (-(this.mProgress / this.gJf)), false, this.dEH);
    }

    public MagicProgressCircle ar(float f) {
        this.mProgress = f;
        as(f);
        return this;
    }

    public MagicProgressCircle uL(int i) {
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
    public MagicProgressCircle as(float f) {
        this.mProgress = f;
        bSE();
        return this;
    }

    private void bSE() {
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
                MagicProgressCircle.this.as(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }
}
