package com.baidu.tieba.ala.live.guess.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class HorizontalProgressBar extends View {
    private static final String TAG = HorizontalProgressBar.class.getSimpleName();
    private int bgColor;
    private boolean edz;
    private Paint gOA;
    private Paint gOB;
    private Paint gOC;
    private int gOD;
    private int gOE;
    private int gOF;
    private String gOG;
    private String gOH;
    private String gOI;
    private boolean gOJ;
    private float gOK;
    private float gOL;
    private int gOM;
    private int gON;
    private Paint gOO;
    private int gOq;
    private int gOr;
    private int gOs;
    private int gOt;
    private boolean gOu;
    private Paint gOv;
    private Paint gOw;
    private Paint gOx;
    private Paint gOy;
    private Paint gOz;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gOK != max) {
            if (A(max, this.gOL)) {
                bVb();
                return;
            }
            this.gOK = max;
            bVd();
        }
    }

    private void bVb() {
        this.edz = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gOL != max) {
            if (A(this.gOK, max)) {
                bVb();
                return;
            }
            this.gOL = max;
            bVd();
        }
    }

    private boolean A(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.gOM = i;
        this.gON = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.gOG = "能";
        this.gOH = "（正确答案）";
        this.gOI = "不能";
        this.gOJ = true;
        this.edz = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gOG = "能";
        this.gOH = "（正确答案）";
        this.gOI = "不能";
        this.gOJ = true;
        this.edz = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gOG = "能";
        this.gOH = "（正确答案）";
        this.gOI = "不能";
        this.gOJ = true;
        this.edz = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        initAttrs(context, attributeSet);
        bVc();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_progress, 0);
        this.gOK = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_percent, 0);
        this.gOL = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_pb_color, -49023);
        this.gOF = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_padding, 0);
        this.gOq = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_height, 0);
        this.gOr = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.gOs = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.gOt = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.gOD = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.gOE = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.gOG = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.gOH = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.gOI = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_right);
        this.gOJ = obtainStyledAttributes.getBoolean(a.j.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bVc() {
        this.gOx = new Paint();
        this.gOx.setColor(this.progressColor);
        this.gOx.setStyle(Paint.Style.FILL);
        this.gOx.setAntiAlias(true);
        this.gOv = new Paint();
        this.gOv.setColor(this.gOF);
        this.gOv.setStyle(Paint.Style.FILL);
        this.gOv.setAntiAlias(true);
        this.gOy = new Paint();
        this.gOy.setStyle(Paint.Style.FILL);
        this.gOy.setAntiAlias(true);
        this.gOw = new Paint();
        this.gOw.setStyle(Paint.Style.FILL);
        this.gOw.setAntiAlias(true);
        this.gOz = new Paint();
        this.gOz.setColor(this.bgColor);
        this.gOz.setStyle(Paint.Style.FILL);
        this.gOz.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(as(14.0f));
        this.gOA = new Paint();
        this.gOA.setColor(Color.parseColor("#1F1F1F"));
        this.gOA.setStyle(Paint.Style.FILL);
        this.gOA.setAntiAlias(true);
        this.gOA.setTextSize(as(16.0f));
        this.gOB = new Paint();
        this.gOB.setColor(Color.parseColor("#FF397A"));
        this.gOB.setStyle(Paint.Style.FILL);
        this.gOB.setAntiAlias(true);
        this.gOB.setTextSize(as(14.0f));
        this.gOC = new Paint();
        this.gOC.setColor(Color.parseColor("#2A87FF"));
        this.gOC.setStyle(Paint.Style.FILL);
        this.gOC.setAntiAlias(true);
        this.gOC.setTextSize(as(14.0f));
        this.gOO = new Paint();
        this.gOO.setColor(Color.parseColor("#FFFFFF"));
        this.gOO.setStyle(Paint.Style.FILL);
        this.gOO.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        M(canvas);
    }

    private void M(Canvas canvas) {
        float f;
        float f2 = 0.0f;
        int i = this.gOq / 2;
        int width = getWidth();
        if (this.max != 0) {
            f = this.gOK;
            f2 = this.gOL;
        } else {
            f = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.gOq;
        a(canvas, f * i2, i);
        a(canvas, width, f2 * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.gOG;
        String str2 = this.gOH;
        String str3 = this.gOI;
        Rect rect = new Rect();
        this.gOA.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.gOA);
        if (this.gOJ) {
            canvas.drawText(str2, this.gOA.measureText(str), height, this.gOB);
        }
        canvas.drawText(str3, f, height, this.gOA);
        if (!this.gOJ) {
            canvas.drawText(this.gOH, f - this.gOC.measureText(str2), height, this.gOC);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.gOw.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.gOq, new int[]{this.gOD, this.gOE}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.gOq) {
            if (this.progress == 0) {
                if (this.gOu) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.gOw);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.gOw);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.gOw);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.gOq + f4);
        path.lineTo(f2, this.gOq + f4);
        path.close();
        canvas.drawPath(path, this.gOw);
        String str = this.gON + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.gOy.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.gOq, new int[]{this.gOs, this.gOt}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.gOq) {
            if (this.progress == 0) {
                if (this.gOu) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.gOy);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.gOy);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.gOy);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.gOq + f4);
        path.lineTo(f2, this.gOq + f4);
        path.close();
        canvas.drawPath(path, this.gOy);
        canvas.drawText(this.gOM + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.edz) {
            float f = i2 * this.gOK;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.gOK), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.gOq);
            path.lineTo(f5 - f2, this.padding + this.gOq);
            path.close();
            canvas.drawPath(path, this.gOO);
        }
    }

    private void drawBackground(Canvas canvas) {
        int height = getHeight();
        if (height % 2 != 0) {
            height--;
        }
        int width = getWidth();
        if (width % 2 != 0) {
            width--;
        }
        canvas.drawCircle(height / 2, height / 2, height / 2, this.gOz);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.gOz);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.gOz);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public HorizontalProgressBar mA(boolean z) {
        this.gOJ = z;
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

    public void bI(int i, int i2) {
        this.edz = false;
        setNumber(i, i2);
        int i3 = i <= 12 ? 12 : i;
        int i4 = i2 >= 100 ? 88 : i2;
        if (i3 >= 100) {
            i3 = 90;
        }
        if (i4 <= 10) {
            i4 = 10;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "percent", 0.0f, i3 / 100.0f), ObjectAnimator.ofFloat(this, "secondpercent", 0.0f, i4 / 100.0f));
        animatorSet.setDuration(500L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.live.guess.widget.HorizontalProgressBar.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();
    }

    public float as(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public void setLeftFirstString(String str) {
        this.gOG = str;
    }

    public void setRightFirstString(String str) {
        this.gOI = str;
    }
}
