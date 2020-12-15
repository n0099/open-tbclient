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
    private int fHR;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener ieG;
    private int ieH;
    int ieI;
    int ieJ;
    private Paint ieK;
    private RectF ieL;
    private RectF ieM;
    private a ieN;
    private int ieO;
    int margin;
    private Paint paint;

    /* loaded from: classes21.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.ieM.left;
        rect.top = (int) this.ieM.top;
        rect.right = (int) this.ieM.right;
        rect.bottom = (int) this.ieM.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.ieG = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.ieH = -1;
        this.margin = 20;
        this.ieI = 100;
        this.ieJ = 6;
        this.fHR = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ieK = new Paint(1);
        this.ieL = new RectF();
        this.ieM = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ieK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ieO = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ieG = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.ieH = -1;
        this.margin = 20;
        this.ieI = 100;
        this.ieJ = 6;
        this.fHR = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ieK = new Paint(1);
        this.ieL = new RectF();
        this.ieM = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ieK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ieO = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ieG = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.ieH = -1;
        this.margin = 20;
        this.ieI = 100;
        this.ieJ = 6;
        this.fHR = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ieK = new Paint(1);
        this.ieL = new RectF();
        this.ieM = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ieK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ieO = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.ieN = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.ieG);
        this.ieI = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.ieJ = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ch(i, i2);
    }

    private void ch(int i, int i2) {
        if (this.ieO == 1) {
            this.ieM.left = (int) (i * 0.05d);
            this.ieM.top = (int) (i2 * 0.25d);
        } else {
            this.ieM.left = (int) (i * 0.2d);
            this.ieM.top = (int) (i2 * 0.2d);
        }
        this.ieM.right = i - this.ieM.left;
        this.ieM.bottom = i2 - this.ieM.top;
    }

    public void setTypeWide() {
        this.ieO = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(float f, float f2) {
        if (f > 0.0f) {
            if (this.ieM.left - f < this.margin) {
                f = this.ieM.left - this.margin;
            }
        } else if (this.ieM.right - f > getWidth() - this.margin) {
            f = (this.ieM.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.ieM.top - f2 < this.margin) {
                f2 = this.ieM.top - this.margin;
            }
        } else if (this.ieM.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.ieM.bottom - getHeight()) + this.margin;
        }
        this.ieM.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fHR);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.ieM, this.paint);
        canvas.drawRect(this.ieM, this.ieK);
        T(canvas);
    }

    private void T(Canvas canvas) {
        this.paint.setStrokeWidth(this.ieJ);
        a(canvas, this.ieM.left - (this.ieJ / 2), this.ieM.top, this.ieI, 0);
        a(canvas, this.ieM.left, this.ieM.top, 0, this.ieI);
        a(canvas, this.ieM.right + (this.ieJ / 2), this.ieM.top, -this.ieI, 0);
        a(canvas, this.ieM.right, this.ieM.top, 0, this.ieI);
        a(canvas, this.ieM.right, this.ieM.bottom, 0, -this.ieI);
        a(canvas, this.ieM.right + (this.ieJ / 2), this.ieM.bottom, -this.ieI, 0);
        a(canvas, this.ieM.left - (this.ieJ / 2), this.ieM.bottom, this.ieI, 0);
        a(canvas, this.ieM.left, this.ieM.bottom, 0, -this.ieI);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean X = X(motionEvent);
        RectF rectF = new RectF(this.ieM.left - 60.0f, this.ieM.top - 60.0f, this.ieM.right + 60.0f, 60.0f + this.ieM.bottom);
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
                float f = this.ieI;
                this.ieL.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.ieL.contains(this.ieM.left, this.ieM.top)) {
                    this.ieH = 1;
                    return true;
                } else if (this.ieL.contains(this.ieM.right, this.ieM.top)) {
                    this.ieH = 2;
                    return true;
                } else if (this.ieL.contains(this.ieM.right, this.ieM.bottom)) {
                    this.ieH = 3;
                    return true;
                } else if (this.ieL.contains(this.ieM.left, this.ieM.bottom)) {
                    this.ieH = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.ieH = -1;
                break;
            case 2:
                return Y(motionEvent);
        }
        return false;
    }

    private boolean Y(MotionEvent motionEvent) {
        switch (this.ieH) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.ieM.right, this.ieM.bottom);
                return true;
            case 2:
                f(this.ieM.left, motionEvent.getY(), motionEvent.getX(), this.ieM.bottom);
                return true;
            case 3:
                f(this.ieM.left, this.ieM.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.ieM.top, this.ieM.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.ieM.top;
            f4 = this.ieM.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.ieM.left;
            f3 = this.ieM.right;
        }
        this.ieM.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.ieI;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.ieI;
    }
}
