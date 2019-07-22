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
    private GestureDetector cPP;
    private int cRr;
    private GestureDetector.SimpleOnGestureListener exH;
    private int exI;
    int exJ;
    int exK;
    int exL;
    private Paint exM;
    private RectF exN;
    private RectF exO;
    private a exP;
    private int exQ;
    private Paint paint;

    /* loaded from: classes3.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.exO.left;
        rect.top = (int) this.exO.top;
        rect.right = (int) this.exO.right;
        rect.bottom = (int) this.exO.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.exH = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.exI = -1;
        this.exJ = 20;
        this.exK = 100;
        this.exL = 6;
        this.cRr = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.exM = new Paint(1);
        this.exN = new RectF();
        this.exO = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.exM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.exQ = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exH = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.exI = -1;
        this.exJ = 20;
        this.exK = 100;
        this.exL = 6;
        this.cRr = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.exM = new Paint(1);
        this.exN = new RectF();
        this.exO = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.exM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.exQ = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.exH = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.exI = -1;
        this.exJ = 20;
        this.exK = 100;
        this.exL = 6;
        this.cRr = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.exM = new Paint(1);
        this.exN = new RectF();
        this.exO = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.exM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.exQ = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.exP = aVar;
    }

    private void init() {
        this.cPP = new GestureDetector(getContext(), this.exH);
        this.exK = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.exL = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bg(i, i2);
    }

    private void bg(int i, int i2) {
        if (this.exQ == 1) {
            this.exO.left = (int) (i * 0.05d);
            this.exO.top = (int) (i2 * 0.25d);
        } else {
            this.exO.left = (int) (i * 0.2d);
            this.exO.top = (int) (i2 * 0.2d);
        }
        this.exO.right = i - this.exO.left;
        this.exO.bottom = i2 - this.exO.top;
    }

    public void setTypeWide() {
        this.exQ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f, float f2) {
        if (f > 0.0f) {
            if (this.exO.left - f < this.exJ) {
                f = this.exO.left - this.exJ;
            }
        } else if (this.exO.right - f > getWidth() - this.exJ) {
            f = (this.exO.right - getWidth()) + this.exJ;
        }
        if (f2 > 0.0f) {
            if (this.exO.top - f2 < this.exJ) {
                f2 = this.exO.top - this.exJ;
            }
        } else if (this.exO.bottom - f2 > getHeight() - this.exJ) {
            f2 = (this.exO.bottom - getHeight()) + this.exJ;
        }
        this.exO.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.cRr);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.exO, this.paint);
        canvas.drawRect(this.exO, this.exM);
        C(canvas);
    }

    private void C(Canvas canvas) {
        this.paint.setStrokeWidth(this.exL);
        a(canvas, this.exO.left - (this.exL / 2), this.exO.top, this.exK, 0);
        a(canvas, this.exO.left, this.exO.top, 0, this.exK);
        a(canvas, this.exO.right + (this.exL / 2), this.exO.top, -this.exK, 0);
        a(canvas, this.exO.right, this.exO.top, 0, this.exK);
        a(canvas, this.exO.right, this.exO.bottom, 0, -this.exK);
        a(canvas, this.exO.right + (this.exL / 2), this.exO.bottom, -this.exK, 0);
        a(canvas, this.exO.left - (this.exL / 2), this.exO.bottom, this.exK, 0);
        a(canvas, this.exO.left, this.exO.bottom, 0, -this.exK);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean J = J(motionEvent);
        RectF rectF = new RectF(this.exO.left - 60.0f, this.exO.top - 60.0f, this.exO.right + 60.0f, 60.0f + this.exO.bottom);
        if (!J && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.cPP.onTouchEvent(motionEvent);
            return true;
        }
        return J;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean J(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.exK;
                this.exN.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.exN.contains(this.exO.left, this.exO.top)) {
                    this.exI = 1;
                    return true;
                } else if (this.exN.contains(this.exO.right, this.exO.top)) {
                    this.exI = 2;
                    return true;
                } else if (this.exN.contains(this.exO.right, this.exO.bottom)) {
                    this.exI = 3;
                    return true;
                } else if (this.exN.contains(this.exO.left, this.exO.bottom)) {
                    this.exI = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.exI = -1;
                break;
            case 2:
                return K(motionEvent);
        }
        return false;
    }

    private boolean K(MotionEvent motionEvent) {
        switch (this.exI) {
            case 1:
                j(motionEvent.getX(), motionEvent.getY(), this.exO.right, this.exO.bottom);
                return true;
            case 2:
                j(this.exO.left, motionEvent.getY(), motionEvent.getX(), this.exO.bottom);
                return true;
            case 3:
                j(this.exO.left, this.exO.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                j(motionEvent.getX(), this.exO.top, this.exO.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void j(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.exO.top;
            f4 = this.exO.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.exO.left;
            f3 = this.exO.right;
        }
        this.exO.set(Math.max(this.exJ, f), Math.max(this.exJ, f2), Math.min(getWidth() - this.exJ, f3), Math.min(getHeight() - this.exJ, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.exK;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.exK;
    }
}
