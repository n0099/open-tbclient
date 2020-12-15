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
    private float bPi;
    private float cHm;
    private Paint dPP;
    private Paint dPQ;
    private int dPZ;
    private float dQd;
    private float dQe;
    private int gXM;
    private float gXN;
    private float gXO;
    private float gXP;
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
        this.dQd = 0.0f;
        this.dQe = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.gXN = 100.0f;
        this.mReverse = true;
        this.bPi = 0.0f;
        this.mHeight = 0.0f;
        this.gXO = 10.0f;
        this.gXP = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value, 100);
        this.gXN = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dPZ = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.gXM = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_animate_duration, -1);
        this.cHm = vZ(obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_circle_sweep_angle, 0));
        this.gXO = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.gXP = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        sz();
    }

    private float vZ(int i) {
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
        this.bPi = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.dQd = this.bPi / 2.0f;
        this.dQe = this.bPi / 2.0f;
        float min = Math.min(this.dQd, this.dQe);
        if (this.dQd != this.dQe) {
            this.dQe = min;
            this.dQe = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.gXO, this.gXP);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
    }

    private void sz() {
        bYi();
        bYh();
    }

    private void bYh() {
        if (this.dPP == null) {
            this.dPP = new Paint();
            this.dPP.setColor(this.mProgressColor);
            this.dPP.setStyle(Paint.Style.STROKE);
            this.dPP.setStrokeCap(Paint.Cap.ROUND);
            this.dPP.setStrokeWidth(this.gXP);
            this.dPP.setAntiAlias(true);
        }
    }

    private void bYi() {
        if (this.dPQ == null) {
            this.dPQ = new Paint();
            this.dPQ.setColor(this.gXM);
            this.dPQ.setStyle(Paint.Style.STROKE);
            this.dPQ.setStrokeCap(Paint.Cap.ROUND);
            this.dPQ.setStrokeWidth(this.gXO);
            this.dPQ.setAntiAlias(true);
        }
    }

    private void f(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.gXN < 3000.0f / this.mDuration) {
                bYh();
                this.dPP.setColor(this.dPZ);
            } else {
                this.dPP.setColor(this.mProgressColor);
            }
        } else {
            this.dPP.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dQd, this.dQe, this.mRadius, this.dPQ);
        canvas.drawArc(this.mRect, this.cHm, 360.0f * (-(this.mProgress / this.gXN)), false, this.dPP);
    }

    public MagicProgressCircle aw(float f) {
        this.mProgress = f;
        ax(f);
        return this;
    }

    public MagicProgressCircle wa(int i) {
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
    public MagicProgressCircle ax(float f) {
        this.mProgress = f;
        bYg();
        return this;
    }

    private void bYg() {
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
                MagicProgressCircle.this.ax(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }
}
