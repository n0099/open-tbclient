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
    private boolean eqR;
    private int hkG;
    private int hkH;
    private int hkI;
    private int hkJ;
    private boolean hkK;
    private Paint hkL;
    private Paint hkM;
    private Paint hkN;
    private Paint hkO;
    private Paint hkP;
    private Paint hkQ;
    private Paint hkR;
    private Paint hkS;
    private int hkT;
    private int hkU;
    private int hkV;
    private String hkW;
    private String hkX;
    private String hkY;
    private boolean hkZ;
    private float hla;
    private float hlb;
    private int hlc;
    private int hld;
    private Paint hle;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.hla != max) {
            if (B(max, this.hlb)) {
                bYf();
                return;
            }
            this.hla = max;
            bYh();
        }
    }

    private void bYf() {
        this.eqR = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.hlb != max) {
            if (B(this.hla, max)) {
                bYf();
                return;
            }
            this.hlb = max;
            bYh();
        }
    }

    private boolean B(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.hlc = i;
        this.hld = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.hkW = "能";
        this.hkX = "（正确答案）";
        this.hkY = "不能";
        this.hkZ = true;
        this.eqR = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkW = "能";
        this.hkX = "（正确答案）";
        this.hkY = "不能";
        this.hkZ = true;
        this.eqR = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hkW = "能";
        this.hkX = "（正确答案）";
        this.hkY = "不能";
        this.hkZ = true;
        this.eqR = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        c(context, attributeSet);
        bYg();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_progress, 0);
        this.hla = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_percent, 0);
        this.hlb = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_pb_color, -49023);
        this.hkV = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_padding, 0);
        this.hkG = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_height, 0);
        this.hkH = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.hkI = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.hkJ = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.hkT = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.hkU = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.hkW = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.hkX = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.hkY = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_right);
        this.hkZ = obtainStyledAttributes.getBoolean(a.j.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bYg() {
        this.hkN = new Paint();
        this.hkN.setColor(this.progressColor);
        this.hkN.setStyle(Paint.Style.FILL);
        this.hkN.setAntiAlias(true);
        this.hkL = new Paint();
        this.hkL.setColor(this.hkV);
        this.hkL.setStyle(Paint.Style.FILL);
        this.hkL.setAntiAlias(true);
        this.hkO = new Paint();
        this.hkO.setStyle(Paint.Style.FILL);
        this.hkO.setAntiAlias(true);
        this.hkM = new Paint();
        this.hkM.setStyle(Paint.Style.FILL);
        this.hkM.setAntiAlias(true);
        this.hkP = new Paint();
        this.hkP.setColor(this.bgColor);
        this.hkP.setStyle(Paint.Style.FILL);
        this.hkP.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(aD(14.0f));
        this.hkQ = new Paint();
        this.hkQ.setColor(Color.parseColor("#1F1F1F"));
        this.hkQ.setStyle(Paint.Style.FILL);
        this.hkQ.setAntiAlias(true);
        this.hkQ.setTextSize(aD(16.0f));
        this.hkR = new Paint();
        this.hkR.setColor(Color.parseColor("#FF4D4D"));
        this.hkR.setStyle(Paint.Style.FILL);
        this.hkR.setAntiAlias(true);
        this.hkR.setTextSize(aD(14.0f));
        this.hkS = new Paint();
        this.hkS.setColor(Color.parseColor("#2A87FF"));
        this.hkS.setStyle(Paint.Style.FILL);
        this.hkS.setAntiAlias(true);
        this.hkS.setTextSize(aD(14.0f));
        this.hle = new Paint();
        this.hle.setColor(Color.parseColor("#FFFFFF"));
        this.hle.setStyle(Paint.Style.FILL);
        this.hle.setAntiAlias(true);
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
        int i = this.hkG / 2;
        int width = getWidth();
        if (this.max != 0) {
            float f3 = this.hla;
            f = this.hlb;
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.hkG;
        a(canvas, f2 * i2, i);
        a(canvas, width, f * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.hkW;
        String str2 = this.hkX;
        String str3 = this.hkY;
        Rect rect = new Rect();
        this.hkQ.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.hkQ);
        if (this.hkZ) {
            canvas.drawText(str2, this.hkQ.measureText(str), height, this.hkR);
        }
        canvas.drawText(str3, f, height, this.hkQ);
        if (!this.hkZ) {
            canvas.drawText(this.hkX, f - this.hkS.measureText(str2), height, this.hkS);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.hkM.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.hkG, new int[]{this.hkT, this.hkU}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.hkG) {
            if (this.progress == 0) {
                if (this.hkK) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.hkM);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.hkM);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.hkM);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.hkG + f4);
        path.lineTo(f2, this.hkG + f4);
        path.close();
        canvas.drawPath(path, this.hkM);
        String str = this.hld + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.hkO.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.hkG, new int[]{this.hkI, this.hkJ}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.hkG) {
            if (this.progress == 0) {
                if (this.hkK) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.hkO);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.hkO);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.hkO);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.hkG + f4);
        path.lineTo(f2, this.hkG + f4);
        path.close();
        canvas.drawPath(path, this.hkO);
        canvas.drawText(this.hlc + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.eqR) {
            float f = i2 * this.hla;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.hla), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.hkG);
            path.lineTo(f5 - f2, this.padding + this.hkG);
            path.close();
            canvas.drawPath(path, this.hle);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.hkP);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.hkP);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.hkP);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public HorizontalProgressBar nD(boolean z) {
        this.hkZ = z;
        bYh();
        return this;
    }

    private void bYh() {
        if (isMainThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    private boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void bK(int i, int i2) {
        this.eqR = false;
        setNumber(i, i2);
        int i3 = i <= 13 ? 13 : i;
        int i4 = i2 >= 100 ? 87 : i2;
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

    public float aD(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public void setLeftFirstString(String str) {
        this.hkW = str;
    }

    public void setRightFirstString(String str) {
        this.hkY = str;
    }
}
