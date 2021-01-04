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
    private boolean erW;
    private int hja;
    private int hjb;
    private int hjc;
    private int hjd;
    private boolean hje;
    private Paint hjf;
    private Paint hjg;
    private Paint hjh;
    private Paint hji;
    private Paint hjj;
    private Paint hjk;
    private Paint hjl;
    private Paint hjm;
    private int hjn;
    private int hjo;
    private int hjp;
    private String hjq;
    private String hjr;
    private String hjs;
    private boolean hjt;
    private float hju;
    private float hjv;
    private int hjw;
    private int hjx;
    private Paint hjy;
    private int max;
    private int padding;
    private int progress;
    private int progressColor;
    private Paint textPaint;

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.hju != max) {
            if (A(max, this.hjv)) {
                caJ();
                return;
            }
            this.hju = max;
            caL();
        }
    }

    private void caJ() {
        this.erW = true;
    }

    public void setSecondpercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.hjv != max) {
            if (A(this.hju, max)) {
                caJ();
                return;
            }
            this.hjv = max;
            caL();
        }
    }

    private boolean A(float f, float f2) {
        return f + f2 >= 1.0f;
    }

    public void setNumber(int i, int i2) {
        this.hjw = i;
        this.hjx = i2;
    }

    public HorizontalProgressBar(Context context) {
        super(context);
        this.hjq = "能";
        this.hjr = "（正确答案）";
        this.hjs = "不能";
        this.hjt = true;
        this.erW = false;
        init(context, null);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjq = "能";
        this.hjr = "（正确答案）";
        this.hjs = "不能";
        this.hjt = true;
        this.erW = false;
        init(context, attributeSet);
    }

    public HorizontalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjq = "能";
        this.hjr = "（正确答案）";
        this.hjs = "不能";
        this.hjt = true;
        this.erW = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        c(context, attributeSet);
        caK();
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.HorizontalProgressBar);
        this.max = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_max, 100);
        this.progress = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_progress, 0);
        this.hju = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_percent, 0);
        this.hjv = obtainStyledAttributes.getInteger(a.j.HorizontalProgressBar_zpb_secondpercent, 0);
        this.bgColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_bg_color, -12627531);
        this.progressColor = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_pb_color, -49023);
        this.hjp = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_pb_color, -49023);
        this.padding = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_padding, 0);
        this.hja = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_height, 0);
        this.hjb = obtainStyledAttributes.getDimensionPixelSize(a.j.HorizontalProgressBar_zpb_progress_marging_bottom, 0);
        this.hjc = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_from, -49023);
        this.hjd = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_gradient_to, -49023);
        this.hjn = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_from, -49023);
        this.hjo = obtainStyledAttributes.getColor(a.j.HorizontalProgressBar_zpb_second_gradient_to, -49023);
        this.hjq = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_first);
        this.hjr = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_left_second);
        this.hjs = obtainStyledAttributes.getString(a.j.HorizontalProgressBar_zpb_bottom_text_right);
        this.hjt = obtainStyledAttributes.getBoolean(a.j.HorizontalProgressBar_zpb_left_answer, true);
        obtainStyledAttributes.recycle();
    }

    private void caK() {
        this.hjh = new Paint();
        this.hjh.setColor(this.progressColor);
        this.hjh.setStyle(Paint.Style.FILL);
        this.hjh.setAntiAlias(true);
        this.hjf = new Paint();
        this.hjf.setColor(this.hjp);
        this.hjf.setStyle(Paint.Style.FILL);
        this.hjf.setAntiAlias(true);
        this.hji = new Paint();
        this.hji.setStyle(Paint.Style.FILL);
        this.hji.setAntiAlias(true);
        this.hjg = new Paint();
        this.hjg.setStyle(Paint.Style.FILL);
        this.hjg.setAntiAlias(true);
        this.hjj = new Paint();
        this.hjj.setColor(this.bgColor);
        this.hjj.setStyle(Paint.Style.FILL);
        this.hjj.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(Color.parseColor("#FFFFFF"));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(ax(14.0f));
        this.hjk = new Paint();
        this.hjk.setColor(Color.parseColor("#1F1F1F"));
        this.hjk.setStyle(Paint.Style.FILL);
        this.hjk.setAntiAlias(true);
        this.hjk.setTextSize(ax(16.0f));
        this.hjl = new Paint();
        this.hjl.setColor(Color.parseColor("#FF397A"));
        this.hjl.setStyle(Paint.Style.FILL);
        this.hjl.setAntiAlias(true);
        this.hjl.setTextSize(ax(14.0f));
        this.hjm = new Paint();
        this.hjm.setColor(Color.parseColor("#2A87FF"));
        this.hjm.setStyle(Paint.Style.FILL);
        this.hjm.setAntiAlias(true);
        this.hjm.setTextSize(ax(14.0f));
        this.hjy = new Paint();
        this.hjy.setColor(Color.parseColor("#FFFFFF"));
        this.hjy.setStyle(Paint.Style.FILL);
        this.hjy.setAntiAlias(true);
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
        int i = this.hja / 2;
        int width = getWidth();
        if (this.max != 0) {
            float f3 = this.hju;
            f = this.hjv;
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        int i2 = (width - (this.padding * 2)) - this.hja;
        a(canvas, f2 * i2, i);
        a(canvas, width, f * i2, i);
        a(canvas, width);
        a(canvas, width, i2, i);
    }

    private void a(Canvas canvas, int i) {
        String str = this.hjq;
        String str2 = this.hjr;
        String str3 = this.hjs;
        Rect rect = new Rect();
        this.hjk.getTextBounds(str3, 0, str3.length(), rect);
        int width = rect.width();
        float f = (i - width) - 1;
        float height = (getHeight() - this.padding) - (rect.height() / 10);
        canvas.drawText(str, 0.0f, height, this.hjk);
        if (this.hjt) {
            canvas.drawText(str2, this.hjk.measureText(str), height, this.hjl);
        }
        canvas.drawText(str3, f, height, this.hjk);
        if (!this.hjt) {
            canvas.drawText(this.hjr, f - this.hjm.measureText(str2), height, this.hjm);
        }
    }

    private void a(Canvas canvas, int i, float f, int i2) {
        this.hjg.setShader(new LinearGradient(((this.padding + i) - i2) - f, this.padding, (this.padding + i) - i2, this.padding + this.hja, new int[]{this.hjn, this.hjo}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        int i3 = i - (this.padding + i2);
        if (f < this.hja) {
            if (this.progress == 0) {
                if (this.hje) {
                    canvas.drawCircle(i3, this.padding + i2, i2, this.hjg);
                    return;
                }
                return;
            }
            canvas.drawCircle(i3, this.padding + i2, i2, this.hjg);
            return;
        }
        canvas.drawCircle(i3, this.padding + i2, i2, this.hjg);
        Path path = new Path();
        float f2 = i3;
        float f3 = f2 - f;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, f4);
        path.lineTo(f3 - i2, this.hja + f4);
        path.lineTo(f2, this.hja + f4);
        path.close();
        canvas.drawPath(path, this.hjg);
        String str = this.hjx + "%";
        canvas.drawText(str, ((i - this.padding) - i2) - this.textPaint.measureText(str), i2 + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, float f, int i) {
        this.hji.setShader(new LinearGradient(this.padding + i, this.padding, this.padding + i + f, this.padding + this.hja, new int[]{this.hjc, this.hjd}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR));
        if (f < this.hja) {
            if (this.progress == 0) {
                if (this.hje) {
                    canvas.drawCircle(this.padding + i, this.padding + i, i, this.hji);
                    return;
                }
                return;
            }
            canvas.drawCircle(this.padding + i, this.padding + i, i, this.hji);
            return;
        }
        canvas.drawCircle(this.padding + i, this.padding + i, i, this.hji);
        Path path = new Path();
        float f2 = this.padding + i;
        float f3 = f2 + f + i;
        float f4 = this.padding;
        path.moveTo(f2, f4);
        path.lineTo(f3, this.padding);
        path.lineTo(f3 - i, this.hja + f4);
        path.lineTo(f2, this.hja + f4);
        path.close();
        canvas.drawPath(path, this.hji);
        canvas.drawText(this.hjw + "%", i, i + (Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.erW) {
            float f = i2 * this.hju;
            a(canvas, f, i3);
            a(canvas, i, i2 * (1.0f - this.hju), i3);
            float f2 = i * 0.01f;
            Path path = new Path();
            float f3 = f + this.padding + i3;
            float f4 = f3 + f2;
            float f5 = f4 - i3;
            path.moveTo(f3, this.padding);
            path.lineTo(f4, this.padding);
            path.lineTo(f5, this.padding + this.hja);
            path.lineTo(f5 - f2, this.padding + this.hja);
            path.close();
            canvas.drawPath(path, this.hjy);
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
        canvas.drawCircle(height / 2, height / 2, height / 2, this.hjj);
        canvas.drawCircle(width - (height / 2), height / 2, height / 2, this.hjj);
        canvas.drawRect(new RectF(height / 2, 0.0f, width - (height / 2), height), this.hjj);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public HorizontalProgressBar nw(boolean z) {
        this.hjt = z;
        caL();
        return this;
    }

    private void caL() {
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
        this.erW = false;
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
        this.hjq = str;
    }

    public void setRightFirstString(String str) {
        this.hjs = str;
    }
}
