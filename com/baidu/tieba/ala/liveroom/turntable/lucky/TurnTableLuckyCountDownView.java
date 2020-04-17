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
    private RectF cFh;
    private Paint cFj;
    private float cFo;
    private float fQw;
    private float fQx;
    private String fQy;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.fQy = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.fQw = i * 0.5f;
        this.fQx = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cFh.set(this.cFo * 0.5f, this.cFo * 0.5f, i - (this.cFo * 0.5f), i2 - (this.cFo * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cFh, -90.0f, this.mProgress * (-360.0f), false, this.cFj);
        canvas.drawText(this.fQy, this.fQw, this.fQx, this.mTextPaint);
    }

    private void init() {
        bAl();
        initProgress();
    }

    private void bAl() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cFo = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cFj = new Paint(1);
        this.cFj.setDither(true);
        this.cFj.setColor(-12753);
        this.cFj.setStrokeWidth(this.cFo);
        this.cFj.setStyle(Paint.Style.STROKE);
        this.cFh = new RectF();
    }
}
