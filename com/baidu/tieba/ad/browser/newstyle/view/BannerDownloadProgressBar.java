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
    private final Paint bjo;
    private int ebb;
    private int gjA;
    private final Paint gjB;
    private final RectF gjC;
    private final RectF gjD;
    private Shader gjE;
    private int gjz;
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
        this.ebb = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.gjB = new Paint();
        this.bjo = new Paint();
        this.gjC = new RectF();
        this.gjD = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.ebb = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.gjB = new Paint();
        this.bjo = new Paint();
        this.gjC = new RectF();
        this.gjD = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.gjz = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.gjA = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_textColor, parseColor);
        this.ebb = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_max, this.ebb);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.ad_progress_ad_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        sa();
    }

    private void sa() {
        this.bjo.setAntiAlias(true);
        this.bjo.setTextSize(this.mTextSize);
        this.bjo.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.gjB.setAntiAlias(true);
        this.gjB.setStyle(Paint.Style.STROKE);
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
        Paint.FontMetrics fontMetrics = this.bjo.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.bjo.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.bjo);
    }

    private void U(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.gjD.left = 0.0f;
        this.gjD.top = 0.0f;
        this.gjD.right = getMeasuredWidth();
        this.gjD.bottom = getMeasuredHeight();
        this.gjB.setStrokeWidth(this.strokeWidth);
        this.gjB.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.gjD, this.mRadius, this.mRadius, this.gjB);
    }

    private void D(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.ebb + 0.0f);
        this.gjC.left = this.strokeWidth;
        this.gjC.top = this.strokeWidth;
        this.gjC.bottom = getMeasuredHeight() - this.strokeWidth;
        this.gjC.right = f * getMeasuredWidth();
        if (this.gjC.right < this.mRadius * 2) {
            this.gjC.right = this.mRadius * 2;
        }
        this.gjE = new LinearGradient(0.0f, 0.0f, this.gjC.right, 0.0f, new int[]{this.gjz, this.gjA}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.gjE);
        canvas.drawRoundRect(this.gjC, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.gjz || i2 != this.gjA) {
            this.gjz = i;
            this.gjA = i2;
            sa();
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
            sa();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.ebb;
    }

    public void setMaxProgress(int i) {
        this.ebb = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.ebb && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.ebb) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
