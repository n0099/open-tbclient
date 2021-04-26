package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes4.dex */
public class FrameOverlayView extends View {

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f14934e;

    /* renamed from: f  reason: collision with root package name */
    public int f14935f;

    /* renamed from: g  reason: collision with root package name */
    public int f14936g;

    /* renamed from: h  reason: collision with root package name */
    public int f14937h;

    /* renamed from: i  reason: collision with root package name */
    public int f14938i;
    public int j;
    public Paint k;
    public Paint l;
    public GestureDetector m;
    public RectF n;
    public RectF o;
    public int p;

    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            FrameOverlayView.this.i(f2, f3);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.f14934e = new a();
        this.f14935f = -1;
        this.f14936g = 20;
        this.f14937h = 100;
        this.f14938i = 6;
        this.j = Color.argb(180, 0, 0, 0);
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.n = new RectF();
        this.o = new RectF();
        setLayerType(1, null);
        this.k.setColor(-1);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(6.0f);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.p = 0;
        f();
    }

    private float getMinimumFrameHeight() {
        return this.f14937h * 2.4f;
    }

    private float getMinimumFrameWidth() {
        return this.f14937h * 2.4f;
    }

    public final void b(Canvas canvas) {
        this.k.setStrokeWidth(this.f14938i);
        RectF rectF = this.o;
        c(canvas, rectF.left - (this.f14938i / 2), rectF.top, this.f14937h, 0);
        RectF rectF2 = this.o;
        c(canvas, rectF2.left, rectF2.top, 0, this.f14937h);
        RectF rectF3 = this.o;
        c(canvas, rectF3.right + (this.f14938i / 2), rectF3.top, -this.f14937h, 0);
        RectF rectF4 = this.o;
        c(canvas, rectF4.right, rectF4.top, 0, this.f14937h);
        RectF rectF5 = this.o;
        c(canvas, rectF5.right, rectF5.bottom, 0, -this.f14937h);
        RectF rectF6 = this.o;
        c(canvas, rectF6.right + (this.f14938i / 2), rectF6.bottom, -this.f14937h, 0);
        RectF rectF7 = this.o;
        c(canvas, rectF7.left - (this.f14938i / 2), rectF7.bottom, this.f14937h, 0);
        RectF rectF8 = this.o;
        c(canvas, rectF8.left, rectF8.bottom, 0, -this.f14937h);
    }

    public final void c(Canvas canvas, float f2, float f3, int i2, int i3) {
        canvas.drawLine(f2, f3, f2 + i2, f3 + i3, this.k);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r0 != 3) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    return e(motionEvent);
                }
            }
            this.f14935f = -1;
            return false;
        }
        float f2 = this.f14937h;
        this.n.set(motionEvent.getX() - f2, motionEvent.getY() - f2, motionEvent.getX() + f2, motionEvent.getY() + f2);
        RectF rectF = this.n;
        RectF rectF2 = this.o;
        if (rectF.contains(rectF2.left, rectF2.top)) {
            this.f14935f = 1;
            return true;
        }
        RectF rectF3 = this.n;
        RectF rectF4 = this.o;
        if (rectF3.contains(rectF4.right, rectF4.top)) {
            this.f14935f = 2;
            return true;
        }
        RectF rectF5 = this.n;
        RectF rectF6 = this.o;
        if (rectF5.contains(rectF6.right, rectF6.bottom)) {
            this.f14935f = 3;
            return true;
        }
        RectF rectF7 = this.n;
        RectF rectF8 = this.o;
        if (rectF7.contains(rectF8.left, rectF8.bottom)) {
            this.f14935f = 4;
            return true;
        }
        return false;
    }

    public final boolean e(MotionEvent motionEvent) {
        int i2 = this.f14935f;
        if (i2 == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            RectF rectF = this.o;
            h(x, y, rectF.right, rectF.bottom);
            return true;
        } else if (i2 == 2) {
            h(this.o.left, motionEvent.getY(), motionEvent.getX(), this.o.bottom);
            return true;
        } else if (i2 == 3) {
            RectF rectF2 = this.o;
            h(rectF2.left, rectF2.top, motionEvent.getX(), motionEvent.getY());
            return true;
        } else if (i2 != 4) {
            return false;
        } else {
            float x2 = motionEvent.getX();
            RectF rectF3 = this.o;
            h(x2, rectF3.top, rectF3.right, motionEvent.getY());
            return true;
        }
    }

    public final void f() {
        this.m = new GestureDetector(getContext(), this.f14934e);
        this.f14937h = d.a.j0.v.e.b.a(18);
        this.f14938i = d.a.j0.v.e.b.a(3);
    }

    public final void g(int i2, int i3) {
        if (this.p == 1) {
            RectF rectF = this.o;
            rectF.left = (int) (i2 * 0.05d);
            rectF.top = (int) (i3 * 0.25d);
        } else {
            RectF rectF2 = this.o;
            rectF2.left = (int) (i2 * 0.2d);
            rectF2.top = (int) (i3 * 0.2d);
        }
        RectF rectF3 = this.o;
        rectF3.right = i2 - rectF3.left;
        rectF3.bottom = i3 - rectF3.top;
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        RectF rectF = this.o;
        rect.left = (int) rectF.left;
        rect.top = (int) rectF.top;
        rect.right = (int) rectF.right;
        rect.bottom = (int) rectF.bottom;
        return rect;
    }

    public final void h(float f2, float f3, float f4, float f5) {
        if (f5 - f3 < getMinimumFrameHeight()) {
            RectF rectF = this.o;
            float f6 = rectF.top;
            f5 = rectF.bottom;
            f3 = f6;
        }
        if (f4 - f2 < getMinimumFrameWidth()) {
            RectF rectF2 = this.o;
            float f7 = rectF2.left;
            f4 = rectF2.right;
            f2 = f7;
        }
        this.o.set(Math.max(this.f14936g, f2), Math.max(this.f14936g, f3), Math.min(getWidth() - this.f14936g, f4), Math.min(getHeight() - this.f14936g, f5));
        invalidate();
    }

    public final void i(float f2, float f3) {
        if (f2 > 0.0f) {
            float f4 = this.o.left;
            int i2 = this.f14936g;
            if (f4 - f2 < i2) {
                f2 = f4 - i2;
            }
        } else if (this.o.right - f2 > getWidth() - this.f14936g) {
            f2 = (this.o.right - getWidth()) + this.f14936g;
        }
        if (f3 > 0.0f) {
            float f5 = this.o.top;
            int i3 = this.f14936g;
            if (f5 - f3 < i3) {
                f3 = f5 - i3;
            }
        } else if (this.o.bottom - f3 > getHeight() - this.f14936g) {
            f3 = (this.o.bottom - getHeight()) + this.f14936g;
        }
        this.o.offset(-f2, -f3);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.j);
        this.k.setStrokeWidth(d.a.j0.v.e.b.a(1));
        canvas.drawRect(this.o, this.k);
        canvas.drawRect(this.o, this.l);
        b(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        g(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean d2 = d(motionEvent);
        RectF rectF = this.o;
        RectF rectF2 = new RectF(rectF.left - 60.0f, rectF.top - 60.0f, rectF.right + 60.0f, rectF.bottom + 60.0f);
        if (d2 || !rectF2.contains(motionEvent.getX(), motionEvent.getY())) {
            return d2;
        }
        this.m.onTouchEvent(motionEvent);
        return true;
    }

    public void setOnFrameChangeListener(b bVar) {
    }

    public void setTypeWide() {
        this.p = 1;
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14934e = new a();
        this.f14935f = -1;
        this.f14936g = 20;
        this.f14937h = 100;
        this.f14938i = 6;
        this.j = Color.argb(180, 0, 0, 0);
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.n = new RectF();
        this.o = new RectF();
        setLayerType(1, null);
        this.k.setColor(-1);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(6.0f);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.p = 0;
        f();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14934e = new a();
        this.f14935f = -1;
        this.f14936g = 20;
        this.f14937h = 100;
        this.f14938i = 6;
        this.j = Color.argb(180, 0, 0, 0);
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.n = new RectF();
        this.o = new RectF();
        setLayerType(1, null);
        this.k.setColor(-1);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(6.0f);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.p = 0;
        f();
    }
}
