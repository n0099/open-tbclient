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
    private int fOZ;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener irY;
    private int irZ;
    int isa;
    int isb;
    private Paint isc;
    private RectF isd;
    private RectF ise;
    private a isf;
    private int isg;
    int margin;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.ise.left;
        rect.top = (int) this.ise.top;
        rect.right = (int) this.ise.right;
        rect.bottom = (int) this.ise.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.irY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.irZ = -1;
        this.margin = 20;
        this.isa = 100;
        this.isb = 6;
        this.fOZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.isc = new Paint(1);
        this.isd = new RectF();
        this.ise = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.isc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.isg = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.irY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.irZ = -1;
        this.margin = 20;
        this.isa = 100;
        this.isb = 6;
        this.fOZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.isc = new Paint(1);
        this.isd = new RectF();
        this.ise = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.isc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.isg = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.irY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.E(f, f2);
                return true;
            }
        };
        this.irZ = -1;
        this.margin = 20;
        this.isa = 100;
        this.isb = 6;
        this.fOZ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.isc = new Paint(1);
        this.isd = new RectF();
        this.ise = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.isc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.isg = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.isf = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.irY);
        this.isa = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.isb = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cd(i, i2);
    }

    private void cd(int i, int i2) {
        if (this.isg == 1) {
            this.ise.left = (int) (i * 0.05d);
            this.ise.top = (int) (i2 * 0.25d);
        } else {
            this.ise.left = (int) (i * 0.2d);
            this.ise.top = (int) (i2 * 0.2d);
        }
        this.ise.right = i - this.ise.left;
        this.ise.bottom = i2 - this.ise.top;
    }

    public void setTypeWide() {
        this.isg = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(float f, float f2) {
        if (f > 0.0f) {
            if (this.ise.left - f < this.margin) {
                f = this.ise.left - this.margin;
            }
        } else if (this.ise.right - f > getWidth() - this.margin) {
            f = (this.ise.right - getWidth()) + this.margin;
        }
        if (f2 > 0.0f) {
            if (this.ise.top - f2 < this.margin) {
                f2 = this.ise.top - this.margin;
            }
        } else if (this.ise.bottom - f2 > getHeight() - this.margin) {
            f2 = (this.ise.bottom - getHeight()) + this.margin;
        }
        this.ise.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.fOZ);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.ise, this.paint);
        canvas.drawRect(this.ise, this.isc);
        Z(canvas);
    }

    private void Z(Canvas canvas) {
        this.paint.setStrokeWidth(this.isb);
        a(canvas, this.ise.left - (this.isb / 2), this.ise.top, this.isa, 0);
        a(canvas, this.ise.left, this.ise.top, 0, this.isa);
        a(canvas, this.ise.right + (this.isb / 2), this.ise.top, -this.isa, 0);
        a(canvas, this.ise.right, this.ise.top, 0, this.isa);
        a(canvas, this.ise.right, this.ise.bottom, 0, -this.isa);
        a(canvas, this.ise.right + (this.isb / 2), this.ise.bottom, -this.isa, 0);
        a(canvas, this.ise.left - (this.isb / 2), this.ise.bottom, this.isa, 0);
        a(canvas, this.ise.left, this.ise.bottom, 0, -this.isa);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean Y = Y(motionEvent);
        RectF rectF = new RectF(this.ise.left - 60.0f, this.ise.top - 60.0f, this.ise.right + 60.0f, 60.0f + this.ise.bottom);
        if (!Y && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return Y;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean Y(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.isa;
                this.isd.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.isd.contains(this.ise.left, this.ise.top)) {
                    this.irZ = 1;
                    return true;
                } else if (this.isd.contains(this.ise.right, this.ise.top)) {
                    this.irZ = 2;
                    return true;
                } else if (this.isd.contains(this.ise.right, this.ise.bottom)) {
                    this.irZ = 3;
                    return true;
                } else if (this.isd.contains(this.ise.left, this.ise.bottom)) {
                    this.irZ = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.irZ = -1;
                break;
            case 2:
                return Z(motionEvent);
        }
        return false;
    }

    private boolean Z(MotionEvent motionEvent) {
        switch (this.irZ) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.ise.right, this.ise.bottom);
                return true;
            case 2:
                f(this.ise.left, motionEvent.getY(), motionEvent.getX(), this.ise.bottom);
                return true;
            case 3:
                f(this.ise.left, this.ise.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.ise.top, this.ise.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.ise.top;
            f4 = this.ise.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.ise.left;
            f3 = this.ise.right;
        }
        this.ise.set(Math.max(this.margin, f), Math.max(this.margin, f2), Math.min(getWidth() - this.margin, f3), Math.min(getHeight() - this.margin, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.isa;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.isa;
    }
}
