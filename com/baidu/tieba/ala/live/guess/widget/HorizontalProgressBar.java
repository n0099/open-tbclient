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
/* loaded from: classes10.dex */
public class HorizontalProgressBar extends View {
    private static final String TAG = HorizontalProgressBar.class.getSimpleName();
    private int bgColor;
    private boolean enh;
    private Paint heA;
    private Paint heB;
    private Paint heC;
    private Paint heD;
    private Paint heE;
    private Paint heF;
    private int heG;
    private int heH;
    private int heI;
    private String heJ;
    private String heK;
    private String heL;
    private boolean heM;
    private float heN;
    private float heO;
    private int heP;
    private int heQ;
    private Paint heR;
    private int het;
    private int heu;
    private int hev;
    private int hew;
    private boolean hex;
    private Paint hey;
    private Paint hez;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.heN != max) {
            if (B(max, this.heO)) {
                bWS();
                return;
            }
            this.heN = max;
            bWU();
        }
    }

    private void bWS() {
        this.enh = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.heO != max) {
            if (B(this.heN, max)) {
                bWS();
                return;
            }
            this.heO = max;
            bWU();
        }
    }

    private boolean B(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.heP = i;
        this.heQ = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.heJ = "能";
        this.heK = "（正确答案）";
        this.heL = "不能";
        this.heM = true;
        this.enh = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heJ = "能";
        this.heK = "（正确答案）";
        this.heL = "不能";
        this.heM = true;
        this.enh = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.heJ = "能";
        this.heK = "（正确答案）";
        this.heL = "不能";
        this.heM = true;
        this.enh = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        c(context, attributeSet);
        bWT();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_progress, 0);
        this.heN = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_percent, 0);
        this.heO = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_pb_color, -49023);
        this.heI = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_padding, 0);
        this.het = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_height, 0);
        this.heu = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.hev = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.hew = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.heG = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.heH = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.heJ = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.heK = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.heL = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_right);
        this.heM = obtainStyledAttributes.getBoolean(a.j.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bWT() {
        this.heA = new Paint();
        this.heA.setColor(this.progressColor);
        this.heA.setStyle(Paint.Style.FILL);
        this.heA.setAntiAlias(true);
        this.hey = new Paint();
        this.hey.setColor(this.heI);
        this.hey.setStyle(Paint.Style.FILL);
        this.hey.setAntiAlias(true);
        this.heB = new Paint();
        this.heB.setStyle(Paint.Style.FILL);
        this.heB.setAntiAlias(true);
        this.hez = new Paint();
        this.hez.setStyle(Paint.Style.FILL);
        this.hez.setAntiAlias(true);
        this.heC = new Paint();
        this.heC.setColor(this.bgColor);
        this.heC.setStyle(Paint.Style.FILL);
        this.heC.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(ax(14.0f));
        this.heD = new Paint();
        this.heD.setColor(Color.parseColor("#1F1F1F"));
        this.heD.setStyle(Paint.Style.FILL);
        this.heD.setAntiAlias(true);
        this.heD.setTextSize(ax(16.0f));
        this.heE = new Paint();
        this.heE.setColor(Color.parseColor("#FF397A"));
        this.heE.setStyle(Paint.Style.FILL);
        this.heE.setAntiAlias(true);
        this.heE.setTextSize(ax(14.0f));
        this.heF = new Paint();
        this.heF.setColor(Color.parseColor("#2A87FF"));
        this.heF.setStyle(Paint.Style.FILL);
        this.heF.setAntiAlias(true);
        this.heF.setTextSize(ax(14.0f));
        this.heR = new Paint();
        this.heR.setColor(Color.parseColor("#FFFFFF"));
        this.heR.setStyle(Paint.Style.FILL);
        this.heR.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        V(canvas);
    }

    private void V(Canvas canvas) {
        float f;
        float f2;
        int i = this.het / 2;
        int width = getWidth();
        if (this.max != 0) {
            float f3 = this.heN;
            f = this.heO;
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.het;
        a(canvas, f2 * i2, i);
        a(canvas, width, f * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.heJ;
        String str2 = this.heK;
        String str3 = this.heL;
        Rect rect = new Rect();
        this.heD.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.heD);
        if (this.heM) {
            canvas.drawText(str2, this.heD.measureText(str), height, this.heE);
        }
        canvas.drawText(str3, f, height, this.heD);
        if (!this.heM) {
            canvas.drawText(this.heK, f - this.heF.measureText(str2), height, this.heF);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.hez.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.het, new int[]{this.heG, this.heH}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.het) {
            if (this.progress == 0) {
                if (this.hex) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.hez);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.hez);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.hez);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.het + f4);
        path.lineTo(f2, this.het + f4);
        path.close();
        canvas.drawPath(path, this.hez);
        String str = this.heQ + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.heB.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.het, new int[]{this.hev, this.hew}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.het) {
            if (this.progress == 0) {
                if (this.hex) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.heB);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.heB);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.heB);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.het + f4);
        path.lineTo(f2, this.het + f4);
        path.close();
        canvas.drawPath(path, this.heB);
        canvas.drawText(this.heP + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.enh) {
            float f = i2 * this.heN;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.heN), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.het);
            path.lineTo(f5 - f2, this.padding + this.het);
            path.close();
            canvas.drawPath(path, this.heR);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.heC);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.heC);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.heC);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public HorizontalProgressBar ns(boolean z) {
        this.heM = z;
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

    public void bL(int i, int i2) {
        this.enh = false;
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

    public float ax(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public void setLeftFirstString(String str) {
        this.heJ = str;
    }

    public void setRightFirstString(String str) {
        this.heL = str;
    }
}
