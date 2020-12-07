package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class TurnTableLuckyCountDownView extends View {
    private RectF dPN;
    private Paint dPP;
    private float dPU;
    private float hDf;
    private float hDg;
    private String hDh;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.hDh = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.hDf = i * 0.5f;
        this.hDg = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dPN.set(this.dPU * 0.5f, this.dPU * 0.5f, i - (this.dPU * 0.5f), i2 - (this.dPU * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dPN, -90.0f, this.mProgress * (-360.0f), false, this.dPP);
        canvas.drawText(this.hDh == null ? "" : this.hDh, this.hDf, this.hDg, this.mTextPaint);
    }

    private void init() {
        ckL();
        initProgress();
    }

    private void ckL() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
    }

    private void initProgress() {
        this.dPU = getResources().getDimensionPixelOffset(a.d.sdk_ds6);
        this.dPP = new Paint(1);
        this.dPP.setDither(true);
        this.dPP.setColor(-12753);
        this.dPP.setStrokeWidth(this.dPU);
        this.dPP.setStyle(Paint.Style.STROKE);
        this.dPN = new RectF();
    }
}
