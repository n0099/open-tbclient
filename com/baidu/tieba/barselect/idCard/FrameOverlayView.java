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
    private int fml;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener hAO;
    private int hAP;
    int hAQ;
    int hAR;
    private Paint hAS;
    private RectF hAT;
    private RectF hAU;
    private a hAV;
    private int hAW;
    int margin;
    private Paint paint;

    /* loaded from: classes21.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.hAU.left;
        rect.top = (int) this.hAU.top;
        rect.right = (int) this.hAU.right;
        rect.bottom = (int) this.hAU.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.hAO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.B(f, f2);
                return true;
            }
        };
        this.hAP = -1;
        this.margin = 20;
        this.hAQ = 100;
        this.hAR = 6;
        this.fml = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hAS = new Paint(1);
        this.hAT = new RectF();
        this.hAU = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hAS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hAW = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.B(f, f2);
                return true;
            }
        };
        this.hAP = -1;
        this.margin = 20;
        this.hAQ = 100;
        this.hAR = 6;
        this.fml = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hAS = new Paint(1);
        this.hAT = new RectF();
        this.hAU = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hAS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hAW = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.B(f, f2);
                return true;
            }
        };
        this.hAP = -1;
        this.margin = 20;
        this.hAQ = 100;
        this.hAR = 6;
        this.fml = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hAS = new Paint(1);
        this.hAT = new RectF();
        this.hAU = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hAS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hAW = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.hAV = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.hAO);
        this.hAQ = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.hAR = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bZ(i, i2);
    }

    private void bZ(int i, int i2) {
        if (this.hAW == 1) {
            this.hAU.left = (int) (i * 0.05d);
            this.hAU.top = (int) (i2 * 0.25d);
        } else {
            this.hAU.left = (int) (i * 0.2d);
            this.hAU.top = (int) (i2 * 0.2d);
        }
        this.hAU.right = i - this.hAU.left;
        this.hAU.bottom = i2 - this.hAU.top;
    }

    public void setTypeWide() {
        this.hAW = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(float f, float f2) {
        if (f > 0.0f) {
            if (this.hAU.left - f < this.margin) {
                f = this.hAU.left - this.margin;
            }
        } else if (this.hAU.right - f > getWidth() - this.margin) {
            f = (this.hAU.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.hAU.top - f2 < this.margin) {
                f2 = this.hAU.top - this.margin;
            }
        } else if (this.hAU.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.hAU.bottom - getHeight()) + this.margin;
        }
        this.hAU.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fml);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.hAU, this.paint);
        canvas.drawRect(this.hAU, this.hAS);
        Q(canvas);
    }

    private void Q(Canvas canvas) {
        this.paint.setStrokeWidth(this.hAR);
        a(canvas, this.hAU.left - (this.hAR / 2), this.hAU.top, this.hAQ, 0);
        a(canvas, this.hAU.left, this.hAU.top, 0, this.hAQ);
        a(canvas, this.hAU.right + (this.hAR / 2), this.hAU.top, -this.hAQ, 0);
        a(canvas, this.hAU.right, this.hAU.top, 0, this.hAQ);
        a(canvas, this.hAU.right, this.hAU.bottom, 0, -this.hAQ);
        a(canvas, this.hAU.right + (this.hAR / 2), this.hAU.bottom, -this.hAQ, 0);
        a(canvas, this.hAU.left - (this.hAR / 2), this.hAU.bottom, this.hAQ, 0);
        a(canvas, this.hAU.left, this.hAU.bottom, 0, -this.hAQ);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean W = W(motionEvent);
        RectF rectF = new RectF(this.hAU.left - 60.0f, this.hAU.top - 60.0f, this.hAU.right + 60.0f, 60.0f + this.hAU.bottom);
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
                float f = this.hAQ;
                this.hAT.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.hAT.contains(this.hAU.left, this.hAU.top)) {
                    this.hAP = 1;
                    return true;
                } else if (this.hAT.contains(this.hAU.right, this.hAU.top)) {
                    this.hAP = 2;
                    return true;
                } else if (this.hAT.contains(this.hAU.right, this.hAU.bottom)) {
                    this.hAP = 3;
                    return true;
                } else if (this.hAT.contains(this.hAU.left, this.hAU.bottom)) {
                    this.hAP = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.hAP = -1;
                break;
            case 2:
                return X(motionEvent);
        }
        return false;
    }

    private boolean X(MotionEvent motionEvent) {
        switch (this.hAP) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.hAU.right, this.hAU.bottom);
                return true;
            case 2:
                f(this.hAU.left, motionEvent.getY(), motionEvent.getX(), this.hAU.bottom);
                return true;
            case 3:
                f(this.hAU.left, this.hAU.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.hAU.top, this.hAU.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.hAU.top;
            f4 = this.hAU.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.hAU.left;
            f3 = this.hAU.right;
        }
        this.hAU.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.hAQ;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.hAQ;
    }
}
