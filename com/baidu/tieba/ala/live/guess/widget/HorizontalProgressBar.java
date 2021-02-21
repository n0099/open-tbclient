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
    private int hiX;
    private int hiY;
    private int hiZ;
    private int hja;
    private boolean hjb;
    private Paint hjc;
    private Paint hjd;
    private Paint hje;
    private Paint hjf;
    private Paint hjg;
    private Paint hjh;
    private Paint hji;
    private Paint hjj;
    private int hjk;
    private int hjl;
    private int hjm;
    private String hjn;
    private String hjo;
    private String hjp;
    private boolean hjq;
    private float hjr;
    private float hjs;
    private int hjt;
    private int hju;
    private Paint hjv;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.hjr != max) {
            if (B(max, this.hjs)) {
                bXZ();
                return;
            }
            this.hjr = max;
            bYb();
        }
    }

    private void bXZ() {
        this.epq = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.hjs != max) {
            if (B(this.hjr, max)) {
                bXZ();
                return;
            }
            this.hjs = max;
            bYb();
        }
    }

    private boolean B(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.hjt = i;
        this.hju = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.hjn = "能";
        this.hjo = "（正确答案）";
        this.hjp = "不能";
        this.hjq = true;
        this.epq = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjn = "能";
        this.hjo = "（正确答案）";
        this.hjp = "不能";
        this.hjq = true;
        this.epq = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjn = "能";
        this.hjo = "（正确答案）";
        this.hjp = "不能";
        this.hjq = true;
        this.epq = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        c(context, attributeSet);
        bYa();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_progress, 0);
        this.hjr = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_percent, 0);
        this.hjs = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_pb_color, -49023);
        this.hjm = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_padding, 0);
        this.hiX = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_height, 0);
        this.hiY = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.hiZ = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.hja = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.hjk = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.hjl = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.hjn = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.hjo = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.hjp = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_right);
        this.hjq = obtainStyledAttributes.getBoolean(a.j.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void bYa() {
        this.hje = new Paint();
        this.hje.setColor(this.progressColor);
        this.hje.setStyle(Paint.Style.FILL);
        this.hje.setAntiAlias(true);
        this.hjc = new Paint();
        this.hjc.setColor(this.hjm);
        this.hjc.setStyle(Paint.Style.FILL);
        this.hjc.setAntiAlias(true);
        this.hjf = new Paint();
        this.hjf.setStyle(Paint.Style.FILL);
        this.hjf.setAntiAlias(true);
        this.hjd = new Paint();
        this.hjd.setStyle(Paint.Style.FILL);
        this.hjd.setAntiAlias(true);
        this.hjg = new Paint();
        this.hjg.setColor(this.bgColor);
        this.hjg.setStyle(Paint.Style.FILL);
        this.hjg.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(az(14.0f));
        this.hjh = new Paint();
        this.hjh.setColor(Color.parseColor("#1F1F1F"));
        this.hjh.setStyle(Paint.Style.FILL);
        this.hjh.setAntiAlias(true);
        this.hjh.setTextSize(az(16.0f));
        this.hji = new Paint();
        this.hji.setColor(Color.parseColor("#FF4D4D"));
        this.hji.setStyle(Paint.Style.FILL);
        this.hji.setAntiAlias(true);
        this.hji.setTextSize(az(14.0f));
        this.hjj = new Paint();
        this.hjj.setColor(Color.parseColor("#2A87FF"));
        this.hjj.setStyle(Paint.Style.FILL);
        this.hjj.setAntiAlias(true);
        this.hjj.setTextSize(az(14.0f));
        this.hjv = new Paint();
        this.hjv.setColor(Color.parseColor("#FFFFFF"));
        this.hjv.setStyle(Paint.Style.FILL);
        this.hjv.setAntiAlias(true);
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
        int i = this.hiX / 2;
        int width = getWidth();
        if (this.max != 0) {
            float f3 = this.hjr;
            f = this.hjs;
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.hiX;
        a(canvas, f2 * i2, i);
        a(canvas, width, f * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.hjn;
        String str2 = this.hjo;
        String str3 = this.hjp;
        Rect rect = new Rect();
        this.hjh.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.hjh);
        if (this.hjq) {
            canvas.drawText(str2, this.hjh.measureText(str), height, this.hji);
        }
        canvas.drawText(str3, f, height, this.hjh);
        if (!this.hjq) {
            canvas.drawText(this.hjo, f - this.hjj.measureText(str2), height, this.hjj);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.hjd.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.hiX, new int[]{this.hjk, this.hjl}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.hiX) {
            if (this.progress == 0) {
                if (this.hjb) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.hjd);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.hjd);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.hjd);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.hiX + f4);
        path.lineTo(f2, this.hiX + f4);
        path.close();
        canvas.drawPath(path, this.hjd);
        String str = this.hju + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.hjf.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.hiX, new int[]{this.hiZ, this.hja}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.hiX) {
            if (this.progress == 0) {
                if (this.hjb) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.hjf);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.hjf);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.hjf);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.hiX + f4);
        path.lineTo(f2, this.hiX + f4);
        path.close();
        canvas.drawPath(path, this.hjf);
        canvas.drawText(this.hjt + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.epq) {
            float f = i2 * this.hjr;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.hjr), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.hiX);
            path.lineTo(f5 - f2, this.padding + this.hiX);
            path.close();
            canvas.drawPath(path, this.hjv);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.hjg);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.hjg);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.hjg);
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
        this.hjq = z;
        bYb();
        return this;
    }

    private void bYb() {
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
        this.hjn = str;
    }

    public void setRightFirstString(String str) {
        this.hjp = str;
    }
}
