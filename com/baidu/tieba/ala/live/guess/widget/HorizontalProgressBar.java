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
    private boolean dPl;
    private int gwQ;
    private int gwR;
    private int gwS;
    private int gwT;
    private boolean gwU;
    private Paint gwV;
    private Paint gwW;
    private Paint gwX;
    private Paint gwY;
    private Paint gwZ;
    private Paint gxa;
    private Paint gxb;
    private Paint gxc;
    private int gxd;
    private int gxe;
    private int gxf;
    private String gxg;
    private String gxh;
    private String gxi;
    private boolean gxj;
    private float gxk;
    private float gxl;
    private int gxm;
    private int gxn;
    private Paint gxo;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gxk != max) {
            if (z(max, this.gxl)) {
                bPF();
                return;
            }
            this.gxk = max;
            bPH();
        }
    }

    private void bPF() {
        this.dPl = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.gxl != max) {
            if (z(this.gxk, max)) {
                bPF();
                return;
            }
            this.gxl = max;
            bPH();
        }
    }

    private boolean z(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.gxm = i;
        this.gxn = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.gxg = "能";
        this.gxh = "（正确答案）";
        this.gxi = "不能";
        this.gxj = true;
        this.dPl = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxg = "能";
        this.gxh = "（正确答案）";
        this.gxi = "不能";
        this.gxj = true;
        this.dPl = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxg = "能";
        this.gxh = "（正确答案）";
        this.gxi = "不能";
        this.gxj = true;
        this.dPl = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        initAttrs(context, attributeSet);
        bPG();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.k.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.k.HorizontalProgressBar_zpb_progress, 0);
        this.gxk = obtainStyledAttributes.getInteger(a.k.HorizontalProgressBar_zpb_percent, 0);
        this.gxl = obtainStyledAttributes.getInteger(a.k.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_pb_color, -49023);
        this.gxf = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.k.HorizontalProgressBar_zpb_padding, 0);
        this.gwQ = obtainStyledAttributes.getDimensionPixelSize(a.k.HorizontalProgressBar_zpb_progress_height, 0);
        this.gwR = obtainStyledAttributes.getDimensionPixelSize(a.k.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.gwS = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.gwT = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.gxd = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.gxe = obtainStyledAttributes.getColor(a.k.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.gxg = obtainStyledAttributes.getString(a.k.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.gxh = obtainStyledAttributes.getString(a.k.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.gxi = obtainStyledAttributes.getString(a.k.HorizontalProgressBar_zpb_bottom_text_right);
        this.gxj = obtainStyledAttributes.getBoolean(a.k.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bPG() {
        this.gwX = new Paint();
        this.gwX.setColor(this.progressColor);
        this.gwX.setStyle(Paint.Style.FILL);
        this.gwX.setAntiAlias(true);
        this.gwV = new Paint();
        this.gwV.setColor(this.gxf);
        this.gwV.setStyle(Paint.Style.FILL);
        this.gwV.setAntiAlias(true);
        this.gwY = new Paint();
        this.gwY.setStyle(Paint.Style.FILL);
        this.gwY.setAntiAlias(true);
        this.gwW = new Paint();
        this.gwW.setStyle(Paint.Style.FILL);
        this.gwW.setAntiAlias(true);
        this.gwZ = new Paint();
        this.gwZ.setColor(this.bgColor);
        this.gwZ.setStyle(Paint.Style.FILL);
        this.gwZ.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(ao(14.0f));
        this.gxa = new Paint();
        this.gxa.setColor(Color.parseColor("#1F1F1F"));
        this.gxa.setStyle(Paint.Style.FILL);
        this.gxa.setAntiAlias(true);
        this.gxa.setTextSize(ao(16.0f));
        this.gxb = new Paint();
        this.gxb.setColor(Color.parseColor("#FF397A"));
        this.gxb.setStyle(Paint.Style.FILL);
        this.gxb.setAntiAlias(true);
        this.gxb.setTextSize(ao(14.0f));
        this.gxc = new Paint();
        this.gxc.setColor(Color.parseColor("#2A87FF"));
        this.gxc.setStyle(Paint.Style.FILL);
        this.gxc.setAntiAlias(true);
        this.gxc.setTextSize(ao(14.0f));
        this.gxo = new Paint();
        this.gxo.setColor(Color.parseColor("#FFFFFF"));
        this.gxo.setStyle(Paint.Style.FILL);
        this.gxo.setAntiAlias(true);
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
        int i = this.gwQ / 2;
        int width = getWidth();
        if (this.max != 0) {
            f = this.gxk;
            f2 = this.gxl;
        } else {
            f = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.gwQ;
        a(canvas, f * i2, i);
        a(canvas, width, f2 * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.gxg;
        String str2 = this.gxh;
        String str3 = this.gxi;
        Rect rect = new Rect();
        this.gxa.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.gxa);
        if (this.gxj) {
            canvas.drawText(str2, this.gxa.measureText(str), height, this.gxb);
        }
        canvas.drawText(str3, f, height, this.gxa);
        if (!this.gxj) {
            canvas.drawText(this.gxh, f - this.gxc.measureText(str2), height, this.gxc);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.gwW.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.gwQ, new int[]{this.gxd, this.gxe}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.gwQ) {
            if (this.progress == 0) {
                if (this.gwU) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.gwW);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.gwW);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.gwW);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.gwQ + f4);
        path.lineTo(f2, this.gwQ + f4);
        path.close();
        canvas.drawPath(path, this.gwW);
        String str = this.gxn + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.gwY.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.gwQ, new int[]{this.gwS, this.gwT}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.gwQ) {
            if (this.progress == 0) {
                if (this.gwU) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.gwY);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.gwY);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.gwY);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.gwQ + f4);
        path.lineTo(f2, this.gwQ + f4);
        path.close();
        canvas.drawPath(path, this.gwY);
        canvas.drawText(this.gxm + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.dPl) {
            float f = i2 * this.gxk;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.gxk), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.gwQ);
            path.lineTo(f5 - f2, this.padding + this.gwQ);
            path.close();
            canvas.drawPath(path, this.gxo);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.gwZ);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.gwZ);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.gwZ);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public HorizontalProgressBar ma(boolean z) {
        this.gxj = z;
        bPH();
        return this;
    }

    private void bPH() {
        if (isMainThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    private boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void bG(int i, int i2) {
        this.dPl = false;
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

    public float ao(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public void setLeftFirstString(String str) {
        this.gxg = str;
    }

    public void setRightFirstString(String str) {
        this.gxi = str;
    }
}
