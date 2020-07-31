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
/* loaded from: classes15.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    private int fdp;
    private int fdq;
    private int fdr;
    private final Paint fds;
    private final RectF fdt;
    private final RectF fdu;
    private Shader fdv;
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
        this.fdr = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.fds = new Paint();
        this.mTextPaint = new Paint();
        this.fdt = new RectF();
        this.fdu = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.fdr = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.fds = new Paint();
        this.mTextPaint = new Paint();
        this.fdt = new RectF();
        this.fdu = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.fdp = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.fdq = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_textColor, parseColor);
        this.fdr = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_max, this.fdr);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.ad_progress_ad_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        qS();
    }

    private void qS() {
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.fds.setAntiAlias(true);
        this.fds.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            u(canvas);
        }
        H(canvas);
        if (!TextUtils.isEmpty(this.mText)) {
            G(canvas);
        }
    }

    private void G(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.mTextPaint);
    }

    private void H(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.fdu.left = 0.0f;
        this.fdu.top = 0.0f;
        this.fdu.right = getMeasuredWidth();
        this.fdu.bottom = getMeasuredHeight();
        this.fds.setStrokeWidth(this.strokeWidth);
        this.fds.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.fdu, this.mRadius, this.mRadius, this.fds);
    }

    private void u(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.fdr + 0.0f);
        this.fdt.left = this.strokeWidth;
        this.fdt.top = this.strokeWidth;
        this.fdt.bottom = getMeasuredHeight() - this.strokeWidth;
        this.fdt.right = f * getMeasuredWidth();
        if (this.fdt.right < this.mRadius * 2) {
            this.fdt.right = this.mRadius * 2;
        }
        this.fdv = new LinearGradient(0.0f, 0.0f, this.fdt.right, 0.0f, new int[]{this.fdp, this.fdq}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.fdv);
        canvas.drawRoundRect(this.fdt, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.fdp || i2 != this.fdq) {
            this.fdp = i;
            this.fdq = i2;
            qS();
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
            qS();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.fdr;
    }

    public void setMaxProgress(int i) {
        this.fdr = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.fdr && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.fdr) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
