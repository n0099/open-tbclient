package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes11.dex */
public class AlaLiveCountDownView extends TextView {
    private a hPD;
    private Runnable hPE;
    private Handler handler;
    private int mCount;
    private int mInterval;

    /* loaded from: classes11.dex */
    public interface a {
        void civ();
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
        this.hPE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hPD == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.hPE, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hPD.civ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.hPE);
            }
        };
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.hPE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hPD == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.hPE, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hPD.civ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.hPE);
            }
        };
    }

    public AlaLiveCountDownView(Context context) {
        super(context);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.hPE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hPD == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.hPE, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hPD.civ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.hPE);
            }
        };
    }

    public void setCount(int i) {
        this.handler.removeCallbacks(this.hPE);
        this.mCount = i;
        if (i <= 0) {
        }
    }

    public void wh(int i) {
        this.handler.removeCallbacks(this.hPE);
        if (i >= 0) {
            this.mInterval = i;
            this.handler.post(this.hPE);
        }
    }

    public void setOnCountDownListener(a aVar) {
        this.hPD = aVar;
    }

    public void stopCountDown() {
        this.handler.removeCallbacks(this.hPE);
    }
}
