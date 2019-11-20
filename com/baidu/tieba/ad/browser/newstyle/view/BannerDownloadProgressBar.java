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
/* loaded from: classes3.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    private final Paint aiW;
    private float asP;
    private int dhk;
    private int dhl;
    private int dhm;
    private final Paint dhn;
    private final RectF dho;
    private final RectF dhp;
    private Shader dhq;
    private final Paint mForegroundPaint;
    private int mProgress;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private int strokeWidth;

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.asP = 10.0f;
        this.dhm = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.dhn = new Paint();
        this.aiW = new Paint();
        this.dho = new RectF();
        this.dhp = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.asP = 10.0f;
        this.dhm = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.dhn = new Paint();
        this.aiW = new Paint();
        this.dho = new RectF();
        this.dhp = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.dhk = Color.parseColor("#2BBCFF");
        this.dhl = Color.parseColor("#2B87FF");
        this.mTextColor = obtainStyledAttributes.getColor(1, parseColor);
        this.dhm = obtainStyledAttributes.getInteger(2, this.dhm);
        this.mProgress = obtainStyledAttributes.getInteger(3, 0);
        this.mText = obtainStyledAttributes.getString(5);
        this.asP = obtainStyledAttributes.getDimension(4, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        lj();
    }

    private void lj() {
        this.aiW.setAntiAlias(true);
        this.aiW.setTextSize(this.asP);
        this.aiW.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.dhn.setAntiAlias(true);
        this.dhn.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            I(canvas);
        }
        H(canvas);
        if (!TextUtils.isEmpty(this.mText)) {
            G(canvas);
        }
    }

    private void G(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.aiW.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.aiW.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.aiW);
    }

    private void H(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.dhp.left = 0.0f;
        this.dhp.top = 0.0f;
        this.dhp.right = getMeasuredWidth();
        this.dhp.bottom = getMeasuredHeight();
        this.dhn.setStrokeWidth(this.strokeWidth);
        this.dhn.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.dhp, this.mRadius, this.mRadius, this.dhn);
    }

    private void I(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.dhm + 0.0f);
        this.dho.left = this.strokeWidth;
        this.dho.top = this.strokeWidth;
        this.dho.bottom = getMeasuredHeight() - this.strokeWidth;
        this.dho.right = f * getMeasuredWidth();
        if (this.dho.right < this.mRadius * 2) {
            this.dho.right = this.mRadius * 2;
        }
        this.dhq = new LinearGradient(0.0f, 0.0f, this.dho.right, 0.0f, new int[]{this.dhk, this.dhl}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.dhq);
        canvas.drawRoundRect(this.dho, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.dhk || i2 != this.dhl) {
            this.dhk = i;
            this.dhl = i2;
            lj();
            postInvalidate();
        }
    }

    public void setTextSize(int i) {
        if (i != this.asP) {
            this.asP = i;
            postInvalidate();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        if (i != this.mTextColor) {
            this.mTextColor = i;
            lj();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.dhm;
    }

    public void setMaxProgress(int i) {
        this.dhm = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.dhm && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.dhm) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
