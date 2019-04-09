package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {
    private float azg;
    private Paint ccG;
    private Paint ccH;
    private RectF ccI;
    private int currentProgress;

    public CircleProgressView(Context context) {
        super(context);
        this.azg = 5.0f;
        aka();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azg = 5.0f;
        aka();
    }

    private void aka() {
        this.ccI = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.ccG = new Paint();
        this.ccG.setAntiAlias(true);
        this.ccG.setDither(true);
        this.ccG.setStyle(Paint.Style.STROKE);
        this.ccG.setStrokeCap(Paint.Cap.ROUND);
        this.ccG.setStrokeWidth(this.azg);
        this.ccH = new Paint();
        this.ccH.setAntiAlias(true);
        this.ccH.setDither(true);
        this.ccH.setStyle(Paint.Style.STROKE);
        this.ccH.setStrokeCap(Paint.Cap.ROUND);
        this.ccH.setStrokeWidth(this.azg);
    }

    public void setCircleBackgroundColor(int i) {
        this.ccH.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.ccG.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.azg = i;
        this.ccH.setStrokeWidth(i);
        this.ccG.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.ccI.left = this.azg;
            this.ccI.top = this.azg;
            this.ccI.right = getWidth() - this.azg;
            this.ccI.bottom = getHeight() - this.azg;
            canvas.drawArc(this.ccI, 0.0f, 360.0f, false, this.ccH);
            canvas.drawArc(this.ccI, -90.0f, 360.0f * (this.currentProgress / 100), false, this.ccG);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
