package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int cab;
    private b fco;
    private final Runnable fcp;
    private boolean fcq;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes10.dex */
    public interface b {
        void bv(View view);
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fbH;

        private a(CountDownTextView countDownTextView) {
            this.fbH = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fbH.get();
            if (countDownTextView != null) {
                countDownTextView.pK(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cab = 0;
        this.mText = "";
        this.fco = null;
        this.mHandler = new Handler();
        this.fcq = false;
        this.fcp = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.fcq = z;
    }

    public void setTimeoutListener(b bVar) {
        this.fco = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pK(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bqo();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            pK(0);
        } else {
            bqo();
        }
    }

    public void av(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cab = i;
        }
    }

    private void bqo() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(int i) {
        this.cab -= i;
        if (this.cab == 0) {
            if (this.fco != null) {
                this.fco.bv(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cab > 0) {
            if (this.fcq) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.cab)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.cab)));
            }
        }
        this.mHandler.removeCallbacks(this.fcp);
        this.mHandler.postDelayed(this.fcp, 1000L);
    }
}
