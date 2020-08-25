package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class TurnTableLuckyCountDownView extends View {
    private RectF dhV;
    private Paint dhX;
    private float dic;
    private float gJQ;
    private float gJR;
    private String gJS;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.gJS = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.gJQ = i * 0.5f;
        this.gJR = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dhV.set(this.dic * 0.5f, this.dic * 0.5f, i - (this.dic * 0.5f), i2 - (this.dic * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dhV, -90.0f, this.mProgress * (-360.0f), false, this.dhX);
        canvas.drawText(this.gJS, this.gJQ, this.gJR, this.mTextPaint);
    }

    private void init() {
        bWJ();
        initProgress();
    }

    private void bWJ() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.dic = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.dhX = new Paint(1);
        this.dhX.setDither(true);
        this.dhX.setColor(-12753);
        this.dhX.setStrokeWidth(this.dic);
        this.dhX.setStyle(Paint.Style.STROKE);
        this.dhV = new RectF();
    }
}
