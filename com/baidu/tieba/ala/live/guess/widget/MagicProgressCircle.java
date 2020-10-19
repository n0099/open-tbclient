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
    private float cnI;
    private Paint dwk;
    private Paint dwl;
    private int dwu;
    private float dwy;
    private float dwz;
    private int gxq;
    private float gxr;
    private float gxs;
    private float gxt;
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
        this.dwy = 0.0f;
        this.dwz = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.gxr = 100.0f;
        this.mReverse = true;
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.gxs = 10.0f;
        this.gxt = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.k.GuessCircleView_progress_value, 100);
        this.gxr = obtainStyledAttributes.getInteger(a.k.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.k.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dwu = obtainStyledAttributes.getColor(a.k.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.gxq = obtainStyledAttributes.getColor(a.k.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.k.GuessCircleView_progress_animate_duration, -1);
        this.cnI = ur(obtainStyledAttributes.getInt(a.k.GuessCircleView_progress_circle_sweep_angle, 0));
        this.gxs = obtainStyledAttributes.getDimension(a.k.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.gxt = obtainStyledAttributes.getDimension(a.k.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        sw();
    }

    private float ur(int i) {
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
        this.dwy = this.mWidth / 2.0f;
        this.dwz = this.mWidth / 2.0f;
        float min = Math.min(this.dwy, this.dwz);
        if (this.dwy != this.dwz) {
            this.dwz = min;
            this.dwz = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.gxs, this.gxt);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
    }

    private void sw() {
        bPJ();
        bPI();
    }

    private void bPI() {
        if (this.dwk == null) {
            this.dwk = new Paint();
            this.dwk.setColor(this.mProgressColor);
            this.dwk.setStyle(Paint.Style.STROKE);
            this.dwk.setStrokeCap(Paint.Cap.ROUND);
            this.dwk.setStrokeWidth(this.gxt);
            this.dwk.setAntiAlias(true);
        }
    }

    private void bPJ() {
        if (this.dwl == null) {
            this.dwl = new Paint();
            this.dwl.setColor(this.gxq);
            this.dwl.setStyle(Paint.Style.STROKE);
            this.dwl.setStrokeCap(Paint.Cap.ROUND);
            this.dwl.setStrokeWidth(this.gxs);
            this.dwl.setAntiAlias(true);
        }
    }

    private void f(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.gxr < 3000.0f / this.mDuration) {
                bPI();
                this.dwk.setColor(this.dwu);
            } else {
                this.dwk.setColor(this.mProgressColor);
            }
        } else {
            this.dwk.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dwy, this.dwz, this.mRadius, this.dwl);
        canvas.drawArc(this.mRect, this.cnI, 360.0f * (-(this.mProgress / this.gxr)), false, this.dwk);
    }

    public MagicProgressCircle ap(float f) {
        this.mProgress = f;
        aq(f);
        return this;
    }

    public MagicProgressCircle us(int i) {
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
    public MagicProgressCircle aq(float f) {
        this.mProgress = f;
        bPH();
        return this;
    }

    private void bPH() {
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
                MagicProgressCircle.this.aq(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }
}
