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
    private GestureDetector dae;
    private int dbL;
    private GestureDetector.SimpleOnGestureListener eIg;
    private int eIh;
    int eIi;
    int eIj;
    int eIk;
    private Paint eIl;
    private RectF eIm;
    private RectF eIn;
    private a eIo;
    private int eIp;
    private Paint paint;

    /* loaded from: classes3.dex */
    interface a {
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        rect.left = (int) this.eIn.left;
        rect.top = (int) this.eIn.top;
        rect.right = (int) this.eIn.right;
        rect.bottom = (int) this.eIn.bottom;
        return rect;
    }

    public FrameOverlayView(Context context) {
        super(context);
        this.eIg = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.u(f, f2);
                return true;
            }
        };
        this.eIh = -1;
        this.eIi = 20;
        this.eIj = 100;
        this.eIk = 6;
        this.dbL = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.eIl = new Paint(1);
        this.eIm = new RectF();
        this.eIn = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.eIl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.eIp = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eIg = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.u(f, f2);
                return true;
            }
        };
        this.eIh = -1;
        this.eIi = 20;
        this.eIj = 100;
        this.eIk = 6;
        this.dbL = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.eIl = new Paint(1);
        this.eIm = new RectF();
        this.eIn = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.eIl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.eIp = 0;
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eIg = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.FrameOverlayView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                FrameOverlayView.this.u(f, f2);
                return true;
            }
        };
        this.eIh = -1;
        this.eIi = 20;
        this.eIj = 100;
        this.eIk = 6;
        this.dbL = Color.argb((int) SubsamplingScaleImageView.ORIENTATION_180, 0, 0, 0);
        this.paint = new Paint(1);
        this.eIl = new Paint(1);
        this.eIm = new RectF();
        this.eIn = new RectF();
        setLayerType(1, null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.eIl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.eIp = 0;
        init();
    }

    public void setOnFrameChangeListener(a aVar) {
        this.eIo = aVar;
    }

    private void init() {
        this.dae = new GestureDetector(getContext(), this.eIg);
        this.eIj = com.baidu.tieba.barselect.a.b.dpToPx(18);
        this.eIk = com.baidu.tieba.barselect.a.b.dpToPx(3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bi(i, i2);
    }

    private void bi(int i, int i2) {
        if (this.eIp == 1) {
            this.eIn.left = (int) (i * 0.05d);
            this.eIn.top = (int) (i2 * 0.25d);
        } else {
            this.eIn.left = (int) (i * 0.2d);
            this.eIn.top = (int) (i2 * 0.2d);
        }
        this.eIn.right = i - this.eIn.left;
        this.eIn.bottom = i2 - this.eIn.top;
    }

    public void setTypeWide() {
        this.eIp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f, float f2) {
        if (f > 0.0f) {
            if (this.eIn.left - f < this.eIi) {
                f = this.eIn.left - this.eIi;
            }
        } else if (this.eIn.right - f > getWidth() - this.eIi) {
            f = (this.eIn.right - getWidth()) + this.eIi;
        }
        if (f2 > 0.0f) {
            if (this.eIn.top - f2 < this.eIi) {
                f2 = this.eIn.top - this.eIi;
            }
        } else if (this.eIn.bottom - f2 > getHeight() - this.eIi) {
            f2 = (this.eIn.bottom - getHeight()) + this.eIi;
        }
        this.eIn.offset(-f, -f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.dbL);
        this.paint.setStrokeWidth(com.baidu.tieba.barselect.a.b.dpToPx(1));
        canvas.drawRect(this.eIn, this.paint);
        canvas.drawRect(this.eIn, this.eIl);
        drawCorners(canvas);
    }

    private void drawCorners(Canvas canvas) {
        this.paint.setStrokeWidth(this.eIk);
        a(canvas, this.eIn.left - (this.eIk / 2), this.eIn.top, this.eIj, 0);
        a(canvas, this.eIn.left, this.eIn.top, 0, this.eIj);
        a(canvas, this.eIn.right + (this.eIk / 2), this.eIn.top, -this.eIj, 0);
        a(canvas, this.eIn.right, this.eIn.top, 0, this.eIj);
        a(canvas, this.eIn.right, this.eIn.bottom, 0, -this.eIj);
        a(canvas, this.eIn.right + (this.eIk / 2), this.eIn.bottom, -this.eIj, 0);
        a(canvas, this.eIn.left - (this.eIk / 2), this.eIn.bottom, this.eIj, 0);
        a(canvas, this.eIn.left, this.eIn.bottom, 0, -this.eIj);
    }

    private void a(Canvas canvas, float f, float f2, int i, int i2) {
        canvas.drawLine(f, f2, f + i, f2 + i2, this.paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean B = B(motionEvent);
        RectF rectF = new RectF(this.eIn.left - 60.0f, this.eIn.top - 60.0f, this.eIn.right + 60.0f, 60.0f + this.eIn.bottom);
        if (!B && rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            this.dae.onTouchEvent(motionEvent);
            return true;
        }
        return B;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean B(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float f = this.eIj;
                this.eIm.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, f + motionEvent.getY());
                if (this.eIm.contains(this.eIn.left, this.eIn.top)) {
                    this.eIh = 1;
                    return true;
                } else if (this.eIm.contains(this.eIn.right, this.eIn.top)) {
                    this.eIh = 2;
                    return true;
                } else if (this.eIm.contains(this.eIn.right, this.eIn.bottom)) {
                    this.eIh = 3;
                    return true;
                } else if (this.eIm.contains(this.eIn.left, this.eIn.bottom)) {
                    this.eIh = 4;
                    return true;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.eIh = -1;
                break;
            case 2:
                return handleScale(motionEvent);
        }
        return false;
    }

    private boolean handleScale(MotionEvent motionEvent) {
        switch (this.eIh) {
            case 1:
                scaleTo(motionEvent.getX(), motionEvent.getY(), this.eIn.right, this.eIn.bottom);
                return true;
            case 2:
                scaleTo(this.eIn.left, motionEvent.getY(), motionEvent.getX(), this.eIn.bottom);
                return true;
            case 3:
                scaleTo(this.eIn.left, this.eIn.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 4:
                scaleTo(motionEvent.getX(), this.eIn.top, this.eIn.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void scaleTo(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            f2 = this.eIn.top;
            f4 = this.eIn.bottom;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            f = this.eIn.left;
            f3 = this.eIn.right;
        }
        this.eIn.set(Math.max(this.eIi, f), Math.max(this.eIi, f2), Math.min(getWidth() - this.eIi, f3), Math.min(getHeight() - this.eIi, f4));
        invalidate();
    }

    private float getMinimumFrameWidth() {
        return 2.4f * this.eIj;
    }

    private float getMinimumFrameHeight() {
        return 2.4f * this.eIj;
    }
}
