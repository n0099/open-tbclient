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
    private boolean dXI;
    private int gIE;
    private int gIF;
    private int gIG;
    private int gIH;
    private boolean gII;
    private Paint gIJ;
    private Paint gIK;
    private Paint gIL;
    private Paint gIM;
    private Paint gIN;
    private Paint gIO;
    private Paint gIP;
    private Paint gIQ;
    private int gIR;
    private int gIS;
    private int gIT;
    private String gIU;
    private String gIV;
    private String gIW;
    private boolean gIX;
    private float gIY;
    private float gIZ;
    private int gJa;
    private int gJb;
    private Paint gJc;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gIY != max) {
            if (A(max, this.gIZ)) {
                bSC();
                return;
            }
            this.gIY = max;
            bSE();
        }
    }

    private void bSC() {
        this.dXI = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gIZ != max) {
            if (A(this.gIY, max)) {
                bSC();
                return;
            }
            this.gIZ = max;
            bSE();
        }
    }

    private boolean A(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.gJa = i;
        this.gJb = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.gIU = "能";
        this.gIV = "（正确答案）";
        this.gIW = "不能";
        this.gIX = true;
        this.dXI = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIU = "能";
        this.gIV = "（正确答案）";
        this.gIW = "不能";
        this.gIX = true;
        this.dXI = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIU = "能";
        this.gIV = "（正确答案）";
        this.gIW = "不能";
        this.gIX = true;
        this.dXI = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        initAttrs(context, attributeSet);
        bSD();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.k.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.k.HorizontalProgressBar_zpb_progress, 0);
        this.gIY = obtainStyledAttributes.getInteger(a.k.HorizontalProgressBar_zpb_percent, 0);
        this.gIZ = obtainStyledAttributes.getInteger(a.k.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_pb_color, -49023);
        this.gIT = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.k.HorizontalProgressBar_zpb_padding, 0);
        this.gIE = obtainStyledAttributes.getDimensionPixelSize(a.k.HorizontalProgressBar_zpb_progress_height, 0);
        this.gIF = obtainStyledAttributes.getDimensionPixelSize(a.k.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.gIG = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.gIH = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.gIR = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.gIS = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.gIU = obtainStyledAttributes.getString(a.k.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.gIV = obtainStyledAttributes.getString(a.k.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.gIW = obtainStyledAttributes.getString(a.k.HorizontalProgressBar_zpb_bottom_text_right);
        this.gIX = obtainStyledAttributes.getBoolean(a.k.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bSD() {
        this.gIL = new Paint();
        this.gIL.setColor(this.progressColor);
        this.gIL.setStyle(Paint.Style.FILL);
        this.gIL.setAntiAlias(true);
        this.gIJ = new Paint();
        this.gIJ.setColor(this.gIT);
        this.gIJ.setStyle(Paint.Style.FILL);
        this.gIJ.setAntiAlias(true);
        this.gIM = new Paint();
        this.gIM.setStyle(Paint.Style.FILL);
        this.gIM.setAntiAlias(true);
        this.gIK = new Paint();
        this.gIK.setStyle(Paint.Style.FILL);
        this.gIK.setAntiAlias(true);
        this.gIN = new Paint();
        this.gIN.setColor(this.bgColor);
        this.gIN.setStyle(Paint.Style.FILL);
        this.gIN.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(aq(14.0f));
        this.gIO = new Paint();
        this.gIO.setColor(Color.parseColor("#1F1F1F"));
        this.gIO.setStyle(Paint.Style.FILL);
        this.gIO.setAntiAlias(true);
        this.gIO.setTextSize(aq(16.0f));
        this.gIP = new Paint();
        this.gIP.setColor(Color.parseColor("#FF397A"));
        this.gIP.setStyle(Paint.Style.FILL);
        this.gIP.setAntiAlias(true);
        this.gIP.setTextSize(aq(14.0f));
        this.gIQ = new Paint();
        this.gIQ.setColor(Color.parseColor("#2A87FF"));
        this.gIQ.setStyle(Paint.Style.FILL);
        this.gIQ.setAntiAlias(true);
        this.gIQ.setTextSize(aq(14.0f));
        this.gJc = new Paint();
        this.gJc.setColor(Color.parseColor("#FFFFFF"));
        this.gJc.setStyle(Paint.Style.FILL);
        this.gJc.setAntiAlias(true);
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
        int i = this.gIE / 2;
        int width = getWidth();
        if (this.max != 0) {
            f = this.gIY;
            f2 = this.gIZ;
        } else {
            f = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.gIE;
        a(canvas, f * i2, i);
        a(canvas, width, f2 * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.gIU;
        String str2 = this.gIV;
        String str3 = this.gIW;
        Rect rect = new Rect();
        this.gIO.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.gIO);
        if (this.gIX) {
            canvas.drawText(str2, this.gIO.measureText(str), height, this.gIP);
        }
        canvas.drawText(str3, f, height, this.gIO);
        if (!this.gIX) {
            canvas.drawText(this.gIV, f - this.gIQ.measureText(str2), height, this.gIQ);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.gIK.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.gIE, new int[]{this.gIR, this.gIS}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.gIE) {
            if (this.progress == 0) {
                if (this.gII) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.gIK);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.gIK);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.gIK);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.gIE + f4);
        path.lineTo(f2, this.gIE + f4);
        path.close();
        canvas.drawPath(path, this.gIK);
        String str = this.gJb + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.gIM.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.gIE, new int[]{this.gIG, this.gIH}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.gIE) {
            if (this.progress == 0) {
                if (this.gII) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.gIM);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.gIM);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.gIM);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.gIE + f4);
        path.lineTo(f2, this.gIE + f4);
        path.close();
        canvas.drawPath(path, this.gIM);
        canvas.drawText(this.gJa + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.dXI) {
            float f = i2 * this.gIY;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.gIY), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.gIE);
            path.lineTo(f5 - f2, this.padding + this.gIE);
            path.close();
            canvas.drawPath(path, this.gJc);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.gIN);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.gIN);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.gIN);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public HorizontalProgressBar mr(boolean z) {
        this.gIX = z;
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

    public void bI(int i, int i2) {
        this.dXI = false;
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

    public float aq(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public void setLeftFirstString(String str) {
        this.gIU = str;
    }

    public void setRightFirstString(String str) {
        this.gIW = str;
    }
}
