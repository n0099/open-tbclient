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
    private Paint bhF;
    private RectF dWd;
    private Paint dWf;
    private float dWl;
    private float hPk;
    private float hPl;
    private String hPm;
    private float mProgress;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.hPm = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.bhF.getFontMetricsInt();
        this.hPk = i * 0.5f;
        this.hPl = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dWd.set(this.dWl * 0.5f, this.dWl * 0.5f, i - (this.dWl * 0.5f), i2 - (this.dWl * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dWd, -90.0f, this.mProgress * (-360.0f), false, this.dWf);
        canvas.drawText(this.hPm == null ? "" : this.hPm, this.hPk, this.hPl, this.bhF);
    }

    private void init() {
        ckR();
        initProgress();
    }

    private void ckR() {
        this.bhF = new Paint(1);
        this.bhF.setDither(true);
        this.bhF.setColor(-1);
        this.bhF.setStyle(Paint.Style.FILL);
        this.bhF.setTextAlign(Paint.Align.CENTER);
        this.bhF.setTextSize(getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
    }

    private void initProgress() {
        this.dWl = getResources().getDimensionPixelOffset(a.d.sdk_ds6);
        this.dWf = new Paint(1);
        this.dWf.setDither(true);
        this.dWf.setColor(-12753);
        this.dWf.setStrokeWidth(this.dWl);
        this.dWf.setStyle(Paint.Style.STROKE);
        this.dWd = new RectF();
    }
}
