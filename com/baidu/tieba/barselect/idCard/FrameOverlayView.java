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
    private int eGc;
    private GestureDetector.SimpleOnGestureListener gMp;
    private int gMq;
    int gMr;
    int gMs;
    int gMt;
    private Paint gMu;
    private RectF gMv;
    private RectF gMw;
    private a gMx;
    private int gMy;
    private GestureDetector gestureDetector;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.gMw.left;
        rect.top = (int) this.gMw.top;
        rect.right = (int) this.gMw.right;
        rect.bottom = (int) this.gMw.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.gMp = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gMq = -1;
        this.gMr = 20;
        this.gMs = 100;
        this.gMt = 6;
        this.eGc = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gMu = new Paint(1);
        this.gMv = new RectF();
        this.gMw = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gMu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gMy = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gMp = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gMq = -1;
        this.gMr = 20;
        this.gMs = 100;
        this.gMt = 6;
        this.eGc = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gMu = new Paint(1);
        this.gMv = new RectF();
        this.gMw = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gMu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gMy = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gMp = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gMq = -1;
        this.gMr = 20;
        this.gMs = 100;
        this.gMt = 6;
        this.eGc = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gMu = new Paint(1);
        this.gMv = new RectF();
        this.gMw = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gMu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gMy = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.gMx = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.gMp);
        this.gMs = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.gMt = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bL(i, i2);
    }

    private void bL(int i, int i2) {
        if (this.gMy == 1) {
            this.gMw.left = (int) (i * 0.05d);
            this.gMw.top = (int) (i2 * 0.25d);
        } else {
            this.gMw.left = (int) (i * 0.2d);
            this.gMw.top = (int) (i2 * 0.2d);
        }
        this.gMw.right = i - this.gMw.left;
        this.gMw.bottom = i2 - this.gMw.top;
    }

    public void setTypeWide() {
        this.gMy = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (f > 0.0f) {
            if (this.gMw.left - f < this.gMr) {
                f = this.gMw.left - this.gMr;
            }
        } else if (this.gMw.right - f > getWidth() - this.gMr) {
            f = (this.gMw.right - getWidth()) + this.gMr;
        }
        if (f2 > 0.0f) {
            if (this.gMw.top - f2 < this.gMr) {
                f2 = this.gMw.top - this.gMr;
            }
        } else if (this.gMw.bottom - f2 > getHeight() - this.gMr) {
            f2 = (this.gMw.bottom - getHeight()) + this.gMr;
        }
        this.gMw.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.eGc);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.gMw, this.paint);
        canvas.drawRect(this.gMw, this.gMu);
        I(canvas);
    }

    private void I(Canvas canvas) {
        this.paint.setStrokeWidth(this.gMt);
        a(canvas, this.gMw.left - (this.gMt / 2), this.gMw.top, this.gMs, 0);
        a(canvas, this.gMw.left, this.gMw.top, 0, this.gMs);
        a(canvas, this.gMw.right + (this.gMt / 2), this.gMw.top, -this.gMs, 0);
        a(canvas, this.gMw.right, this.gMw.top, 0, this.gMs);
        a(canvas, this.gMw.right, this.gMw.bottom, 0, -this.gMs);
        a(canvas, this.gMw.right + (this.gMt / 2), this.gMw.bottom, -this.gMs, 0);
        a(canvas, this.gMw.left - (this.gMt / 2), this.gMw.bottom, this.gMs, 0);
        a(canvas, this.gMw.left, this.gMw.bottom, 0, -this.gMs);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean F = F(motionEvent);
        RectF rectF = new RectF(this.gMw.left - 60.0f, this.gMw.top - 60.0f, this.gMw.right + 60.0f, 60.0f + this.gMw.bottom);
        if (!F && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return F;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean F(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.gMs;
                this.gMv.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.gMv.contains(this.gMw.left, this.gMw.top)) {
                    this.gMq = 1;
                    return true;
                } else if (this.gMv.contains(this.gMw.right, this.gMw.top)) {
                    this.gMq = 2;
                    return true;
                } else if (this.gMv.contains(this.gMw.right, this.gMw.bottom)) {
                    this.gMq = 3;
                    return true;
                } else if (this.gMv.contains(this.gMw.left, this.gMw.bottom)) {
                    this.gMq = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.gMq = -1;
                break;
            case 2:
                return G(motionEvent);
        }
        return false;
    }

    private boolean G(MotionEvent motionEvent) {
        switch (this.gMq) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.gMw.right, this.gMw.bottom);
                return true;
            case 2:
                f(this.gMw.left, motionEvent.getY(), motionEvent.getX(), this.gMw.bottom);
                return true;
            case 3:
                f(this.gMw.left, this.gMw.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.gMw.top, this.gMw.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.gMw.top;
            f4 = this.gMw.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.gMw.left;
            f3 = this.gMw.right;
        }
        this.gMw.set(Math.max(this.gMr, f), Math.max(this.gMr, f2), Math.min(getWidth() - this.gMr, f3), Math.min(getHeight() - this.gMr, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.gMs;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.gMs;
    }
}
