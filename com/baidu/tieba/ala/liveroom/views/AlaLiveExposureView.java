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
/* loaded from: classes7.dex */
public class AlaLiveExposureView extends View {
    private int bnK;
    private Paint eKt;
    private Paint gKT;
    private int gKU;
    private int gKV;
    private float gKW;
    private float gKX;
    private a gKY;
    private Runnable gKZ;
    private int mActivePointerId;
    private Paint mCirclePaint;
    private float mDownX;
    private float mDownY;

    /* loaded from: classes7.dex */
    interface a {
        void onExposure(float f);
    }

    public AlaLiveExposureView(Context context) {
        super(context);
        this.bnK = 5;
        this.gKU = 4;
        this.gKV = 4;
        this.gKW = 0.5f;
        this.gKX = 0.5f;
        this.mActivePointerId = -1;
        this.gKZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnK = 5;
        this.gKU = 4;
        this.gKV = 4;
        this.gKW = 0.5f;
        this.gKX = 0.5f;
        this.mActivePointerId = -1;
        this.gKZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnK = 5;
        this.gKU = 4;
        this.gKV = 4;
        this.gKW = 0.5f;
        this.gKX = 0.5f;
        this.mActivePointerId = -1;
        this.gKZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.eKt = new Paint();
        this.eKt.setAntiAlias(true);
        this.eKt.setStyle(Paint.Style.STROKE);
        this.eKt.setColor(Color.parseColor("#ffffffff"));
        this.eKt.setStrokeWidth(this.bnK);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-1);
        this.mCirclePaint.setStrokeWidth(this.gKU);
        this.gKT = new Paint();
        this.gKT.setAntiAlias(true);
        this.gKT.setStyle(Paint.Style.STROKE);
        this.gKT.setStrokeCap(Paint.Cap.ROUND);
        this.gKT.setColor(-1);
        this.gKT.setStrokeWidth(this.gKV);
    }

    public void setExposureListener(a aVar) {
        this.gKY = aVar;
    }

    public void setExposureValue(float f) {
        this.gKW = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        M(canvas);
        N(canvas);
        f(canvas);
        O(canvas);
    }

    private void M(Canvas canvas) {
        int height = (int) ((getHeight() - 88) * this.gKW);
        if (height > 3) {
            int width = getWidth() / 2;
            canvas.drawLine(width, 0, width, height + 0, this.eKt);
        }
    }

    private void N(Canvas canvas) {
        int height = getHeight() - 88;
        int i = height - ((int) (height * this.gKW));
        if (i > 3) {
            int width = getWidth() / 2;
            int height2 = getHeight();
            canvas.drawLine(width, height2, width, height2 - i, this.eKt);
        }
    }

    private void f(Canvas canvas) {
        int round = Math.round((getHeight() - 88) * this.gKW);
        int width = getWidth() / 2;
        int i = round + 44;
        canvas.drawArc(new RectF(width - 18, i - 18, width + 18, i + 18), 360.0f, 360.0f, false, this.mCirclePaint);
    }

    private void O(Canvas canvas) {
        int width = getWidth() / 2;
        int height = ((int) ((getHeight() - 88) * this.gKW)) + 44;
        int round = 8 - Math.round(this.gKW * 8.0f);
        int i = (height - 18) - 8;
        int i2 = i - 4;
        for (int i3 = 0; i3 < round; i3++) {
            canvas.drawLine(width, i, width, i2, this.gKT);
            canvas.rotate(45.0f, width, height);
        }
    }

    public void bWY() {
        removeCallbacks(this.gKZ);
        postDelayed(this.gKZ, IMConnection.RETRY_DELAY_TIMES);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mDownY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.gKX = this.gKW;
                    removeCallbacks(this.gKZ);
                    return true;
                }
                break;
            case 1:
            case 3:
                bWY();
                break;
            case 2:
                getDiffX(motionEvent);
                float M = ((M(motionEvent) * 1.0f) / (getHeight() - 88)) + this.gKX;
                float f = M < 1.0f ? M : 1.0f;
                float f2 = f > 0.0f ? f : 0.0f;
                if (f2 != this.gKW) {
                    this.gKW = f2;
                    if (this.gKY != null) {
                        this.gKY.onExposure(this.gKW);
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.mDownY);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }
}
