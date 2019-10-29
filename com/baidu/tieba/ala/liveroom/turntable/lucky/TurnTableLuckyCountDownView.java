package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class TurnTableLuckyCountDownView extends View {
    private Paint ajo;
    private float epr;
    private float eps;
    private float ept;
    private Paint epu;
    private RectF epv;
    private String epw;
    private float mProgress;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.epw = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.ajo.getFontMetricsInt();
        this.epr = i * 0.5f;
        this.eps = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.epv.set(this.ept * 0.5f, this.ept * 0.5f, i - (this.ept * 0.5f), i2 - (this.ept * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.epv, -90.0f, this.mProgress * (-360.0f), false, this.epu);
        canvas.drawText(this.epw, this.epr, this.eps, this.ajo);
    }

    private void init() {
        aWl();
        initProgress();
    }

    private void aWl() {
        this.ajo = new Paint(1);
        this.ajo.setDither(true);
        this.ajo.setColor(-1);
        this.ajo.setStyle(Paint.Style.FILL);
        this.ajo.setTextAlign(Paint.Align.CENTER);
        this.ajo.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.ept = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.epu = new Paint(1);
        this.epu.setDither(true);
        this.epu.setColor(-12753);
        this.epu.setStrokeWidth(this.ept);
        this.epu.setStyle(Paint.Style.STROKE);
        this.epv = new RectF();
    }
}
