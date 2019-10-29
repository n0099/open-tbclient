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
    private final Paint ajo;
    private float ath;
    private int dib;
    private int dic;
    private int did;
    private final Paint die;
    private final RectF dif;
    private final RectF dig;
    private Shader dih;
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
        this.ath = 10.0f;
        this.did = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.die = new Paint();
        this.ajo = new Paint();
        this.dif = new RectF();
        this.dig = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.ath = 10.0f;
        this.did = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.mForegroundPaint = new Paint();
        this.die = new Paint();
        this.ajo = new Paint();
        this.dif = new RectF();
        this.dig = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.dib = Color.parseColor("#2BBCFF");
        this.dic = Color.parseColor("#2B87FF");
        this.mTextColor = obtainStyledAttributes.getColor(1, parseColor);
        this.did = obtainStyledAttributes.getInteger(2, this.did);
        this.mProgress = obtainStyledAttributes.getInteger(3, 0);
        this.mText = obtainStyledAttributes.getString(5);
        this.ath = obtainStyledAttributes.getDimension(4, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        lj();
    }

    private void lj() {
        this.ajo.setAntiAlias(true);
        this.ajo.setTextSize(this.ath);
        this.ajo.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.die.setAntiAlias(true);
        this.die.setStyle(Paint.Style.STROKE);
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
        Paint.FontMetrics fontMetrics = this.ajo.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.ajo.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.ajo);
    }

    private void H(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.dig.left = 0.0f;
        this.dig.top = 0.0f;
        this.dig.right = getMeasuredWidth();
        this.dig.bottom = getMeasuredHeight();
        this.die.setStrokeWidth(this.strokeWidth);
        this.die.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.dig, this.mRadius, this.mRadius, this.die);
    }

    private void I(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.did + 0.0f);
        this.dif.left = this.strokeWidth;
        this.dif.top = this.strokeWidth;
        this.dif.bottom = getMeasuredHeight() - this.strokeWidth;
        this.dif.right = f * getMeasuredWidth();
        if (this.dif.right < this.mRadius * 2) {
            this.dif.right = this.mRadius * 2;
        }
        this.dih = new LinearGradient(0.0f, 0.0f, this.dif.right, 0.0f, new int[]{this.dib, this.dic}, (float[]) null, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.dih);
        canvas.drawRoundRect(this.dif, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.mText)) {
            this.mText = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.dib || i2 != this.dic) {
            this.dib = i;
            this.dic = i2;
            lj();
            postInvalidate();
        }
    }

    public void setTextSize(int i) {
        if (i != this.ath) {
            this.ath = i;
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
        return this.did;
    }

    public void setMaxProgress(int i) {
        this.did = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.did && i != this.mProgress) {
            this.mProgress = i;
            this.mText = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.did) {
                this.mText = "";
            }
            postInvalidate();
        }
    }
}
