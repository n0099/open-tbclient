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
    private float dKE;
    private RectF dKx;
    private Paint dKz;
    private float htV;
    private float htW;
    private String htX;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.htX = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.htV = i * 0.5f;
        this.htW = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dKx.set(this.dKE * 0.5f, this.dKE * 0.5f, i - (this.dKE * 0.5f), i2 - (this.dKE * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dKx, -90.0f, this.mProgress * (-360.0f), false, this.dKz);
        canvas.drawText(this.htX, this.htV, this.htW, this.mTextPaint);
    }

    private void init() {
        chy();
        initProgress();
    }

    private void chy() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
    }

    private void initProgress() {
        this.dKE = getResources().getDimensionPixelOffset(a.d.sdk_ds6);
        this.dKz = new Paint(1);
        this.dKz.setDither(true);
        this.dKz.setColor(-12753);
        this.dKz.setStrokeWidth(this.dKE);
        this.dKz.setStyle(Paint.Style.STROKE);
        this.dKx = new RectF();
    }
}
