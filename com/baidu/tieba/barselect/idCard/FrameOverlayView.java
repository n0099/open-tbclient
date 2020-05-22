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
    private int ewJ;
    private GestureDetector gestureDetector;
    private a gzA;
    private int gzB;
    private GestureDetector.SimpleOnGestureListener gzs;
    private int gzt;
    int gzu;
    int gzv;
    int gzw;
    private Paint gzx;
    private RectF gzy;
    private RectF gzz;
    private Paint paint;

    /* loaded from: classes8.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.gzz.left;
        rect.top = (int) this.gzz.top;
        rect.right = (int) this.gzz.right;
        rect.bottom = (int) this.gzz.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.gzs = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gzt = -1;
        this.gzu = 20;
        this.gzv = 100;
        this.gzw = 6;
        this.ewJ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gzx = new Paint(1);
        this.gzy = new RectF();
        this.gzz = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gzx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gzB = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzs = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gzt = -1;
        this.gzu = 20;
        this.gzv = 100;
        this.gzw = 6;
        this.ewJ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gzx = new Paint(1);
        this.gzy = new RectF();
        this.gzz = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gzx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gzB = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzs = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.v(f, f2);
                return true;
            }
        };
        this.gzt = -1;
        this.gzu = 20;
        this.gzv = 100;
        this.gzw = 6;
        this.ewJ = Color.argb(180, 0, 0, 0);
        this.paint = new Paint(1);
        this.gzx = new Paint(1);
        this.gzy = new RectF();
        this.gzz = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.gzx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.gzB = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.gzA = aVar;
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.gzs);
        this.gzv = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.gzw = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bH(i, i2);
    }

    private void bH(int i, int i2) {
        if (this.gzB == 1) {
            this.gzz.left = (int) (i * 0.05d);
            this.gzz.top = (int) (i2 * 0.25d);
        } else {
            this.gzz.left = (int) (i * 0.2d);
            this.gzz.top = (int) (i2 * 0.2d);
        }
        this.gzz.right = i - this.gzz.left;
        this.gzz.bottom = i2 - this.gzz.top;
    }

    public void setTypeWide() {
        this.gzB = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (f > 0.0f) {
            if (this.gzz.left - f < this.gzu) {
                f = this.gzz.left - this.gzu;
            }
        } else if (this.gzz.right - f > getWidth() - this.gzu) {
            f = (this.gzz.right - getWidth()) + this.gzu;
        }
        if (f2 > 0.0f) {
            if (this.gzz.top - f2 < this.gzu) {
                f2 = this.gzz.top - this.gzu;
            }
        } else if (this.gzz.bottom - f2 > getHeight() - this.gzu) {
            f2 = (this.gzz.bottom - getHeight()) + this.gzu;
        }
        this.gzz.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.ewJ);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.gzz, this.paint);
        canvas.drawRect(this.gzz, this.gzx);
        H(canvas);
    }

    private void H(Canvas canvas) {
        this.paint.setStrokeWidth(this.gzw);
        a(canvas, this.gzz.left - (this.gzw / 2), this.gzz.top, this.gzv, 0);
        a(canvas, this.gzz.left, this.gzz.top, 0, this.gzv);
        a(canvas, this.gzz.right + (this.gzw / 2), this.gzz.top, -this.gzv, 0);
        a(canvas, this.gzz.right, this.gzz.top, 0, this.gzv);
        a(canvas, this.gzz.right, this.gzz.bottom, 0, -this.gzv);
        a(canvas, this.gzz.right + (this.gzw / 2), this.gzz.bottom, -this.gzv, 0);
        a(canvas, this.gzz.left - (this.gzw / 2), this.gzz.bottom, this.gzv, 0);
        a(canvas, this.gzz.left, this.gzz.bottom, 0, -this.gzv);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean F = F(motionEvent);
        RectF rectF = new RectF(this.gzz.left - 60.0f, this.gzz.top - 60.0f, this.gzz.right + 60.0f, 60.0f + this.gzz.bottom);
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
                float f = this.gzv;
                this.gzy.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.gzy.contains(this.gzz.left, this.gzz.top)) {
                    this.gzt = 1;
                    return true;
                } else if (this.gzy.contains(this.gzz.right, this.gzz.top)) {
                    this.gzt = 2;
                    return true;
                } else if (this.gzy.contains(this.gzz.right, this.gzz.bottom)) {
                    this.gzt = 3;
                    return true;
                } else if (this.gzy.contains(this.gzz.left, this.gzz.bottom)) {
                    this.gzt = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.gzt = -1;
                break;
            case 2:
                return G(motionEvent);
        }
        return false;
    }

    private boolean G(MotionEvent motionEvent) {
        switch (this.gzt) {
            case 1:
                f(motionEvent.getX(), motionEvent.getY(), this.gzz.right, this.gzz.bottom);
                return true;
            case 2:
                f(this.gzz.left, motionEvent.getY(), motionEvent.getX(), this.gzz.bottom);
                return true;
            case 3:
                f(this.gzz.left, this.gzz.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                f(motionEvent.getX(), this.gzz.top, this.gzz.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void f(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.gzz.top;
            f4 = this.gzz.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.gzz.left;
            f3 = this.gzz.right;
        }
        this.gzz.set(Math.max(this.gzu, f), Math.max(this.gzu, f2), Math.min(getWidth() - this.gzu, f3), Math.min(getHeight() - this.gzu, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.gzv;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.gzv;
    }
}
