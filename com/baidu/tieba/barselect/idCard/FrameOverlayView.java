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
/* loaded from: classes7.dex */
public class FrameOverlayView extends View {
    private int fMM;
    private GestureDetector gestureDetector;
    private a imA;
    private int imB;
    private GestureDetector.SimpleOnGestureListener imt;
    private int imu;
    int imv;
    int imw;
    private Paint imx;
    private RectF imy;
    private RectF imz;
    int margin;
    private Paint paint;

    /* loaded from: classes7.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.imz.left;
        rect.top = (int) this.imz.top;
        rect.right = (int) this.imz.right;
        rect.bottom = (int) this.imz.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.imt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.imu = -1;
        this.margin = 20;
        this.imv = 100;
        this.imw = 6;
        this.fMM = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.imx = new Paint(1);
        this.imy = new RectF();
        this.imz = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.imx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.imB = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.imu = -1;
        this.margin = 20;
        this.imv = 100;
        this.imw = 6;
        this.fMM = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.imx = new Paint(1);
        this.imy = new RectF();
        this.imz = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.imx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.imB = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.imu = -1;
        this.margin = 20;
        this.imv = 100;
        this.imw = 6;
        this.fMM = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.imx = new Paint(1);
        this.imy = new RectF();
        this.imz = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.imx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.imB = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.imA = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.imt);
        this.imv = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.imw = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cg(i, i2);
    }

    private void cg(int i, int i2) {
        if (this.imB == 1) {
            this.imz.left = (int) (i * 0.05d);
            this.imz.top = (int) (i2 * 0.25d);
        } else {
            this.imz.left = (int) (i * 0.2d);
            this.imz.top = (int) (i2 * 0.2d);
        }
        this.imz.right = i - this.imz.left;
        this.imz.bottom = i2 - this.imz.top;
    }

    public void setTypeWide() {
        this.imB = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(float f, float f2) {
        if (f > 0.0f) {
            if (this.imz.left - f < this.margin) {
                f = this.imz.left - this.margin;
            }
        } else if (this.imz.right - f > getWidth() - this.margin) {
            f = (this.imz.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.imz.top - f2 < this.margin) {
                f2 = this.imz.top - this.margin;
            }
        } else if (this.imz.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.imz.bottom - getHeight()) + this.margin;
        }
        this.imz.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fMM);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.imz, this.paint);
        canvas.drawRect(this.imz, this.imx);
        Z(canvas);
    }

    private void Z(Canvas canvas) {
        this.paint.setStrokeWidth(this.imw);
        a(canvas, this.imz.left - (this.imw / 2), this.imz.top, this.imv, 0);
        a(canvas, this.imz.left, this.imz.top, 0, this.imv);
        a(canvas, this.imz.right + (this.imw / 2), this.imz.top, -this.imv, 0);
        a(canvas, this.imz.right, this.imz.top, 0, this.imv);
        a(canvas, this.imz.right, this.imz.bottom, 0, -this.imv);
        a(canvas, this.imz.right + (this.imw / 2), this.imz.bottom, -this.imv, 0);
        a(canvas, this.imz.left - (this.imw / 2), this.imz.bottom, this.imv, 0);
        a(canvas, this.imz.left, this.imz.bottom, 0, -this.imv);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean Y = Y(motionEvent);
        RectF rectF = new RectF(this.imz.left - 60.0f, this.imz.top - 60.0f, this.imz.right + 60.0f, 60.0f + this.imz.bottom);
        if (!Y && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return Y;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean Y(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.imv;
                this.imy.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.imy.contains(this.imz.left, this.imz.top)) {
                    this.imu = 1;
                    return true;
                } else if (this.imy.contains(this.imz.right, this.imz.top)) {
                    this.imu = 2;
                    return true;
                } else if (this.imy.contains(this.imz.right, this.imz.bottom)) {
                    this.imu = 3;
                    return true;
                } else if (this.imy.contains(this.imz.left, this.imz.bottom)) {
                    this.imu = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.imu = -1;
                break;
            case 2:
                return Z(motionEvent);
        }
        return false;
    }

    private boolean Z(MotionEvent motionEvent) {
        switch (this.imu) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.imz.right, this.imz.bottom);
                return true;
            case 2:
                f(this.imz.left, motionEvent.getY(), motionEvent.getX(), this.imz.bottom);
                return true;
            case 3:
                f(this.imz.left, this.imz.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.imz.top, this.imz.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.imz.top;
            f4 = this.imz.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.imz.left;
            f3 = this.imz.right;
        }
        this.imz.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.imv;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.imv;
    }
}
