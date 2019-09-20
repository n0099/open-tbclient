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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    private final Paint GG;
    private String anb;
    private final Paint bYv;
    private float cMv;
    private int cYH;
    private int cYI;
    private int cYJ;
    private final Paint cYK;
    private final RectF cYL;
    private final RectF cYM;
    private Shader cYN;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cMv = 10.0f;
        this.cYJ = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.GG = new Paint();
        this.cYK = new Paint();
        this.bYv = new Paint();
        this.cYL = new RectF();
        this.cYM = new RectF();
        init(context, attributeSet);
    }

    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cMv = 10.0f;
        this.cYJ = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.GG = new Paint();
        this.cYK = new Paint();
        this.bYv = new Paint();
        this.cYL = new RectF();
        this.cYM = new RectF();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.ad_progress);
        int parseColor = Color.parseColor("#666666");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
        this.cYH = Color.parseColor("#2BBCFF");
        this.cYI = Color.parseColor("#2B87FF");
        this.mTextColor = obtainStyledAttributes.getColor(1, parseColor);
        this.cYJ = obtainStyledAttributes.getInteger(2, this.cYJ);
        this.mProgress = obtainStyledAttributes.getInteger(3, 0);
        this.anb = obtainStyledAttributes.getString(5);
        this.cMv = obtainStyledAttributes.getDimension(4, (int) getResources().getDimension(R.dimen.progress_button_font_size));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        qq();
    }

    private void qq() {
        this.bYv.setAntiAlias(true);
        this.bYv.setTextSize(this.cMv);
        this.bYv.setColor(this.mTextColor);
        this.GG.setAntiAlias(true);
        this.GG.setStyle(Paint.Style.FILL);
        this.cYK.setAntiAlias(true);
        this.cYK.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            E(canvas);
        }
        D(canvas);
        if (!TextUtils.isEmpty(this.anb)) {
            C(canvas);
        }
    }

    private void C(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.bYv.getFontMetrics();
        float height = (getHeight() / 2) - fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.bYv.measureText(this.anb)) / 2.0f;
        canvas.drawText(this.anb, measuredWidth, (float) (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + height + 0.5d), this.bYv);
    }

    private void D(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.cYM.left = 0.0f;
        this.cYM.top = 0.0f;
        this.cYM.right = getMeasuredWidth();
        this.cYM.bottom = getMeasuredHeight();
        this.cYK.setStrokeWidth(this.strokeWidth);
        this.cYK.setColor(Color.parseColor("#E5E5E5"));
        canvas.drawRoundRect(this.cYM, this.mRadius, this.mRadius, this.cYK);
    }

    private void E(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        float f = this.mProgress / (this.cYJ + 0.0f);
        this.cYL.left = this.strokeWidth;
        this.cYL.top = this.strokeWidth;
        this.cYL.bottom = getMeasuredHeight() - this.strokeWidth;
        this.cYL.right = f * getMeasuredWidth();
        if (this.cYL.right < this.mRadius * 2) {
            this.cYL.right = this.mRadius * 2;
        }
        this.cYN = new LinearGradient(0.0f, 0.0f, this.cYL.right, 0.0f, new int[]{this.cYH, this.cYI}, (float[]) null, Shader.TileMode.CLAMP);
        this.GG.setShader(this.cYN);
        canvas.drawRoundRect(this.cYL, this.mRadius, this.mRadius, this.GG);
    }

    public void setText(String str) {
        if (str != null && !str.equals(this.anb)) {
            this.anb = str;
            this.mProgress = 0;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        if (i != this.cYH || i2 != this.cYI) {
            this.cYH = i;
            this.cYI = i2;
            qq();
            postInvalidate();
        }
    }

    public void setTextSize(int i) {
        if (i != this.cMv) {
            this.cMv = i;
            postInvalidate();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        if (i != this.mTextColor) {
            this.mTextColor = i;
            qq();
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.cYJ;
    }

    public void setMaxProgress(int i) {
        this.cYJ = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (i >= 0 && i <= this.cYJ && i != this.mProgress) {
            this.mProgress = i;
            this.anb = getResources().getString(R.string.ad_button_already_download) + this.mProgress + "%";
            if (this.mProgress == this.cYJ) {
                this.anb = "";
            }
            postInvalidate();
        }
    }
}
