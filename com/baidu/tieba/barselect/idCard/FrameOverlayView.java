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
    private int fQz;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener itV;
    private int itW;
    int itX;
    int itY;
    private Paint itZ;
    private RectF iua;
    private RectF iub;
    private a iuc;
    private int iud;
    int margin;
    private Paint paint;

    /* loaded from: classes7.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.iub.left;
        rect.top = (int) this.iub.top;
        rect.right = (int) this.iub.right;
        rect.bottom = (int) this.iub.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.itV = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.itW = -1;
        this.margin = 20;
        this.itX = 100;
        this.itY = 6;
        this.fQz = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.itZ = new Paint(1);
        this.iua = new RectF();
        this.iub = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.itZ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iud = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itV = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.itW = -1;
        this.margin = 20;
        this.itX = 100;
        this.itY = 6;
        this.fQz = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.itZ = new Paint(1);
        this.iua = new RectF();
        this.iub = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.itZ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iud = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itV = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.itW = -1;
        this.margin = 20;
        this.itX = 100;
        this.itY = 6;
        this.fQz = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.itZ = new Paint(1);
        this.iua = new RectF();
        this.iub = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.itZ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iud = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.iuc = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.itV);
        this.itX = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.itY = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ce(i, i2);
    }

    private void ce(int i, int i2) {
        if (this.iud == 1) {
            this.iub.left = (int) (i * 0.05d);
            this.iub.top = (int) (i2 * 0.25d);
        } else {
            this.iub.left = (int) (i * 0.2d);
            this.iub.top = (int) (i2 * 0.2d);
        }
        this.iub.right = i - this.iub.left;
        this.iub.bottom = i2 - this.iub.top;
    }

    public void setTypeWide() {
        this.iud = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(float f, float f2) {
        if (f > 0.0f) {
            if (this.iub.left - f < this.margin) {
                f = this.iub.left - this.margin;
            }
        } else if (this.iub.right - f > getWidth() - this.margin) {
            f = (this.iub.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.iub.top - f2 < this.margin) {
                f2 = this.iub.top - this.margin;
            }
        } else if (this.iub.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.iub.bottom - getHeight()) + this.margin;
        }
        this.iub.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fQz);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.iub, this.paint);
        canvas.drawRect(this.iub, this.itZ);
        Z(canvas);
    }

    private void Z(Canvas canvas) {
        this.paint.setStrokeWidth(this.itY);
        a(canvas, this.iub.left - (this.itY / 2), this.iub.top, this.itX, 0);
        a(canvas, this.iub.left, this.iub.top, 0, this.itX);
        a(canvas, this.iub.right + (this.itY / 2), this.iub.top, -this.itX, 0);
        a(canvas, this.iub.right, this.iub.top, 0, this.itX);
        a(canvas, this.iub.right, this.iub.bottom, 0, -this.itX);
        a(canvas, this.iub.right + (this.itY / 2), this.iub.bottom, -this.itX, 0);
        a(canvas, this.iub.left - (this.itY / 2), this.iub.bottom, this.itX, 0);
        a(canvas, this.iub.left, this.iub.bottom, 0, -this.itX);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean Y = Y(motionEvent);
        RectF rectF = new RectF(this.iub.left - 60.0f, this.iub.top - 60.0f, this.iub.right + 60.0f, 60.0f + this.iub.bottom);
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
                float f = this.itX;
                this.iua.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.iua.contains(this.iub.left, this.iub.top)) {
                    this.itW = 1;
                    return true;
                } else if (this.iua.contains(this.iub.right, this.iub.top)) {
                    this.itW = 2;
                    return true;
                } else if (this.iua.contains(this.iub.right, this.iub.bottom)) {
                    this.itW = 3;
                    return true;
                } else if (this.iua.contains(this.iub.left, this.iub.bottom)) {
                    this.itW = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.itW = -1;
                break;
            case 2:
                return Z(motionEvent);
        }
        return false;
    }

    private boolean Z(MotionEvent motionEvent) {
        switch (this.itW) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.iub.right, this.iub.bottom);
                return true;
            case 2:
                f(this.iub.left, motionEvent.getY(), motionEvent.getX(), this.iub.bottom);
                return true;
            case 3:
                f(this.iub.left, this.iub.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.iub.top, this.iub.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.iub.top;
            f4 = this.iub.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.iub.left;
            f3 = this.iub.right;
        }
        this.iub.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.itX;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.itX;
    }
}
