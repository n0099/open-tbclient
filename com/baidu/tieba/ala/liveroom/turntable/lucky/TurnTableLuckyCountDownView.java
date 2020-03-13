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
    private RectF cfY;
    private Paint cga;
    private float cgf;
    private float flA;
    private String flB;
    private float flz;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.flB = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.flz = i * 0.5f;
        this.flA = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cfY.set(this.cgf * 0.5f, this.cgf * 0.5f, i - (this.cgf * 0.5f), i2 - (this.cgf * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cfY, -90.0f, this.mProgress * (-360.0f), false, this.cga);
        canvas.drawText(this.flB, this.flz, this.flA, this.mTextPaint);
    }

    private void init() {
        bqH();
        initProgress();
    }

    private void bqH() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cgf = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cga = new Paint(1);
        this.cga.setDither(true);
        this.cga.setColor(-12753);
        this.cga.setStrokeWidth(this.cgf);
        this.cga.setStyle(Paint.Style.STROKE);
        this.cfY = new RectF();
    }
}
