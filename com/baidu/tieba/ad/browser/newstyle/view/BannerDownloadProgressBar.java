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
/* loaded from: classes.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    private final Paint bhF;
    private int dYw;
    private int ghf;
    private int ghg;
    private final Paint ghh;
    private final RectF ghi;
    private final RectF ghj;
    private Shader ghk;
    private final Paint mForegroundPaint;
    private int mProgress;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private float mTextSize;
    private int strokeWidth;

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.dYw = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.ghh = new Paint();
        this.bhF = new Paint();
        this.ghi = new RectF();
        this.ghj = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.dYw = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.ghh = new Paint();
        this.bhF = new Paint();
        this.ghi = new RectF();
        this.ghj = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.ghf = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.ghg = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_textColor, parseColor);
        this.dYw = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_max, this.dYw);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.ad_progress_ad_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        rX();
    }

    private void rX() {
        this.bhF.setAntiAlias(true);
        this.bhF.setTextSize(this.mTextSize);
        this.bhF.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.ghh.setAntiAlias(true);
        this.ghh.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            D(canvas);
        }
        U(canvas);
        if (!TextUtils.isEmpty(this.mText)) {
            J(canvas);
        }
    }

    private void J(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.bhF.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.bhF.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.bhF);
    }

    private void U(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.ghj.left = 0.0f;
        this.ghj.top = 0.0f;
        this.ghj.right = getMeasuredWidth();
        this.ghj.bottom = getMeasuredHeight();
        this.ghh.setStrokeWidth(this.strokeWidth);
        this.ghh.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.ghj, this.mRadius, this.mRadius, this.ghh);
    }

    private void D(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.dYw + 0.0f);
        this.ghi.left = this.strokeWidth;
        this.ghi.top = this.strokeWidth;
        this.ghi.bottom = getMeasuredHeight() - this.strokeWidth;
        this.ghi.right = f * getMeasuredWidth();
        if (this.ghi.right < this.mRadius * 2) {
            this.ghi.right = this.mRadius * 2;
        }
        this.ghk = new LinearGradient(0.0f, 0.0f, this.ghi.right, 0.0f, new int[]{this.ghf, this.ghg}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.ghk);
        canvas.drawRoundRect(this.ghi, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.ghf || i2 != this.ghg) {
            this.ghf = i;
            this.ghg = i2;
            rX();
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
            rX();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.dYw;
    }

    public void setMaxProgress(int i) {
        this.dYw = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.dYw && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.dYw) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
