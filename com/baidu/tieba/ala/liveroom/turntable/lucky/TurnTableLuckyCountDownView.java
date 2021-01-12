package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class TurnTableLuckyCountDownView extends View {
    private Paint bex;
    private RectF dTX;
    private Paint dTZ;
    private float dUf;
    private float hKC;
    private float hKD;
    private String hKE;
    private float mProgress;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.hKE = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.bex.getFontMetricsInt();
        this.hKC = i * 0.5f;
        this.hKD = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dTX.set(this.dUf * 0.5f, this.dUf * 0.5f, i - (this.dUf * 0.5f), i2 - (this.dUf * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dTX, -90.0f, this.mProgress * (-360.0f), false, this.dTZ);
        canvas.drawText(this.hKE == null ? "" : this.hKE, this.hKC, this.hKD, this.bex);
    }

    private void init() {
        cjM();
        initProgress();
    }

    private void cjM() {
        this.bex = new Paint(1);
        this.bex.setDither(true);
        this.bex.setColor(-1);
        this.bex.setStyle(Paint.Style.FILL);
        this.bex.setTextAlign(Paint.Align.CENTER);
        this.bex.setTextSize(getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
    }

    private void initProgress() {
        this.dUf = getResources().getDimensionPixelOffset(a.d.sdk_ds6);
        this.dTZ = new Paint(1);
        this.dTZ.setDither(true);
        this.dTZ.setColor(-12753);
        this.dTZ.setStrokeWidth(this.dUf);
        this.dTZ.setStyle(Paint.Style.STROKE);
        this.dTX = new RectF();
    }
}
