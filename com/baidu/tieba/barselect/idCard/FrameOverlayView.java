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
    private int ewU;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener gzD;
    private int gzE;
    int gzF;
    int gzG;
    int gzH;
    private Paint gzI;
    private RectF gzJ;
    private RectF gzK;
    private a gzL;
    private int gzM;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.gzK.left;
        rect.top = (int) this.gzK.top;
        rect.right = (int) this.gzK.right;
        rect.bottom = (int) this.gzK.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.gzD = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gzE = -1;
        this.gzF = 20;
        this.gzG = 100;
        this.gzH = 6;
        this.ewU = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gzI = new Paint(1);
        this.gzJ = new RectF();
        this.gzK = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gzI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gzM = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzD = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gzE = -1;
        this.gzF = 20;
        this.gzG = 100;
        this.gzH = 6;
        this.ewU = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gzI = new Paint(1);
        this.gzJ = new RectF();
        this.gzK = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gzI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gzM = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzD = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gzE = -1;
        this.gzF = 20;
        this.gzG = 100;
        this.gzH = 6;
        this.ewU = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gzI = new Paint(1);
        this.gzJ = new RectF();
        this.gzK = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gzI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gzM = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.gzL = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.gzD);
        this.gzG = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.gzH = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bH(i, i2);
    }

    private void bH(int i, int i2) {
        if (this.gzM == 1) {
            this.gzK.left = (int) (i * 0.05d);
            this.gzK.top = (int) (i2 * 0.25d);
        } else {
            this.gzK.left = (int) (i * 0.2d);
            this.gzK.top = (int) (i2 * 0.2d);
        }
        this.gzK.right = i - this.gzK.left;
        this.gzK.bottom = i2 - this.gzK.top;
    }

    public void setTypeWide() {
        this.gzM = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (f > 0.0f) {
            if (this.gzK.left - f < this.gzF) {
                f = this.gzK.left - this.gzF;
            }
        } else if (this.gzK.right - f > getWidth() - this.gzF) {
            f = (this.gzK.right - getWidth()) + this.gzF;
        }
        if (f2 > 0.0f) {
            if (this.gzK.top - f2 < this.gzF) {
                f2 = this.gzK.top - this.gzF;
            }
        } else if (this.gzK.bottom - f2 > getHeight() - this.gzF) {
            f2 = (this.gzK.bottom - getHeight()) + this.gzF;
        }
        this.gzK.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.ewU);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.gzK, this.paint);
        canvas.drawRect(this.gzK, this.gzI);
        H(canvas);
    }

    private void H(Canvas canvas) {
        this.paint.setStrokeWidth(this.gzH);
        a(canvas, this.gzK.left - (this.gzH / 2), this.gzK.top, this.gzG, 0);
        a(canvas, this.gzK.left, this.gzK.top, 0, this.gzG);
        a(canvas, this.gzK.right + (this.gzH / 2), this.gzK.top, -this.gzG, 0);
        a(canvas, this.gzK.right, this.gzK.top, 0, this.gzG);
        a(canvas, this.gzK.right, this.gzK.bottom, 0, -this.gzG);
        a(canvas, this.gzK.right + (this.gzH / 2), this.gzK.bottom, -this.gzG, 0);
        a(canvas, this.gzK.left - (this.gzH / 2), this.gzK.bottom, this.gzG, 0);
        a(canvas, this.gzK.left, this.gzK.bottom, 0, -this.gzG);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean F = F(motionEvent);
        RectF rectF = new RectF(this.gzK.left - 60.0f, this.gzK.top - 60.0f, this.gzK.right + 60.0f, 60.0f + this.gzK.bottom);
        if (!F && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return F;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean F(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.gzG;
                this.gzJ.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.gzJ.contains(this.gzK.left, this.gzK.top)) {
                    this.gzE = 1;
                    return true;
                } else if (this.gzJ.contains(this.gzK.right, this.gzK.top)) {
                    this.gzE = 2;
                    return true;
                } else if (this.gzJ.contains(this.gzK.right, this.gzK.bottom)) {
                    this.gzE = 3;
                    return true;
                } else if (this.gzJ.contains(this.gzK.left, this.gzK.bottom)) {
                    this.gzE = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.gzE = -1;
                break;
            case 2:
                return G(motionEvent);
        }
        return false;
    }

    private boolean G(MotionEvent motionEvent) {
        switch (this.gzE) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.gzK.right, this.gzK.bottom);
                return true;
            case 2:
                f(this.gzK.left, motionEvent.getY(), motionEvent.getX(), this.gzK.bottom);
                return true;
            case 3:
                f(this.gzK.left, this.gzK.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.gzK.top, this.gzK.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.gzK.top;
            f4 = this.gzK.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.gzK.left;
            f3 = this.gzK.right;
        }
        this.gzK.set(Math.max(this.gzF, f), Math.max(this.gzF, f2), Math.min(getWidth() - this.gzF, f3), Math.min(getHeight() - this.gzF, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.gzG;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.gzG;
    }
}
