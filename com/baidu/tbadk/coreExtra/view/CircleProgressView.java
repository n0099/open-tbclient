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
    public Paint f13406e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f13407f;

    /* renamed from: g  reason: collision with root package name */
    public float f13408g;

    /* renamed from: h  reason: collision with root package name */
    public int f13409h;
    public RectF i;

    public CircleProgressView(Context context) {
        super(context);
        this.f13408g = 5.0f;
        a();
    }

    public final void a() {
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f13406e = paint;
        paint.setAntiAlias(true);
        this.f13406e.setDither(true);
        this.f13406e.setStyle(Paint.Style.STROKE);
        this.f13406e.setStrokeCap(Paint.Cap.ROUND);
        this.f13406e.setStrokeWidth(this.f13408g);
        Paint paint2 = new Paint();
        this.f13407f = paint2;
        paint2.setAntiAlias(true);
        this.f13407f.setDither(true);
        this.f13407f.setStyle(Paint.Style.STROKE);
        this.f13407f.setStrokeCap(Paint.Cap.ROUND);
        this.f13407f.setStrokeWidth(this.f13408g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13409h >= 0) {
            RectF rectF = this.i;
            float f2 = this.f13408g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f13408g;
            this.i.bottom = getHeight() - this.f13408g;
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.f13407f);
            canvas.drawArc(this.i, -90.0f, (this.f13409h / 100) * 360.0f, false, this.f13406e);
        }
    }

    public void setCircleBackgroundColor(int i) {
        this.f13407f.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.f13406e.setColor(i);
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f13409h = i;
        postInvalidate();
    }

    public void setWidth(int i) {
        float f2 = i;
        this.f13408g = f2;
        this.f13407f.setStrokeWidth(f2);
        this.f13406e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13408g = 5.0f;
        a();
    }
}
