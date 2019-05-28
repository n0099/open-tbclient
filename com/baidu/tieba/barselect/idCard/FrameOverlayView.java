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
    private GestureDetector cOs;
    private int cPU;
    private GestureDetector.SimpleOnGestureListener esJ;
    private int esK;
    int esL;
    int esM;
    int esN;
    private Paint esO;
    private RectF esP;
    private RectF esQ;
    private a esR;
    private int esS;
    private Paint paint;

    /* loaded from: classes3.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.esQ.left;
        rect.top = (int) this.esQ.top;
        rect.right = (int) this.esQ.right;
        rect.bottom = (int) this.esQ.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.esJ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.translate(f, f2);
                return true;
            }
        };
        this.esK = -1;
        this.esL = 20;
        this.esM = 100;
        this.esN = 6;
        this.cPU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.esO = new Paint(1);
        this.esP = new RectF();
        this.esQ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.esO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.esS = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.esJ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.translate(f, f2);
                return true;
            }
        };
        this.esK = -1;
        this.esL = 20;
        this.esM = 100;
        this.esN = 6;
        this.cPU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.esO = new Paint(1);
        this.esP = new RectF();
        this.esQ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.esO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.esS = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.esJ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.translate(f, f2);
                return true;
            }
        };
        this.esK = -1;
        this.esL = 20;
        this.esM = 100;
        this.esN = 6;
        this.cPU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.esO = new Paint(1);
        this.esP = new RectF();
        this.esQ = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.esO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.esS = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.esR = aVar;
    }

    private void init() {
        this.cOs = new GestureDetector(getContext(), this.esJ);
        this.esM = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.esN = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bb(i, i2);
    }

    private void bb(int i, int i2) {
        if (this.esS == 1) {
            this.esQ.left = (int) (i * 0.05d);
            this.esQ.top = (int) (i2 * 0.25d);
        } else {
            this.esQ.left = (int) (i * 0.2d);
            this.esQ.top = (int) (i2 * 0.2d);
        }
        this.esQ.right = i - this.esQ.left;
        this.esQ.bottom = i2 - this.esQ.top;
    }

    public void setTypeWide() {
        this.esS = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translate(float f, float f2) {
        if (f > 0.0f) {
            if (this.esQ.left - f < this.esL) {
                f = this.esQ.left - this.esL;
            }
        } else if (this.esQ.right - f > getWidth() - this.esL) {
            f = (this.esQ.right - getWidth()) + this.esL;
        }
        if (f2 > 0.0f) {
            if (this.esQ.top - f2 < this.esL) {
                f2 = this.esQ.top - this.esL;
            }
        } else if (this.esQ.bottom - f2 > getHeight() - this.esL) {
            f2 = (this.esQ.bottom - getHeight()) + this.esL;
        }
        this.esQ.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.cPU);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.esQ, this.paint);
        canvas.drawRect(this.esQ, this.esO);
        C(canvas);
    }

    private void C(Canvas canvas) {
        this.paint.setStrokeWidth(this.esN);
        a(canvas, this.esQ.left - (this.esN / 2), this.esQ.top, this.esM, 0);
        a(canvas, this.esQ.left, this.esQ.top, 0, this.esM);
        a(canvas, this.esQ.right + (this.esN / 2), this.esQ.top, -this.esM, 0);
        a(canvas, this.esQ.right, this.esQ.top, 0, this.esM);
        a(canvas, this.esQ.right, this.esQ.bottom, 0, -this.esM);
        a(canvas, this.esQ.right + (this.esN / 2), this.esQ.bottom, -this.esM, 0);
        a(canvas, this.esQ.left - (this.esN / 2), this.esQ.bottom, this.esM, 0);
        a(canvas, this.esQ.left, this.esQ.bottom, 0, -this.esM);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean J = J(motionEvent);
        RectF rectF = new RectF(this.esQ.left - 60.0f, this.esQ.top - 60.0f, this.esQ.right + 60.0f, 60.0f + this.esQ.bottom);
        if (!J && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.cOs.onTouchEvent(motionEvent);
            return true;
        }
        return J;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean J(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.esM;
                this.esP.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.esP.contains(this.esQ.left, this.esQ.top)) {
                    this.esK = 1;
                    return true;
                } else if (this.esP.contains(this.esQ.right, this.esQ.top)) {
                    this.esK = 2;
                    return true;
                } else if (this.esP.contains(this.esQ.right, this.esQ.bottom)) {
                    this.esK = 3;
                    return true;
                } else if (this.esP.contains(this.esQ.left, this.esQ.bottom)) {
                    this.esK = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.esK = -1;
                break;
            case 2:
                return K(motionEvent);
        }
        return false;
    }

    private boolean K(MotionEvent motionEvent) {
        switch (this.esK) {
            case 1:
                j(motionEvent.getX(), motionEvent.getY(), this.esQ.right, this.esQ.bottom);
                return true;
            case 2:
                j(this.esQ.left, motionEvent.getY(), motionEvent.getX(), this.esQ.bottom);
                return true;
            case 3:
                j(this.esQ.left, this.esQ.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                j(motionEvent.getX(), this.esQ.top, this.esQ.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void j(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.esQ.top;
            f4 = this.esQ.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.esQ.left;
            f3 = this.esQ.right;
        }
        this.esQ.set(Math.max(this.esL, f), Math.max(this.esL, f2), Math.min(getWidth() - this.esL, f3), Math.min(getHeight() - this.esL, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.esM;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.esM;
    }
}
