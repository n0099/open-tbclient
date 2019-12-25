package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class AlaLiveCountDownView extends TextView {
    private a ffB;
    private Runnable ffC;
    private Handler handler;
    private int mCount;
    private int mInterval;

    /* loaded from: classes2.dex */
    public interface a {
        void blY();
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
        this.ffC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.ffB == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.ffC, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.ffB.blY();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.ffC);
            }
        };
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.ffC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.ffB == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.ffC, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.ffB.blY();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.ffC);
            }
        };
    }

    public AlaLiveCountDownView(Context context) {
        super(context);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.ffC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.ffB == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.ffC, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.ffB.blY();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.ffC);
            }
        };
    }

    public void setCount(int i) {
        this.handler.removeCallbacks(this.ffC);
        this.mCount = i;
        if (i <= 0) {
        }
    }

    public void qs(int i) {
        this.handler.removeCallbacks(this.ffC);
        if (i >= 0) {
            this.mInterval = i;
            this.handler.post(this.ffC);
        }
    }

    public void setOnCountDownListener(a aVar) {
        this.ffB = aVar;
    }

    public void stopCountDown() {
        this.handler.removeCallbacks(this.ffC);
    }
}
