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
    private RectF cFn;
    private Paint cFp;
    private float cFu;
    private float fQB;
    private float fQC;
    private String fQD;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.fQD = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.fQB = i * 0.5f;
        this.fQC = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cFn.set(this.cFu * 0.5f, this.cFu * 0.5f, i - (this.cFu * 0.5f), i2 - (this.cFu * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cFn, -90.0f, this.mProgress * (-360.0f), false, this.cFp);
        canvas.drawText(this.fQD, this.fQB, this.fQC, this.mTextPaint);
    }

    private void init() {
        bAj();
        initProgress();
    }

    private void bAj() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cFu = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cFp = new Paint(1);
        this.cFp.setDither(true);
        this.cFp.setColor(-12753);
        this.cFp.setStrokeWidth(this.cFu);
        this.cFp.setStyle(Paint.Style.STROKE);
        this.cFn = new RectF();
    }
}
