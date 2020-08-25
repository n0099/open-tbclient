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
    private int eXe;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener heO;
    private int heP;
    int heQ;
    int heR;
    int heS;
    private Paint heT;
    private RectF heU;
    private RectF heV;
    private a heW;
    private int heX;
    private Paint paint;

    /* loaded from: classes15.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.heV.left;
        rect.top = (int) this.heV.top;
        rect.right = (int) this.heV.right;
        rect.bottom = (int) this.heV.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.heO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.z(f, f2);
                return true;
            }
        };
        this.heP = -1;
        this.heQ = 20;
        this.heR = 100;
        this.heS = 6;
        this.eXe = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.heT = new Paint(1);
        this.heU = new RectF();
        this.heV = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.heT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.heX = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.z(f, f2);
                return true;
            }
        };
        this.heP = -1;
        this.heQ = 20;
        this.heR = 100;
        this.heS = 6;
        this.eXe = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.heT = new Paint(1);
        this.heU = new RectF();
        this.heV = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.heT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.heX = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.heO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.z(f, f2);
                return true;
            }
        };
        this.heP = -1;
        this.heQ = 20;
        this.heR = 100;
        this.heS = 6;
        this.eXe = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.heT = new Paint(1);
        this.heU = new RectF();
        this.heV = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.heT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.heX = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.heW = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.heO);
        this.heR = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.heS = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bW(i, i2);
    }

    private void bW(int i, int i2) {
        if (this.heX == 1) {
            this.heV.left = (int) (i * 0.05d);
            this.heV.top = (int) (i2 * 0.25d);
        } else {
            this.heV.left = (int) (i * 0.2d);
            this.heV.top = (int) (i2 * 0.2d);
        }
        this.heV.right = i - this.heV.left;
        this.heV.bottom = i2 - this.heV.top;
    }

    public void setTypeWide() {
        this.heX = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(float f, float f2) {
        if (f > 0.0f) {
            if (this.heV.left - f < this.heQ) {
                f = this.heV.left - this.heQ;
            }
        } else if (this.heV.right - f > getWidth() - this.heQ) {
            f = (this.heV.right - getWidth()) + this.heQ;
        }
        if (f2 > 0.0f) {
            if (this.heV.top - f2 < this.heQ) {
                f2 = this.heV.top - this.heQ;
            }
        } else if (this.heV.bottom - f2 > getHeight() - this.heQ) {
            f2 = (this.heV.bottom - getHeight()) + this.heQ;
        }
        this.heV.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.eXe);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.heV, this.paint);
        canvas.drawRect(this.heV, this.heT);
        P(canvas);
    }

    private void P(Canvas canvas) {
        this.paint.setStrokeWidth(this.heS);
        a(canvas, this.heV.left - (this.heS / 2), this.heV.top, this.heR, 0);
        a(canvas, this.heV.left, this.heV.top, 0, this.heR);
        a(canvas, this.heV.right + (this.heS / 2), this.heV.top, -this.heR, 0);
        a(canvas, this.heV.right, this.heV.top, 0, this.heR);
        a(canvas, this.heV.right, this.heV.bottom, 0, -this.heR);
        a(canvas, this.heV.right + (this.heS / 2), this.heV.bottom, -this.heR, 0);
        a(canvas, this.heV.left - (this.heS / 2), this.heV.bottom, this.heR, 0);
        a(canvas, this.heV.left, this.heV.bottom, 0, -this.heR);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean W = W(motionEvent);
        RectF rectF = new RectF(this.heV.left - 60.0f, this.heV.top - 60.0f, this.heV.right + 60.0f, 60.0f + this.heV.bottom);
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
                float f = this.heR;
                this.heU.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.heU.contains(this.heV.left, this.heV.top)) {
                    this.heP = 1;
                    return true;
                } else if (this.heU.contains(this.heV.right, this.heV.top)) {
                    this.heP = 2;
                    return true;
                } else if (this.heU.contains(this.heV.right, this.heV.bottom)) {
                    this.heP = 3;
                    return true;
                } else if (this.heU.contains(this.heV.left, this.heV.bottom)) {
                    this.heP = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.heP = -1;
                break;
            case 2:
                return X(motionEvent);
        }
        return false;
    }

    private boolean X(MotionEvent motionEvent) {
        switch (this.heP) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.heV.right, this.heV.bottom);
                return true;
            case 2:
                f(this.heV.left, motionEvent.getY(), motionEvent.getX(), this.heV.bottom);
                return true;
            case 3:
                f(this.heV.left, this.heV.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.heV.top, this.heV.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.heV.top;
            f4 = this.heV.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.heV.left;
            f3 = this.heV.right;
        }
        this.heV.set(Math.max(this.heQ, f), Math.max(this.heQ, f2), Math.min(getWidth() - this.heQ, f3), Math.min(getHeight() - this.heQ, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.heR;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.heR;
    }
}
