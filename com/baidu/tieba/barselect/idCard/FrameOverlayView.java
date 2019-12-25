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
/* loaded from: classes5.dex */
public class FrameOverlayView extends View {
    private GestureDetector.SimpleOnGestureListener fzm;
    private int fzn;
    int fzo;
    int fzp;
    int fzq;
    private Paint fzr;
    private RectF fzs;
    private RectF fzt;
    private a fzu;
    private int fzv;
    private GestureDetector gestureDetector;
    private int maskColor;
    private Paint paint;

    /* loaded from: classes5.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.fzt.left;
        rect.top = (int) this.fzt.top;
        rect.right = (int) this.fzt.right;
        rect.bottom = (int) this.fzt.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.fzm = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fzn = -1;
        this.fzo = 20;
        this.fzp = 100;
        this.fzq = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fzr = new Paint(1);
        this.fzs = new RectF();
        this.fzt = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fzr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fzv = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzm = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fzn = -1;
        this.fzo = 20;
        this.fzp = 100;
        this.fzq = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fzr = new Paint(1);
        this.fzs = new RectF();
        this.fzt = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fzr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fzv = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzm = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fzn = -1;
        this.fzo = 20;
        this.fzp = 100;
        this.fzq = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fzr = new Paint(1);
        this.fzs = new RectF();
        this.fzt = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fzr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fzv = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.fzu = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.fzm);
        this.fzp = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.fzq = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bx(i, i2);
    }

    private void bx(int i, int i2) {
        if (this.fzv == 1) {
            this.fzt.left = (int) (i * 0.05d);
            this.fzt.top = (int) (i2 * 0.25d);
        } else {
            this.fzt.left = (int) (i * 0.2d);
            this.fzt.top = (int) (i2 * 0.2d);
        }
        this.fzt.right = i - this.fzt.left;
        this.fzt.bottom = i2 - this.fzt.top;
    }

    public void setTypeWide() {
        this.fzv = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(float f, float f2) {
        if (f > 0.0f) {
            if (this.fzt.left - f < this.fzo) {
                f = this.fzt.left - this.fzo;
            }
        } else if (this.fzt.right - f > getWidth() - this.fzo) {
            f = (this.fzt.right - getWidth()) + this.fzo;
        }
        if (f2 > 0.0f) {
            if (this.fzt.top - f2 < this.fzo) {
                f2 = this.fzt.top - this.fzo;
            }
        } else if (this.fzt.bottom - f2 > getHeight() - this.fzo) {
            f2 = (this.fzt.bottom - getHeight()) + this.fzo;
        }
        this.fzt.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.maskColor);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.fzt, this.paint);
        canvas.drawRect(this.fzt, this.fzr);
        F(canvas);
    }

    private void F(Canvas canvas) {
        this.paint.setStrokeWidth(this.fzq);
        a(canvas, this.fzt.left - (this.fzq / 2), this.fzt.top, this.fzp, 0);
        a(canvas, this.fzt.left, this.fzt.top, 0, this.fzp);
        a(canvas, this.fzt.right + (this.fzq / 2), this.fzt.top, -this.fzp, 0);
        a(canvas, this.fzt.right, this.fzt.top, 0, this.fzp);
        a(canvas, this.fzt.right, this.fzt.bottom, 0, -this.fzp);
        a(canvas, this.fzt.right + (this.fzq / 2), this.fzt.bottom, -this.fzp, 0);
        a(canvas, this.fzt.left - (this.fzq / 2), this.fzt.bottom, this.fzp, 0);
        a(canvas, this.fzt.left, this.fzt.bottom, 0, -this.fzp);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean B = B(motionEvent);
        RectF rectF = new RectF(this.fzt.left - 60.0f, this.fzt.top - 60.0f, this.fzt.right + 60.0f, 60.0f + this.fzt.bottom);
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
                float f = this.fzp;
                this.fzs.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.fzs.contains(this.fzt.left, this.fzt.top)) {
                    this.fzn = 1;
                    return true;
                } else if (this.fzs.contains(this.fzt.right, this.fzt.top)) {
                    this.fzn = 2;
                    return true;
                } else if (this.fzs.contains(this.fzt.right, this.fzt.bottom)) {
                    this.fzn = 3;
                    return true;
                } else if (this.fzs.contains(this.fzt.left, this.fzt.bottom)) {
                    this.fzn = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.fzn = -1;
                break;
            case 2:
                return C(motionEvent);
        }
        return false;
    }

    private boolean C(MotionEvent motionEvent) {
        switch (this.fzn) {
            case 1:
                i(motionEvent.getX(), motionEvent.getY(), this.fzt.right, this.fzt.bottom);
                return true;
            case 2:
                i(this.fzt.left, motionEvent.getY(), motionEvent.getX(), this.fzt.bottom);
                return true;
            case 3:
                i(this.fzt.left, this.fzt.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                i(motionEvent.getX(), this.fzt.top, this.fzt.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void i(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.fzt.top;
            f4 = this.fzt.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.fzt.left;
            f3 = this.fzt.right;
        }
        this.fzt.set(Math.max(this.fzo, f), Math.max(this.fzo, f2), Math.min(getWidth() - this.fzo, f3), Math.min(getHeight() - this.fzo, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.fzp;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.fzp;
    }
}
