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
    private int eMy;
    private GestureDetector.SimpleOnGestureListener gRV;
    private int gRW;
    int gRX;
    int gRY;
    int gRZ;
    private Paint gSa;
    private RectF gSb;
    private RectF gSc;
    private a gSd;
    private int gSe;
    private GestureDetector gestureDetector;
    private Paint paint;

    /* loaded from: classes15.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.gSc.left;
        rect.top = (int) this.gSc.top;
        rect.right = (int) this.gSc.right;
        rect.bottom = (int) this.gSc.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.gRV = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gRW = -1;
        this.gRX = 20;
        this.gRY = 100;
        this.gRZ = 6;
        this.eMy = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gSa = new Paint(1);
        this.gSb = new RectF();
        this.gSc = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gSa.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gSe = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gRV = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gRW = -1;
        this.gRX = 20;
        this.gRY = 100;
        this.gRZ = 6;
        this.eMy = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gSa = new Paint(1);
        this.gSb = new RectF();
        this.gSc = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gSa.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gSe = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gRV = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gRW = -1;
        this.gRX = 20;
        this.gRY = 100;
        this.gRZ = 6;
        this.eMy = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gSa = new Paint(1);
        this.gSb = new RectF();
        this.gSc = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gSa.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gSe = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.gSd = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.gRV);
        this.gRY = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.gRZ = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bO(i, i2);
    }

    private void bO(int i, int i2) {
        if (this.gSe == 1) {
            this.gSc.left = (int) (i * 0.05d);
            this.gSc.top = (int) (i2 * 0.25d);
        } else {
            this.gSc.left = (int) (i * 0.2d);
            this.gSc.top = (int) (i2 * 0.2d);
        }
        this.gSc.right = i - this.gSc.left;
        this.gSc.bottom = i2 - this.gSc.top;
    }

    public void setTypeWide() {
        this.gSe = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (f > 0.0f) {
            if (this.gSc.left - f < this.gRX) {
                f = this.gSc.left - this.gRX;
            }
        } else if (this.gSc.right - f > getWidth() - this.gRX) {
            f = (this.gSc.right - getWidth()) + this.gRX;
        }
        if (f2 > 0.0f) {
            if (this.gSc.top - f2 < this.gRX) {
                f2 = this.gSc.top - this.gRX;
            }
        } else if (this.gSc.bottom - f2 > getHeight() - this.gRX) {
            f2 = (this.gSc.bottom - getHeight()) + this.gRX;
        }
        this.gSc.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.eMy);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.gSc, this.paint);
        canvas.drawRect(this.gSc, this.gSa);
        I(canvas);
    }

    private void I(Canvas canvas) {
        this.paint.setStrokeWidth(this.gRZ);
        a(canvas, this.gSc.left - (this.gRZ / 2), this.gSc.top, this.gRY, 0);
        a(canvas, this.gSc.left, this.gSc.top, 0, this.gRY);
        a(canvas, this.gSc.right + (this.gRZ / 2), this.gSc.top, -this.gRY, 0);
        a(canvas, this.gSc.right, this.gSc.top, 0, this.gRY);
        a(canvas, this.gSc.right, this.gSc.bottom, 0, -this.gRY);
        a(canvas, this.gSc.right + (this.gRZ / 2), this.gSc.bottom, -this.gRY, 0);
        a(canvas, this.gSc.left - (this.gRZ / 2), this.gSc.bottom, this.gRY, 0);
        a(canvas, this.gSc.left, this.gSc.bottom, 0, -this.gRY);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean F = F(motionEvent);
        RectF rectF = new RectF(this.gSc.left - 60.0f, this.gSc.top - 60.0f, this.gSc.right + 60.0f, 60.0f + this.gSc.bottom);
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
                float f = this.gRY;
                this.gSb.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.gSb.contains(this.gSc.left, this.gSc.top)) {
                    this.gRW = 1;
                    return true;
                } else if (this.gSb.contains(this.gSc.right, this.gSc.top)) {
                    this.gRW = 2;
                    return true;
                } else if (this.gSb.contains(this.gSc.right, this.gSc.bottom)) {
                    this.gRW = 3;
                    return true;
                } else if (this.gSb.contains(this.gSc.left, this.gSc.bottom)) {
                    this.gRW = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.gRW = -1;
                break;
            case 2:
                return G(motionEvent);
        }
        return false;
    }

    private boolean G(MotionEvent motionEvent) {
        switch (this.gRW) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.gSc.right, this.gSc.bottom);
                return true;
            case 2:
                f(this.gSc.left, motionEvent.getY(), motionEvent.getX(), this.gSc.bottom);
                return true;
            case 3:
                f(this.gSc.left, this.gSc.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.gSc.top, this.gSc.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.gSc.top;
            f4 = this.gSc.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.gSc.left;
            f3 = this.gSc.right;
        }
        this.gSc.set(Math.max(this.gRX, f), Math.max(this.gRX, f2), Math.min(getWidth() - this.gRX, f3), Math.min(getHeight() - this.gRX, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.gRY;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.gRY;
    }
}
