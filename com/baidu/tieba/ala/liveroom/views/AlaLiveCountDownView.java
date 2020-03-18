package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class AlaLiveCountDownView extends TextView {
    private a fmu;
    private Runnable fmv;
    private Handler handler;
    private int mCount;
    private int mInterval;

    /* loaded from: classes3.dex */
    public interface a {
        void boO();
    }

    static /* synthetic */ int e(AlaLiveCountDownView alaLiveCountDownView) {
        int i = alaLiveCountDownView.mCount - 1;
        alaLiveCountDownView.mCount = i;
        return i;
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.fmv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.fmu == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.fmv, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.fmu.boO();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.fmv);
            }
        };
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.fmv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.fmu == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.fmv, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.fmu.boO();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.fmv);
            }
        };
    }

    public AlaLiveCountDownView(Context context) {
        super(context);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.fmv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.fmu == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.fmv, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.fmu.boO();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.fmv);
            }
        };
    }

    public void setCount(int i) {
        this.handler.removeCallbacks(this.fmv);
        this.mCount = i;
        if (i <= 0) {
        }
    }

    public void qG(int i) {
        this.handler.removeCallbacks(this.fmv);
        if (i >= 0) {
            this.mInterval = i;
            this.handler.post(this.fmv);
        }
    }

    public void setOnCountDownListener(a aVar) {
        this.fmu = aVar;
    }

    public void stopCountDown() {
        this.handler.removeCallbacks(this.fmv);
    }
}
