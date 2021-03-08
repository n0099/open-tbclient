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
    private final Paint bjh;
    private int dZX;
    private int giP;
    private int giQ;
    private final Paint giR;
    private final RectF giS;
    private final RectF giT;
    private Shader giU;
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
        this.dZX = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.giR = new Paint();
        this.bjh = new Paint();
        this.giS = new RectF();
        this.giT = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.dZX = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.giR = new Paint();
        this.bjh = new Paint();
        this.giS = new RectF();
        this.giT = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.giP = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.giQ = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_textColor, parseColor);
        this.dZX = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_max, this.dZX);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.ad_progress_ad_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        rX();
    }

    private void rX() {
        this.bjh.setAntiAlias(true);
        this.bjh.setTextSize(this.mTextSize);
        this.bjh.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.giR.setAntiAlias(true);
        this.giR.setStyle(Paint.Style.STROKE);
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
        Paint.FontMetrics fontMetrics = this.bjh.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.bjh.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.bjh);
    }

    private void U(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.giT.left = 0.0f;
        this.giT.top = 0.0f;
        this.giT.right = getMeasuredWidth();
        this.giT.bottom = getMeasuredHeight();
        this.giR.setStrokeWidth(this.strokeWidth);
        this.giR.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.giT, this.mRadius, this.mRadius, this.giR);
    }

    private void D(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.dZX + 0.0f);
        this.giS.left = this.strokeWidth;
        this.giS.top = this.strokeWidth;
        this.giS.bottom = getMeasuredHeight() - this.strokeWidth;
        this.giS.right = f * getMeasuredWidth();
        if (this.giS.right < this.mRadius * 2) {
            this.giS.right = this.mRadius * 2;
        }
        this.giU = new LinearGradient(0.0f, 0.0f, this.giS.right, 0.0f, new int[]{this.giP, this.giQ}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.giU);
        canvas.drawRoundRect(this.giS, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.giP || i2 != this.giQ) {
            this.giP = i;
            this.giQ = i2;
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
        return this.dZX;
    }

    public void setMaxProgress(int i) {
        this.dZX = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.dZX && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.dZX) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
