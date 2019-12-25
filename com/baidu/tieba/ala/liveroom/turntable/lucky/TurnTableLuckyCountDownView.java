package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class TurnTableLuckyCountDownView extends View {
    private RectF cbF;
    private Paint cbH;
    private float cbM;
    private float feX;
    private float feY;
    private String feZ;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.feZ = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.feX = i * 0.5f;
        this.feY = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cbF.set(this.cbM * 0.5f, this.cbM * 0.5f, i - (this.cbM * 0.5f), i2 - (this.cbM * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cbF, -90.0f, this.mProgress * (-360.0f), false, this.cbH);
        canvas.drawText(this.feZ, this.feX, this.feY, this.mTextPaint);
    }

    private void init() {
        bnX();
        initProgress();
    }

    private void bnX() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cbM = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cbH = new Paint(1);
        this.cbH.setDither(true);
        this.cbH.setColor(-12753);
        this.cbH.setStrokeWidth(this.cbM);
        this.cbH.setStyle(Paint.Style.STROKE);
        this.cbF = new RectF();
    }
}
