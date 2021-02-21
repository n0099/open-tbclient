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
/* loaded from: classes8.dex */
public class FrameOverlayView extends View {
    private int fOZ;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener ism;
    private int isn;
    int iso;
    int isp;
    private Paint isq;
    private RectF isr;
    private RectF iss;
    private a ist;
    private int isu;
    int margin;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.iss.left;
        rect.top = (int) this.iss.top;
        rect.right = (int) this.iss.right;
        rect.bottom = (int) this.iss.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.ism = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.isn = -1;
        this.margin = 20;
        this.iso = 100;
        this.isp = 6;
        this.fOZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.isq = new Paint(1);
        this.isr = new RectF();
        this.iss = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.isq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.isu = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ism = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.isn = -1;
        this.margin = 20;
        this.iso = 100;
        this.isp = 6;
        this.fOZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.isq = new Paint(1);
        this.isr = new RectF();
        this.iss = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.isq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.isu = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ism = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.isn = -1;
        this.margin = 20;
        this.iso = 100;
        this.isp = 6;
        this.fOZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.isq = new Paint(1);
        this.isr = new RectF();
        this.iss = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.isq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.isu = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.ist = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.ism);
        this.iso = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.isp = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ce(i, i2);
    }

    private void ce(int i, int i2) {
        if (this.isu == 1) {
            this.iss.left = (int) (i * 0.05d);
            this.iss.top = (int) (i2 * 0.25d);
        } else {
            this.iss.left = (int) (i * 0.2d);
            this.iss.top = (int) (i2 * 0.2d);
        }
        this.iss.right = i - this.iss.left;
        this.iss.bottom = i2 - this.iss.top;
    }

    public void setTypeWide() {
        this.isu = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(float f, float f2) {
        if (f > 0.0f) {
            if (this.iss.left - f < this.margin) {
                f = this.iss.left - this.margin;
            }
        } else if (this.iss.right - f > getWidth() - this.margin) {
            f = (this.iss.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.iss.top - f2 < this.margin) {
                f2 = this.iss.top - this.margin;
            }
        } else if (this.iss.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.iss.bottom - getHeight()) + this.margin;
        }
        this.iss.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fOZ);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.iss, this.paint);
        canvas.drawRect(this.iss, this.isq);
        Z(canvas);
    }

    private void Z(Canvas canvas) {
        this.paint.setStrokeWidth(this.isp);
        a(canvas, this.iss.left - (this.isp / 2), this.iss.top, this.iso, 0);
        a(canvas, this.iss.left, this.iss.top, 0, this.iso);
        a(canvas, this.iss.right + (this.isp / 2), this.iss.top, -this.iso, 0);
        a(canvas, this.iss.right, this.iss.top, 0, this.iso);
        a(canvas, this.iss.right, this.iss.bottom, 0, -this.iso);
        a(canvas, this.iss.right + (this.isp / 2), this.iss.bottom, -this.iso, 0);
        a(canvas, this.iss.left - (this.isp / 2), this.iss.bottom, this.iso, 0);
        a(canvas, this.iss.left, this.iss.bottom, 0, -this.iso);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean Y = Y(motionEvent);
        RectF rectF = new RectF(this.iss.left - 60.0f, this.iss.top - 60.0f, this.iss.right + 60.0f, 60.0f + this.iss.bottom);
        if (!Y && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return Y;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean Y(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.iso;
                this.isr.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.isr.contains(this.iss.left, this.iss.top)) {
                    this.isn = 1;
                    return true;
                } else if (this.isr.contains(this.iss.right, this.iss.top)) {
                    this.isn = 2;
                    return true;
                } else if (this.isr.contains(this.iss.right, this.iss.bottom)) {
                    this.isn = 3;
                    return true;
                } else if (this.isr.contains(this.iss.left, this.iss.bottom)) {
                    this.isn = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.isn = -1;
                break;
            case 2:
                return Z(motionEvent);
        }
        return false;
    }

    private boolean Z(MotionEvent motionEvent) {
        switch (this.isn) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.iss.right, this.iss.bottom);
                return true;
            case 2:
                f(this.iss.left, motionEvent.getY(), motionEvent.getX(), this.iss.bottom);
                return true;
            case 3:
                f(this.iss.left, this.iss.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.iss.top, this.iss.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.iss.top;
            f4 = this.iss.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.iss.left;
            f3 = this.iss.right;
        }
        this.iss.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.iso;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.iso;
    }
}
