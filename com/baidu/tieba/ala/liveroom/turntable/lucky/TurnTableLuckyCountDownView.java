package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class TurnTableLuckyCountDownView extends View {
    private RectF dhZ;
    private Paint dib;
    private float dih;
    private float gJU;
    private float gJV;
    private String gJW;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.gJW = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.gJU = i * 0.5f;
        this.gJV = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dhZ.set(this.dih * 0.5f, this.dih * 0.5f, i - (this.dih * 0.5f), i2 - (this.dih * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dhZ, -90.0f, this.mProgress * (-360.0f), false, this.dib);
        canvas.drawText(this.gJW, this.gJU, this.gJV, this.mTextPaint);
    }

    private void init() {
        bWK();
        initProgress();
    }

    private void bWK() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.dih = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.dib = new Paint(1);
        this.dib.setDither(true);
        this.dib.setColor(-12753);
        this.dib.setStrokeWidth(this.dih);
        this.dib.setStyle(Paint.Style.STROKE);
        this.dhZ = new RectF();
    }
}
