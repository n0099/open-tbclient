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
    private GestureDetector.SimpleOnGestureListener fEU;
    private int fEV;
    int fEW;
    int fEX;
    int fEY;
    private Paint fEZ;
    private RectF fFa;
    private RectF fFb;
    private a fFc;
    private int fFd;
    private GestureDetector gestureDetector;
    private int maskColor;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.fFb.left;
        rect.top = (int) this.fFb.top;
        rect.right = (int) this.fFb.right;
        rect.bottom = (int) this.fFb.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.fEU = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fEV = -1;
        this.fEW = 20;
        this.fEX = 100;
        this.fEY = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fEZ = new Paint(1);
        this.fFa = new RectF();
        this.fFb = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fEZ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFd = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEU = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fEV = -1;
        this.fEW = 20;
        this.fEX = 100;
        this.fEY = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fEZ = new Paint(1);
        this.fFa = new RectF();
        this.fFb = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fEZ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFd = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEU = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fEV = -1;
        this.fEW = 20;
        this.fEX = 100;
        this.fEY = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fEZ = new Paint(1);
        this.fFa = new RectF();
        this.fFb = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fEZ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFd = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.fFc = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.fEU);
        this.fEX = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.fEY = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bx(i, i2);
    }

    private void bx(int i, int i2) {
        if (this.fFd == 1) {
            this.fFb.left = (int) (i * 0.05d);
            this.fFb.top = (int) (i2 * 0.25d);
        } else {
            this.fFb.left = (int) (i * 0.2d);
            this.fFb.top = (int) (i2 * 0.2d);
        }
        this.fFb.right = i - this.fFb.left;
        this.fFb.bottom = i2 - this.fFb.top;
    }

    public void setTypeWide() {
        this.fFd = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(float f, float f2) {
        if (f > 0.0f) {
            if (this.fFb.left - f < this.fEW) {
                f = this.fFb.left - this.fEW;
            }
        } else if (this.fFb.right - f > getWidth() - this.fEW) {
            f = (this.fFb.right - getWidth()) + this.fEW;
        }
        if (f2 > 0.0f) {
            if (this.fFb.top - f2 < this.fEW) {
                f2 = this.fFb.top - this.fEW;
            }
        } else if (this.fFb.bottom - f2 > getHeight() - this.fEW) {
            f2 = (this.fFb.bottom - getHeight()) + this.fEW;
        }
        this.fFb.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.maskColor);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.fFb, this.paint);
        canvas.drawRect(this.fFb, this.fEZ);
        F(canvas);
    }

    private void F(Canvas canvas) {
        this.paint.setStrokeWidth(this.fEY);
        a(canvas, this.fFb.left - (this.fEY / 2), this.fFb.top, this.fEX, 0);
        a(canvas, this.fFb.left, this.fFb.top, 0, this.fEX);
        a(canvas, this.fFb.right + (this.fEY / 2), this.fFb.top, -this.fEX, 0);
        a(canvas, this.fFb.right, this.fFb.top, 0, this.fEX);
        a(canvas, this.fFb.right, this.fFb.bottom, 0, -this.fEX);
        a(canvas, this.fFb.right + (this.fEY / 2), this.fFb.bottom, -this.fEX, 0);
        a(canvas, this.fFb.left - (this.fEY / 2), this.fFb.bottom, this.fEX, 0);
        a(canvas, this.fFb.left, this.fFb.bottom, 0, -this.fEX);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean B = B(motionEvent);
        RectF rectF = new RectF(this.fFb.left - 60.0f, this.fFb.top - 60.0f, this.fFb.right + 60.0f, 60.0f + this.fFb.bottom);
        if (!B && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return B;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean B(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.fEX;
                this.fFa.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.fFa.contains(this.fFb.left, this.fFb.top)) {
                    this.fEV = 1;
                    return true;
                } else if (this.fFa.contains(this.fFb.right, this.fFb.top)) {
                    this.fEV = 2;
                    return true;
                } else if (this.fFa.contains(this.fFb.right, this.fFb.bottom)) {
                    this.fEV = 3;
                    return true;
                } else if (this.fFa.contains(this.fFb.left, this.fFb.bottom)) {
                    this.fEV = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.fEV = -1;
                break;
            case 2:
                return C(motionEvent);
        }
        return false;
    }

    private boolean C(MotionEvent motionEvent) {
        switch (this.fEV) {
            case 1:
                i(motionEvent.getX(), motionEvent.getY(), this.fFb.right, this.fFb.bottom);
                return true;
            case 2:
                i(this.fFb.left, motionEvent.getY(), motionEvent.getX(), this.fFb.bottom);
                return true;
            case 3:
                i(this.fFb.left, this.fFb.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                i(motionEvent.getX(), this.fFb.top, this.fFb.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void i(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.fFb.top;
            f4 = this.fFb.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.fFb.left;
            f3 = this.fFb.right;
        }
        this.fFb.set(Math.max(this.fEW, f), Math.max(this.fEW, f2), Math.min(getWidth() - this.fEW, f3), Math.min(getHeight() - this.fEW, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.fEX;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.fEX;
    }
}
