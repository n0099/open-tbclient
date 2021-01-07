package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class TurnTableLuckyCountDownView extends View {
    private Paint bjo;
    private RectF dYJ;
    private Paint dYL;
    private float dYR;
    private float hPi;
    private float hPj;
    private String hPk;
    private float mProgress;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.hPk = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.bjo.getFontMetricsInt();
        this.hPi = i * 0.5f;
        this.hPj = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dYJ.set(this.dYR * 0.5f, this.dYR * 0.5f, i - (this.dYR * 0.5f), i2 - (this.dYR * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dYJ, -90.0f, this.mProgress * (-360.0f), false, this.dYL);
        canvas.drawText(this.hPk == null ? "" : this.hPk, this.hPi, this.hPj, this.bjo);
    }

    private void init() {
        cnE();
        initProgress();
    }

    private void cnE() {
        this.bjo = new Paint(1);
        this.bjo.setDither(true);
        this.bjo.setColor(-1);
        this.bjo.setStyle(Paint.Style.FILL);
        this.bjo.setTextAlign(Paint.Align.CENTER);
        this.bjo.setTextSize(getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
    }

    private void initProgress() {
        this.dYR = getResources().getDimensionPixelOffset(a.d.sdk_ds6);
        this.dYL = new Paint(1);
        this.dYL.setDither(true);
        this.dYL.setColor(-12753);
        this.dYL.setStrokeWidth(this.dYR);
        this.dYL.setStyle(Paint.Style.STROKE);
        this.dYJ = new RectF();
    }
}
