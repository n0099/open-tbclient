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
    private int bCK;
    private float cwD;
    private Paint fnh;
    private Paint huU;
    private int huV;
    private int huW;
    private float huX;
    private float huY;
    private a huZ;
    private Runnable hva;
    private int mActivePointerId;
    private Paint mCirclePaint;
    private float mDownX;

    /* loaded from: classes4.dex */
    interface a {
        void cea();

        void onExposure(float f);
    }

    public AlaLiveExposureView(Context context) {
        super(context);
        this.bCK = 5;
        this.huV = 4;
        this.huW = 4;
        this.huX = 0.5f;
        this.huY = 0.5f;
        this.mActivePointerId = -1;
        this.hva = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCK = 5;
        this.huV = 4;
        this.huW = 4;
        this.huX = 0.5f;
        this.huY = 0.5f;
        this.mActivePointerId = -1;
        this.hva = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCK = 5;
        this.huV = 4;
        this.huW = 4;
        this.huX = 0.5f;
        this.huY = 0.5f;
        this.mActivePointerId = -1;
        this.hva = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fnh = new Paint();
        this.fnh.setAntiAlias(true);
        this.fnh.setStyle(Paint.Style.STROKE);
        this.fnh.setColor(Color.parseColor("#ffffffff"));
        this.fnh.setStrokeWidth(this.bCK);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-1);
        this.mCirclePaint.setStrokeWidth(this.huV);
        this.huU = new Paint();
        this.huU.setAntiAlias(true);
        this.huU.setStyle(Paint.Style.STROKE);
        this.huU.setStrokeCap(Paint.Cap.ROUND);
        this.huU.setColor(-1);
        this.huU.setStrokeWidth(this.huW);
    }

    public void setExposureListener(a aVar) {
        this.huZ = aVar;
    }

    public void setExposureValue(float f) {
        this.huX = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        N(canvas);
        O(canvas);
        f(canvas);
        P(canvas);
    }

    private void N(Canvas canvas) {
        int height = (int) ((getHeight() - 88) * this.huX);
        if (height > 3) {
            int width = getWidth() / 2;
            canvas.drawLine(width, 0, width, height + 0, this.fnh);
        }
    }

    private void O(Canvas canvas) {
        int height = getHeight() - 88;
        int i = height - ((int) (height * this.huX));
        if (i > 3) {
            int width = getWidth() / 2;
            int height2 = getHeight();
            canvas.drawLine(width, height2, width, height2 - i, this.fnh);
        }
    }

    private void f(Canvas canvas) {
        int round = Math.round((getHeight() - 88) * this.huX);
        int width = getWidth() / 2;
        int i = round + 44;
        canvas.drawArc(new RectF(width - 18, i - 18, width + 18, i + 18), 360.0f, 360.0f, false, this.mCirclePaint);
    }

    private void P(Canvas canvas) {
        int width = getWidth() / 2;
        int height = ((int) ((getHeight() - 88) * this.huX)) + 44;
        int round = 8 - Math.round(this.huX * 8.0f);
        int i = (height - 18) - 8;
        int i2 = i - 4;
        for (int i3 = 0; i3 < round; i3++) {
            canvas.drawLine(width, i, width, i2, this.huU);
            canvas.rotate(45.0f, width, height);
        }
    }

    public void chM() {
        removeCallbacks(this.hva);
        postDelayed(this.hva, IMConnection.RETRY_DELAY_TIMES);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.huZ != null) {
                    this.huZ.cea();
                }
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cwD = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.huY = this.huX;
                    removeCallbacks(this.hva);
                    return true;
                }
                break;
            case 1:
            case 3:
                chM();
                break;
            case 2:
                getDiffX(motionEvent);
                float M = ((M(motionEvent) * 1.0f) / (getHeight() - 88)) + this.huY;
                float f = M < 1.0f ? M : 1.0f;
                float f2 = f > 0.0f ? f : 0.0f;
                if (f2 != this.huX) {
                    this.huX = f2;
                    if (this.huZ != null) {
                        this.huZ.onExposure(this.huX);
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cwD);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }
}
