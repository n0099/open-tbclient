package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class AlaLiveCountDownView extends TextView {
    private Handler handler;
    private a hor;
    private Runnable hos;
    private int mCount;
    private int mInterval;

    /* loaded from: classes4.dex */
    public interface a {
        void ccJ();
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
        this.hos = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hor == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.hos, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hor.ccJ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.hos);
            }
        };
    }

    public AlaLiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.hos = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hor == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.hos, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hor.ccJ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.hos);
            }
        };
    }

    public AlaLiveCountDownView(Context context) {
        super(context);
        this.mCount = 0;
        this.mInterval = 0;
        this.handler = new Handler();
        this.hos = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveCountDownView.this.mCount > 0 || AlaLiveCountDownView.this.hor == null) {
                    AlaLiveCountDownView.this.setText(Integer.toString(AlaLiveCountDownView.this.mCount));
                    AlaLiveCountDownView.e(AlaLiveCountDownView.this);
                    AlaLiveCountDownView.this.handler.postDelayed(AlaLiveCountDownView.this.hos, AlaLiveCountDownView.this.mInterval);
                    return;
                }
                AlaLiveCountDownView.this.hor.ccJ();
                AlaLiveCountDownView.this.handler.removeCallbacks(AlaLiveCountDownView.this.hos);
            }
        };
    }

    public void setCount(int i) {
        this.handler.removeCallbacks(this.hos);
        this.mCount = i;
        if (i <= 0) {
        }
    }

    public void wa(int i) {
        this.handler.removeCallbacks(this.hos);
        if (i >= 0) {
            this.mInterval = i;
            this.handler.post(this.hos);
        }
    }

    public void setOnCountDownListener(a aVar) {
        this.hor = aVar;
    }

    public void stopCountDown() {
        this.handler.removeCallbacks(this.hos);
    }
}
