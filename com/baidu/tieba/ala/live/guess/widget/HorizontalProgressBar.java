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
/* loaded from: classes11.dex */
public class HorizontalProgressBar extends View {
    private static final String TAG = HorizontalProgressBar.class.getSimpleName();
    private int bgColor;
    private boolean epq;
    private int hiJ;
    private int hiK;
    private int hiL;
    private int hiM;
    private boolean hiN;
    private Paint hiO;
    private Paint hiP;
    private Paint hiQ;
    private Paint hiR;
    private Paint hiS;
    private Paint hiT;
    private Paint hiU;
    private Paint hiV;
    private int hiW;
    private int hiX;
    private int hiY;
    private String hiZ;
    private String hja;
    private String hjb;
    private boolean hjc;
    private float hjd;
    private float hje;
    private int hjf;
    private int hjg;
    private Paint hjh;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.hjd != max) {
            if (B(max, this.hje)) {
                bXS();
                return;
            }
            this.hjd = max;
            bXU();
        }
    }

    private void bXS() {
        this.epq = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.hje != max) {
            if (B(this.hjd, max)) {
                bXS();
                return;
            }
            this.hje = max;
            bXU();
        }
    }

    private boolean B(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.hjf = i;
        this.hjg = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.hiZ = "能";
        this.hja = "（正确答案）";
        this.hjb = "不能";
        this.hjc = true;
        this.epq = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hiZ = "能";
        this.hja = "（正确答案）";
        this.hjb = "不能";
        this.hjc = true;
        this.epq = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hiZ = "能";
        this.hja = "（正确答案）";
        this.hjb = "不能";
        this.hjc = true;
        this.epq = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        c(context, attributeSet);
        bXT();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_progress, 0);
        this.hjd = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_percent, 0);
        this.hje = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_pb_color, -49023);
        this.hiY = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_padding, 0);
        this.hiJ = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_height, 0);
        this.hiK = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.hiL = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.hiM = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.hiW = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.hiX = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.hiZ = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.hja = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.hjb = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_right);
        this.hjc = obtainStyledAttributes.getBoolean(a.j.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bXT() {
        this.hiQ = new Paint();
        this.hiQ.setColor(this.progressColor);
        this.hiQ.setStyle(Paint.Style.FILL);
        this.hiQ.setAntiAlias(true);
        this.hiO = new Paint();
        this.hiO.setColor(this.hiY);
        this.hiO.setStyle(Paint.Style.FILL);
        this.hiO.setAntiAlias(true);
        this.hiR = new Paint();
        this.hiR.setStyle(Paint.Style.FILL);
        this.hiR.setAntiAlias(true);
        this.hiP = new Paint();
        this.hiP.setStyle(Paint.Style.FILL);
        this.hiP.setAntiAlias(true);
        this.hiS = new Paint();
        this.hiS.setColor(this.bgColor);
        this.hiS.setStyle(Paint.Style.FILL);
        this.hiS.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(az(14.0f));
        this.hiT = new Paint();
        this.hiT.setColor(Color.parseColor("#1F1F1F"));
        this.hiT.setStyle(Paint.Style.FILL);
        this.hiT.setAntiAlias(true);
        this.hiT.setTextSize(az(16.0f));
        this.hiU = new Paint();
        this.hiU.setColor(Color.parseColor("#FF4D4D"));
        this.hiU.setStyle(Paint.Style.FILL);
        this.hiU.setAntiAlias(true);
        this.hiU.setTextSize(az(14.0f));
        this.hiV = new Paint();
        this.hiV.setColor(Color.parseColor("#2A87FF"));
        this.hiV.setStyle(Paint.Style.FILL);
        this.hiV.setAntiAlias(true);
        this.hiV.setTextSize(az(14.0f));
        this.hjh = new Paint();
        this.hjh.setColor(Color.parseColor("#FFFFFF"));
        this.hjh.setStyle(Paint.Style.FILL);
        this.hjh.setAntiAlias(true);
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
        int i = this.hiJ / 2;
        int width = getWidth();
        if (this.max != 0) {
            float f3 = this.hjd;
            f = this.hje;
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.hiJ;
        a(canvas, f2 * i2, i);
        a(canvas, width, f * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.hiZ;
        String str2 = this.hja;
        String str3 = this.hjb;
        Rect rect = new Rect();
        this.hiT.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.hiT);
        if (this.hjc) {
            canvas.drawText(str2, this.hiT.measureText(str), height, this.hiU);
        }
        canvas.drawText(str3, f, height, this.hiT);
        if (!this.hjc) {
            canvas.drawText(this.hja, f - this.hiV.measureText(str2), height, this.hiV);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.hiP.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.hiJ, new int[]{this.hiW, this.hiX}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.hiJ) {
            if (this.progress == 0) {
                if (this.hiN) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.hiP);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.hiP);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.hiP);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.hiJ + f4);
        path.lineTo(f2, this.hiJ + f4);
        path.close();
        canvas.drawPath(path, this.hiP);
        String str = this.hjg + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.hiR.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.hiJ, new int[]{this.hiL, this.hiM}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.hiJ) {
            if (this.progress == 0) {
                if (this.hiN) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.hiR);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.hiR);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.hiR);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.hiJ + f4);
        path.lineTo(f2, this.hiJ + f4);
        path.close();
        canvas.drawPath(path, this.hiR);
        canvas.drawText(this.hjf + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.epq) {
            float f = i2 * this.hjd;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.hjd), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.hiJ);
            path.lineTo(f5 - f2, this.padding + this.hiJ);
            path.close();
            canvas.drawPath(path, this.hjh);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.hiS);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.hiS);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.hiS);
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
        this.hjc = z;
        bXU();
        return this;
    }

    private void bXU() {
        if (isMainThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    private boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void bJ(int i, int i2) {
        this.epq = false;
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

    public float az(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public void setLeftFirstString(String str) {
        this.hiZ = str;
    }

    public void setRightFirstString(String str) {
        this.hjb = str;
    }
}
