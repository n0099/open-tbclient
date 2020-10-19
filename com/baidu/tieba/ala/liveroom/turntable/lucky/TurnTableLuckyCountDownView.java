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
    private RectF dwi;
    private Paint dwk;
    private float dwp;
    private float hch;
    private float hci;
    private String hcj;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.hcj = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.hch = i * 0.5f;
        this.hci = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dwi.set(this.dwp * 0.5f, this.dwp * 0.5f, i - (this.dwp * 0.5f), i2 - (this.dwp * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dwi, -90.0f, this.mProgress * (-360.0f), false, this.dwk);
        canvas.drawText(this.hcj, this.hch, this.hci, this.mTextPaint);
    }

    private void init() {
        cbR();
        initProgress();
    }

    private void cbR() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.dwp = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.dwk = new Paint(1);
        this.dwk.setDither(true);
        this.dwk.setColor(-12753);
        this.dwk.setStrokeWidth(this.dwp);
        this.dwk.setStyle(Paint.Style.STROKE);
        this.dwi = new RectF();
    }
}
