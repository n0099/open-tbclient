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
    private float cPE;
    private RectF cPx;
    private Paint cPz;
    private float gfm;
    private float gfn;
    private String gfo;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.gfo = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.gfm = i * 0.5f;
        this.gfn = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cPx.set(this.cPE * 0.5f, this.cPE * 0.5f, i - (this.cPE * 0.5f), i2 - (this.cPE * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cPx, -90.0f, this.mProgress * (-360.0f), false, this.cPz);
        canvas.drawText(this.gfo, this.gfm, this.gfn, this.mTextPaint);
    }

    private void init() {
        bGw();
        initProgress();
    }

    private void bGw() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cPE = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cPz = new Paint(1);
        this.cPz.setDither(true);
        this.cPz.setColor(-12753);
        this.cPz.setStrokeWidth(this.cPE);
        this.cPz.setStyle(Paint.Style.STROKE);
        this.cPx = new RectF();
    }
}
