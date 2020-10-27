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
    private RectF dEF;
    private Paint dEH;
    private float dEM;
    private float hnX;
    private float hnY;
    private String hnZ;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.hnZ = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.hnX = i * 0.5f;
        this.hnY = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.dEF.set(this.dEM * 0.5f, this.dEM * 0.5f, i - (this.dEM * 0.5f), i2 - (this.dEM * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.dEF, -90.0f, this.mProgress * (-360.0f), false, this.dEH);
        canvas.drawText(this.hnZ, this.hnX, this.hnY, this.mTextPaint);
    }

    private void init() {
        ceV();
        initProgress();
    }

    private void ceV() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.dEM = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.dEH = new Paint(1);
        this.dEH.setDither(true);
        this.dEH.setColor(-12753);
        this.dEH.setStrokeWidth(this.dEM);
        this.dEH.setStyle(Paint.Style.STROKE);
        this.dEF = new RectF();
    }
}
