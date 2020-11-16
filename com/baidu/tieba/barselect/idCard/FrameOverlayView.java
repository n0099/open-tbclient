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
/* loaded from: classes20.dex */
public class FrameOverlayView extends View {
    private int fAc;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener hTH;
    private int hTI;
    int hTJ;
    int hTK;
    private Paint hTL;
    private RectF hTM;
    private RectF hTN;
    private a hTO;
    private int hTP;
    int margin;
    private Paint paint;

    /* loaded from: classes20.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.hTN.left;
        rect.top = (int) this.hTN.top;
        rect.right = (int) this.hTN.right;
        rect.bottom = (int) this.hTN.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.hTH = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.hTI = -1;
        this.margin = 20;
        this.hTJ = 100;
        this.hTK = 6;
        this.fAc = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hTL = new Paint(1);
        this.hTM = new RectF();
        this.hTN = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hTL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hTP = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hTH = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.hTI = -1;
        this.margin = 20;
        this.hTJ = 100;
        this.hTK = 6;
        this.fAc = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hTL = new Paint(1);
        this.hTM = new RectF();
        this.hTN = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hTL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hTP = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTH = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.hTI = -1;
        this.margin = 20;
        this.hTJ = 100;
        this.hTK = 6;
        this.fAc = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hTL = new Paint(1);
        this.hTM = new RectF();
        this.hTN = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hTL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hTP = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.hTO = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.hTH);
        this.hTJ = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.hTK = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cd(i, i2);
    }

    private void cd(int i, int i2) {
        if (this.hTP == 1) {
            this.hTN.left = (int) (i * 0.05d);
            this.hTN.top = (int) (i2 * 0.25d);
        } else {
            this.hTN.left = (int) (i * 0.2d);
            this.hTN.top = (int) (i2 * 0.2d);
        }
        this.hTN.right = i - this.hTN.left;
        this.hTN.bottom = i2 - this.hTN.top;
    }

    public void setTypeWide() {
        this.hTP = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(float f, float f2) {
        if (f > 0.0f) {
            if (this.hTN.left - f < this.margin) {
                f = this.hTN.left - this.margin;
            }
        } else if (this.hTN.right - f > getWidth() - this.margin) {
            f = (this.hTN.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.hTN.top - f2 < this.margin) {
                f2 = this.hTN.top - this.margin;
            }
        } else if (this.hTN.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.hTN.bottom - getHeight()) + this.margin;
        }
        this.hTN.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fAc);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.hTN, this.paint);
        canvas.drawRect(this.hTN, this.hTL);
        T(canvas);
    }

    private void T(Canvas canvas) {
        this.paint.setStrokeWidth(this.hTK);
        a(canvas, this.hTN.left - (this.hTK / 2), this.hTN.top, this.hTJ, 0);
        a(canvas, this.hTN.left, this.hTN.top, 0, this.hTJ);
        a(canvas, this.hTN.right + (this.hTK / 2), this.hTN.top, -this.hTJ, 0);
        a(canvas, this.hTN.right, this.hTN.top, 0, this.hTJ);
        a(canvas, this.hTN.right, this.hTN.bottom, 0, -this.hTJ);
        a(canvas, this.hTN.right + (this.hTK / 2), this.hTN.bottom, -this.hTJ, 0);
        a(canvas, this.hTN.left - (this.hTK / 2), this.hTN.bottom, this.hTJ, 0);
        a(canvas, this.hTN.left, this.hTN.bottom, 0, -this.hTJ);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean X = X(motionEvent);
        RectF rectF = new RectF(this.hTN.left - 60.0f, this.hTN.top - 60.0f, this.hTN.right + 60.0f, 60.0f + this.hTN.bottom);
        if (!X && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return X;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean X(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.hTJ;
                this.hTM.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.hTM.contains(this.hTN.left, this.hTN.top)) {
                    this.hTI = 1;
                    return true;
                } else if (this.hTM.contains(this.hTN.right, this.hTN.top)) {
                    this.hTI = 2;
                    return true;
                } else if (this.hTM.contains(this.hTN.right, this.hTN.bottom)) {
                    this.hTI = 3;
                    return true;
                } else if (this.hTM.contains(this.hTN.left, this.hTN.bottom)) {
                    this.hTI = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.hTI = -1;
                break;
            case 2:
                return Y(motionEvent);
        }
        return false;
    }

    private boolean Y(MotionEvent motionEvent) {
        switch (this.hTI) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.hTN.right, this.hTN.bottom);
                return true;
            case 2:
                f(this.hTN.left, motionEvent.getY(), motionEvent.getX(), this.hTN.bottom);
                return true;
            case 3:
                f(this.hTN.left, this.hTN.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.hTN.top, this.hTN.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.hTN.top;
            f4 = this.hTN.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.hTN.left;
            f3 = this.hTN.right;
        }
        this.hTN.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.hTJ;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.hTJ;
    }
}
