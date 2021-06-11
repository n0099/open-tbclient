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
    public Paint f12695e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12696f;

    /* renamed from: g  reason: collision with root package name */
    public float f12697g;

    /* renamed from: h  reason: collision with root package name */
    public int f12698h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f12699i;

    public CircleProgressView(Context context) {
        super(context);
        this.f12697g = 5.0f;
        a();
    }

    public final void a() {
        this.f12699i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f12695e = paint;
        paint.setAntiAlias(true);
        this.f12695e.setDither(true);
        this.f12695e.setStyle(Paint.Style.STROKE);
        this.f12695e.setStrokeCap(Paint.Cap.ROUND);
        this.f12695e.setStrokeWidth(this.f12697g);
        Paint paint2 = new Paint();
        this.f12696f = paint2;
        paint2.setAntiAlias(true);
        this.f12696f.setDither(true);
        this.f12696f.setStyle(Paint.Style.STROKE);
        this.f12696f.setStrokeCap(Paint.Cap.ROUND);
        this.f12696f.setStrokeWidth(this.f12697g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f12698h >= 0) {
            RectF rectF = this.f12699i;
            float f2 = this.f12697g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f12697g;
            this.f12699i.bottom = getHeight() - this.f12697g;
            canvas.drawArc(this.f12699i, 0.0f, 360.0f, false, this.f12696f);
            canvas.drawArc(this.f12699i, -90.0f, (this.f12698h / 100) * 360.0f, false, this.f12695e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f12696f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f12695e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f12698h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f12697g = f2;
        this.f12696f.setStrokeWidth(f2);
        this.f12695e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12697g = 5.0f;
        a();
    }
}
