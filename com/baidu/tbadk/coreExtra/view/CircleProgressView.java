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
    public Paint f12777e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12778f;

    /* renamed from: g  reason: collision with root package name */
    public float f12779g;

    /* renamed from: h  reason: collision with root package name */
    public int f12780h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f12781i;

    public CircleProgressView(Context context) {
        super(context);
        this.f12779g = 5.0f;
        a();
    }

    public final void a() {
        this.f12781i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f12777e = paint;
        paint.setAntiAlias(true);
        this.f12777e.setDither(true);
        this.f12777e.setStyle(Paint.Style.STROKE);
        this.f12777e.setStrokeCap(Paint.Cap.ROUND);
        this.f12777e.setStrokeWidth(this.f12779g);
        Paint paint2 = new Paint();
        this.f12778f = paint2;
        paint2.setAntiAlias(true);
        this.f12778f.setDither(true);
        this.f12778f.setStyle(Paint.Style.STROKE);
        this.f12778f.setStrokeCap(Paint.Cap.ROUND);
        this.f12778f.setStrokeWidth(this.f12779g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f12780h >= 0) {
            RectF rectF = this.f12781i;
            float f2 = this.f12779g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f12779g;
            this.f12781i.bottom = getHeight() - this.f12779g;
            canvas.drawArc(this.f12781i, 0.0f, 360.0f, false, this.f12778f);
            canvas.drawArc(this.f12781i, -90.0f, (this.f12780h / 100) * 360.0f, false, this.f12777e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f12778f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f12777e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f12780h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f12779g = f2;
        this.f12778f.setStrokeWidth(f2);
        this.f12777e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12779g = 5.0f;
        a();
    }
}
