package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes11.dex */
public class AlaLiveExposureView extends View {
    private int bJU;
    private float cEl;
    private Paint fBg;
    private Paint hPU;
    private int hPV;
    private int hPW;
    private float hPX;
    private float hPY;
    private a hPZ;
    private Runnable hQa;
    private int mActivePointerId;
    private Paint mCirclePaint;
    private float mDownX;

    /* loaded from: classes11.dex */
    interface a {
        void chc();

        void onExposure(float f);
    }

    public AlaLiveExposureView(Context context) {
        super(context);
        this.bJU = 5;
        this.hPV = 4;
        this.hPW = 4;
        this.hPX = 0.5f;
        this.hPY = 0.5f;
        this.mActivePointerId = -1;
        this.hQa = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJU = 5;
        this.hPV = 4;
        this.hPW = 4;
        this.hPX = 0.5f;
        this.hPY = 0.5f;
        this.mActivePointerId = -1;
        this.hQa = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJU = 5;
        this.hPV = 4;
        this.hPW = 4;
        this.hPX = 0.5f;
        this.hPY = 0.5f;
        this.mActivePointerId = -1;
        this.hQa = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fBg = new Paint();
        this.fBg.setAntiAlias(true);
        this.fBg.setStyle(Paint.Style.STROKE);
        this.fBg.setColor(Color.parseColor("#ffffffff"));
        this.fBg.setStrokeWidth(this.bJU);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-1);
        this.mCirclePaint.setStrokeWidth(this.hPV);
        this.hPU = new Paint();
        this.hPU.setAntiAlias(true);
        this.hPU.setStyle(Paint.Style.STROKE);
        this.hPU.setStrokeCap(Paint.Cap.ROUND);
        this.hPU.setColor(-1);
        this.hPU.setStrokeWidth(this.hPW);
    }

    public void setExposureListener(a aVar) {
        this.hPZ = aVar;
    }

    public void setExposureValue(float f) {
        this.hPX = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        W(canvas);
        X(canvas);
        g(canvas);
        Y(canvas);
    }

    private void W(Canvas canvas) {
        int height = (int) ((getHeight() - 88) * this.hPX);
        if (height > 3) {
            int width = getWidth() / 2;
            canvas.drawLine(width, 0, width, height + 0, this.fBg);
        }
    }

    private void X(Canvas canvas) {
        int height = getHeight() - 88;
        int i = height - ((int) (height * this.hPX));
        if (i > 3) {
            int width = getWidth() / 2;
            int height2 = getHeight();
            canvas.drawLine(width, height2, width, height2 - i, this.fBg);
        }
    }

    private void g(Canvas canvas) {
        int round = Math.round((getHeight() - 88) * this.hPX);
        int width = getWidth() / 2;
        int i = round + 44;
        canvas.drawArc(new RectF(width - 18, i - 18, width + 18, i + 18), 360.0f, 360.0f, false, this.mCirclePaint);
    }

    private void Y(Canvas canvas) {
        int width = getWidth() / 2;
        int height = ((int) ((getHeight() - 88) * this.hPX)) + 44;
        int round = 8 - Math.round(this.hPX * 8.0f);
        int i = (height - 18) - 8;
        int i2 = i - 4;
        for (int i3 = 0; i3 < round; i3++) {
            canvas.drawLine(width, i, width, i2, this.hPU);
            canvas.rotate(45.0f, width, height);
        }
    }

    public void ckY() {
        removeCallbacks(this.hQa);
        postDelayed(this.hQa, IMConnection.RETRY_DELAY_TIMES);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.hPZ != null) {
                    this.hPZ.chc();
                }
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cEl = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.hPY = this.hPX;
                    removeCallbacks(this.hQa);
                    return true;
                }
                break;
            case 1:
            case 3:
                ckY();
                break;
            case 2:
                getDiffX(motionEvent);
                float M = ((M(motionEvent) * 1.0f) / (getHeight() - 88)) + this.hPY;
                float f = M < 1.0f ? M : 1.0f;
                float f2 = f > 0.0f ? f : 0.0f;
                if (f2 != this.hPX) {
                    this.hPX = f2;
                    if (this.hPZ != null) {
                        this.hPZ.onExposure(this.hPX);
                    }
                }
                invalidate();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private int getDiffX(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private int M(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cEl);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }
}
