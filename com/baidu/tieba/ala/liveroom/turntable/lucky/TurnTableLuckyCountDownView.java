package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class TurnTableLuckyCountDownView extends View {
    private RectF cgj;
    private Paint cgl;
    private float cgq;
    private float flY;
    private float flZ;
    private String fma;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.fma = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.flY = i * 0.5f;
        this.flZ = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cgj.set(this.cgq * 0.5f, this.cgq * 0.5f, i - (this.cgq * 0.5f), i2 - (this.cgq * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cgj, -90.0f, this.mProgress * (-360.0f), false, this.cgl);
        canvas.drawText(this.fma, this.flY, this.flZ, this.mTextPaint);
    }

    private void init() {
        bqM();
        initProgress();
    }

    private void bqM() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cgq = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cgl = new Paint(1);
        this.cgl.setDither(true);
        this.cgl.setColor(-12753);
        this.cgl.setStrokeWidth(this.cgq);
        this.cgl.setStyle(Paint.Style.STROKE);
        this.cgj = new RectF();
    }
}
