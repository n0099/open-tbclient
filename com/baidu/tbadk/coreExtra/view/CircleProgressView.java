package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f13389e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f13390f;

    /* renamed from: g  reason: collision with root package name */
    public float f13391g;

    /* renamed from: h  reason: collision with root package name */
    public int f13392h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f13393i;

    public CircleProgressView(Context context) {
        super(context);
        this.f13391g = 5.0f;
        a();
    }

    public final void a() {
        this.f13393i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f13389e = paint;
        paint.setAntiAlias(true);
        this.f13389e.setDither(true);
        this.f13389e.setStyle(Paint.Style.STROKE);
        this.f13389e.setStrokeCap(Paint.Cap.ROUND);
        this.f13389e.setStrokeWidth(this.f13391g);
        Paint paint2 = new Paint();
        this.f13390f = paint2;
        paint2.setAntiAlias(true);
        this.f13390f.setDither(true);
        this.f13390f.setStyle(Paint.Style.STROKE);
        this.f13390f.setStrokeCap(Paint.Cap.ROUND);
        this.f13390f.setStrokeWidth(this.f13391g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13392h >= 0) {
            RectF rectF = this.f13393i;
            float f2 = this.f13391g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f13391g;
            this.f13393i.bottom = getHeight() - this.f13391g;
            canvas.drawArc(this.f13393i, 0.0f, 360.0f, false, this.f13390f);
            canvas.drawArc(this.f13393i, -90.0f, (this.f13392h / 100) * 360.0f, false, this.f13389e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f13390f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f13389e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f13392h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f13391g = f2;
        this.f13390f.setStrokeWidth(f2);
        this.f13389e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13391g = 5.0f;
        a();
    }
}
