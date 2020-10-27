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
    private int dGX;
    private int fMA;
    private final Paint fMB;
    private final RectF fMC;
    private final RectF fMD;
    private Shader fME;
    private int fMz;
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
        this.dGX = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.fMB = new Paint();
        this.mTextPaint = new Paint();
        this.fMC = new RectF();
        this.fMD = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.dGX = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.fMB = new Paint();
        this.mTextPaint = new Paint();
        this.fMC = new RectF();
        this.fMD = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.fMz = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.fMA = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_textColor, parseColor);
        this.dGX = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_max, this.dGX);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.ad_progress_ad_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        sw();
    }

    private void sw() {
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.fMB.setAntiAlias(true);
        this.fMB.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            w(canvas);
        }
        L(canvas);
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

    private void L(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.fMD.left = 0.0f;
        this.fMD.top = 0.0f;
        this.fMD.right = getMeasuredWidth();
        this.fMD.bottom = getMeasuredHeight();
        this.fMB.setStrokeWidth(this.strokeWidth);
        this.fMB.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.fMD, this.mRadius, this.mRadius, this.fMB);
    }

    private void w(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.dGX + 0.0f);
        this.fMC.left = this.strokeWidth;
        this.fMC.top = this.strokeWidth;
        this.fMC.bottom = getMeasuredHeight() - this.strokeWidth;
        this.fMC.right = f * getMeasuredWidth();
        if (this.fMC.right < this.mRadius * 2) {
            this.fMC.right = this.mRadius * 2;
        }
        this.fME = new LinearGradient(0.0f, 0.0f, this.fMC.right, 0.0f, new int[]{this.fMz, this.fMA}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.fME);
        canvas.drawRoundRect(this.fMC, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.fMz || i2 != this.fMA) {
            this.fMz = i;
            this.fMA = i2;
            sw();
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
            sw();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.dGX;
    }

    public void setMaxProgress(int i) {
        this.dGX = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.dGX && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.dGX) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
