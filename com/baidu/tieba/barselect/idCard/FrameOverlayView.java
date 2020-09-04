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
/* loaded from: classes15.dex */
public class FrameOverlayView extends View {
    private int eXi;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener heS;
    private int heT;
    int heU;
    int heV;
    int heW;
    private Paint heX;
    private RectF heY;
    private RectF heZ;
    private a hfa;
    private int hfb;
    private Paint paint;

    /* loaded from: classes15.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.heZ.left;
        rect.top = (int) this.heZ.top;
        rect.right = (int) this.heZ.right;
        rect.bottom = (int) this.heZ.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.heS = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.z(f, f2);
                return true;
            }
        };
        this.heT = -1;
        this.heU = 20;
        this.heV = 100;
        this.heW = 6;
        this.eXi = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.heX = new Paint(1);
        this.heY = new RectF();
        this.heZ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.heX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hfb = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heS = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.z(f, f2);
                return true;
            }
        };
        this.heT = -1;
        this.heU = 20;
        this.heV = 100;
        this.heW = 6;
        this.eXi = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.heX = new Paint(1);
        this.heY = new RectF();
        this.heZ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.heX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hfb = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.heS = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.z(f, f2);
                return true;
            }
        };
        this.heT = -1;
        this.heU = 20;
        this.heV = 100;
        this.heW = 6;
        this.eXi = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.heX = new Paint(1);
        this.heY = new RectF();
        this.heZ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.heX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hfb = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.hfa = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.heS);
        this.heV = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.heW = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bW(i, i2);
    }

    private void bW(int i, int i2) {
        if (this.hfb == 1) {
            this.heZ.left = (int) (i * 0.05d);
            this.heZ.top = (int) (i2 * 0.25d);
        } else {
            this.heZ.left = (int) (i * 0.2d);
            this.heZ.top = (int) (i2 * 0.2d);
        }
        this.heZ.right = i - this.heZ.left;
        this.heZ.bottom = i2 - this.heZ.top;
    }

    public void setTypeWide() {
        this.hfb = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(float f, float f2) {
        if (f > 0.0f) {
            if (this.heZ.left - f < this.heU) {
                f = this.heZ.left - this.heU;
            }
        } else if (this.heZ.right - f > getWidth() - this.heU) {
            f = (this.heZ.right - getWidth()) + this.heU;
        }
        if (f2 > 0.0f) {
            if (this.heZ.top - f2 < this.heU) {
                f2 = this.heZ.top - this.heU;
            }
        } else if (this.heZ.bottom - f2 > getHeight() - this.heU) {
            f2 = (this.heZ.bottom - getHeight()) + this.heU;
        }
        this.heZ.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.eXi);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.heZ, this.paint);
        canvas.drawRect(this.heZ, this.heX);
        P(canvas);
    }

    private void P(Canvas canvas) {
        this.paint.setStrokeWidth(this.heW);
        a(canvas, this.heZ.left - (this.heW / 2), this.heZ.top, this.heV, 0);
        a(canvas, this.heZ.left, this.heZ.top, 0, this.heV);
        a(canvas, this.heZ.right + (this.heW / 2), this.heZ.top, -this.heV, 0);
        a(canvas, this.heZ.right, this.heZ.top, 0, this.heV);
        a(canvas, this.heZ.right, this.heZ.bottom, 0, -this.heV);
        a(canvas, this.heZ.right + (this.heW / 2), this.heZ.bottom, -this.heV, 0);
        a(canvas, this.heZ.left - (this.heW / 2), this.heZ.bottom, this.heV, 0);
        a(canvas, this.heZ.left, this.heZ.bottom, 0, -this.heV);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean W = W(motionEvent);
        RectF rectF = new RectF(this.heZ.left - 60.0f, this.heZ.top - 60.0f, this.heZ.right + 60.0f, 60.0f + this.heZ.bottom);
        if (!W && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return W;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean W(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.heV;
                this.heY.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.heY.contains(this.heZ.left, this.heZ.top)) {
                    this.heT = 1;
                    return true;
                } else if (this.heY.contains(this.heZ.right, this.heZ.top)) {
                    this.heT = 2;
                    return true;
                } else if (this.heY.contains(this.heZ.right, this.heZ.bottom)) {
                    this.heT = 3;
                    return true;
                } else if (this.heY.contains(this.heZ.left, this.heZ.bottom)) {
                    this.heT = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.heT = -1;
                break;
            case 2:
                return X(motionEvent);
        }
        return false;
    }

    private boolean X(MotionEvent motionEvent) {
        switch (this.heT) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.heZ.right, this.heZ.bottom);
                return true;
            case 2:
                f(this.heZ.left, motionEvent.getY(), motionEvent.getX(), this.heZ.bottom);
                return true;
            case 3:
                f(this.heZ.left, this.heZ.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.heZ.top, this.heZ.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.heZ.top;
            f4 = this.heZ.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.heZ.left;
            f3 = this.heZ.right;
        }
        this.heZ.set(Math.max(this.heU, f), Math.max(this.heU, f2), Math.min(getWidth() - this.heU, f3), Math.min(getHeight() - this.heU, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.heV;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.heV;
    }
}
