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
    private RectF cfW;
    private Paint cfY;
    private float cgd;
    private float fll;
    private float flm;
    private String fln;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.fln = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.fll = i * 0.5f;
        this.flm = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cfW.set(this.cgd * 0.5f, this.cgd * 0.5f, i - (this.cgd * 0.5f), i2 - (this.cgd * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cfW, -90.0f, this.mProgress * (-360.0f), false, this.cfY);
        canvas.drawText(this.fln, this.fll, this.flm, this.mTextPaint);
    }

    private void init() {
        bqE();
        initProgress();
    }

    private void bqE() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cgd = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cfY = new Paint(1);
        this.cfY.setDither(true);
        this.cfY.setColor(-12753);
        this.cfY.setStrokeWidth(this.cgd);
        this.cfY.setStyle(Paint.Style.STROKE);
        this.cfW = new RectF();
    }
}
