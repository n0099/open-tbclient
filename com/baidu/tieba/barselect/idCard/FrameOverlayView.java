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
    private GestureDetector.SimpleOnGestureListener fFR;
    private int fFS;
    int fFT;
    int fFU;
    int fFV;
    private Paint fFW;
    private RectF fFX;
    private RectF fFY;
    private a fFZ;
    private int fGa;
    private GestureDetector gestureDetector;
    private int maskColor;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.fFY.left;
        rect.top = (int) this.fFY.top;
        rect.right = (int) this.fFY.right;
        rect.bottom = (int) this.fFY.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.fFR = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fFS = -1;
        this.fFT = 20;
        this.fFU = 100;
        this.fFV = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFW = new Paint(1);
        this.fFX = new RectF();
        this.fFY = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fGa = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFR = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fFS = -1;
        this.fFT = 20;
        this.fFU = 100;
        this.fFV = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFW = new Paint(1);
        this.fFX = new RectF();
        this.fFY = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fGa = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFR = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fFS = -1;
        this.fFT = 20;
        this.fFU = 100;
        this.fFV = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFW = new Paint(1);
        this.fFX = new RectF();
        this.fFY = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fGa = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.fFZ = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.fFR);
        this.fFU = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.fFV = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        by(i, i2);
    }

    private void by(int i, int i2) {
        if (this.fGa == 1) {
            this.fFY.left = (int) (i * 0.05d);
            this.fFY.top = (int) (i2 * 0.25d);
        } else {
            this.fFY.left = (int) (i * 0.2d);
            this.fFY.top = (int) (i2 * 0.2d);
        }
        this.fFY.right = i - this.fFY.left;
        this.fFY.bottom = i2 - this.fFY.top;
    }

    public void setTypeWide() {
        this.fGa = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(float f, float f2) {
        if (f > 0.0f) {
            if (this.fFY.left - f < this.fFT) {
                f = this.fFY.left - this.fFT;
            }
        } else if (this.fFY.right - f > getWidth() - this.fFT) {
            f = (this.fFY.right - getWidth()) + this.fFT;
        }
        if (f2 > 0.0f) {
            if (this.fFY.top - f2 < this.fFT) {
                f2 = this.fFY.top - this.fFT;
            }
        } else if (this.fFY.bottom - f2 > getHeight() - this.fFT) {
            f2 = (this.fFY.bottom - getHeight()) + this.fFT;
        }
        this.fFY.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.maskColor);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.fFY, this.paint);
        canvas.drawRect(this.fFY, this.fFW);
        F(canvas);
    }

    private void F(Canvas canvas) {
        this.paint.setStrokeWidth(this.fFV);
        a(canvas, this.fFY.left - (this.fFV / 2), this.fFY.top, this.fFU, 0);
        a(canvas, this.fFY.left, this.fFY.top, 0, this.fFU);
        a(canvas, this.fFY.right + (this.fFV / 2), this.fFY.top, -this.fFU, 0);
        a(canvas, this.fFY.right, this.fFY.top, 0, this.fFU);
        a(canvas, this.fFY.right, this.fFY.bottom, 0, -this.fFU);
        a(canvas, this.fFY.right + (this.fFV / 2), this.fFY.bottom, -this.fFU, 0);
        a(canvas, this.fFY.left - (this.fFV / 2), this.fFY.bottom, this.fFU, 0);
        a(canvas, this.fFY.left, this.fFY.bottom, 0, -this.fFU);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean B = B(motionEvent);
        RectF rectF = new RectF(this.fFY.left - 60.0f, this.fFY.top - 60.0f, this.fFY.right + 60.0f, 60.0f + this.fFY.bottom);
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
                float f = this.fFU;
                this.fFX.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.fFX.contains(this.fFY.left, this.fFY.top)) {
                    this.fFS = 1;
                    return true;
                } else if (this.fFX.contains(this.fFY.right, this.fFY.top)) {
                    this.fFS = 2;
                    return true;
                } else if (this.fFX.contains(this.fFY.right, this.fFY.bottom)) {
                    this.fFS = 3;
                    return true;
                } else if (this.fFX.contains(this.fFY.left, this.fFY.bottom)) {
                    this.fFS = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.fFS = -1;
                break;
            case 2:
                return C(motionEvent);
        }
        return false;
    }

    private boolean C(MotionEvent motionEvent) {
        switch (this.fFS) {
            case 1:
                i(motionEvent.getX(), motionEvent.getY(), this.fFY.right, this.fFY.bottom);
                return true;
            case 2:
                i(this.fFY.left, motionEvent.getY(), motionEvent.getX(), this.fFY.bottom);
                return true;
            case 3:
                i(this.fFY.left, this.fFY.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                i(motionEvent.getX(), this.fFY.top, this.fFY.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void i(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.fFY.top;
            f4 = this.fFY.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.fFY.left;
            f3 = this.fFY.right;
        }
        this.fFY.set(Math.max(this.fFT, f), Math.max(this.fFT, f2), Math.min(getWidth() - this.fFT, f3), Math.min(getHeight() - this.fFT, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.fFU;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.fFU;
    }
}
