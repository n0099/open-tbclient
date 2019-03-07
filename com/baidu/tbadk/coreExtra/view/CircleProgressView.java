package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {
    private float azb;
    private Paint ccD;
    private Paint ccE;
    private RectF ccF;
    private int currentProgress;

    public CircleProgressView(Context context) {
        super(context);
        this.azb = 5.0f;
        ake();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azb = 5.0f;
        ake();
    }

    private void ake() {
        this.ccF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.ccD = new Paint();
        this.ccD.setAntiAlias(true);
        this.ccD.setDither(true);
        this.ccD.setStyle(Paint.Style.STROKE);
        this.ccD.setStrokeCap(Paint.Cap.ROUND);
        this.ccD.setStrokeWidth(this.azb);
        this.ccE = new Paint();
        this.ccE.setAntiAlias(true);
        this.ccE.setDither(true);
        this.ccE.setStyle(Paint.Style.STROKE);
        this.ccE.setStrokeCap(Paint.Cap.ROUND);
        this.ccE.setStrokeWidth(this.azb);
    }

    public void setCircleBackgroundColor(int i) {
        this.ccE.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.ccD.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.azb = i;
        this.ccE.setStrokeWidth(i);
        this.ccD.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.ccF.left = this.azb;
            this.ccF.top = this.azb;
            this.ccF.right = getWidth() - this.azb;
            this.ccF.bottom = getHeight() - this.azb;
            canvas.drawArc(this.ccF, 0.0f, 360.0f, false, this.ccE);
            canvas.drawArc(this.ccF, -90.0f, 360.0f * (this.currentProgress / 100), false, this.ccD);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
