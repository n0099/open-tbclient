package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class TurnTableLuckyCountDownView extends View {
    private RectF cUh;
    private Paint cUj;
    private float cUo;
    private float gsu;
    private float gsv;
    private String gsw;
    private float mProgress;
    private Paint mTextPaint;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.gsw = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.gsu = i * 0.5f;
        this.gsv = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.cUh.set(this.cUo * 0.5f, this.cUo * 0.5f, i - (this.cUo * 0.5f), i2 - (this.cUo * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.cUh, -90.0f, this.mProgress * (-360.0f), false, this.cUj);
        canvas.drawText(this.gsw, this.gsu, this.gsv, this.mTextPaint);
    }

    private void init() {
        bJF();
        initProgress();
    }

    private void bJF() {
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.cUo = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.cUj = new Paint(1);
        this.cUj.setDither(true);
        this.cUj.setColor(-12753);
        this.cUj.setStrokeWidth(this.cUo);
        this.cUj.setStyle(Paint.Style.STROKE);
        this.cUh = new RectF();
    }
}
