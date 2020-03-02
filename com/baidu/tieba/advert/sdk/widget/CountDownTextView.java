package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int bnF;
    private b ecU;
    private final Runnable ecV;
    private boolean ecW;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes10.dex */
    public interface b {
        void bq(View view);
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecq;

        private a(CountDownTextView countDownTextView) {
            this.ecq = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecq.get();
            if (countDownTextView != null) {
                countDownTextView.on(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bnF = 0;
        this.mText = "";
        this.ecU = null;
        this.mHandler = new Handler();
        this.ecW = false;
        this.ecV = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.ecW = z;
    }

    public void setTimeoutListener(b bVar) {
        this.ecU = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        on(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZt();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            on(0);
        } else {
            aZt();
        }
    }

    public void al(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bnF = i;
        }
    }

    private void aZt() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
        this.bnF -= i;
        if (this.bnF == 0) {
            if (this.ecU != null) {
                this.ecU.bq(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bnF > 0) {
            if (this.ecW) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.bnF)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.bnF)));
            }
        }
        this.mHandler.removeCallbacks(this.ecV);
        this.mHandler.postDelayed(this.ecV, 1000L);
    }
}
