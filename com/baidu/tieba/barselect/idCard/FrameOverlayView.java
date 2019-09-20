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
    private GestureDetector cQM;
    private int cSr;
    int ezA;
    int ezB;
    int ezC;
    private Paint ezD;
    private RectF ezE;
    private RectF ezF;
    private a ezG;
    private int ezH;
    private GestureDetector.SimpleOnGestureListener ezy;
    private int ezz;
    private Paint paint;

    /* loaded from: classes3.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.ezF.left;
        rect.top = (int) this.ezF.top;
        rect.right = (int) this.ezF.right;
        rect.bottom = (int) this.ezF.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.ezy = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.ezz = -1;
        this.ezA = 20;
        this.ezB = 100;
        this.ezC = 6;
        this.cSr = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ezD = new Paint(1);
        this.ezE = new RectF();
        this.ezF = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ezD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ezH = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezy = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.ezz = -1;
        this.ezA = 20;
        this.ezB = 100;
        this.ezC = 6;
        this.cSr = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ezD = new Paint(1);
        this.ezE = new RectF();
        this.ezF = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ezD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ezH = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ezy = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.y(f, f2);
                return true;
            }
        };
        this.ezz = -1;
        this.ezA = 20;
        this.ezB = 100;
        this.ezC = 6;
        this.cSr = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.ezD = new Paint(1);
        this.ezE = new RectF();
        this.ezF = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.ezD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ezH = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.ezG = aVar;
    }

    private void init() {
        this.cQM = new GestureDetector(getContext(), this.ezy);
        this.ezB = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.ezC = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bg(i, i2);
    }

    private void bg(int i, int i2) {
        if (this.ezH == 1) {
            this.ezF.left = (int) (i * 0.05d);
            this.ezF.top = (int) (i2 * 0.25d);
        } else {
            this.ezF.left = (int) (i * 0.2d);
            this.ezF.top = (int) (i2 * 0.2d);
        }
        this.ezF.right = i - this.ezF.left;
        this.ezF.bottom = i2 - this.ezF.top;
    }

    public void setTypeWide() {
        this.ezH = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f, float f2) {
        if (f > 0.0f) {
            if (this.ezF.left - f < this.ezA) {
                f = this.ezF.left - this.ezA;
            }
        } else if (this.ezF.right - f > getWidth() - this.ezA) {
            f = (this.ezF.right - getWidth()) + this.ezA;
        }
        if (f2 > 0.0f) {
            if (this.ezF.top - f2 < this.ezA) {
                f2 = this.ezF.top - this.ezA;
            }
        } else if (this.ezF.bottom - f2 > getHeight() - this.ezA) {
            f2 = (this.ezF.bottom - getHeight()) + this.ezA;
        }
        this.ezF.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.cSr);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.ezF, this.paint);
        canvas.drawRect(this.ezF, this.ezD);
        drawCorners(canvas);
    }

    private void drawCorners(Canvas canvas) {
        this.paint.setStrokeWidth(this.ezC);
        a(canvas, this.ezF.left - (this.ezC / 2), this.ezF.top, this.ezB, 0);
        a(canvas, this.ezF.left, this.ezF.top, 0, this.ezB);
        a(canvas, this.ezF.right + (this.ezC / 2), this.ezF.top, -this.ezB, 0);
        a(canvas, this.ezF.right, this.ezF.top, 0, this.ezB);
        a(canvas, this.ezF.right, this.ezF.bottom, 0, -this.ezB);
        a(canvas, this.ezF.right + (this.ezC / 2), this.ezF.bottom, -this.ezB, 0);
        a(canvas, this.ezF.left - (this.ezC / 2), this.ezF.bottom, this.ezB, 0);
        a(canvas, this.ezF.left, this.ezF.bottom, 0, -this.ezB);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean J = J(motionEvent);
        RectF rectF = new RectF(this.ezF.left - 60.0f, this.ezF.top - 60.0f, this.ezF.right + 60.0f, 60.0f + this.ezF.bottom);
        if (!J && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.cQM.onTouchEvent(motionEvent);
            return true;
        }
        return J;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean J(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.ezB;
                this.ezE.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.ezE.contains(this.ezF.left, this.ezF.top)) {
                    this.ezz = 1;
                    return true;
                } else if (this.ezE.contains(this.ezF.right, this.ezF.top)) {
                    this.ezz = 2;
                    return true;
                } else if (this.ezE.contains(this.ezF.right, this.ezF.bottom)) {
                    this.ezz = 3;
                    return true;
                } else if (this.ezE.contains(this.ezF.left, this.ezF.bottom)) {
                    this.ezz = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.ezz = -1;
                break;
            case 2:
                return handleScale(motionEvent);
        }
        return false;
    }

    private boolean handleScale(MotionEvent motionEvent) {
        switch (this.ezz) {
            case 1:
                scaleTo(motionEvent.getX(), motionEvent.getY(), this.ezF.right, this.ezF.bottom);
                return true;
            case 2:
                scaleTo(this.ezF.left, motionEvent.getY(), motionEvent.getX(), this.ezF.bottom);
                return true;
            case 3:
                scaleTo(this.ezF.left, this.ezF.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                scaleTo(motionEvent.getX(), this.ezF.top, this.ezF.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void scaleTo(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.ezF.top;
            f4 = this.ezF.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.ezF.left;
            f3 = this.ezF.right;
        }
        this.ezF.set(Math.max(this.ezA, f), Math.max(this.ezA, f2), Math.min(getWidth() - this.ezA, f3), Math.min(getHeight() - this.ezA, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.ezB;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.ezB;
    }
}
