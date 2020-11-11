package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class AlaLiveCountDownView extends TextView {
    private Handler handler;
    private a hup;
    private Runnable huq;
    private int mCount;
    private int mInterval;

    /* loaded from: classes4.dex */
    public interface a {
        void cfk();
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
        this.huq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hup == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.huq, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hup.cfk();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.huq);
            }
        };
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.huq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hup == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.huq, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hup.cfk();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.huq);
            }
        };
    }

    public AlaLiveCountDownView(Context context) {
        super(context);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.huq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hup == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.huq, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hup.cfk();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.huq);
            }
        };
    }

    public void setCount(int i) {
        this.handler.removeCallbacks(this.huq);
        this.mCount = i;
        if (i <= 0) {
        }
    }

    public void wn(int i) {
        this.handler.removeCallbacks(this.huq);
        if (i >= 0) {
            this.mInterval = i;
            this.handler.post(this.huq);
        }
    }

    public void setOnCountDownListener(a aVar) {
        this.hup = aVar;
    }

    public void stopCountDown() {
        this.handler.removeCallbacks(this.huq);
    }
}
