package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {
    private float aAe;
    private Paint ckK;
    private Paint ckL;
    private RectF ckM;
    private int currentProgress;

    public CircleProgressView(Context context) {
        super(context);
        this.aAe = 5.0f;
        apb();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAe = 5.0f;
        apb();
    }

    private void apb() {
        this.ckM = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.ckK = new Paint();
        this.ckK.setAntiAlias(true);
        this.ckK.setDither(true);
        this.ckK.setStyle(Paint.Style.STROKE);
        this.ckK.setStrokeCap(Paint.Cap.ROUND);
        this.ckK.setStrokeWidth(this.aAe);
        this.ckL = new Paint();
        this.ckL.setAntiAlias(true);
        this.ckL.setDither(true);
        this.ckL.setStyle(Paint.Style.STROKE);
        this.ckL.setStrokeCap(Paint.Cap.ROUND);
        this.ckL.setStrokeWidth(this.aAe);
    }

    public void setCircleBackgroundColor(int i) {
        this.ckL.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.ckK.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.aAe = i;
        this.ckL.setStrokeWidth(i);
        this.ckK.setStrokeWidth(i);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.ckM.left = this.aAe;
            this.ckM.top = this.aAe;
            this.ckM.right = getWidth() - this.aAe;
            this.ckM.bottom = getHeight() - this.aAe;
            canvas.drawArc(this.ckM, 0.0f, 360.0f, false, this.ckL);
            canvas.drawArc(this.ckM, -90.0f, 360.0f * (this.currentProgress / 100), false, this.ckK);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
