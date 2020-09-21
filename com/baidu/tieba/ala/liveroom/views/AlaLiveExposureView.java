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
    private float bVQ;
    private int bqF;
    private Paint eMK;
    private Paint gOj;
    private int gOk;
    private int gOl;
    private float gOm;
    private float gOn;
    private a gOo;
    private Runnable gOp;
    private int mActivePointerId;
    private Paint mCirclePaint;
    private float mDownX;

    /* loaded from: classes4.dex */
    interface a {
        void onExposure(float f);
    }

    public AlaLiveExposureView(Context context) {
        super(context);
        this.bqF = 5;
        this.gOk = 4;
        this.gOl = 4;
        this.gOm = 0.5f;
        this.gOn = 0.5f;
        this.mActivePointerId = -1;
        this.gOp = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqF = 5;
        this.gOk = 4;
        this.gOl = 4;
        this.gOm = 0.5f;
        this.gOn = 0.5f;
        this.mActivePointerId = -1;
        this.gOp = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    public AlaLiveExposureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqF = 5;
        this.gOk = 4;
        this.gOl = 4;
        this.gOm = 0.5f;
        this.gOn = 0.5f;
        this.mActivePointerId = -1;
        this.gOp = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveExposureView.this.setVisibility(4);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.eMK = new Paint();
        this.eMK.setAntiAlias(true);
        this.eMK.setStyle(Paint.Style.STROKE);
        this.eMK.setColor(Color.parseColor("#ffffffff"));
        this.eMK.setStrokeWidth(this.bqF);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-1);
        this.mCirclePaint.setStrokeWidth(this.gOk);
        this.gOj = new Paint();
        this.gOj.setAntiAlias(true);
        this.gOj.setStyle(Paint.Style.STROKE);
        this.gOj.setStrokeCap(Paint.Cap.ROUND);
        this.gOj.setColor(-1);
        this.gOj.setStrokeWidth(this.gOl);
    }

    public void setExposureListener(a aVar) {
        this.gOo = aVar;
    }

    public void setExposureValue(float f) {
        this.gOm = f;
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
        int height = (int) ((getHeight() - 88) * this.gOm);
        if (height > 3) {
            int width = getWidth() / 2;
            canvas.drawLine(width, 0, width, height + 0, this.eMK);
        }
    }

    private void N(Canvas canvas) {
        int height = getHeight() - 88;
        int i = height - ((int) (height * this.gOm));
        if (i > 3) {
            int width = getWidth() / 2;
            int height2 = getHeight();
            canvas.drawLine(width, height2, width, height2 - i, this.eMK);
        }
    }

    private void f(Canvas canvas) {
        int round = Math.round((getHeight() - 88) * this.gOm);
        int width = getWidth() / 2;
        int i = round + 44;
        canvas.drawArc(new RectF(width - 18, i - 18, width + 18, i + 18), 360.0f, 360.0f, false, this.mCirclePaint);
    }

    private void O(Canvas canvas) {
        int width = getWidth() / 2;
        int height = ((int) ((getHeight() - 88) * this.gOm)) + 44;
        int round = 8 - Math.round(this.gOm * 8.0f);
        int i = (height - 18) - 8;
        int i2 = i - 4;
        for (int i3 = 0; i3 < round; i3++) {
            canvas.drawLine(width, i, width, i2, this.gOj);
            canvas.rotate(45.0f, width, height);
        }
    }

    public void bYF() {
        removeCallbacks(this.gOp);
        postDelayed(this.gOp, IMConnection.RETRY_DELAY_TIMES);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.bVQ = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.gOn = this.gOm;
                    removeCallbacks(this.gOp);
                    return true;
                }
                break;
            case 1:
            case 3:
                bYF();
                break;
            case 2:
                getDiffX(motionEvent);
                float M = ((M(motionEvent) * 1.0f) / (getHeight() - 88)) + this.gOn;
                float f = M < 1.0f ? M : 1.0f;
                float f2 = f > 0.0f ? f : 0.0f;
                if (f2 != this.gOm) {
                    this.gOm = f2;
                    if (this.gOo != null) {
                        this.gOo.onExposure(this.gOm);
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.bVQ);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }
}
