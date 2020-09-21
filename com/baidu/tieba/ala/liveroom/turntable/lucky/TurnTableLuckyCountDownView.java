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
    private RectF dkc;
    private Paint dke;
    private float dkj;
    private float gNk;
    private float gNl;
    private String gNm;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.gNm = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.gNk = i * 0.5f;
        this.gNl = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dkc.set(this.dkj * 0.5f, this.dkj * 0.5f, i - (this.dkj * 0.5f), i2 - (this.dkj * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dkc, -90.0f, this.mProgress * (-360.0f), false, this.dke);
        canvas.drawText(this.gNm, this.gNk, this.gNl, this.mTextPaint);
    }

    private void init() {
        bYr();
        initProgress();
    }

    private void bYr() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.dkj = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.dke = new Paint(1);
        this.dke.setDither(true);
        this.dke.setColor(-12753);
        this.dke.setStrokeWidth(this.dkj);
        this.dke.setStyle(Paint.Style.STROKE);
        this.dkc = new RectF();
    }
}
