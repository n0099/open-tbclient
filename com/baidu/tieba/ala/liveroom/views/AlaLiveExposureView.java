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
/* loaded from: classes10.dex */
public class AlaLiveExposureView extends View {
    private int bLu;
    private float cFL;
    private Paint fCF;
    private Paint hRR;
    private int hRS;
    private int hRT;
    private float hRU;
    private float hRV;
    private a hRW;
    private Runnable hRX;
    private int mActivePointerId;
    private Paint mCirclePaint;
    private float mDownX;

    /* loaded from: classes10.dex */
    interface a {
        void chp();

        void onExposure(float f);
    }

    public AlaLiveExposureView(Context context) {
        super(context);
        this.bLu = 5;
        this.hRS = 4;
        this.hRT = 4;
        this.hRU = 0.5f;
        this.hRV = 0.5f;
        this.mActivePointerId = -1;
        this.hRX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLu = 5;
        this.hRS = 4;
        this.hRT = 4;
        this.hRU = 0.5f;
        this.hRV = 0.5f;
        this.mActivePointerId = -1;
        this.hRX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLu = 5;
        this.hRS = 4;
        this.hRT = 4;
        this.hRU = 0.5f;
        this.hRV = 0.5f;
        this.mActivePointerId = -1;
        this.hRX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fCF = new Paint();
        this.fCF.setAntiAlias(true);
        this.fCF.setStyle(Paint.Style.STROKE);
        this.fCF.setColor(Color.parseColor("#ffffffff"));
        this.fCF.setStrokeWidth(this.bLu);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-1);
        this.mCirclePaint.setStrokeWidth(this.hRS);
        this.hRR = new Paint();
        this.hRR.setAntiAlias(true);
        this.hRR.setStyle(Paint.Style.STROKE);
        this.hRR.setStrokeCap(Paint.Cap.ROUND);
        this.hRR.setColor(-1);
        this.hRR.setStrokeWidth(this.hRT);
    }

    public void setExposureListener(a aVar) {
        this.hRW = aVar;
    }

    public void setExposureValue(float f) {
        this.hRU = f;
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
        int height = (int) ((getHeight() - 88) * this.hRU);
        if (height > 3) {
            int width = getWidth() / 2;
            canvas.drawLine(width, 0, width, height + 0, this.fCF);
        }
    }

    private void X(Canvas canvas) {
        int height = getHeight() - 88;
        int i = height - ((int) (height * this.hRU));
        if (i > 3) {
            int width = getWidth() / 2;
            int height2 = getHeight();
            canvas.drawLine(width, height2, width, height2 - i, this.fCF);
        }
    }

    private void g(Canvas canvas) {
        int round = Math.round((getHeight() - 88) * this.hRU);
        int width = getWidth() / 2;
        int i = round + 44;
        canvas.drawArc(new RectF(width - 18, i - 18, width + 18, i + 18), 360.0f, 360.0f, false, this.mCirclePaint);
    }

    private void Y(Canvas canvas) {
        int width = getWidth() / 2;
        int height = ((int) ((getHeight() - 88) * this.hRU)) + 44;
        int round = 8 - Math.round(this.hRU * 8.0f);
        int i = (height - 18) - 8;
        int i2 = i - 4;
        for (int i3 = 0; i3 < round; i3++) {
            canvas.drawLine(width, i, width, i2, this.hRR);
            canvas.rotate(45.0f, width, height);
        }
    }

    public void cll() {
        removeCallbacks(this.hRX);
        postDelayed(this.hRX, IMConnection.RETRY_DELAY_TIMES);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.hRW != null) {
                    this.hRW.chp();
                }
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cFL = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.hRV = this.hRU;
                    removeCallbacks(this.hRX);
                    return true;
                }
                break;
            case 1:
            case 3:
                cll();
                break;
            case 2:
                getDiffX(motionEvent);
                float M = ((M(motionEvent) * 1.0f) / (getHeight() - 88)) + this.hRV;
                float f = M < 1.0f ? M : 1.0f;
                float f2 = f > 0.0f ? f : 0.0f;
                if (f2 != this.hRU) {
                    this.hRU = f2;
                    if (this.hRW != null) {
                        this.hRW.onExposure(this.hRU);
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cFL);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }
}
