package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {
    private float azf;
    private Paint ccF;
    private Paint ccG;
    private RectF ccH;
    private int currentProgress;

    public CircleProgressView(Context context) {
        super(context);
        this.azf = 5.0f;
        aka();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azf = 5.0f;
        aka();
    }

    private void aka() {
        this.ccH = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.ccF = new Paint();
        this.ccF.setAntiAlias(true);
        this.ccF.setDither(true);
        this.ccF.setStyle(Paint.Style.STROKE);
        this.ccF.setStrokeCap(Paint.Cap.ROUND);
        this.ccF.setStrokeWidth(this.azf);
        this.ccG = new Paint();
        this.ccG.setAntiAlias(true);
        this.ccG.setDither(true);
        this.ccG.setStyle(Paint.Style.STROKE);
        this.ccG.setStrokeCap(Paint.Cap.ROUND);
        this.ccG.setStrokeWidth(this.azf);
    }

    public void setCircleBackgroundColor(int i) {
        this.ccG.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.ccF.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.azf = i;
        this.ccG.setStrokeWidth(i);
        this.ccF.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.ccH.left = this.azf;
            this.ccH.top = this.azf;
            this.ccH.right = getWidth() - this.azf;
            this.ccH.bottom = getHeight() - this.azf;
            canvas.drawArc(this.ccH, 0.0f, 360.0f, false, this.ccG);
            canvas.drawArc(this.ccH, -90.0f, 360.0f * (this.currentProgress / 100), false, this.ccF);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
