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
    public Paint f13745e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f13746f;

    /* renamed from: g  reason: collision with root package name */
    public float f13747g;

    /* renamed from: h  reason: collision with root package name */
    public int f13748h;
    public RectF i;

    public CircleProgressView(Context context) {
        super(context);
        this.f13747g = 5.0f;
        a();
    }

    public final void a() {
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f13745e = paint;
        paint.setAntiAlias(true);
        this.f13745e.setDither(true);
        this.f13745e.setStyle(Paint.Style.STROKE);
        this.f13745e.setStrokeCap(Paint.Cap.ROUND);
        this.f13745e.setStrokeWidth(this.f13747g);
        Paint paint2 = new Paint();
        this.f13746f = paint2;
        paint2.setAntiAlias(true);
        this.f13746f.setDither(true);
        this.f13746f.setStyle(Paint.Style.STROKE);
        this.f13746f.setStrokeCap(Paint.Cap.ROUND);
        this.f13746f.setStrokeWidth(this.f13747g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13748h >= 0) {
            RectF rectF = this.i;
            float f2 = this.f13747g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f13747g;
            this.i.bottom = getHeight() - this.f13747g;
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.f13746f);
            canvas.drawArc(this.i, -90.0f, (this.f13748h / 100) * 360.0f, false, this.f13745e);
        }
    }

    public void setCircleBackgroundColor(int i) {
        this.f13746f.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.f13745e.setColor(i);
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f13748h = i;
        postInvalidate();
    }

    public void setWidth(int i) {
        float f2 = i;
        this.f13747g = f2;
        this.f13746f.setStrokeWidth(f2);
        this.f13745e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13747g = 5.0f;
        a();
    }
}
