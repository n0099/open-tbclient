package com.baidu.tieba.frs.gamepaltform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes4.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f16238e;

    /* renamed from: f  reason: collision with root package name */
    public float f16239f;

    /* renamed from: g  reason: collision with root package name */
    public float f16240g;

    /* renamed from: h  reason: collision with root package name */
    public float f16241h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f16242i;
    public Paint j;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        if (this.f16240g > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            float f2 = height;
            path.moveTo(0.0f, f2 - this.f16240g);
            path.lineTo(0.0f, f2);
            path.lineTo(this.f16240g, f2);
            float f3 = this.f16240g;
            path.arcTo(new RectF(0.0f, f2 - (f3 * 2.0f), f3 * 2.0f, f2), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.f16242i);
        }
    }

    public final void b(Canvas canvas) {
        if (this.f16241h > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            float f2 = width;
            float f3 = height;
            path.moveTo(f2 - this.f16241h, f3);
            path.lineTo(f2, f3);
            path.lineTo(f2, f3 - this.f16241h);
            float f4 = this.f16241h;
            path.arcTo(new RectF(f2 - (f4 * 2.0f), f3 - (f4 * 2.0f), f2, f3), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.f16242i);
        }
    }

    public final void c(Canvas canvas) {
        if (this.f16238e > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.f16238e);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.f16238e, 0.0f);
            float f2 = this.f16238e;
            path.arcTo(new RectF(0.0f, 0.0f, f2 * 2.0f, f2 * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f16242i);
        }
    }

    public final void d(Canvas canvas) {
        if (this.f16239f > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            float f2 = width;
            path.moveTo(f2 - this.f16239f, 0.0f);
            path.lineTo(f2, 0.0f);
            path.lineTo(f2, this.f16239f);
            float f3 = this.f16239f;
            path.arcTo(new RectF(f2 - (f3 * 2.0f), 0.0f, f2, f3 * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f16242i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.j, 31);
        super.dispatchDraw(canvas);
        c(canvas);
        d(canvas);
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    public void setBottomLeftRadius(float f2) {
        this.f16240g = f2;
    }

    public void setBottomRightRadius(float f2) {
        this.f16241h = f2;
    }

    public void setRadius(float f2) {
        this.f16238e = f2;
        this.f16240g = f2;
        this.f16239f = f2;
        this.f16241h = f2;
        invalidate();
    }

    public void setTopLeftRadius(float f2) {
        this.f16238e = f2;
    }

    public void setTopRightRadius(float f2) {
        this.f16239f = f2;
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Paint paint = new Paint();
        this.f16242i = paint;
        paint.setColor(-1);
        this.f16242i.setAntiAlias(true);
        this.f16242i.setStyle(Paint.Style.FILL);
        this.f16242i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setXfermode(null);
    }
}
