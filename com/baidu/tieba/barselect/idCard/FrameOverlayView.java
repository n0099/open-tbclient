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
/* loaded from: classes20.dex */
public class FrameOverlayView extends View {
    private int eZZ;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener hlU;
    private int hlV;
    int hlW;
    int hlX;
    private Paint hlY;
    private RectF hlZ;
    private RectF hma;
    private a hmb;
    private int hmc;
    int margin;
    private Paint paint;

    /* loaded from: classes20.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.hma.left;
        rect.top = (int) this.hma.top;
        rect.right = (int) this.hma.right;
        rect.bottom = (int) this.hma.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.hlU = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.A(f, f2);
                return true;
            }
        };
        this.hlV = -1;
        this.margin = 20;
        this.hlW = 100;
        this.hlX = 6;
        this.eZZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hlY = new Paint(1);
        this.hlZ = new RectF();
        this.hma = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hlY.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hmc = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlU = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.A(f, f2);
                return true;
            }
        };
        this.hlV = -1;
        this.margin = 20;
        this.hlW = 100;
        this.hlX = 6;
        this.eZZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hlY = new Paint(1);
        this.hlZ = new RectF();
        this.hma = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hlY.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hmc = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlU = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.A(f, f2);
                return true;
            }
        };
        this.hlV = -1;
        this.margin = 20;
        this.hlW = 100;
        this.hlX = 6;
        this.eZZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hlY = new Paint(1);
        this.hlZ = new RectF();
        this.hma = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hlY.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hmc = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.hmb = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.hlU);
        this.hlW = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.hlX = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bZ(i, i2);
    }

    private void bZ(int i, int i2) {
        if (this.hmc == 1) {
            this.hma.left = (int) (i * 0.05d);
            this.hma.top = (int) (i2 * 0.25d);
        } else {
            this.hma.left = (int) (i * 0.2d);
            this.hma.top = (int) (i2 * 0.2d);
        }
        this.hma.right = i - this.hma.left;
        this.hma.bottom = i2 - this.hma.top;
    }

    public void setTypeWide() {
        this.hmc = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(float f, float f2) {
        if (f > 0.0f) {
            if (this.hma.left - f < this.margin) {
                f = this.hma.left - this.margin;
            }
        } else if (this.hma.right - f > getWidth() - this.margin) {
            f = (this.hma.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.hma.top - f2 < this.margin) {
                f2 = this.hma.top - this.margin;
            }
        } else if (this.hma.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.hma.bottom - getHeight()) + this.margin;
        }
        this.hma.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.eZZ);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.hma, this.paint);
        canvas.drawRect(this.hma, this.hlY);
        P(canvas);
    }

    private void P(Canvas canvas) {
        this.paint.setStrokeWidth(this.hlX);
        a(canvas, this.hma.left - (this.hlX / 2), this.hma.top, this.hlW, 0);
        a(canvas, this.hma.left, this.hma.top, 0, this.hlW);
        a(canvas, this.hma.right + (this.hlX / 2), this.hma.top, -this.hlW, 0);
        a(canvas, this.hma.right, this.hma.top, 0, this.hlW);
        a(canvas, this.hma.right, this.hma.bottom, 0, -this.hlW);
        a(canvas, this.hma.right + (this.hlX / 2), this.hma.bottom, -this.hlW, 0);
        a(canvas, this.hma.left - (this.hlX / 2), this.hma.bottom, this.hlW, 0);
        a(canvas, this.hma.left, this.hma.bottom, 0, -this.hlW);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean W = W(motionEvent);
        RectF rectF = new RectF(this.hma.left - 60.0f, this.hma.top - 60.0f, this.hma.right + 60.0f, 60.0f + this.hma.bottom);
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
                float f = this.hlW;
                this.hlZ.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.hlZ.contains(this.hma.left, this.hma.top)) {
                    this.hlV = 1;
                    return true;
                } else if (this.hlZ.contains(this.hma.right, this.hma.top)) {
                    this.hlV = 2;
                    return true;
                } else if (this.hlZ.contains(this.hma.right, this.hma.bottom)) {
                    this.hlV = 3;
                    return true;
                } else if (this.hlZ.contains(this.hma.left, this.hma.bottom)) {
                    this.hlV = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.hlV = -1;
                break;
            case 2:
                return X(motionEvent);
        }
        return false;
    }

    private boolean X(MotionEvent motionEvent) {
        switch (this.hlV) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.hma.right, this.hma.bottom);
                return true;
            case 2:
                f(this.hma.left, motionEvent.getY(), motionEvent.getX(), this.hma.bottom);
                return true;
            case 3:
                f(this.hma.left, this.hma.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.hma.top, this.hma.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.hma.top;
            f4 = this.hma.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.hma.left;
            f3 = this.hma.right;
        }
        this.hma.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.hlW;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.hlW;
    }
}
