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
    private float bUn;
    private float cMd;
    private Paint dYL;
    private Paint dYM;
    private int dYW;
    private float dZa;
    private float dZb;
    private int hjA;
    private float hjB;
    private boolean hjC;
    private float hjD;
    private float hjE;
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
        this.dZa = 0.0f;
        this.dZb = 0.0f;
        this.mRadius = 0.0f;
        this.mRect = new RectF();
        this.mProgress = 100.0f;
        this.hjB = 100.0f;
        this.hjC = true;
        this.bUn = 0.0f;
        this.mHeight = 0.0f;
        this.hjD = 10.0f;
        this.hjE = 10.0f;
        this.mValueAnimator = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.GuessCircleView);
        this.mProgress = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value, 100);
        this.hjB = obtainStyledAttributes.getInteger(a.j.GuessCircleView_progress_value_max, 100);
        this.mProgressColor = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color, Color.parseColor("#974DF8"));
        this.dYW = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_end_color, Color.parseColor("#FF0050"));
        this.hjA = obtainStyledAttributes.getColor(a.j.GuessCircleView_progress_color_background, 0);
        this.mDuration = obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_animate_duration, -1);
        this.cMd = wk(obtainStyledAttributes.getInt(a.j.GuessCircleView_progress_circle_sweep_angle, 0));
        this.hjD = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_bg_width, 10.0f);
        this.hjE = obtainStyledAttributes.getDimension(a.j.GuessCircleView_progress_paint_value_width, 10.0f);
        obtainStyledAttributes.recycle();
        sa();
    }

    private float wk(int i) {
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
        this.bUn = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.dZa = this.bUn / 2.0f;
        this.dZb = this.bUn / 2.0f;
        float min = Math.min(this.dZa, this.dZb);
        if (this.dZa != this.dZb) {
            this.dZb = min;
            this.dZb = min;
        }
        if (this.mRadius < 1.0f) {
            this.mRadius = min - Math.max(this.hjD, this.hjE);
        }
        this.mRect.set(min - this.mRadius, min - this.mRadius, this.mRadius + min, min + this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g(canvas);
    }

    private void sa() {
        caO();
        caN();
    }

    private void caN() {
        if (this.dYL == null) {
            this.dYL = new Paint();
            this.dYL.setColor(this.mProgressColor);
            this.dYL.setStyle(Paint.Style.STROKE);
            this.dYL.setStrokeCap(Paint.Cap.ROUND);
            this.dYL.setStrokeWidth(this.hjE);
            this.dYL.setAntiAlias(true);
        }
    }

    private void caO() {
        if (this.dYM == null) {
            this.dYM = new Paint();
            this.dYM.setColor(this.hjA);
            this.dYM.setStyle(Paint.Style.STROKE);
            this.dYM.setStrokeCap(Paint.Cap.ROUND);
            this.dYM.setStrokeWidth(this.hjD);
            this.dYM.setAntiAlias(true);
        }
    }

    private void g(Canvas canvas) {
        if (this.mDuration != -1) {
            if (this.mProgress / this.hjB < 3000.0f / this.mDuration) {
                caN();
                this.dYL.setColor(this.dYW);
            } else {
                this.dYL.setColor(this.mProgressColor);
            }
        } else {
            this.dYL.setColor(this.mProgressColor);
        }
        canvas.drawCircle(this.dZa, this.dZb, this.mRadius, this.dYM);
        canvas.drawArc(this.mRect, this.cMd, 360.0f * (-(this.mProgress / this.hjB)), false, this.dYL);
    }

    public MagicProgressCircle ay(float f) {
        this.mProgress = f;
        az(f);
        return this;
    }

    public MagicProgressCircle wl(int i) {
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
        caM();
        return this;
    }

    private void caM() {
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
        if (this.hjC) {
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
