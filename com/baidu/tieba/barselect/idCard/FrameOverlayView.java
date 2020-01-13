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
/* loaded from: classes6.dex */
public class FrameOverlayView extends View {
    int fCA;
    int fCB;
    private Paint fCC;
    private RectF fCD;
    private RectF fCE;
    private a fCF;
    private int fCG;
    private GestureDetector.SimpleOnGestureListener fCx;
    private int fCy;
    int fCz;
    private GestureDetector gestureDetector;
    private int maskColor;
    private Paint paint;

    /* loaded from: classes6.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.fCE.left;
        rect.top = (int) this.fCE.top;
        rect.right = (int) this.fCE.right;
        rect.bottom = (int) this.fCE.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.fCx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fCy = -1;
        this.fCz = 20;
        this.fCA = 100;
        this.fCB = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fCC = new Paint(1);
        this.fCD = new RectF();
        this.fCE = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fCC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fCG = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fCy = -1;
        this.fCz = 20;
        this.fCA = 100;
        this.fCB = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fCC = new Paint(1);
        this.fCD = new RectF();
        this.fCE = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fCC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fCG = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fCx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.w(f, f2);
                return true;
            }
        };
        this.fCy = -1;
        this.fCz = 20;
        this.fCA = 100;
        this.fCB = 6;
        this.maskColor = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.fCC = new Paint(1);
        this.fCD = new RectF();
        this.fCE = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.fCC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.fCG = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.fCF = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.fCx);
        this.fCA = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.fCB = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bw(i, i2);
    }

    private void bw(int i, int i2) {
        if (this.fCG == 1) {
            this.fCE.left = (int) (i * 0.05d);
            this.fCE.top = (int) (i2 * 0.25d);
        } else {
            this.fCE.left = (int) (i * 0.2d);
            this.fCE.top = (int) (i2 * 0.2d);
        }
        this.fCE.right = i - this.fCE.left;
        this.fCE.bottom = i2 - this.fCE.top;
    }

    public void setTypeWide() {
        this.fCG = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(float f, float f2) {
        if (f > 0.0f) {
            if (this.fCE.left - f < this.fCz) {
                f = this.fCE.left - this.fCz;
            }
        } else if (this.fCE.right - f > getWidth() - this.fCz) {
            f = (this.fCE.right - getWidth()) + this.fCz;
        }
        if (f2 > 0.0f) {
            if (this.fCE.top - f2 < this.fCz) {
                f2 = this.fCE.top - this.fCz;
            }
        } else if (this.fCE.bottom - f2 > getHeight() - this.fCz) {
            f2 = (this.fCE.bottom - getHeight()) + this.fCz;
        }
        this.fCE.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.maskColor);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.fCE, this.paint);
        canvas.drawRect(this.fCE, this.fCC);
        F(canvas);
    }

    private void F(Canvas canvas) {
        this.paint.setStrokeWidth(this.fCB);
        a(canvas, this.fCE.left - (this.fCB / 2), this.fCE.top, this.fCA, 0);
        a(canvas, this.fCE.left, this.fCE.top, 0, this.fCA);
        a(canvas, this.fCE.right + (this.fCB / 2), this.fCE.top, -this.fCA, 0);
        a(canvas, this.fCE.right, this.fCE.top, 0, this.fCA);
        a(canvas, this.fCE.right, this.fCE.bottom, 0, -this.fCA);
        a(canvas, this.fCE.right + (this.fCB / 2), this.fCE.bottom, -this.fCA, 0);
        a(canvas, this.fCE.left - (this.fCB / 2), this.fCE.bottom, this.fCA, 0);
        a(canvas, this.fCE.left, this.fCE.bottom, 0, -this.fCA);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean B = B(motionEvent);
        RectF rectF = new RectF(this.fCE.left - 60.0f, this.fCE.top - 60.0f, this.fCE.right + 60.0f, 60.0f + this.fCE.bottom);
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
                float f = this.fCA;
                this.fCD.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.fCD.contains(this.fCE.left, this.fCE.top)) {
                    this.fCy = 1;
                    return true;
                } else if (this.fCD.contains(this.fCE.right, this.fCE.top)) {
                    this.fCy = 2;
                    return true;
                } else if (this.fCD.contains(this.fCE.right, this.fCE.bottom)) {
                    this.fCy = 3;
                    return true;
                } else if (this.fCD.contains(this.fCE.left, this.fCE.bottom)) {
                    this.fCy = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.fCy = -1;
                break;
            case 2:
                return C(motionEvent);
        }
        return false;
    }

    private boolean C(MotionEvent motionEvent) {
        switch (this.fCy) {
            case 1:
                i(motionEvent.getX(), motionEvent.getY(), this.fCE.right, this.fCE.bottom);
                return true;
            case 2:
                i(this.fCE.left, motionEvent.getY(), motionEvent.getX(), this.fCE.bottom);
                return true;
            case 3:
                i(this.fCE.left, this.fCE.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                i(motionEvent.getX(), this.fCE.top, this.fCE.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void i(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.fCE.top;
            f4 = this.fCE.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.fCE.left;
            f3 = this.fCE.right;
        }
        this.fCE.set(Math.max(this.fCz, f), Math.max(this.fCz, f2), Math.min(getWidth() - this.fCz, f3), Math.min(getHeight() - this.fCz, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.fCA;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.fCA;
    }
}
