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
    private GestureDetector.SimpleOnGestureListener fFj;
    private int fFk;
    int fFl;
    int fFm;
    int fFn;
    private Paint fFo;
    private RectF fFp;
    private RectF fFq;
    private a fFr;
    private int fFs;
    private GestureDetector gestureDetector;
    private int maskColor;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.fFq.left;
        rect.top = (int) this.fFq.top;
        rect.right = (int) this.fFq.right;
        rect.bottom = (int) this.fFq.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.fFj = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fFk = -1;
        this.fFl = 20;
        this.fFm = 100;
        this.fFn = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFo = new Paint(1);
        this.fFp = new RectF();
        this.fFq = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFs = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFj = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fFk = -1;
        this.fFl = 20;
        this.fFm = 100;
        this.fFn = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFo = new Paint(1);
        this.fFp = new RectF();
        this.fFq = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFs = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFj = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fFk = -1;
        this.fFl = 20;
        this.fFm = 100;
        this.fFn = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fFo = new Paint(1);
        this.fFp = new RectF();
        this.fFq = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fFo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fFs = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.fFr = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.fFj);
        this.fFm = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.fFn = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bx(i, i2);
    }

    private void bx(int i, int i2) {
        if (this.fFs == 1) {
            this.fFq.left = (int) (i * 0.05d);
            this.fFq.top = (int) (i2 * 0.25d);
        } else {
            this.fFq.left = (int) (i * 0.2d);
            this.fFq.top = (int) (i2 * 0.2d);
        }
        this.fFq.right = i - this.fFq.left;
        this.fFq.bottom = i2 - this.fFq.top;
    }

    public void setTypeWide() {
        this.fFs = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(float f, float f2) {
        if (f > 0.0f) {
            if (this.fFq.left - f < this.fFl) {
                f = this.fFq.left - this.fFl;
            }
        } else if (this.fFq.right - f > getWidth() - this.fFl) {
            f = (this.fFq.right - getWidth()) + this.fFl;
        }
        if (f2 > 0.0f) {
            if (this.fFq.top - f2 < this.fFl) {
                f2 = this.fFq.top - this.fFl;
            }
        } else if (this.fFq.bottom - f2 > getHeight() - this.fFl) {
            f2 = (this.fFq.bottom - getHeight()) + this.fFl;
        }
        this.fFq.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.maskColor);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.fFq, this.paint);
        canvas.drawRect(this.fFq, this.fFo);
        F(canvas);
    }

    private void F(Canvas canvas) {
        this.paint.setStrokeWidth(this.fFn);
        a(canvas, this.fFq.left - (this.fFn / 2), this.fFq.top, this.fFm, 0);
        a(canvas, this.fFq.left, this.fFq.top, 0, this.fFm);
        a(canvas, this.fFq.right + (this.fFn / 2), this.fFq.top, -this.fFm, 0);
        a(canvas, this.fFq.right, this.fFq.top, 0, this.fFm);
        a(canvas, this.fFq.right, this.fFq.bottom, 0, -this.fFm);
        a(canvas, this.fFq.right + (this.fFn / 2), this.fFq.bottom, -this.fFm, 0);
        a(canvas, this.fFq.left - (this.fFn / 2), this.fFq.bottom, this.fFm, 0);
        a(canvas, this.fFq.left, this.fFq.bottom, 0, -this.fFm);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean B = B(motionEvent);
        RectF rectF = new RectF(this.fFq.left - 60.0f, this.fFq.top - 60.0f, this.fFq.right + 60.0f, 60.0f + this.fFq.bottom);
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
                float f = this.fFm;
                this.fFp.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.fFp.contains(this.fFq.left, this.fFq.top)) {
                    this.fFk = 1;
                    return true;
                } else if (this.fFp.contains(this.fFq.right, this.fFq.top)) {
                    this.fFk = 2;
                    return true;
                } else if (this.fFp.contains(this.fFq.right, this.fFq.bottom)) {
                    this.fFk = 3;
                    return true;
                } else if (this.fFp.contains(this.fFq.left, this.fFq.bottom)) {
                    this.fFk = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.fFk = -1;
                break;
            case 2:
                return C(motionEvent);
        }
        return false;
    }

    private boolean C(MotionEvent motionEvent) {
        switch (this.fFk) {
            case 1:
                i(motionEvent.getX(), motionEvent.getY(), this.fFq.right, this.fFq.bottom);
                return true;
            case 2:
                i(this.fFq.left, motionEvent.getY(), motionEvent.getX(), this.fFq.bottom);
                return true;
            case 3:
                i(this.fFq.left, this.fFq.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                i(motionEvent.getX(), this.fFq.top, this.fFq.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void i(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.fFq.top;
            f4 = this.fFq.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.fFq.left;
            f3 = this.fFq.right;
        }
        this.fFq.set(Math.max(this.fFl, f), Math.max(this.fFl, f2), Math.min(getWidth() - this.fFl, f3), Math.min(getHeight() - this.fFl, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.fFm;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.fFm;
    }
}
