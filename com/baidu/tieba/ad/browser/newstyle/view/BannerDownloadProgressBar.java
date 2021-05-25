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
    public int f13491e;

    /* renamed from: f  reason: collision with root package name */
    public int f13492f;

    /* renamed from: g  reason: collision with root package name */
    public float f13493g;

    /* renamed from: h  reason: collision with root package name */
    public int f13494h;

    /* renamed from: i  reason: collision with root package name */
    public int f13495i;
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
        this.f13491e = 0;
        this.f13492f = -1;
        this.f13493g = 10.0f;
        this.k = 100;
        this.l = 0;
        this.m = 0;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new RectF();
        this.r = new RectF();
        g(context, attributeSet);
    }

    public final void d(Canvas canvas) {
        this.l = getMeasuredHeight() / 2;
        RectF rectF = this.r;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getMeasuredWidth();
        this.r.bottom = getMeasuredHeight();
        this.o.setStrokeWidth(this.m);
        this.o.setColor(Color.parseColor("#E5E5E5"));
        RectF rectF2 = this.r;
        int i2 = this.l;
        canvas.drawRoundRect(rectF2, i2, i2, this.o);
    }

    public final void e(Canvas canvas) {
        this.l = getMeasuredHeight() / 2;
        float f2 = this.f13491e / (this.k + 0.0f);
        RectF rectF = this.q;
        int i2 = this.m;
        rectF.left = i2;
        rectF.top = i2;
        rectF.bottom = getMeasuredHeight() - this.m;
        this.q.right = getMeasuredWidth() * f2;
        RectF rectF2 = this.q;
        float f3 = rectF2.right;
        int i3 = this.l;
        if (f3 < i3 * 2) {
            rectF2.right = i3 * 2;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.q.right, 0.0f, new int[]{this.f13494h, this.f13495i}, (float[]) null, Shader.TileMode.CLAMP);
        this.s = linearGradient;
        this.n.setShader(linearGradient);
        RectF rectF3 = this.q;
        int i4 = this.l;
        canvas.drawRoundRect(rectF3, i4, i4, this.n);
    }

    public final void f(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
        float f2 = fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.p.measureText(this.j)) / 2.0f;
        canvas.drawText(this.j, measuredWidth, (float) (((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f) + 0.5d), this.p);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.m = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.f13494h = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.f13495i = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.f13492f = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_textColor, parseColor);
        this.k = obtainStyledAttributes.getInteger(R$styleable.ad_progress_ad_btn_max, this.k);
        this.f13491e = obtainStyledAttributes.getInteger(R$styleable.ad_progress_ad_btn_progress, 0);
        this.j = obtainStyledAttributes.getString(R$styleable.ad_progress_ad_btn_text);
        this.f13493g = obtainStyledAttributes.getDimension(R$styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        h();
    }

    public int getMaxProgress() {
        return this.k;
    }

    public int getProgress() {
        return this.f13491e;
    }

    public final void h() {
        this.p.setAntiAlias(true);
        this.p.setTextSize(this.f13493g);
        this.p.setColor(this.f13492f);
        this.n.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.o.setAntiAlias(true);
        this.o.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f13491e > 0) {
            e(canvas);
        }
        d(canvas);
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        f(canvas);
    }

    public void setForeground(int i2, int i3) {
        if (i2 == this.f13494h && i3 == this.f13495i) {
            return;
        }
        this.f13494h = i2;
        this.f13495i = i3;
        h();
        postInvalidate();
    }

    public void setMaxProgress(int i2) {
        this.k = i2;
    }

    public void setProgress(int i2) {
        if (i2 >= 0 && i2 <= this.k && i2 != this.f13491e) {
            this.f13491e = i2;
            this.j = getResources().getString(R.string.ad_button_already_download) + this.f13491e + "%";
            if (this.f13491e == this.k) {
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
        this.f13491e = 0;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        if (i2 == this.f13492f) {
            return;
        }
        this.f13492f = i2;
        h();
        postInvalidate();
    }

    public void setTextSize(int i2) {
        float f2 = i2;
        if (f2 == this.f13493g) {
            return;
        }
        this.f13493g = f2;
        postInvalidate();
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13491e = 0;
        this.f13492f = -1;
        this.f13493g = 10.0f;
        this.k = 100;
        this.l = 0;
        this.m = 0;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new RectF();
        this.r = new RectF();
        g(context, attributeSet);
    }
}
