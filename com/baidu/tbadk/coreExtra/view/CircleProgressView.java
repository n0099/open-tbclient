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
    public Paint f13414e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f13415f;

    /* renamed from: g  reason: collision with root package name */
    public float f13416g;

    /* renamed from: h  reason: collision with root package name */
    public int f13417h;
    public RectF i;

    public CircleProgressView(Context context) {
        super(context);
        this.f13416g = 5.0f;
        a();
    }

    public final void a() {
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f13414e = paint;
        paint.setAntiAlias(true);
        this.f13414e.setDither(true);
        this.f13414e.setStyle(Paint.Style.STROKE);
        this.f13414e.setStrokeCap(Paint.Cap.ROUND);
        this.f13414e.setStrokeWidth(this.f13416g);
        Paint paint2 = new Paint();
        this.f13415f = paint2;
        paint2.setAntiAlias(true);
        this.f13415f.setDither(true);
        this.f13415f.setStyle(Paint.Style.STROKE);
        this.f13415f.setStrokeCap(Paint.Cap.ROUND);
        this.f13415f.setStrokeWidth(this.f13416g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13417h >= 0) {
            RectF rectF = this.i;
            float f2 = this.f13416g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f13416g;
            this.i.bottom = getHeight() - this.f13416g;
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.f13415f);
            canvas.drawArc(this.i, -90.0f, (this.f13417h / 100) * 360.0f, false, this.f13414e);
        }
    }

    public void setCircleBackgroundColor(int i) {
        this.f13415f.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.f13414e.setColor(i);
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f13417h = i;
        postInvalidate();
    }

    public void setWidth(int i) {
        float f2 = i;
        this.f13416g = f2;
        this.f13415f.setStrokeWidth(f2);
        this.f13414e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13416g = 5.0f;
        a();
    }
}
