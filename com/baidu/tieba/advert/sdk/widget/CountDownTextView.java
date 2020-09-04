package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes17.dex */
public class CountDownTextView extends TextView {
    private int chH;
    private b fsp;
    private final Runnable fsq;
    private boolean fsr;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes17.dex */
    public interface b {
        void bD(View view);
    }

    /* loaded from: classes17.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> frI;

        private a(CountDownTextView countDownTextView) {
            this.frI = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.frI.get();
            if (countDownTextView != null) {
                countDownTextView.sj(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.chH = 0;
        this.mText = "";
        this.fsp = null;
        this.mHandler = new Handler();
        this.fsr = false;
        this.fsq = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.fsr = z;
    }

    public void setTimeoutListener(b bVar) {
        this.fsp = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bCm();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            sj(0);
        } else {
            bCm();
        }
    }

    public void ax(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.chH = i;
        }
    }

    private void bCm() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(int i) {
        this.chH -= i;
        if (this.chH == 0) {
            if (this.fsp != null) {
                this.fsp.bD(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.chH > 0) {
            if (this.fsr) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.chH)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.chH)));
            }
        }
        this.mHandler.removeCallbacks(this.fsq);
        this.mHandler.postDelayed(this.fsq, 1000L);
    }
}
