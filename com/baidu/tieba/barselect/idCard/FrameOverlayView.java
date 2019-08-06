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
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes3.dex */
public class FrameOverlayView extends View {
    private GestureDetector cPW;
    private int cRy;
    private GestureDetector.SimpleOnGestureListener exO;
    private int exP;
    int exQ;
    int exR;
    int exS;
    private Paint exT;
    private RectF exU;
    private RectF exV;
    private a exW;
    private int exX;
    private Paint paint;

    /* loaded from: classes3.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.exV.left;
        rect.top = (int) this.exV.top;
        rect.right = (int) this.exV.right;
        rect.bottom = (int) this.exV.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.exO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.exP = -1;
        this.exQ = 20;
        this.exR = 100;
        this.exS = 6;
        this.cRy = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.exT = new Paint(1);
        this.exU = new RectF();
        this.exV = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.exT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.exX = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.exP = -1;
        this.exQ = 20;
        this.exR = 100;
        this.exS = 6;
        this.cRy = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.exT = new Paint(1);
        this.exU = new RectF();
        this.exV = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.exT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.exX = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.exO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.exP = -1;
        this.exQ = 20;
        this.exR = 100;
        this.exS = 6;
        this.cRy = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.exT = new Paint(1);
        this.exU = new RectF();
        this.exV = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.exT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.exX = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.exW = aVar;
    }

    private void init() {
        this.cPW = new GestureDetector(getContext(), this.exO);
        this.exR = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.exS = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bg(i, i2);
    }

    private void bg(int i, int i2) {
        if (this.exX == 1) {
            this.exV.left = (int) (i * 0.05d);
            this.exV.top = (int) (i2 * 0.25d);
        } else {
            this.exV.left = (int) (i * 0.2d);
            this.exV.top = (int) (i2 * 0.2d);
        }
        this.exV.right = i - this.exV.left;
        this.exV.bottom = i2 - this.exV.top;
    }

    public void setTypeWide() {
        this.exX = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f, float f2) {
        if (f > 0.0f) {
            if (this.exV.left - f < this.exQ) {
                f = this.exV.left - this.exQ;
            }
        } else if (this.exV.right - f > getWidth() - this.exQ) {
            f = (this.exV.right - getWidth()) + this.exQ;
        }
        if (f2 > 0.0f) {
            if (this.exV.top - f2 < this.exQ) {
                f2 = this.exV.top - this.exQ;
            }
        } else if (this.exV.bottom - f2 > getHeight() - this.exQ) {
            f2 = (this.exV.bottom - getHeight()) + this.exQ;
        }
        this.exV.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.cRy);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.exV, this.paint);
        canvas.drawRect(this.exV, this.exT);
        C(canvas);
    }

    private void C(Canvas canvas) {
        this.paint.setStrokeWidth(this.exS);
        a(canvas, this.exV.left - (this.exS / 2), this.exV.top, this.exR, 0);
        a(canvas, this.exV.left, this.exV.top, 0, this.exR);
        a(canvas, this.exV.right + (this.exS / 2), this.exV.top, -this.exR, 0);
        a(canvas, this.exV.right, this.exV.top, 0, this.exR);
        a(canvas, this.exV.right, this.exV.bottom, 0, -this.exR);
        a(canvas, this.exV.right + (this.exS / 2), this.exV.bottom, -this.exR, 0);
        a(canvas, this.exV.left - (this.exS / 2), this.exV.bottom, this.exR, 0);
        a(canvas, this.exV.left, this.exV.bottom, 0, -this.exR);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean J = J(motionEvent);
        RectF rectF = new RectF(this.exV.left - 60.0f, this.exV.top - 60.0f, this.exV.right + 60.0f, 60.0f + this.exV.bottom);
        if (!J && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.cPW.onTouchEvent(motionEvent);
            return true;
        }
        return J;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean J(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.exR;
                this.exU.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.exU.contains(this.exV.left, this.exV.top)) {
                    this.exP = 1;
                    return true;
                } else if (this.exU.contains(this.exV.right, this.exV.top)) {
                    this.exP = 2;
                    return true;
                } else if (this.exU.contains(this.exV.right, this.exV.bottom)) {
                    this.exP = 3;
                    return true;
                } else if (this.exU.contains(this.exV.left, this.exV.bottom)) {
                    this.exP = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.exP = -1;
                break;
            case 2:
                return K(motionEvent);
        }
        return false;
    }

    private boolean K(MotionEvent motionEvent) {
        switch (this.exP) {
            case 1:
                j(motionEvent.getX(), motionEvent.getY(), this.exV.right, this.exV.bottom);
                return true;
            case 2:
                j(this.exV.left, motionEvent.getY(), motionEvent.getX(), this.exV.bottom);
                return true;
            case 3:
                j(this.exV.left, this.exV.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                j(motionEvent.getX(), this.exV.top, this.exV.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void j(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.exV.top;
            f4 = this.exV.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.exV.left;
            f3 = this.exV.right;
        }
        this.exV.set(Math.max(this.exQ, f), Math.max(this.exQ, f2), Math.min(getWidth() - this.exQ, f3), Math.min(getHeight() - this.exQ, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.exR;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.exR;
    }
}
