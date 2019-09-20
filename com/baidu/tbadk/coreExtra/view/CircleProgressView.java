package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {
    private float aBk;
    private Paint cna;
    private Paint cnb;
    private RectF cnc;
    private int currentProgress;

    public CircleProgressView(Context context) {
        super(context);
        this.aBk = 5.0f;
        aqv();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBk = 5.0f;
        aqv();
    }

    private void aqv() {
        this.cnc = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.cna = new Paint();
        this.cna.setAntiAlias(true);
        this.cna.setDither(true);
        this.cna.setStyle(Paint.Style.STROKE);
        this.cna.setStrokeCap(Paint.Cap.ROUND);
        this.cna.setStrokeWidth(this.aBk);
        this.cnb = new Paint();
        this.cnb.setAntiAlias(true);
        this.cnb.setDither(true);
        this.cnb.setStyle(Paint.Style.STROKE);
        this.cnb.setStrokeCap(Paint.Cap.ROUND);
        this.cnb.setStrokeWidth(this.aBk);
    }

    public void setCircleBackgroundColor(int i) {
        this.cnb.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.cna.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.aBk = i;
        this.cnb.setStrokeWidth(i);
        this.cna.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.cnc.left = this.aBk;
            this.cnc.top = this.aBk;
            this.cnc.right = getWidth() - this.aBk;
            this.cnc.bottom = getHeight() - this.aBk;
            canvas.drawArc(this.cnc, 0.0f, 360.0f, false, this.cnb);
            canvas.drawArc(this.cnc, -90.0f, 360.0f * (this.currentProgress / 100), false, this.cna);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
