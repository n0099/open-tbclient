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
    private boolean ebR;
    private int gNX;
    private int gNY;
    private int gNZ;
    private int gOa;
    private boolean gOb;
    private Paint gOc;
    private Paint gOd;
    private Paint gOe;
    private Paint gOf;
    private Paint gOg;
    private Paint gOh;
    private Paint gOi;
    private Paint gOj;
    private int gOk;
    private int gOl;
    private int gOm;
    private String gOn;
    private String gOo;
    private String gOp;
    private boolean gOq;
    private float gOr;
    private float gOs;
    private int gOt;
    private int gOu;
    private Paint gOv;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gOr != max) {
            if (A(max, this.gOs)) {
                bUu();
                return;
            }
            this.gOr = max;
            bUw();
        }
    }

    private void bUu() {
        this.ebR = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gOs != max) {
            if (A(this.gOr, max)) {
                bUu();
                return;
            }
            this.gOs = max;
            bUw();
        }
    }

    private boolean A(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.gOt = i;
        this.gOu = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.gOn = "能";
        this.gOo = "（正确答案）";
        this.gOp = "不能";
        this.gOq = true;
        this.ebR = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gOn = "能";
        this.gOo = "（正确答案）";
        this.gOp = "不能";
        this.gOq = true;
        this.ebR = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gOn = "能";
        this.gOo = "（正确答案）";
        this.gOp = "不能";
        this.gOq = true;
        this.ebR = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        initAttrs(context, attributeSet);
        bUv();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_progress, 0);
        this.gOr = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_percent, 0);
        this.gOs = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_pb_color, -49023);
        this.gOm = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_padding, 0);
        this.gNX = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_height, 0);
        this.gNY = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.gNZ = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.gOa = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.gOk = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.gOl = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.gOn = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.gOo = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.gOp = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_right);
        this.gOq = obtainStyledAttributes.getBoolean(a.j.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bUv() {
        this.gOe = new Paint();
        this.gOe.setColor(this.progressColor);
        this.gOe.setStyle(Paint.Style.FILL);
        this.gOe.setAntiAlias(true);
        this.gOc = new Paint();
        this.gOc.setColor(this.gOm);
        this.gOc.setStyle(Paint.Style.FILL);
        this.gOc.setAntiAlias(true);
        this.gOf = new Paint();
        this.gOf.setStyle(Paint.Style.FILL);
        this.gOf.setAntiAlias(true);
        this.gOd = new Paint();
        this.gOd.setStyle(Paint.Style.FILL);
        this.gOd.setAntiAlias(true);
        this.gOg = new Paint();
        this.gOg.setColor(this.bgColor);
        this.gOg.setStyle(Paint.Style.FILL);
        this.gOg.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(au(14.0f));
        this.gOh = new Paint();
        this.gOh.setColor(Color.parseColor("#1F1F1F"));
        this.gOh.setStyle(Paint.Style.FILL);
        this.gOh.setAntiAlias(true);
        this.gOh.setTextSize(au(16.0f));
        this.gOi = new Paint();
        this.gOi.setColor(Color.parseColor("#FF397A"));
        this.gOi.setStyle(Paint.Style.FILL);
        this.gOi.setAntiAlias(true);
        this.gOi.setTextSize(au(14.0f));
        this.gOj = new Paint();
        this.gOj.setColor(Color.parseColor("#2A87FF"));
        this.gOj.setStyle(Paint.Style.FILL);
        this.gOj.setAntiAlias(true);
        this.gOj.setTextSize(au(14.0f));
        this.gOv = new Paint();
        this.gOv.setColor(Color.parseColor("#FFFFFF"));
        this.gOv.setStyle(Paint.Style.FILL);
        this.gOv.setAntiAlias(true);
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
        int i = this.gNX / 2;
        int width = getWidth();
        if (this.max != 0) {
            f = this.gOr;
            f2 = this.gOs;
        } else {
            f = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.gNX;
        a(canvas, f * i2, i);
        a(canvas, width, f2 * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.gOn;
        String str2 = this.gOo;
        String str3 = this.gOp;
        Rect rect = new Rect();
        this.gOh.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.gOh);
        if (this.gOq) {
            canvas.drawText(str2, this.gOh.measureText(str), height, this.gOi);
        }
        canvas.drawText(str3, f, height, this.gOh);
        if (!this.gOq) {
            canvas.drawText(this.gOo, f - this.gOj.measureText(str2), height, this.gOj);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.gOd.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.gNX, new int[]{this.gOk, this.gOl}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.gNX) {
            if (this.progress == 0) {
                if (this.gOb) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.gOd);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.gOd);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.gOd);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.gNX + f4);
        path.lineTo(f2, this.gNX + f4);
        path.close();
        canvas.drawPath(path, this.gOd);
        String str = this.gOu + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.gOf.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.gNX, new int[]{this.gNZ, this.gOa}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.gNX) {
            if (this.progress == 0) {
                if (this.gOb) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.gOf);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.gOf);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.gOf);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.gNX + f4);
        path.lineTo(f2, this.gNX + f4);
        path.close();
        canvas.drawPath(path, this.gOf);
        canvas.drawText(this.gOt + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.ebR) {
            float f = i2 * this.gOr;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.gOr), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.gNX);
            path.lineTo(f5 - f2, this.padding + this.gNX);
            path.close();
            canvas.drawPath(path, this.gOv);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.gOg);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.gOg);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.gOg);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public HorizontalProgressBar mB(boolean z) {
        this.gOq = z;
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

    public void bI(int i, int i2) {
        this.ebR = false;
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

    public float au(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public void setLeftFirstString(String str) {
        this.gOn = str;
    }

    public void setRightFirstString(String str) {
        this.gOp = str;
    }
}
