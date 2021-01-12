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
    private final Paint bex;
    private int dWp;
    private int geR;
    private int geS;
    private final Paint geT;
    private final RectF geU;
    private final RectF geV;
    private Shader geW;
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
        this.dWp = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.geT = new Paint();
        this.bex = new Paint();
        this.geU = new RectF();
        this.geV = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.dWp = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.geT = new Paint();
        this.bex = new Paint();
        this.geU = new RectF();
        this.geV = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.geR = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_start, parseColor2);
        this.geS = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_foreground_end, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.ad_progress_ad_btn_textColor, parseColor);
        this.dWp = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_max, this.dWp);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.ad_progress_ad_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.ad_progress_ad_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        sa();
    }

    private void sa() {
        this.bex.setAntiAlias(true);
        this.bex.setTextSize(this.mTextSize);
        this.bex.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.geT.setAntiAlias(true);
        this.geT.setStyle(Paint.Style.STROKE);
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
        Paint.FontMetrics fontMetrics = this.bex.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.bex.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.bex);
    }

    private void U(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.geV.left = 0.0f;
        this.geV.top = 0.0f;
        this.geV.right = getMeasuredWidth();
        this.geV.bottom = getMeasuredHeight();
        this.geT.setStrokeWidth(this.strokeWidth);
        this.geT.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.geV, this.mRadius, this.mRadius, this.geT);
    }

    private void D(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.dWp + 0.0f);
        this.geU.left = this.strokeWidth;
        this.geU.top = this.strokeWidth;
        this.geU.bottom = getMeasuredHeight() - this.strokeWidth;
        this.geU.right = f * getMeasuredWidth();
        if (this.geU.right < this.mRadius * 2) {
            this.geU.right = this.mRadius * 2;
        }
        this.geW = new LinearGradient(0.0f, 0.0f, this.geU.right, 0.0f, new int[]{this.geR, this.geS}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.geW);
        canvas.drawRoundRect(this.geU, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.geR || i2 != this.geS) {
            this.geR = i;
            this.geS = i2;
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
        return this.dWp;
    }

    public void setMaxProgress(int i) {
        this.dWp = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.dWp && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.dWp) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
