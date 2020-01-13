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
/* loaded from: classes6.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    private int dVh;
    private int dVi;
    private int dVj;
    private final Paint dVk;
    private final RectF dVl;
    private final RectF dVm;
    private Shader dVn;
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
        this.dVj = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.dVk = new Paint();
        this.mTextPaint = new Paint();
        this.dVl = new RectF();
        this.dVm = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.dVj = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.dVk = new Paint();
        this.mTextPaint = new Paint();
        this.dVl = new RectF();
        this.dVm = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.dVh = obtainStyledAttributes.getColor(0, parseColor2);
        this.dVi = obtainStyledAttributes.getColor(1, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(2, parseColor);
        this.dVj = obtainStyledAttributes.getInteger(3, this.dVj);
        this.mProgress = obtainStyledAttributes.getInteger(4, 0);
        this.mText = obtainStyledAttributes.getString(6);
        this.mTextSize = obtainStyledAttributes.getDimension(5, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(7, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        lB();
    }

    private void lB() {
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.dVk.setAntiAlias(true);
        this.dVk.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            t(canvas);
        }
        E(canvas);
        if (!TextUtils.isEmpty(this.mText)) {
            D(canvas);
        }
    }

    private void D(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.mTextPaint);
    }

    private void E(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.dVm.left = 0.0f;
        this.dVm.top = 0.0f;
        this.dVm.right = getMeasuredWidth();
        this.dVm.bottom = getMeasuredHeight();
        this.dVk.setStrokeWidth(this.strokeWidth);
        this.dVk.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.dVm, this.mRadius, this.mRadius, this.dVk);
    }

    private void t(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.dVj + 0.0f);
        this.dVl.left = this.strokeWidth;
        this.dVl.top = this.strokeWidth;
        this.dVl.bottom = getMeasuredHeight() - this.strokeWidth;
        this.dVl.right = f * getMeasuredWidth();
        if (this.dVl.right < this.mRadius * 2) {
            this.dVl.right = this.mRadius * 2;
        }
        this.dVn = new LinearGradient(0.0f, 0.0f, this.dVl.right, 0.0f, new int[]{this.dVh, this.dVi}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.dVn);
        canvas.drawRoundRect(this.dVl, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.dVh || i2 != this.dVi) {
            this.dVh = i;
            this.dVi = i2;
            lB();
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
            lB();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.dVj;
    }

    public void setMaxProgress(int i) {
        this.dVj = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.dVj && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.dVj) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
