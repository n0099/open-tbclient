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
    private Paint aiW;
    private float eoA;
    private float eoB;
    private float eoC;
    private Paint eoD;
    private RectF eoE;
    private String eoF;
    private float mProgress;

    public TurnTableLuckyCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setTimer(String str, float f) {
        this.eoF = str;
        this.mProgress = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Paint.FontMetricsInt fontMetricsInt = this.aiW.getFontMetricsInt();
        this.eoA = i * 0.5f;
        this.eoB = ((i2 - fontMetricsInt.top) - fontMetricsInt.bottom) * 0.5f;
        this.eoE.set(this.eoC * 0.5f, this.eoC * 0.5f, i - (this.eoC * 0.5f), i2 - (this.eoC * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.eoE, -90.0f, this.mProgress * (-360.0f), false, this.eoD);
        canvas.drawText(this.eoF, this.eoA, this.eoB, this.aiW);
    }

    private void init() {
        aWj();
        initProgress();
    }

    private void aWj() {
        this.aiW = new Paint(1);
        this.aiW.setDither(true);
        this.aiW.setColor(-1);
        this.aiW.setStyle(Paint.Style.FILL);
        this.aiW.setTextAlign(Paint.Align.CENTER);
        this.aiW.setTextSize(getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
    }

    private void initProgress() {
        this.eoC = getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        this.eoD = new Paint(1);
        this.eoD.setDither(true);
        this.eoD.setColor(-12753);
        this.eoD.setStrokeWidth(this.eoC);
        this.eoD.setStyle(Paint.Style.STROKE);
        this.eoE = new RectF();
    }
}
