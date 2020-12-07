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
    private GestureDetector.SimpleOnGestureListener ieE;
    private int ieF;
    int ieG;
    int ieH;
    private Paint ieI;
    private RectF ieJ;
    private RectF ieK;
    private a ieL;
    private int ieM;
    int margin;
    private Paint paint;

    /* loaded from: classes21.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.ieK.left;
        rect.top = (int) this.ieK.top;
        rect.right = (int) this.ieK.right;
        rect.bottom = (int) this.ieK.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.ieE = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.ieF = -1;
        this.margin = 20;
        this.ieG = 100;
        this.ieH = 6;
        this.fHR = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ieI = new Paint(1);
        this.ieJ = new RectF();
        this.ieK = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ieI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ieM = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ieE = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.ieF = -1;
        this.margin = 20;
        this.ieG = 100;
        this.ieH = 6;
        this.fHR = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ieI = new Paint(1);
        this.ieJ = new RectF();
        this.ieK = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ieI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ieM = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ieE = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.ieF = -1;
        this.margin = 20;
        this.ieG = 100;
        this.ieH = 6;
        this.fHR = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ieI = new Paint(1);
        this.ieJ = new RectF();
        this.ieK = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ieI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ieM = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.ieL = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.ieE);
        this.ieG = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.ieH = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ch(i, i2);
    }

    private void ch(int i, int i2) {
        if (this.ieM == 1) {
            this.ieK.left = (int) (i * 0.05d);
            this.ieK.top = (int) (i2 * 0.25d);
        } else {
            this.ieK.left = (int) (i * 0.2d);
            this.ieK.top = (int) (i2 * 0.2d);
        }
        this.ieK.right = i - this.ieK.left;
        this.ieK.bottom = i2 - this.ieK.top;
    }

    public void setTypeWide() {
        this.ieM = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(float f, float f2) {
        if (f > 0.0f) {
            if (this.ieK.left - f < this.margin) {
                f = this.ieK.left - this.margin;
            }
        } else if (this.ieK.right - f > getWidth() - this.margin) {
            f = (this.ieK.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.ieK.top - f2 < this.margin) {
                f2 = this.ieK.top - this.margin;
            }
        } else if (this.ieK.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.ieK.bottom - getHeight()) + this.margin;
        }
        this.ieK.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fHR);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.ieK, this.paint);
        canvas.drawRect(this.ieK, this.ieI);
        T(canvas);
    }

    private void T(Canvas canvas) {
        this.paint.setStrokeWidth(this.ieH);
        a(canvas, this.ieK.left - (this.ieH / 2), this.ieK.top, this.ieG, 0);
        a(canvas, this.ieK.left, this.ieK.top, 0, this.ieG);
        a(canvas, this.ieK.right + (this.ieH / 2), this.ieK.top, -this.ieG, 0);
        a(canvas, this.ieK.right, this.ieK.top, 0, this.ieG);
        a(canvas, this.ieK.right, this.ieK.bottom, 0, -this.ieG);
        a(canvas, this.ieK.right + (this.ieH / 2), this.ieK.bottom, -this.ieG, 0);
        a(canvas, this.ieK.left - (this.ieH / 2), this.ieK.bottom, this.ieG, 0);
        a(canvas, this.ieK.left, this.ieK.bottom, 0, -this.ieG);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean X = X(motionEvent);
        RectF rectF = new RectF(this.ieK.left - 60.0f, this.ieK.top - 60.0f, this.ieK.right + 60.0f, 60.0f + this.ieK.bottom);
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
                float f = this.ieG;
                this.ieJ.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.ieJ.contains(this.ieK.left, this.ieK.top)) {
                    this.ieF = 1;
                    return true;
                } else if (this.ieJ.contains(this.ieK.right, this.ieK.top)) {
                    this.ieF = 2;
                    return true;
                } else if (this.ieJ.contains(this.ieK.right, this.ieK.bottom)) {
                    this.ieF = 3;
                    return true;
                } else if (this.ieJ.contains(this.ieK.left, this.ieK.bottom)) {
                    this.ieF = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.ieF = -1;
                break;
            case 2:
                return Y(motionEvent);
        }
        return false;
    }

    private boolean Y(MotionEvent motionEvent) {
        switch (this.ieF) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.ieK.right, this.ieK.bottom);
                return true;
            case 2:
                f(this.ieK.left, motionEvent.getY(), motionEvent.getX(), this.ieK.bottom);
                return true;
            case 3:
                f(this.ieK.left, this.ieK.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.ieK.top, this.ieK.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.ieK.top;
            f4 = this.ieK.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.ieK.left;
            f3 = this.ieK.right;
        }
        this.ieK.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.ieG;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.ieG;
    }
}
