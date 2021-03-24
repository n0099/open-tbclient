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
    public Paint f13744e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f13745f;

    /* renamed from: g  reason: collision with root package name */
    public float f13746g;

    /* renamed from: h  reason: collision with root package name */
    public int f13747h;
    public RectF i;

    public CircleProgressView(Context context) {
        super(context);
        this.f13746g = 5.0f;
        a();
    }

    public final void a() {
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.f13744e = paint;
        paint.setAntiAlias(true);
        this.f13744e.setDither(true);
        this.f13744e.setStyle(Paint.Style.STROKE);
        this.f13744e.setStrokeCap(Paint.Cap.ROUND);
        this.f13744e.setStrokeWidth(this.f13746g);
        Paint paint2 = new Paint();
        this.f13745f = paint2;
        paint2.setAntiAlias(true);
        this.f13745f.setDither(true);
        this.f13745f.setStyle(Paint.Style.STROKE);
        this.f13745f.setStrokeCap(Paint.Cap.ROUND);
        this.f13745f.setStrokeWidth(this.f13746g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13747h >= 0) {
            RectF rectF = this.i;
            float f2 = this.f13746g;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - this.f13746g;
            this.i.bottom = getHeight() - this.f13746g;
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.f13745f);
            canvas.drawArc(this.i, -90.0f, (this.f13747h / 100) * 360.0f, false, this.f13744e);
        }
    }

    public void setCircleBackgroundColor(int i) {
        this.f13745f.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.f13744e.setColor(i);
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f13747h = i;
        postInvalidate();
    }

    public void setWidth(int i) {
        float f2 = i;
        this.f13746g = f2;
        this.f13745f.setStrokeWidth(f2);
        this.f13744e.setStrokeWidth(f2);
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13746g = 5.0f;
        a();
    }
}
