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
    private int eim;
    private GestureDetector gestureDetector;
    int gkA;
    private Paint gkB;
    private RectF gkC;
    private RectF gkD;
    private a gkE;
    private int gkF;
    private GestureDetector.SimpleOnGestureListener gkw;
    private int gkx;
    int gky;
    int gkz;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.gkD.left;
        rect.top = (int) this.gkD.top;
        rect.right = (int) this.gkD.right;
        rect.bottom = (int) this.gkD.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.gkw = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gkx = -1;
        this.gky = 20;
        this.gkz = 100;
        this.gkA = 6;
        this.eim = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gkB = new Paint(1);
        this.gkC = new RectF();
        this.gkD = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gkB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gkF = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkw = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gkx = -1;
        this.gky = 20;
        this.gkz = 100;
        this.gkA = 6;
        this.eim = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gkB = new Paint(1);
        this.gkC = new RectF();
        this.gkD = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gkB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gkF = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkw = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gkx = -1;
        this.gky = 20;
        this.gkz = 100;
        this.gkA = 6;
        this.eim = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gkB = new Paint(1);
        this.gkC = new RectF();
        this.gkD = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gkB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gkF = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.gkE = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.gkw);
        this.gkz = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.gkA = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bD(i, i2);
    }

    private void bD(int i, int i2) {
        if (this.gkF == 1) {
            this.gkD.left = (int) (i * 0.05d);
            this.gkD.top = (int) (i2 * 0.25d);
        } else {
            this.gkD.left = (int) (i * 0.2d);
            this.gkD.top = (int) (i2 * 0.2d);
        }
        this.gkD.right = i - this.gkD.left;
        this.gkD.bottom = i2 - this.gkD.top;
    }

    public void setTypeWide() {
        this.gkF = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (f > 0.0f) {
            if (this.gkD.left - f < this.gky) {
                f = this.gkD.left - this.gky;
            }
        } else if (this.gkD.right - f > getWidth() - this.gky) {
            f = (this.gkD.right - getWidth()) + this.gky;
        }
        if (f2 > 0.0f) {
            if (this.gkD.top - f2 < this.gky) {
                f2 = this.gkD.top - this.gky;
            }
        } else if (this.gkD.bottom - f2 > getHeight() - this.gky) {
            f2 = (this.gkD.bottom - getHeight()) + this.gky;
        }
        this.gkD.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.eim);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.gkD, this.paint);
        canvas.drawRect(this.gkD, this.gkB);
        G(canvas);
    }

    private void G(Canvas canvas) {
        this.paint.setStrokeWidth(this.gkA);
        a(canvas, this.gkD.left - (this.gkA / 2), this.gkD.top, this.gkz, 0);
        a(canvas, this.gkD.left, this.gkD.top, 0, this.gkz);
        a(canvas, this.gkD.right + (this.gkA / 2), this.gkD.top, -this.gkz, 0);
        a(canvas, this.gkD.right, this.gkD.top, 0, this.gkz);
        a(canvas, this.gkD.right, this.gkD.bottom, 0, -this.gkz);
        a(canvas, this.gkD.right + (this.gkA / 2), this.gkD.bottom, -this.gkz, 0);
        a(canvas, this.gkD.left - (this.gkA / 2), this.gkD.bottom, this.gkz, 0);
        a(canvas, this.gkD.left, this.gkD.bottom, 0, -this.gkz);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean A = A(motionEvent);
        RectF rectF = new RectF(this.gkD.left - 60.0f, this.gkD.top - 60.0f, this.gkD.right + 60.0f, 60.0f + this.gkD.bottom);
        if (!A && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return A;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean A(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.gkz;
                this.gkC.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.gkC.contains(this.gkD.left, this.gkD.top)) {
                    this.gkx = 1;
                    return true;
                } else if (this.gkC.contains(this.gkD.right, this.gkD.top)) {
                    this.gkx = 2;
                    return true;
                } else if (this.gkC.contains(this.gkD.right, this.gkD.bottom)) {
                    this.gkx = 3;
                    return true;
                } else if (this.gkC.contains(this.gkD.left, this.gkD.bottom)) {
                    this.gkx = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.gkx = -1;
                break;
            case 2:
                return B(motionEvent);
        }
        return false;
    }

    private boolean B(MotionEvent motionEvent) {
        switch (this.gkx) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.gkD.right, this.gkD.bottom);
                return true;
            case 2:
                f(this.gkD.left, motionEvent.getY(), motionEvent.getX(), this.gkD.bottom);
                return true;
            case 3:
                f(this.gkD.left, this.gkD.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.gkD.top, this.gkD.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.gkD.top;
            f4 = this.gkD.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.gkD.left;
            f3 = this.gkD.right;
        }
        this.gkD.set(Math.max(this.gky, f), Math.max(this.gky, f2), Math.min(getWidth() - this.gky, f3), Math.min(getHeight() - this.gky, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.gkz;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.gkz;
    }
}
