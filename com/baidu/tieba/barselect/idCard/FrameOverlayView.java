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
    private int fRt;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener irb;
    private int irc;
    int ird;
    int ire;
    private Paint irf;
    private RectF irg;
    private RectF irh;
    private a iri;
    private int irj;
    int margin;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.irh.left;
        rect.top = (int) this.irh.top;
        rect.right = (int) this.irh.right;
        rect.bottom = (int) this.irh.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.irb = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.irc = -1;
        this.margin = 20;
        this.ird = 100;
        this.ire = 6;
        this.fRt = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.irf = new Paint(1);
        this.irg = new RectF();
        this.irh = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.irf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.irj = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.irb = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.irc = -1;
        this.margin = 20;
        this.ird = 100;
        this.ire = 6;
        this.fRt = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.irf = new Paint(1);
        this.irg = new RectF();
        this.irh = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.irf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.irj = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.irb = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.D(f, f2);
                return true;
            }
        };
        this.irc = -1;
        this.margin = 20;
        this.ird = 100;
        this.ire = 6;
        this.fRt = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.irf = new Paint(1);
        this.irg = new RectF();
        this.irh = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.irf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.irj = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.iri = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.irb);
        this.ird = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.ire = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cg(i, i2);
    }

    private void cg(int i, int i2) {
        if (this.irj == 1) {
            this.irh.left = (int) (i * 0.05d);
            this.irh.top = (int) (i2 * 0.25d);
        } else {
            this.irh.left = (int) (i * 0.2d);
            this.irh.top = (int) (i2 * 0.2d);
        }
        this.irh.right = i - this.irh.left;
        this.irh.bottom = i2 - this.irh.top;
    }

    public void setTypeWide() {
        this.irj = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(float f, float f2) {
        if (f > 0.0f) {
            if (this.irh.left - f < this.margin) {
                f = this.irh.left - this.margin;
            }
        } else if (this.irh.right - f > getWidth() - this.margin) {
            f = (this.irh.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.irh.top - f2 < this.margin) {
                f2 = this.irh.top - this.margin;
            }
        } else if (this.irh.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.irh.bottom - getHeight()) + this.margin;
        }
        this.irh.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fRt);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.irh, this.paint);
        canvas.drawRect(this.irh, this.irf);
        Z(canvas);
    }

    private void Z(Canvas canvas) {
        this.paint.setStrokeWidth(this.ire);
        a(canvas, this.irh.left - (this.ire / 2), this.irh.top, this.ird, 0);
        a(canvas, this.irh.left, this.irh.top, 0, this.ird);
        a(canvas, this.irh.right + (this.ire / 2), this.irh.top, -this.ird, 0);
        a(canvas, this.irh.right, this.irh.top, 0, this.ird);
        a(canvas, this.irh.right, this.irh.bottom, 0, -this.ird);
        a(canvas, this.irh.right + (this.ire / 2), this.irh.bottom, -this.ird, 0);
        a(canvas, this.irh.left - (this.ire / 2), this.irh.bottom, this.ird, 0);
        a(canvas, this.irh.left, this.irh.bottom, 0, -this.ird);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean X = X(motionEvent);
        RectF rectF = new RectF(this.irh.left - 60.0f, this.irh.top - 60.0f, this.irh.right + 60.0f, 60.0f + this.irh.bottom);
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
                float f = this.ird;
                this.irg.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.irg.contains(this.irh.left, this.irh.top)) {
                    this.irc = 1;
                    return true;
                } else if (this.irg.contains(this.irh.right, this.irh.top)) {
                    this.irc = 2;
                    return true;
                } else if (this.irg.contains(this.irh.right, this.irh.bottom)) {
                    this.irc = 3;
                    return true;
                } else if (this.irg.contains(this.irh.left, this.irh.bottom)) {
                    this.irc = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.irc = -1;
                break;
            case 2:
                return Y(motionEvent);
        }
        return false;
    }

    private boolean Y(MotionEvent motionEvent) {
        switch (this.irc) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.irh.right, this.irh.bottom);
                return true;
            case 2:
                f(this.irh.left, motionEvent.getY(), motionEvent.getX(), this.irh.bottom);
                return true;
            case 3:
                f(this.irh.left, this.irh.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.irh.top, this.irh.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.irh.top;
            f4 = this.irh.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.irh.left;
            f3 = this.irh.right;
        }
        this.irh.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.ird;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.ird;
    }
}
