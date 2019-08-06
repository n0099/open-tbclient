package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {
    private float aAM;
    private Paint cmf;
    private Paint cmg;
    private RectF cmh;
    private int currentProgress;

    public CircleProgressView(Context context) {
        super(context);
        this.aAM = 5.0f;
        aqj();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAM = 5.0f;
        aqj();
    }

    private void aqj() {
        this.cmh = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.cmf = new Paint();
        this.cmf.setAntiAlias(true);
        this.cmf.setDither(true);
        this.cmf.setStyle(Paint.Style.STROKE);
        this.cmf.setStrokeCap(Paint.Cap.ROUND);
        this.cmf.setStrokeWidth(this.aAM);
        this.cmg = new Paint();
        this.cmg.setAntiAlias(true);
        this.cmg.setDither(true);
        this.cmg.setStyle(Paint.Style.STROKE);
        this.cmg.setStrokeCap(Paint.Cap.ROUND);
        this.cmg.setStrokeWidth(this.aAM);
    }

    public void setCircleBackgroundColor(int i) {
        this.cmg.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.cmf.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.aAM = i;
        this.cmg.setStrokeWidth(i);
        this.cmf.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.cmh.left = this.aAM;
            this.cmh.top = this.aAM;
            this.cmh.right = getWidth() - this.aAM;
            this.cmh.bottom = getHeight() - this.aAM;
            canvas.drawArc(this.cmh, 0.0f, 360.0f, false, this.cmg);
            canvas.drawArc(this.cmh, -90.0f, 360.0f * (this.currentProgress / 100), false, this.cmf);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
