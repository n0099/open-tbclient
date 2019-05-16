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
    private GestureDetector.SimpleOnGestureListener esI;
    private int esJ;
    int esK;
    int esL;
    int esM;
    private Paint esN;
    private RectF esO;
    private RectF esP;
    private a esQ;
    private int esR;
    private Paint paint;

    /* loaded from: classes3.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.esP.left;
        rect.top = (int) this.esP.top;
        rect.right = (int) this.esP.right;
        rect.bottom = (int) this.esP.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.esI = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.translate(f, f2);
                return true;
            }
        };
        this.esJ = -1;
        this.esK = 20;
        this.esL = 100;
        this.esM = 6;
        this.cPU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.esN = new Paint(1);
        this.esO = new RectF();
        this.esP = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.esN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.esR = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.esI = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.translate(f, f2);
                return true;
            }
        };
        this.esJ = -1;
        this.esK = 20;
        this.esL = 100;
        this.esM = 6;
        this.cPU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.esN = new Paint(1);
        this.esO = new RectF();
        this.esP = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.esN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.esR = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.esI = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.translate(f, f2);
                return true;
            }
        };
        this.esJ = -1;
        this.esK = 20;
        this.esL = 100;
        this.esM = 6;
        this.cPU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.esN = new Paint(1);
        this.esO = new RectF();
        this.esP = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.esN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.esR = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.esQ = aVar;
    }

    private void init() {
        this.cOs = new GestureDetector(getContext(), this.esI);
        this.esL = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.esM = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bb(i, i2);
    }

    private void bb(int i, int i2) {
        if (this.esR == 1) {
            this.esP.left = (int) (i * 0.05d);
            this.esP.top = (int) (i2 * 0.25d);
        } else {
            this.esP.left = (int) (i * 0.2d);
            this.esP.top = (int) (i2 * 0.2d);
        }
        this.esP.right = i - this.esP.left;
        this.esP.bottom = i2 - this.esP.top;
    }

    public void setTypeWide() {
        this.esR = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translate(float f, float f2) {
        if (f > 0.0f) {
            if (this.esP.left - f < this.esK) {
                f = this.esP.left - this.esK;
            }
        } else if (this.esP.right - f > getWidth() - this.esK) {
            f = (this.esP.right - getWidth()) + this.esK;
        }
        if (f2 > 0.0f) {
            if (this.esP.top - f2 < this.esK) {
                f2 = this.esP.top - this.esK;
            }
        } else if (this.esP.bottom - f2 > getHeight() - this.esK) {
            f2 = (this.esP.bottom - getHeight()) + this.esK;
        }
        this.esP.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.cPU);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.esP, this.paint);
        canvas.drawRect(this.esP, this.esN);
        C(canvas);
    }

    private void C(Canvas canvas) {
        this.paint.setStrokeWidth(this.esM);
        a(canvas, this.esP.left - (this.esM / 2), this.esP.top, this.esL, 0);
        a(canvas, this.esP.left, this.esP.top, 0, this.esL);
        a(canvas, this.esP.right + (this.esM / 2), this.esP.top, -this.esL, 0);
        a(canvas, this.esP.right, this.esP.top, 0, this.esL);
        a(canvas, this.esP.right, this.esP.bottom, 0, -this.esL);
        a(canvas, this.esP.right + (this.esM / 2), this.esP.bottom, -this.esL, 0);
        a(canvas, this.esP.left - (this.esM / 2), this.esP.bottom, this.esL, 0);
        a(canvas, this.esP.left, this.esP.bottom, 0, -this.esL);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean J = J(motionEvent);
        RectF rectF = new RectF(this.esP.left - 60.0f, this.esP.top - 60.0f, this.esP.right + 60.0f, 60.0f + this.esP.bottom);
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
                float f = this.esL;
                this.esO.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.esO.contains(this.esP.left, this.esP.top)) {
                    this.esJ = 1;
                    return true;
                } else if (this.esO.contains(this.esP.right, this.esP.top)) {
                    this.esJ = 2;
                    return true;
                } else if (this.esO.contains(this.esP.right, this.esP.bottom)) {
                    this.esJ = 3;
                    return true;
                } else if (this.esO.contains(this.esP.left, this.esP.bottom)) {
                    this.esJ = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.esJ = -1;
                break;
            case 2:
                return K(motionEvent);
        }
        return false;
    }

    private boolean K(MotionEvent motionEvent) {
        switch (this.esJ) {
            case 1:
                j(motionEvent.getX(), motionEvent.getY(), this.esP.right, this.esP.bottom);
                return true;
            case 2:
                j(this.esP.left, motionEvent.getY(), motionEvent.getX(), this.esP.bottom);
                return true;
            case 3:
                j(this.esP.left, this.esP.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                j(motionEvent.getX(), this.esP.top, this.esP.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void j(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.esP.top;
            f4 = this.esP.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.esP.left;
            f3 = this.esP.right;
        }
        this.esP.set(Math.max(this.esK, f), Math.max(this.esK, f2), Math.min(getWidth() - this.esK, f3), Math.min(getHeight() - this.esK, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.esL;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.esL;
    }
}
