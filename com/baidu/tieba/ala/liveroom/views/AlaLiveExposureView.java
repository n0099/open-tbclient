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
    private int but;
    private float cif;
    private Paint eYR;
    private Paint hdg;
    private int hdh;
    private int hdi;
    private float hdj;
    private float hdk;
    private a hdl;
    private Runnable hdm;
    private int mActivePointerId;
    private Paint mCirclePaint;
    private float mDownX;

    /* loaded from: classes4.dex */
    interface a {
        void onExposure(float f);
    }

    public AlaLiveExposureView(Context context) {
        super(context);
        this.but = 5;
        this.hdh = 4;
        this.hdi = 4;
        this.hdj = 0.5f;
        this.hdk = 0.5f;
        this.mActivePointerId = -1;
        this.hdm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.but = 5;
        this.hdh = 4;
        this.hdi = 4;
        this.hdj = 0.5f;
        this.hdk = 0.5f;
        this.mActivePointerId = -1;
        this.hdm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.but = 5;
        this.hdh = 4;
        this.hdi = 4;
        this.hdj = 0.5f;
        this.hdk = 0.5f;
        this.mActivePointerId = -1;
        this.hdm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.eYR = new Paint();
        this.eYR.setAntiAlias(true);
        this.eYR.setStyle(Paint.Style.STROKE);
        this.eYR.setColor(Color.parseColor("#ffffffff"));
        this.eYR.setStrokeWidth(this.but);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-1);
        this.mCirclePaint.setStrokeWidth(this.hdh);
        this.hdg = new Paint();
        this.hdg.setAntiAlias(true);
        this.hdg.setStyle(Paint.Style.STROKE);
        this.hdg.setStrokeCap(Paint.Cap.ROUND);
        this.hdg.setColor(-1);
        this.hdg.setStrokeWidth(this.hdi);
    }

    public void setExposureListener(a aVar) {
        this.hdl = aVar;
    }

    public void setExposureValue(float f) {
        this.hdj = f;
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
        int height = (int) ((getHeight() - 88) * this.hdj);
        if (height > 3) {
            int width = getWidth() / 2;
            canvas.drawLine(width, 0, width, height + 0, this.eYR);
        }
    }

    private void O(Canvas canvas) {
        int height = getHeight() - 88;
        int i = height - ((int) (height * this.hdj));
        if (i > 3) {
            int width = getWidth() / 2;
            int height2 = getHeight();
            canvas.drawLine(width, height2, width, height2 - i, this.eYR);
        }
    }

    private void f(Canvas canvas) {
        int round = Math.round((getHeight() - 88) * this.hdj);
        int width = getWidth() / 2;
        int i = round + 44;
        canvas.drawArc(new RectF(width - 18, i - 18, width + 18, i + 18), 360.0f, 360.0f, false, this.mCirclePaint);
    }

    private void P(Canvas canvas) {
        int width = getWidth() / 2;
        int height = ((int) ((getHeight() - 88) * this.hdj)) + 44;
        int round = 8 - Math.round(this.hdj * 8.0f);
        int i = (height - 18) - 8;
        int i2 = i - 4;
        for (int i3 = 0; i3 < round; i3++) {
            canvas.drawLine(width, i, width, i2, this.hdg);
            canvas.rotate(45.0f, width, height);
        }
    }

    public void ccf() {
        removeCallbacks(this.hdm);
        postDelayed(this.hdm, IMConnection.RETRY_DELAY_TIMES);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cif = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.hdk = this.hdj;
                    removeCallbacks(this.hdm);
                    return true;
                }
                break;
            case 1:
            case 3:
                ccf();
                break;
            case 2:
                getDiffX(motionEvent);
                float M = ((M(motionEvent) * 1.0f) / (getHeight() - 88)) + this.hdk;
                float f = M < 1.0f ? M : 1.0f;
                float f2 = f > 0.0f ? f : 0.0f;
                if (f2 != this.hdj) {
                    this.hdj = f2;
                    if (this.hdl != null) {
                        this.hdl.onExposure(this.hdj);
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cif);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }
}
