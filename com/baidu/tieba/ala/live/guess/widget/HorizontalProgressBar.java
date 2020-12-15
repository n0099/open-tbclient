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
    private boolean eiS;
    private int gXA;
    private int gXB;
    private String gXC;
    private String gXD;
    private String gXE;
    private boolean gXF;
    private float gXG;
    private float gXH;
    private int gXI;
    private int gXJ;
    private Paint gXK;
    private int gXm;
    private int gXn;
    private int gXo;
    private int gXp;
    private boolean gXq;
    private Paint gXr;
    private Paint gXs;
    private Paint gXt;
    private Paint gXu;
    private Paint gXv;
    private Paint gXw;
    private Paint gXx;
    private Paint gXy;
    private int gXz;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gXG != max) {
            if (A(max, this.gXH)) {
                bYe();
                return;
            }
            this.gXG = max;
            bYg();
        }
    }

    private void bYe() {
        this.eiS = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gXH != max) {
            if (A(this.gXG, max)) {
                bYe();
                return;
            }
            this.gXH = max;
            bYg();
        }
    }

    private boolean A(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.gXI = i;
        this.gXJ = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.gXC = "能";
        this.gXD = "（正确答案）";
        this.gXE = "不能";
        this.gXF = true;
        this.eiS = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXC = "能";
        this.gXD = "（正确答案）";
        this.gXE = "不能";
        this.gXF = true;
        this.eiS = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gXC = "能";
        this.gXD = "（正确答案）";
        this.gXE = "不能";
        this.gXF = true;
        this.eiS = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        initAttrs(context, attributeSet);
        bYf();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_progress, 0);
        this.gXG = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_percent, 0);
        this.gXH = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_pb_color, -49023);
        this.gXB = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_padding, 0);
        this.gXm = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_height, 0);
        this.gXn = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.gXo = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.gXp = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.gXz = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.gXA = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.gXC = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.gXD = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.gXE = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_right);
        this.gXF = obtainStyledAttributes.getBoolean(a.j.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bYf() {
        this.gXt = new Paint();
        this.gXt.setColor(this.progressColor);
        this.gXt.setStyle(Paint.Style.FILL);
        this.gXt.setAntiAlias(true);
        this.gXr = new Paint();
        this.gXr.setColor(this.gXB);
        this.gXr.setStyle(Paint.Style.FILL);
        this.gXr.setAntiAlias(true);
        this.gXu = new Paint();
        this.gXu.setStyle(Paint.Style.FILL);
        this.gXu.setAntiAlias(true);
        this.gXs = new Paint();
        this.gXs.setStyle(Paint.Style.FILL);
        this.gXs.setAntiAlias(true);
        this.gXv = new Paint();
        this.gXv.setColor(this.bgColor);
        this.gXv.setStyle(Paint.Style.FILL);
        this.gXv.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(av(14.0f));
        this.gXw = new Paint();
        this.gXw.setColor(Color.parseColor("#1F1F1F"));
        this.gXw.setStyle(Paint.Style.FILL);
        this.gXw.setAntiAlias(true);
        this.gXw.setTextSize(av(16.0f));
        this.gXx = new Paint();
        this.gXx.setColor(Color.parseColor("#FF397A"));
        this.gXx.setStyle(Paint.Style.FILL);
        this.gXx.setAntiAlias(true);
        this.gXx.setTextSize(av(14.0f));
        this.gXy = new Paint();
        this.gXy.setColor(Color.parseColor("#2A87FF"));
        this.gXy.setStyle(Paint.Style.FILL);
        this.gXy.setAntiAlias(true);
        this.gXy.setTextSize(av(14.0f));
        this.gXK = new Paint();
        this.gXK.setColor(Color.parseColor("#FFFFFF"));
        this.gXK.setStyle(Paint.Style.FILL);
        this.gXK.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        P(canvas);
    }

    private void P(Canvas canvas) {
        float f;
        float f2 = 0.0f;
        int i = this.gXm / 2;
        int width = getWidth();
        if (this.max != 0) {
            f = this.gXG;
            f2 = this.gXH;
        } else {
            f = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.gXm;
        a(canvas, f * i2, i);
        a(canvas, width, f2 * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.gXC;
        String str2 = this.gXD;
        String str3 = this.gXE;
        Rect rect = new Rect();
        this.gXw.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.gXw);
        if (this.gXF) {
            canvas.drawText(str2, this.gXw.measureText(str), height, this.gXx);
        }
        canvas.drawText(str3, f, height, this.gXw);
        if (!this.gXF) {
            canvas.drawText(this.gXD, f - this.gXy.measureText(str2), height, this.gXy);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.gXs.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.gXm, new int[]{this.gXz, this.gXA}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.gXm) {
            if (this.progress == 0) {
                if (this.gXq) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.gXs);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.gXs);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.gXs);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.gXm + f4);
        path.lineTo(f2, this.gXm + f4);
        path.close();
        canvas.drawPath(path, this.gXs);
        String str = this.gXJ + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.gXu.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.gXm, new int[]{this.gXo, this.gXp}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.gXm) {
            if (this.progress == 0) {
                if (this.gXq) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.gXu);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.gXu);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.gXu);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.gXm + f4);
        path.lineTo(f2, this.gXm + f4);
        path.close();
        canvas.drawPath(path, this.gXu);
        canvas.drawText(this.gXI + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.eiS) {
            float f = i2 * this.gXG;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.gXG), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.gXm);
            path.lineTo(f5 - f2, this.padding + this.gXm);
            path.close();
            canvas.drawPath(path, this.gXK);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.gXv);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.gXv);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.gXv);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public HorizontalProgressBar mW(boolean z) {
        this.gXF = z;
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

    public void bM(int i, int i2) {
        this.eiS = false;
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

    public float av(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public void setLeftFirstString(String str) {
        this.gXC = str;
    }

    public void setRightFirstString(String str) {
        this.gXE = str;
    }
}
