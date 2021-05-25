package com.baidu.tieba.funad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FunAdButton extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f15951e;

    /* renamed from: f  reason: collision with root package name */
    public int f15952f;

    /* renamed from: g  reason: collision with root package name */
    public int f15953g;

    /* renamed from: h  reason: collision with root package name */
    public int f15954h;

    /* renamed from: i  reason: collision with root package name */
    public final int f15955i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Paint n;
    public TextPaint o;
    public float p;
    public int q;
    public String r;
    public int s;
    public int t;
    public RectF u;
    public Shader v;
    public int w;
    public Runnable x;
    public boolean y;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f15956e;

        public a(String str) {
            this.f15956e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FunAdButton.this.y) {
                return;
            }
            FunAdButton.this.setText(this.f15956e);
        }
    }

    public FunAdButton(Context context) {
        this(context, null, 0);
    }

    public final void b(Canvas canvas) {
        if (this.u == null) {
            this.u = new RectF();
        }
        RectF rectF = this.u;
        int i2 = this.w;
        rectF.left = i2;
        rectF.top = i2;
        rectF.right = getMeasuredWidth() - this.w;
        this.u.bottom = getMeasuredHeight() - this.w;
        float f2 = this.k / (this.s + 0.0f);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.q, 0}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
        this.v = linearGradient;
        this.n.setShader(linearGradient);
        RectF rectF2 = this.u;
        int i3 = this.t;
        canvas.drawRoundRect(rectF2, i3, i3, this.n);
    }

    public final void c() {
        this.w = getResources().getDimensionPixelSize(R.dimen.tbds1);
        this.q = getResources().getColor(R.color.CAM_X0302);
        this.l = getResources().getColor(R.color.CAM_X0101);
        this.m = getResources().getColor(R.color.CAM_X0302);
        this.s = 100;
        this.k = 0;
        this.r = getResources().getString(R.string.ad_interaction_type_download);
        this.p = getResources().getDimension(R.dimen.T_X08);
        this.t = getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.u = new RectF();
        d();
    }

    public final void d() {
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.n.setColor(this.q);
        e();
    }

    public final void e() {
        if (this.o == null) {
            TextPaint textPaint = new TextPaint();
            this.o = textPaint;
            textPaint.setAntiAlias(true);
            this.o.setTextSize(this.p);
        }
        int i2 = this.k > 0 ? this.l : this.m;
        if (i2 != this.o.getColor()) {
            this.o.setColor(i2);
        }
    }

    public final int f(int i2) {
        View.MeasureSpec.getMode(i2);
        return View.MeasureSpec.getSize(i2);
    }

    public final int g(int i2) {
        return View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE ? Math.max((this.f15955i * 2) + ((int) this.o.measureText(this.r)), this.j) : View.MeasureSpec.getSize(i2);
    }

    public int getMax() {
        return this.s;
    }

    public int getProgress() {
        return this.k;
    }

    public void h() {
        SkinManager.setBackgroundResource(this, this.f15954h);
        this.l = SkinManager.getColor(this.f15951e);
        this.m = SkinManager.getColor(this.f15952f);
        this.q = SkinManager.getColor(this.f15953g);
    }

    public void i() {
        Runnable runnable = this.x;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.x = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k > 0) {
            b(canvas);
        }
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        e();
        Paint.FontMetrics fontMetrics = this.o.getFontMetrics();
        float f2 = fontMetrics.descent;
        canvas.drawText(this.r, (getMeasuredWidth() - this.o.measureText(this.r)) / 2.0f, ((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f), this.o);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(g(i2), f(i3));
    }

    public void setBackgroundSkin(int i2) {
        this.f15954h = i2;
    }

    public void setButtonTextColor(int i2) {
        this.m = i2;
        this.l = i2;
        postInvalidate();
    }

    public void setButtonTextSize(int i2) {
        this.p = l.e(getContext(), i2);
        postInvalidate();
    }

    public void setForeground(int i2) {
        this.q = i2;
        postInvalidate();
    }

    public void setMax(int i2) {
        this.s = i2;
    }

    public void setProgress(int i2) {
        this.y = true;
        if (i2 > this.s) {
            return;
        }
        this.k = i2;
        this.r = this.k + "%";
        postInvalidate();
    }

    public void setText(String str) {
        this.y = true;
        this.r = str;
        this.k = 0;
        postInvalidate();
    }

    public void setTextColorInitSkin(int i2) {
        this.f15952f = i2;
    }

    public void setTextDelay(String str, long j) {
        this.y = false;
        Runnable runnable = this.x;
        if (runnable == null) {
            this.x = new a(str);
        } else {
            removeCallbacks(runnable);
        }
        postDelayed(this.x, j);
    }

    public FunAdButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunAdButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15951e = R.color.CAM_X0101;
        this.f15952f = R.color.CAM_X0304;
        this.f15953g = R.color.CAM_X0302;
        this.f15954h = R.drawable.ad_download_progress_button_bg;
        this.f15955i = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.j = getResources().getDimensionPixelSize(R.dimen.tbds198);
        this.k = 0;
        this.l = SkinManager.getColor(this.f15951e);
        this.m = SkinManager.getColor(this.f15952f);
        this.p = 10.0f;
        this.q = SkinManager.getColor(this.f15953g);
        this.s = 100;
        this.t = 0;
        this.w = 0;
        this.y = false;
        c();
    }

    public void setText(int i2) {
        this.y = true;
        this.r = getContext().getString(i2);
        this.k = 0;
        postInvalidate();
    }

    public void setText(String str, int i2) {
        this.y = true;
        this.r = str;
        this.k = i2;
        postInvalidate();
    }
}
