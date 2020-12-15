package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes4.dex */
public class AlaLiveExposureView extends View {
    private int bGh;
    private float cBL;
    private Paint ftT;
    private Paint hEg;
    private int hEh;
    private int hEi;
    private float hEj;
    private float hEk;
    private a hEl;
    private Runnable hEm;
    private int mActivePointerId;
    private Paint mCirclePaint;
    private float mDownX;

    /* loaded from: classes4.dex */
    interface a {
        void chm();

        void onExposure(float f);
    }

    public AlaLiveExposureView(Context context) {
        super(context);
        this.bGh = 5;
        this.hEh = 4;
        this.hEi = 4;
        this.hEj = 0.5f;
        this.hEk = 0.5f;
        this.mActivePointerId = -1;
        this.hEm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGh = 5;
        this.hEh = 4;
        this.hEi = 4;
        this.hEj = 0.5f;
        this.hEk = 0.5f;
        this.mActivePointerId = -1;
        this.hEm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGh = 5;
        this.hEh = 4;
        this.hEi = 4;
        this.hEj = 0.5f;
        this.hEk = 0.5f;
        this.mActivePointerId = -1;
        this.hEm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ftT = new Paint();
        this.ftT.setAntiAlias(true);
        this.ftT.setStyle(Paint.Style.STROKE);
        this.ftT.setColor(Color.parseColor("#ffffffff"));
        this.ftT.setStrokeWidth(this.bGh);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-1);
        this.mCirclePaint.setStrokeWidth(this.hEh);
        this.hEg = new Paint();
        this.hEg.setAntiAlias(true);
        this.hEg.setStyle(Paint.Style.STROKE);
        this.hEg.setStrokeCap(Paint.Cap.ROUND);
        this.hEg.setColor(-1);
        this.hEg.setStrokeWidth(this.hEi);
    }

    public void setExposureListener(a aVar) {
        this.hEl = aVar;
    }

    public void setExposureValue(float f) {
        this.hEj = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Q(canvas);
        R(canvas);
        f(canvas);
        S(canvas);
    }

    private void Q(Canvas canvas) {
        int height = (int) ((getHeight() - 88) * this.hEj);
        if (height > 3) {
            int width = getWidth() / 2;
            canvas.drawLine(width, 0, width, height + 0, this.ftT);
        }
    }

    private void R(Canvas canvas) {
        int height = getHeight() - 88;
        int i = height - ((int) (height * this.hEj));
        if (i > 3) {
            int width = getWidth() / 2;
            int height2 = getHeight();
            canvas.drawLine(width, height2, width, height2 - i, this.ftT);
        }
    }

    private void f(Canvas canvas) {
        int round = Math.round((getHeight() - 88) * this.hEj);
        int width = getWidth() / 2;
        int i = round + 44;
        canvas.drawArc(new RectF(width - 18, i - 18, width + 18, i + 18), 360.0f, 360.0f, false, this.mCirclePaint);
    }

    private void S(Canvas canvas) {
        int width = getWidth() / 2;
        int height = ((int) ((getHeight() - 88) * this.hEj)) + 44;
        int round = 8 - Math.round(this.hEj * 8.0f);
        int i = (height - 18) - 8;
        int i2 = i - 4;
        for (int i3 = 0; i3 < round; i3++) {
            canvas.drawLine(width, i, width, i2, this.hEg);
            canvas.rotate(45.0f, width, height);
        }
    }

    public void cla() {
        removeCallbacks(this.hEm);
        postDelayed(this.hEm, IMConnection.RETRY_DELAY_TIMES);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.hEl != null) {
                    this.hEl.chm();
                }
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cBL = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.hEk = this.hEj;
                    removeCallbacks(this.hEm);
                    return true;
                }
                break;
            case 1:
            case 3:
                cla();
                break;
            case 2:
                getDiffX(motionEvent);
                float M = ((M(motionEvent) * 1.0f) / (getHeight() - 88)) + this.hEk;
                float f = M < 1.0f ? M : 1.0f;
                float f2 = f > 0.0f ? f : 0.0f;
                if (f2 != this.hEj) {
                    this.hEj = f2;
                    if (this.hEl != null) {
                        this.hEl.onExposure(this.hEj);
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cBL);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }
}
