package com.baidu.tieba.funad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class FunAdButton extends View {
    private int dXJ;
    private int jVh;
    private int jVi;
    private int jVj;
    private int jVk;
    private final int jVl;
    private int jVm;
    private int jVn;
    private RectF jVo;
    private Shader jVp;
    private Runnable jVq;
    private boolean jVr;
    private int mForegroundColor;
    private Paint mForegroundPaint;
    private int mProgress;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private TextPaint mTextPaint;
    private float mTextSize;
    private int strokeWidth;

    public FunAdButton(Context context) {
        this(context, null, 0);
    }

    public FunAdButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunAdButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jVh = R.color.CAM_X0901;
        this.jVi = R.color.CAM_X0304;
        this.jVj = R.color.CAM_X0302;
        this.jVk = R.drawable.ad_download_progress_button_bg;
        this.jVl = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.jVm = getResources().getDimensionPixelSize(R.dimen.tbds198);
        this.mProgress = 0;
        this.mTextColor = ap.getColor(this.jVh);
        this.jVn = ap.getColor(this.jVi);
        this.mTextSize = 10.0f;
        this.mForegroundColor = ap.getColor(this.jVj);
        this.dXJ = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        this.jVr = false;
        init();
    }

    private void init() {
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.tbds1);
        this.mForegroundColor = getResources().getColor(R.color.CAM_X0302);
        this.mTextColor = getResources().getColor(R.color.CAM_X0901);
        this.jVn = getResources().getColor(R.color.CAM_X0302);
        this.dXJ = 100;
        this.mProgress = 0;
        this.mText = getResources().getString(R.string.ad_interaction_type_download);
        this.mTextSize = getResources().getDimension(R.dimen.T_X08);
        this.mRadius = getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.jVo = new RectF();
        rX();
    }

    private void rX() {
        this.mForegroundPaint = new Paint();
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.mForegroundPaint.setColor(this.mForegroundColor);
        IE();
    }

    private void IE() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextSize(this.mTextSize);
        }
        int i = this.mProgress > 0 ? this.mTextColor : this.jVn;
        if (i != this.mTextPaint.getColor()) {
            this.mTextPaint.setColor(i);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return Math.max((this.jVl * 2) + ((int) this.mTextPaint.measureText(this.mText)), this.jVm);
        }
        return size;
    }

    private int measureHeight(int i) {
        View.MeasureSpec.getMode(i);
        return View.MeasureSpec.getSize(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            D(canvas);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            IE();
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.mText, (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.mTextPaint);
        }
    }

    private void D(Canvas canvas) {
        if (this.jVo == null) {
            this.jVo = new RectF();
        }
        this.jVo.left = this.strokeWidth;
        this.jVo.top = this.strokeWidth;
        this.jVo.right = getMeasuredWidth() - this.strokeWidth;
        this.jVo.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.dXJ + 0.0f);
        this.jVp = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.mForegroundColor, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.jVp);
        canvas.drawRoundRect(this.jVo, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setMax(int i) {
        this.dXJ = i;
    }

    public void setText(String str) {
        this.jVr = true;
        this.mText = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(int i) {
        this.jVr = true;
        this.mText = getContext().getString(i);
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.jVr = true;
        this.mText = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.mForegroundColor = i;
        postInvalidate();
    }

    public void setButtonTextSize(int i) {
        this.mTextSize = l.dip2px(getContext(), i);
        postInvalidate();
    }

    public void setButtonTextColor(int i) {
        this.jVn = i;
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        this.jVr = true;
        if (i <= this.dXJ) {
            this.mProgress = i;
            this.mText = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.dXJ;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setTextColorInitSkin(int i) {
        this.jVi = i;
    }

    public void setBackgroundSkin(int i) {
        this.jVk = i;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, this.jVk);
        this.mTextColor = ap.getColor(this.jVh);
        this.jVn = ap.getColor(this.jVi);
        this.mForegroundColor = ap.getColor(this.jVj);
    }

    public void setTextDelay(final String str, long j) {
        this.jVr = false;
        if (this.jVq == null) {
            this.jVq = new Runnable() { // from class: com.baidu.tieba.funad.view.FunAdButton.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!FunAdButton.this.jVr) {
                        FunAdButton.this.setText(str);
                    }
                }
            };
        } else {
            removeCallbacks(this.jVq);
        }
        postDelayed(this.jVq, j);
    }

    public void onDestroy() {
        if (this.jVq != null) {
            removeCallbacks(this.jVq);
            this.jVq = null;
        }
    }
}
