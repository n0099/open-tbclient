package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
/* loaded from: classes4.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {

    /* renamed from: e  reason: collision with root package name */
    public int f14199e;

    /* renamed from: f  reason: collision with root package name */
    public int f14200f;

    /* renamed from: g  reason: collision with root package name */
    public float f14201g;

    /* renamed from: h  reason: collision with root package name */
    public int f14202h;
    public int i;
    public String j;
    public int k;
    public int l;
    public int m;
    public final Paint n;
    public final Paint o;
    public final Paint p;
    public final RectF q;
    public final RectF r;
    public Shader s;

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14199e = 0;
        this.f14200f = -1;
        this.f14201g = 10.0f;
        this.k = 100;
        this.l = 0;
        this.m = 0;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new RectF();
        this.r = new RectF();
        i(context, attributeSet);
    }

    public final void f(Canvas canvas) {
        this.l = getMeasuredHeight() / 2;
        RectF rectF = this.r;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getMeasuredWidth();
        this.r.bottom = getMeasuredHeight();
        this.o.setStrokeWidth(this.m);
        this.o.setColor(Color.parseColor("#E5E5E5"));
        RectF rectF2 = this.r;
        int i = this.l;
        canvas.drawRoundRect(rectF2, i, i, this.o);
    }

    public final void g(Canvas canvas) {
        this.l = getMeasuredHeight() / 2;
        float f2 = this.f14199e / (this.k + 0.0f);
        RectF rectF = this.q;
        int i = this.m;
        rectF.left = i;
        rectF.top = i;
        rectF.bottom = getMeasuredHeight() - this.m;
        this.q.right = getMeasuredWidth() * f2;
        RectF rectF2 = this.q;
        float f3 = rectF2.right;
        int i2 = this.l;
        if (f3 < i2 * 2) {
            rectF2.right = i2 * 2;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.q.right, 0.0f, new int[]{this.f14202h, this.i}, (float[]) null, Shader.TileMode.CLAMP);
        this.s = linearGradient;
        this.n.setShader(linearGradient);
        RectF rectF3 = this.q;
        int i3 = this.l;
        canvas.drawRoundRect(rectF3, i3, i3, this.n);
    }

    public int getMaxProgress() {
        return this.k;
    }

    public int getProgress() {
        return this.f14199e;
    }

    public final void h(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
        float f2 = fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.p.measureText(this.j)) / 2.0f;
        canvas.drawText(this.j, measuredWidth, (float) (((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f) + 0.5d), this.p);
    }

    public final void i(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.m = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.f14202h = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.i = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.f14200f = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_textColor, parseColor);
        this.k = obtainStyledAttributes.getInteger(R$styleable.ad_progress_ad_btn_max, this.k);
        this.f14199e = obtainStyledAttributes.getInteger(R$styleable.ad_progress_ad_btn_progress, 0);
        this.j = obtainStyledAttributes.getString(R$styleable.ad_progress_ad_btn_text);
        this.f14201g = obtainStyledAttributes.getDimension(R$styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        j();
    }

    public final void j() {
        this.p.setAntiAlias(true);
        this.p.setTextSize(this.f14201g);
        this.p.setColor(this.f14200f);
        this.n.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.o.setAntiAlias(true);
        this.o.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14199e > 0) {
            g(canvas);
        }
        f(canvas);
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        h(canvas);
    }

    public void setForeground(int i, int i2) {
        if (i == this.f14202h && i2 == this.i) {
            return;
        }
        this.f14202h = i;
        this.i = i2;
        j();
        postInvalidate();
    }

    public void setMaxProgress(int i) {
        this.k = i;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.k && i != this.f14199e) {
            this.f14199e = i;
            this.j = getResources().getString(R.string.ad_button_already_download) + this.f14199e + "%";
            if (this.f14199e == this.k) {
                this.j = "";
            }
            postInvalidate();
        }
    }

    public void setText(String str) {
        if (str == null || str.equals(this.j)) {
            return;
        }
        this.j = str;
        this.f14199e = 0;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        if (i == this.f14200f) {
            return;
        }
        this.f14200f = i;
        j();
        postInvalidate();
    }

    public void setTextSize(int i) {
        float f2 = i;
        if (f2 == this.f14201g) {
            return;
        }
        this.f14201g = f2;
        postInvalidate();
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14199e = 0;
        this.f14200f = -1;
        this.f14201g = 10.0f;
        this.k = 100;
        this.l = 0;
        this.m = 0;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new RectF();
        this.r = new RectF();
        i(context, attributeSet);
    }
}
