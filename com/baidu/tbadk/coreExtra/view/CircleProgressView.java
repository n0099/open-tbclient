package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {
    private float aUy;
    private int asx;
    private RectF cAa;
    private Paint czY;
    private Paint czZ;

    public CircleProgressView(Context context) {
        super(context);
        this.aUy = 5.0f;
        asp();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUy = 5.0f;
        asp();
    }

    private void asp() {
        this.cAa = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.czY = new Paint();
        this.czY.setAntiAlias(true);
        this.czY.setDither(true);
        this.czY.setStyle(Paint.Style.STROKE);
        this.czY.setStrokeCap(Paint.Cap.ROUND);
        this.czY.setStrokeWidth(this.aUy);
        this.czZ = new Paint();
        this.czZ.setAntiAlias(true);
        this.czZ.setDither(true);
        this.czZ.setStyle(Paint.Style.STROKE);
        this.czZ.setStrokeCap(Paint.Cap.ROUND);
        this.czZ.setStrokeWidth(this.aUy);
    }

    public void setCircleBackgroundColor(int i) {
        this.czZ.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.czY.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.aUy = i;
        this.czZ.setStrokeWidth(i);
        this.czY.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.asx >= 0) {
            this.cAa.left = this.aUy;
            this.cAa.top = this.aUy;
            this.cAa.right = getWidth() - this.aUy;
            this.cAa.bottom = getHeight() - this.aUy;
            canvas.drawArc(this.cAa, 0.0f, 360.0f, false, this.czZ);
            canvas.drawArc(this.cAa, -90.0f, 360.0f * (this.asx / 100), false, this.czY);
        }
    }

    public void setProgress(int i) {
        this.asx = i;
        postInvalidate();
    }
}
