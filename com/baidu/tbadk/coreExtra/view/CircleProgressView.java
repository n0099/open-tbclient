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
    public Paint f12633e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12634f;

    /* renamed from: g  reason: collision with root package name */
    public float f12635g;

    /* renamed from: h  reason: collision with root package name */
    public int f12636h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f12637i;

    public CircleProgressView(Context context) {
        super(context);
        this.f12635g = 5.0f;
        a();
    }

    public final void a() {
        this.f12637i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f12633e = paint;
        paint.setAntiAlias(true);
        this.f12633e.setDither(true);
        this.f12633e.setStyle(Paint.Style.STROKE);
        this.f12633e.setStrokeCap(Paint.Cap.ROUND);
        this.f12633e.setStrokeWidth(this.f12635g);
        Paint paint2 = new Paint();
        this.f12634f = paint2;
        paint2.setAntiAlias(true);
        this.f12634f.setDither(true);
        this.f12634f.setStyle(Paint.Style.STROKE);
        this.f12634f.setStrokeCap(Paint.Cap.ROUND);
        this.f12634f.setStrokeWidth(this.f12635g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f12636h >= 0) {
            RectF rectF = this.f12637i;
            float f2 = this.f12635g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f12635g;
            this.f12637i.bottom = getHeight() - this.f12635g;
            canvas.drawArc(this.f12637i, 0.0f, 360.0f, false, this.f12634f);
            canvas.drawArc(this.f12637i, -90.0f, (this.f12636h / 100) * 360.0f, false, this.f12633e);
        }
    }

    public void setCircleBackgroundColor(int i2) {
        this.f12634f.setColor(i2);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i2) {
        this.f12633e.setColor(i2);
        postInvalidate();
    }

    public void setProgress(int i2) {
        this.f12636h = i2;
        postInvalidate();
    }

    public void setWidth(int i2) {
        float f2 = i2;
        this.f12635g = f2;
        this.f12634f.setStrokeWidth(f2);
        this.f12633e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12635g = 5.0f;
        a();
    }
}
