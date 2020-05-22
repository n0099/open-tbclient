package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class AlaLiveCountDownView extends TextView {
    private a gfG;
    private Runnable gfH;
    private Handler handler;
    private int mCount;
    private int mInterval;

    /* loaded from: classes3.dex */
    public interface a {
        void bEh();
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
        this.gfH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.gfG == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.gfH, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.gfG.bEh();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.gfH);
            }
        };
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.gfH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.gfG == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.gfH, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.gfG.bEh();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.gfH);
            }
        };
    }

    public AlaLiveCountDownView(Context context) {
        super(context);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.gfH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.gfG == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.gfH, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.gfG.bEh();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.gfH);
            }
        };
    }

    public void setCount(int i) {
        this.handler.removeCallbacks(this.gfH);
        this.mCount = i;
        if (i <= 0) {
        }
    }

    public void rB(int i) {
        this.handler.removeCallbacks(this.gfH);
        if (i >= 0) {
            this.mInterval = i;
            this.handler.post(this.gfH);
        }
    }

    public void setOnCountDownListener(a aVar) {
        this.gfG = aVar;
    }

    public void stopCountDown() {
        this.handler.removeCallbacks(this.gfH);
    }
}
