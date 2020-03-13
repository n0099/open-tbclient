package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class AlaLiveCountDownView extends TextView {
    private a flV;
    private Runnable flW;
    private Handler handler;
    private int mCount;
    private int mInterval;

    /* loaded from: classes3.dex */
    public interface a {
        void boJ();
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
        this.flW = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.flV == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.flW, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.flV.boJ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.flW);
            }
        };
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.flW = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.flV == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.flW, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.flV.boJ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.flW);
            }
        };
    }

    public AlaLiveCountDownView(Context context) {
        super(context);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.flW = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.flV == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.flW, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.flV.boJ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.flW);
            }
        };
    }

    public void setCount(int i) {
        this.handler.removeCallbacks(this.flW);
        this.mCount = i;
        if (i <= 0) {
        }
    }

    public void qE(int i) {
        this.handler.removeCallbacks(this.flW);
        if (i >= 0) {
            this.mInterval = i;
            this.handler.post(this.flW);
        }
    }

    public void setOnCountDownListener(a aVar) {
        this.flV = aVar;
    }

    public void stopCountDown() {
        this.handler.removeCallbacks(this.flW);
    }
}
