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
    public Paint f12725e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12726f;

    /* renamed from: g  reason: collision with root package name */
    public float f12727g;

    /* renamed from: h  reason: collision with root package name */
    public int f12728h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f12729i;

    public CircleProgressView(Context context) {
        super(context);
        this.f12727g = 5.0f;
        a();
    }

    public final void a() {
        this.f12729i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f12725e = paint;
        paint.setAntiAlias(true);
        this.f12725e.setDither(true);
        this.f12725e.setStyle(Paint.Style.STROKE);
        this.f12725e.setStrokeCap(Paint.Cap.ROUND);
        this.f12725e.setStrokeWidth(this.f12727g);
        Paint paint2 = new Paint();
        this.f12726f = paint2;
        paint2.setAntiAlias(true);
        this.f12726f.setDither(true);
        this.f12726f.setStyle(Paint.Style.STROKE);
        this.f12726f.setStrokeCap(Paint.Cap.ROUND);
        this.f12726f.setStrokeWidth(this.f12727g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f12728h >= 0) {
            RectF rectF = this.f12729i;
            float f2 = this.f12727g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f12727g;
            this.f12729i.bottom = getHeight() - this.f12727g;
            canvas.drawArc(this.f12729i, 0.0f, 360.0f, false, this.f12726f);
            canvas.drawArc(this.f12729i, -90.0f, (this.f12728h / 100) * 360.0f, false, this.f12725e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f12726f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f12725e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f12728h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f12727g = f2;
        this.f12726f.setStrokeWidth(f2);
        this.f12725e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12727g = 5.0f;
        a();
    }
}
