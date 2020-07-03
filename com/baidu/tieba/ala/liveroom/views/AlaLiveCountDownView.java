package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class AlaLiveCountDownView extends TextView {
    private a gsO;
    private Runnable gsP;
    private Handler handler;
    private int mCount;
    private int mInterval;

    /* loaded from: classes3.dex */
    public interface a {
        void bHp();
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
        this.gsP = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.gsO == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.gsP, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.gsO.bHp();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.gsP);
            }
        };
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.gsP = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.gsO == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.gsP, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.gsO.bHp();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.gsP);
            }
        };
    }

    public AlaLiveCountDownView(Context context) {
        super(context);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.gsP = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.gsO == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.gsP, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.gsO.bHp();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.gsP);
            }
        };
    }

    public void setCount(int i) {
        this.handler.removeCallbacks(this.gsP);
        this.mCount = i;
        if (i <= 0) {
        }
    }

    public void sb(int i) {
        this.handler.removeCallbacks(this.gsP);
        if (i >= 0) {
            this.mInterval = i;
            this.handler.post(this.gsP);
        }
    }

    public void setOnCountDownListener(a aVar) {
        this.gsO = aVar;
    }

    public void stopCountDown() {
        this.handler.removeCallbacks(this.gsP);
    }
}
