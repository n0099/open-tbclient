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
    private RectF cfX;
    private Paint cfZ;
    private float cge;
    private float flm;
    private float fln;
    private String flo;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.flo = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.flm = i * 0.5f;
        this.fln = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cfX.set(this.cge * 0.5f, this.cge * 0.5f, i - (this.cge * 0.5f), i2 - (this.cge * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cfX, -90.0f, this.mProgress * (-360.0f), false, this.cfZ);
        canvas.drawText(this.flo, this.flm, this.fln, this.mTextPaint);
    }

    private void init() {
        bqG();
        initProgress();
    }

    private void bqG() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cge = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cfZ = new Paint(1);
        this.cfZ.setDither(true);
        this.cfZ.setColor(-12753);
        this.cfZ.setStrokeWidth(this.cge);
        this.cfZ.setStyle(Paint.Style.STROKE);
        this.cfX = new RectF();
    }
}
