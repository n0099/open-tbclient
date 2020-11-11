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
    private float cCe;
    private Paint dKA;
    private int dKJ;
    private float dKN;
    private float dKO;
    private Paint dKz;
    private int gOQ;
    private float gOR;
    private float gOS;
    private float gOT;
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
        this.dKN = 0.0f;
        this.dKO = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.gOR = 100.0f;
        this.mReverse = true;
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.gOS = 10.0f;
        this.gOT = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value, 100);
        this.gOR = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dKJ = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.gOQ = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_animate_duration, -1);
        this.cCe = uU(obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_circle_sweep_angle, 0));
        this.gOS = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.gOT = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        sw();
    }

    private float uU(int i) {
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
        this.dKN = this.mWidth / 2.0f;
        this.dKO = this.mWidth / 2.0f;
        float min = Math.min(this.dKN, this.dKO);
        if (this.dKN != this.dKO) {
            this.dKO = min;
            this.dKO = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.gOS, this.gOT);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
    }

    private void sw() {
        bVf();
        bVe();
    }

    private void bVe() {
        if (this.dKz == null) {
            this.dKz = new Paint();
            this.dKz.setColor(this.mProgressColor);
            this.dKz.setStyle(Paint.Style.STROKE);
            this.dKz.setStrokeCap(Paint.Cap.ROUND);
            this.dKz.setStrokeWidth(this.gOT);
            this.dKz.setAntiAlias(true);
        }
    }

    private void bVf() {
        if (this.dKA == null) {
            this.dKA = new Paint();
            this.dKA.setColor(this.gOQ);
            this.dKA.setStyle(Paint.Style.STROKE);
            this.dKA.setStrokeCap(Paint.Cap.ROUND);
            this.dKA.setStrokeWidth(this.gOS);
            this.dKA.setAntiAlias(true);
        }
    }

    private void f(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.gOR < 3000.0f / this.mDuration) {
                bVe();
                this.dKz.setColor(this.dKJ);
            } else {
                this.dKz.setColor(this.mProgressColor);
            }
        } else {
            this.dKz.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dKN, this.dKO, this.mRadius, this.dKA);
        canvas.drawArc(this.mRect, this.cCe, 360.0f * (-(this.mProgress / this.gOR)), false, this.dKz);
    }

    public MagicProgressCircle at(float f) {
        this.mProgress = f;
        au(f);
        return this;
    }

    public MagicProgressCircle uV(int i) {
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
    public MagicProgressCircle au(float f) {
        this.mProgress = f;
        bVd();
        return this;
    }

    private void bVd() {
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
                MagicProgressCircle.this.au(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }
}
