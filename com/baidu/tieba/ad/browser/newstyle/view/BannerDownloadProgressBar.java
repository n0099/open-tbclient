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
/* loaded from: classes8.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    private int eOC;
    private int eOD;
    private int eOE;
    private final Paint eOF;
    private final RectF eOG;
    private final RectF eOH;
    private Shader eOI;
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
        this.eOE = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.eOF = new Paint();
        this.mTextPaint = new Paint();
        this.eOG = new RectF();
        this.eOH = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.mTextSize = 10.0f;
        this.eOE = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.eOF = new Paint();
        this.mTextPaint = new Paint();
        this.eOG = new RectF();
        this.eOH = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        int parseColor2 = Color.parseColor("#2BBCFF");
        int parseColor3 = Color.parseColor("#2B87FF");
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.eOC = obtainStyledAttributes.getColor(0, parseColor2);
        this.eOD = obtainStyledAttributes.getColor(1, parseColor3);
        this.mTextColor = obtainStyledAttributes.getColor(2, parseColor);
        this.eOE = obtainStyledAttributes.getInteger(3, this.eOE);
        this.mProgress = obtainStyledAttributes.getInteger(4, 0);
        this.mText = obtainStyledAttributes.getString(6);
        this.mTextSize = obtainStyledAttributes.getDimension(5, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(7, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        qy();
    }

    private void qy() {
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.eOF.setAntiAlias(true);
        this.eOF.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            u(canvas);
        }
        G(canvas);
        if (!TextUtils.isEmpty(this.mText)) {
            F(canvas);
        }
    }

    private void F(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.mTextPaint);
    }

    private void G(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.eOH.left = 0.0f;
        this.eOH.top = 0.0f;
        this.eOH.right = getMeasuredWidth();
        this.eOH.bottom = getMeasuredHeight();
        this.eOF.setStrokeWidth(this.strokeWidth);
        this.eOF.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.eOH, this.mRadius, this.mRadius, this.eOF);
    }

    private void u(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.eOE + 0.0f);
        this.eOG.left = this.strokeWidth;
        this.eOG.top = this.strokeWidth;
        this.eOG.bottom = getMeasuredHeight() - this.strokeWidth;
        this.eOG.right = f * getMeasuredWidth();
        if (this.eOG.right < this.mRadius * 2) {
            this.eOG.right = this.mRadius * 2;
        }
        this.eOI = new LinearGradient(0.0f, 0.0f, this.eOG.right, 0.0f, new int[]{this.eOC, this.eOD}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.eOI);
        canvas.drawRoundRect(this.eOG, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.eOC || i2 != this.eOD) {
            this.eOC = i;
            this.eOD = i2;
            qy();
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
            qy();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.eOE;
    }

    public void setMaxProgress(int i) {
        this.eOE = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.eOE && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.eOE) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
