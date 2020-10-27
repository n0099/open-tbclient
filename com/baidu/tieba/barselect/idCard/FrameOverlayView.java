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
/* loaded from: classes21.dex */
public class FrameOverlayView extends View {
    private int fuM;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener hNk;
    private int hNl;
    int hNm;
    int hNn;
    private Paint hNo;
    private RectF hNp;
    private RectF hNq;
    private a hNr;
    private int hNs;
    int margin;
    private Paint paint;

    /* loaded from: classes21.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.hNq.left;
        rect.top = (int) this.hNq.top;
        rect.right = (int) this.hNq.right;
        rect.bottom = (int) this.hNq.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.hNk = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.C(f, f2);
                return true;
            }
        };
        this.hNl = -1;
        this.margin = 20;
        this.hNm = 100;
        this.hNn = 6;
        this.fuM = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hNo = new Paint(1);
        this.hNp = new RectF();
        this.hNq = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hNo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hNs = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNk = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.C(f, f2);
                return true;
            }
        };
        this.hNl = -1;
        this.margin = 20;
        this.hNm = 100;
        this.hNn = 6;
        this.fuM = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hNo = new Paint(1);
        this.hNp = new RectF();
        this.hNq = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hNo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hNs = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNk = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.C(f, f2);
                return true;
            }
        };
        this.hNl = -1;
        this.margin = 20;
        this.hNm = 100;
        this.hNn = 6;
        this.fuM = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hNo = new Paint(1);
        this.hNp = new RectF();
        this.hNq = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hNo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hNs = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.hNr = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.hNk);
        this.hNm = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.hNn = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cb(i, i2);
    }

    private void cb(int i, int i2) {
        if (this.hNs == 1) {
            this.hNq.left = (int) (i * 0.05d);
            this.hNq.top = (int) (i2 * 0.25d);
        } else {
            this.hNq.left = (int) (i * 0.2d);
            this.hNq.top = (int) (i2 * 0.2d);
        }
        this.hNq.right = i - this.hNq.left;
        this.hNq.bottom = i2 - this.hNq.top;
    }

    public void setTypeWide() {
        this.hNs = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f, float f2) {
        if (f > 0.0f) {
            if (this.hNq.left - f < this.margin) {
                f = this.hNq.left - this.margin;
            }
        } else if (this.hNq.right - f > getWidth() - this.margin) {
            f = (this.hNq.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.hNq.top - f2 < this.margin) {
                f2 = this.hNq.top - this.margin;
            }
        } else if (this.hNq.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.hNq.bottom - getHeight()) + this.margin;
        }
        this.hNq.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fuM);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.hNq, this.paint);
        canvas.drawRect(this.hNq, this.hNo);
        Q(canvas);
    }

    private void Q(Canvas canvas) {
        this.paint.setStrokeWidth(this.hNn);
        a(canvas, this.hNq.left - (this.hNn / 2), this.hNq.top, this.hNm, 0);
        a(canvas, this.hNq.left, this.hNq.top, 0, this.hNm);
        a(canvas, this.hNq.right + (this.hNn / 2), this.hNq.top, -this.hNm, 0);
        a(canvas, this.hNq.right, this.hNq.top, 0, this.hNm);
        a(canvas, this.hNq.right, this.hNq.bottom, 0, -this.hNm);
        a(canvas, this.hNq.right + (this.hNn / 2), this.hNq.bottom, -this.hNm, 0);
        a(canvas, this.hNq.left - (this.hNn / 2), this.hNq.bottom, this.hNm, 0);
        a(canvas, this.hNq.left, this.hNq.bottom, 0, -this.hNm);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean W = W(motionEvent);
        RectF rectF = new RectF(this.hNq.left - 60.0f, this.hNq.top - 60.0f, this.hNq.right + 60.0f, 60.0f + this.hNq.bottom);
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
                float f = this.hNm;
                this.hNp.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.hNp.contains(this.hNq.left, this.hNq.top)) {
                    this.hNl = 1;
                    return true;
                } else if (this.hNp.contains(this.hNq.right, this.hNq.top)) {
                    this.hNl = 2;
                    return true;
                } else if (this.hNp.contains(this.hNq.right, this.hNq.bottom)) {
                    this.hNl = 3;
                    return true;
                } else if (this.hNp.contains(this.hNq.left, this.hNq.bottom)) {
                    this.hNl = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.hNl = -1;
                break;
            case 2:
                return X(motionEvent);
        }
        return false;
    }

    private boolean X(MotionEvent motionEvent) {
        switch (this.hNl) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.hNq.right, this.hNq.bottom);
                return true;
            case 2:
                f(this.hNq.left, motionEvent.getY(), motionEvent.getX(), this.hNq.bottom);
                return true;
            case 3:
                f(this.hNq.left, this.hNq.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.hNq.top, this.hNq.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.hNq.top;
            f4 = this.hNq.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.hNq.left;
            f3 = this.hNq.right;
        }
        this.hNq.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.hNm;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.hNm;
    }
}
