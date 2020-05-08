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
    private int eir;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener gkC;
    private int gkD;
    int gkE;
    int gkF;
    int gkG;
    private Paint gkH;
    private RectF gkI;
    private RectF gkJ;
    private a gkK;
    private int gkL;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.gkJ.left;
        rect.top = (int) this.gkJ.top;
        rect.right = (int) this.gkJ.right;
        rect.bottom = (int) this.gkJ.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.gkC = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gkD = -1;
        this.gkE = 20;
        this.gkF = 100;
        this.gkG = 6;
        this.eir = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gkH = new Paint(1);
        this.gkI = new RectF();
        this.gkJ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gkH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gkL = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkC = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gkD = -1;
        this.gkE = 20;
        this.gkF = 100;
        this.gkG = 6;
        this.eir = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gkH = new Paint(1);
        this.gkI = new RectF();
        this.gkJ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gkH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gkL = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkC = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gkD = -1;
        this.gkE = 20;
        this.gkF = 100;
        this.gkG = 6;
        this.eir = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gkH = new Paint(1);
        this.gkI = new RectF();
        this.gkJ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gkH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gkL = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.gkK = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.gkC);
        this.gkF = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.gkG = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bD(i, i2);
    }

    private void bD(int i, int i2) {
        if (this.gkL == 1) {
            this.gkJ.left = (int) (i * 0.05d);
            this.gkJ.top = (int) (i2 * 0.25d);
        } else {
            this.gkJ.left = (int) (i * 0.2d);
            this.gkJ.top = (int) (i2 * 0.2d);
        }
        this.gkJ.right = i - this.gkJ.left;
        this.gkJ.bottom = i2 - this.gkJ.top;
    }

    public void setTypeWide() {
        this.gkL = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (f > 0.0f) {
            if (this.gkJ.left - f < this.gkE) {
                f = this.gkJ.left - this.gkE;
            }
        } else if (this.gkJ.right - f > getWidth() - this.gkE) {
            f = (this.gkJ.right - getWidth()) + this.gkE;
        }
        if (f2 > 0.0f) {
            if (this.gkJ.top - f2 < this.gkE) {
                f2 = this.gkJ.top - this.gkE;
            }
        } else if (this.gkJ.bottom - f2 > getHeight() - this.gkE) {
            f2 = (this.gkJ.bottom - getHeight()) + this.gkE;
        }
        this.gkJ.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.eir);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.gkJ, this.paint);
        canvas.drawRect(this.gkJ, this.gkH);
        G(canvas);
    }

    private void G(Canvas canvas) {
        this.paint.setStrokeWidth(this.gkG);
        a(canvas, this.gkJ.left - (this.gkG / 2), this.gkJ.top, this.gkF, 0);
        a(canvas, this.gkJ.left, this.gkJ.top, 0, this.gkF);
        a(canvas, this.gkJ.right + (this.gkG / 2), this.gkJ.top, -this.gkF, 0);
        a(canvas, this.gkJ.right, this.gkJ.top, 0, this.gkF);
        a(canvas, this.gkJ.right, this.gkJ.bottom, 0, -this.gkF);
        a(canvas, this.gkJ.right + (this.gkG / 2), this.gkJ.bottom, -this.gkF, 0);
        a(canvas, this.gkJ.left - (this.gkG / 2), this.gkJ.bottom, this.gkF, 0);
        a(canvas, this.gkJ.left, this.gkJ.bottom, 0, -this.gkF);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean A = A(motionEvent);
        RectF rectF = new RectF(this.gkJ.left - 60.0f, this.gkJ.top - 60.0f, this.gkJ.right + 60.0f, 60.0f + this.gkJ.bottom);
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
                float f = this.gkF;
                this.gkI.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.gkI.contains(this.gkJ.left, this.gkJ.top)) {
                    this.gkD = 1;
                    return true;
                } else if (this.gkI.contains(this.gkJ.right, this.gkJ.top)) {
                    this.gkD = 2;
                    return true;
                } else if (this.gkI.contains(this.gkJ.right, this.gkJ.bottom)) {
                    this.gkD = 3;
                    return true;
                } else if (this.gkI.contains(this.gkJ.left, this.gkJ.bottom)) {
                    this.gkD = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.gkD = -1;
                break;
            case 2:
                return B(motionEvent);
        }
        return false;
    }

    private boolean B(MotionEvent motionEvent) {
        switch (this.gkD) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.gkJ.right, this.gkJ.bottom);
                return true;
            case 2:
                f(this.gkJ.left, motionEvent.getY(), motionEvent.getX(), this.gkJ.bottom);
                return true;
            case 3:
                f(this.gkJ.left, this.gkJ.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.gkJ.top, this.gkJ.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.gkJ.top;
            f4 = this.gkJ.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.gkJ.left;
            f3 = this.gkJ.right;
        }
        this.gkJ.set(Math.max(this.gkE, f), Math.max(this.gkE, f2), Math.min(getWidth() - this.gkE, f3), Math.min(getHeight() - this.gkE, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.gkF;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.gkF;
    }
}
