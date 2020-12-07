package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    private int dSe;
    private int gaf;
    private int gag;
    private final Paint gah;
    private final RectF gai;
    private final RectF gaj;
    private Shader gak;
    private final Paint mForegroundPaint;
    private int mProgress;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private final Paint mTextPaint;
    private float mTextSize;
    private int strokeWidth;

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.dSe = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.gah = new Paint();
        this.mTextPaint = new Paint();
        this.gai = new RectF();
        this.gaj = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.dSe = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.gah = new Paint();
        this.mTextPaint = new Paint();
        this.gai = new RectF();
        this.gaj = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.gaf = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.gag = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_textColor, parseColor);
        this.dSe = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_max, this.dSe);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.ad_progress_ad_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        sz();
    }

    private void sz() {
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.gah.setAntiAlias(true);
        this.gah.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            w(canvas);
        }
        O(canvas);
        if (!TextUtils.isEmpty(this.mText)) {
            C(canvas);
        }
    }

    private void C(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.mTextPaint);
    }

    private void O(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.gaj.left = 0.0f;
        this.gaj.top = 0.0f;
        this.gaj.right = getMeasuredWidth();
        this.gaj.bottom = getMeasuredHeight();
        this.gah.setStrokeWidth(this.strokeWidth);
        this.gah.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.gaj, this.mRadius, this.mRadius, this.gah);
    }

    private void w(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.dSe + 0.0f);
        this.gai.left = this.strokeWidth;
        this.gai.top = this.strokeWidth;
        this.gai.bottom = getMeasuredHeight() - this.strokeWidth;
        this.gai.right = f * getMeasuredWidth();
        if (this.gai.right < this.mRadius * 2) {
            this.gai.right = this.mRadius * 2;
        }
        this.gak = new LinearGradient(0.0f, 0.0f, this.gai.right, 0.0f, new int[]{this.gaf, this.gag}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.gak);
        canvas.drawRoundRect(this.gai, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.gaf || i2 != this.gag) {
            this.gaf = i;
            this.gag = i2;
            sz();
            postInvalidate();
        }
    }

    public void setTextSize(int i) {
        if (i != this.mTextSize) {
            this.mTextSize = i;
            postInvalidate();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        if (i != this.mTextColor) {
            this.mTextColor = i;
            sz();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.dSe;
    }

    public void setMaxProgress(int i) {
        this.dSe = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.dSe && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.dSe) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
