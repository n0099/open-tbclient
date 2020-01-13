package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class TurnTableLuckyCountDownView extends View {
    private RectF cbR;
    private Paint cbT;
    private float cbY;
    private float fig;
    private float fih;
    private String fii;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.fii = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.fig = i * 0.5f;
        this.fih = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cbR.set(this.cbY * 0.5f, this.cbY * 0.5f, i - (this.cbY * 0.5f), i2 - (this.cbY * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cbR, -90.0f, this.mProgress * (-360.0f), false, this.cbT);
        canvas.drawText(this.fii, this.fig, this.fih, this.mTextPaint);
    }

    private void init() {
        boY();
        initProgress();
    }

    private void boY() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cbY = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cbT = new Paint(1);
        this.cbT.setDither(true);
        this.cbT.setColor(-12753);
        this.cbT.setStrokeWidth(this.cbY);
        this.cbT.setStyle(Paint.Style.STROKE);
        this.cbR = new RectF();
    }
}
