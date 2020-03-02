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
    private GestureDetector.SimpleOnGestureListener fEW;
    private int fEX;
    int fEY;
    int fEZ;
    int fFa;
    private Paint fFb;
    private RectF fFc;
    private RectF fFd;
    private a fFe;
    private int fFf;
    private GestureDetector gestureDetector;
    private int maskColor;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.fFd.left;
        rect.top = (int) this.fFd.top;
        rect.right = (int) this.fFd.right;
        rect.bottom = (int) this.fFd.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.fEW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fEX = -1;
        this.fEY = 20;
        this.fEZ = 100;
        this.fFa = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFb = new Paint(1);
        this.fFc = new RectF();
        this.fFd = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFb.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFf = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fEX = -1;
        this.fEY = 20;
        this.fEZ = 100;
        this.fFa = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFb = new Paint(1);
        this.fFc = new RectF();
        this.fFd = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFb.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFf = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fEX = -1;
        this.fEY = 20;
        this.fEZ = 100;
        this.fFa = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFb = new Paint(1);
        this.fFc = new RectF();
        this.fFd = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFb.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFf = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.fFe = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.fEW);
        this.fEZ = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.fFa = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bx(i, i2);
    }

    private void bx(int i, int i2) {
        if (this.fFf == 1) {
            this.fFd.left = (int) (i * 0.05d);
            this.fFd.top = (int) (i2 * 0.25d);
        } else {
            this.fFd.left = (int) (i * 0.2d);
            this.fFd.top = (int) (i2 * 0.2d);
        }
        this.fFd.right = i - this.fFd.left;
        this.fFd.bottom = i2 - this.fFd.top;
    }

    public void setTypeWide() {
        this.fFf = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(float f, float f2) {
        if (f > 0.0f) {
            if (this.fFd.left - f < this.fEY) {
                f = this.fFd.left - this.fEY;
            }
        } else if (this.fFd.right - f > getWidth() - this.fEY) {
            f = (this.fFd.right - getWidth()) + this.fEY;
        }
        if (f2 > 0.0f) {
            if (this.fFd.top - f2 < this.fEY) {
                f2 = this.fFd.top - this.fEY;
            }
        } else if (this.fFd.bottom - f2 > getHeight() - this.fEY) {
            f2 = (this.fFd.bottom - getHeight()) + this.fEY;
        }
        this.fFd.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.maskColor);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.fFd, this.paint);
        canvas.drawRect(this.fFd, this.fFb);
        F(canvas);
    }

    private void F(Canvas canvas) {
        this.paint.setStrokeWidth(this.fFa);
        a(canvas, this.fFd.left - (this.fFa / 2), this.fFd.top, this.fEZ, 0);
        a(canvas, this.fFd.left, this.fFd.top, 0, this.fEZ);
        a(canvas, this.fFd.right + (this.fFa / 2), this.fFd.top, -this.fEZ, 0);
        a(canvas, this.fFd.right, this.fFd.top, 0, this.fEZ);
        a(canvas, this.fFd.right, this.fFd.bottom, 0, -this.fEZ);
        a(canvas, this.fFd.right + (this.fFa / 2), this.fFd.bottom, -this.fEZ, 0);
        a(canvas, this.fFd.left - (this.fFa / 2), this.fFd.bottom, this.fEZ, 0);
        a(canvas, this.fFd.left, this.fFd.bottom, 0, -this.fEZ);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean B = B(motionEvent);
        RectF rectF = new RectF(this.fFd.left - 60.0f, this.fFd.top - 60.0f, this.fFd.right + 60.0f, 60.0f + this.fFd.bottom);
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
                float f = this.fEZ;
                this.fFc.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.fFc.contains(this.fFd.left, this.fFd.top)) {
                    this.fEX = 1;
                    return true;
                } else if (this.fFc.contains(this.fFd.right, this.fFd.top)) {
                    this.fEX = 2;
                    return true;
                } else if (this.fFc.contains(this.fFd.right, this.fFd.bottom)) {
                    this.fEX = 3;
                    return true;
                } else if (this.fFc.contains(this.fFd.left, this.fFd.bottom)) {
                    this.fEX = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.fEX = -1;
                break;
            case 2:
                return C(motionEvent);
        }
        return false;
    }

    private boolean C(MotionEvent motionEvent) {
        switch (this.fEX) {
            case 1:
                i(motionEvent.getX(), motionEvent.getY(), this.fFd.right, this.fFd.bottom);
                return true;
            case 2:
                i(this.fFd.left, motionEvent.getY(), motionEvent.getX(), this.fFd.bottom);
                return true;
            case 3:
                i(this.fFd.left, this.fFd.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                i(motionEvent.getX(), this.fFd.top, this.fFd.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void i(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.fFd.top;
            f4 = this.fFd.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.fFd.left;
            f3 = this.fFd.right;
        }
        this.fFd.set(Math.max(this.fEY, f), Math.max(this.fEY, f2), Math.min(getWidth() - this.fEY, f3), Math.min(getHeight() - this.fEY, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.fEZ;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.fEZ;
    }
}
