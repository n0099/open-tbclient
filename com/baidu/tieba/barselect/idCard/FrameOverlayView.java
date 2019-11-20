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
    private GestureDetector cZn;
    private int daU;
    private GestureDetector.SimpleOnGestureListener eHp;
    private int eHq;
    int eHr;
    int eHs;
    int eHt;
    private Paint eHu;
    private RectF eHv;
    private RectF eHw;
    private a eHx;
    private int eHy;
    private Paint paint;

    /* loaded from: classes3.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.eHw.left;
        rect.top = (int) this.eHw.top;
        rect.right = (int) this.eHw.right;
        rect.bottom = (int) this.eHw.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.eHp = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.u(f, f2);
                return true;
            }
        };
        this.eHq = -1;
        this.eHr = 20;
        this.eHs = 100;
        this.eHt = 6;
        this.daU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.eHu = new Paint(1);
        this.eHv = new RectF();
        this.eHw = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.eHu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.eHy = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHp = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.u(f, f2);
                return true;
            }
        };
        this.eHq = -1;
        this.eHr = 20;
        this.eHs = 100;
        this.eHt = 6;
        this.daU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.eHu = new Paint(1);
        this.eHv = new RectF();
        this.eHw = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.eHu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.eHy = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHp = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.u(f, f2);
                return true;
            }
        };
        this.eHq = -1;
        this.eHr = 20;
        this.eHs = 100;
        this.eHt = 6;
        this.daU = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.eHu = new Paint(1);
        this.eHv = new RectF();
        this.eHw = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.eHu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.eHy = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.eHx = aVar;
    }

    private void init() {
        this.cZn = new GestureDetector(getContext(), this.eHp);
        this.eHs = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.eHt = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bg(i, i2);
    }

    private void bg(int i, int i2) {
        if (this.eHy == 1) {
            this.eHw.left = (int) (i * 0.05d);
            this.eHw.top = (int) (i2 * 0.25d);
        } else {
            this.eHw.left = (int) (i * 0.2d);
            this.eHw.top = (int) (i2 * 0.2d);
        }
        this.eHw.right = i - this.eHw.left;
        this.eHw.bottom = i2 - this.eHw.top;
    }

    public void setTypeWide() {
        this.eHy = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f, float f2) {
        if (f > 0.0f) {
            if (this.eHw.left - f < this.eHr) {
                f = this.eHw.left - this.eHr;
            }
        } else if (this.eHw.right - f > getWidth() - this.eHr) {
            f = (this.eHw.right - getWidth()) + this.eHr;
        }
        if (f2 > 0.0f) {
            if (this.eHw.top - f2 < this.eHr) {
                f2 = this.eHw.top - this.eHr;
            }
        } else if (this.eHw.bottom - f2 > getHeight() - this.eHr) {
            f2 = (this.eHw.bottom - getHeight()) + this.eHr;
        }
        this.eHw.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.daU);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.eHw, this.paint);
        canvas.drawRect(this.eHw, this.eHu);
        drawCorners(canvas);
    }

    private void drawCorners(Canvas canvas) {
        this.paint.setStrokeWidth(this.eHt);
        a(canvas, this.eHw.left - (this.eHt / 2), this.eHw.top, this.eHs, 0);
        a(canvas, this.eHw.left, this.eHw.top, 0, this.eHs);
        a(canvas, this.eHw.right + (this.eHt / 2), this.eHw.top, -this.eHs, 0);
        a(canvas, this.eHw.right, this.eHw.top, 0, this.eHs);
        a(canvas, this.eHw.right, this.eHw.bottom, 0, -this.eHs);
        a(canvas, this.eHw.right + (this.eHt / 2), this.eHw.bottom, -this.eHs, 0);
        a(canvas, this.eHw.left - (this.eHt / 2), this.eHw.bottom, this.eHs, 0);
        a(canvas, this.eHw.left, this.eHw.bottom, 0, -this.eHs);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean B = B(motionEvent);
        RectF rectF = new RectF(this.eHw.left - 60.0f, this.eHw.top - 60.0f, this.eHw.right + 60.0f, 60.0f + this.eHw.bottom);
        if (!B && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.cZn.onTouchEvent(motionEvent);
            return true;
        }
        return B;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean B(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.eHs;
                this.eHv.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.eHv.contains(this.eHw.left, this.eHw.top)) {
                    this.eHq = 1;
                    return true;
                } else if (this.eHv.contains(this.eHw.right, this.eHw.top)) {
                    this.eHq = 2;
                    return true;
                } else if (this.eHv.contains(this.eHw.right, this.eHw.bottom)) {
                    this.eHq = 3;
                    return true;
                } else if (this.eHv.contains(this.eHw.left, this.eHw.bottom)) {
                    this.eHq = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.eHq = -1;
                break;
            case 2:
                return handleScale(motionEvent);
        }
        return false;
    }

    private boolean handleScale(MotionEvent motionEvent) {
        switch (this.eHq) {
            case 1:
                scaleTo(motionEvent.getX(), motionEvent.getY(), this.eHw.right, this.eHw.bottom);
                return true;
            case 2:
                scaleTo(this.eHw.left, motionEvent.getY(), motionEvent.getX(), this.eHw.bottom);
                return true;
            case 3:
                scaleTo(this.eHw.left, this.eHw.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                scaleTo(motionEvent.getX(), this.eHw.top, this.eHw.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void scaleTo(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.eHw.top;
            f4 = this.eHw.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.eHw.left;
            f3 = this.eHw.right;
        }
        this.eHw.set(Math.max(this.eHr, f), Math.max(this.eHr, f2), Math.min(getWidth() - this.eHr, f3), Math.min(getHeight() - this.eHr, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.eHs;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.eHs;
    }
}
