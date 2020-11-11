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
    private int fAC;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener hTh;
    private int hTi;
    int hTj;
    int hTk;
    private Paint hTl;
    private RectF hTm;
    private RectF hTn;
    private a hTo;
    private int hTp;
    int margin;
    private Paint paint;

    /* loaded from: classes21.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.hTn.left;
        rect.top = (int) this.hTn.top;
        rect.right = (int) this.hTn.right;
        rect.bottom = (int) this.hTn.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.hTh = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.C(f, f2);
                return true;
            }
        };
        this.hTi = -1;
        this.margin = 20;
        this.hTj = 100;
        this.hTk = 6;
        this.fAC = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hTl = new Paint(1);
        this.hTm = new RectF();
        this.hTn = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hTl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hTp = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hTh = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.C(f, f2);
                return true;
            }
        };
        this.hTi = -1;
        this.margin = 20;
        this.hTj = 100;
        this.hTk = 6;
        this.fAC = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hTl = new Paint(1);
        this.hTm = new RectF();
        this.hTn = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hTl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hTp = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTh = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.C(f, f2);
                return true;
            }
        };
        this.hTi = -1;
        this.margin = 20;
        this.hTj = 100;
        this.hTk = 6;
        this.fAC = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.hTl = new Paint(1);
        this.hTm = new RectF();
        this.hTn = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.hTl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hTp = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.hTo = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.hTh);
        this.hTj = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.hTk = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cd(i, i2);
    }

    private void cd(int i, int i2) {
        if (this.hTp == 1) {
            this.hTn.left = (int) (i * 0.05d);
            this.hTn.top = (int) (i2 * 0.25d);
        } else {
            this.hTn.left = (int) (i * 0.2d);
            this.hTn.top = (int) (i2 * 0.2d);
        }
        this.hTn.right = i - this.hTn.left;
        this.hTn.bottom = i2 - this.hTn.top;
    }

    public void setTypeWide() {
        this.hTp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f, float f2) {
        if (f > 0.0f) {
            if (this.hTn.left - f < this.margin) {
                f = this.hTn.left - this.margin;
            }
        } else if (this.hTn.right - f > getWidth() - this.margin) {
            f = (this.hTn.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.hTn.top - f2 < this.margin) {
                f2 = this.hTn.top - this.margin;
            }
        } else if (this.hTn.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.hTn.bottom - getHeight()) + this.margin;
        }
        this.hTn.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fAC);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.hTn, this.paint);
        canvas.drawRect(this.hTn, this.hTl);
        Q(canvas);
    }

    private void Q(Canvas canvas) {
        this.paint.setStrokeWidth(this.hTk);
        a(canvas, this.hTn.left - (this.hTk / 2), this.hTn.top, this.hTj, 0);
        a(canvas, this.hTn.left, this.hTn.top, 0, this.hTj);
        a(canvas, this.hTn.right + (this.hTk / 2), this.hTn.top, -this.hTj, 0);
        a(canvas, this.hTn.right, this.hTn.top, 0, this.hTj);
        a(canvas, this.hTn.right, this.hTn.bottom, 0, -this.hTj);
        a(canvas, this.hTn.right + (this.hTk / 2), this.hTn.bottom, -this.hTj, 0);
        a(canvas, this.hTn.left - (this.hTk / 2), this.hTn.bottom, this.hTj, 0);
        a(canvas, this.hTn.left, this.hTn.bottom, 0, -this.hTj);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean X = X(motionEvent);
        RectF rectF = new RectF(this.hTn.left - 60.0f, this.hTn.top - 60.0f, this.hTn.right + 60.0f, 60.0f + this.hTn.bottom);
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
                float f = this.hTj;
                this.hTm.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.hTm.contains(this.hTn.left, this.hTn.top)) {
                    this.hTi = 1;
                    return true;
                } else if (this.hTm.contains(this.hTn.right, this.hTn.top)) {
                    this.hTi = 2;
                    return true;
                } else if (this.hTm.contains(this.hTn.right, this.hTn.bottom)) {
                    this.hTi = 3;
                    return true;
                } else if (this.hTm.contains(this.hTn.left, this.hTn.bottom)) {
                    this.hTi = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.hTi = -1;
                break;
            case 2:
                return Y(motionEvent);
        }
        return false;
    }

    private boolean Y(MotionEvent motionEvent) {
        switch (this.hTi) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.hTn.right, this.hTn.bottom);
                return true;
            case 2:
                f(this.hTn.left, motionEvent.getY(), motionEvent.getX(), this.hTn.bottom);
                return true;
            case 3:
                f(this.hTn.left, this.hTn.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.hTn.top, this.hTn.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.hTn.top;
            f4 = this.hTn.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.hTn.left;
            f3 = this.hTn.right;
        }
        this.hTn.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.hTj;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.hTj;
    }
}
