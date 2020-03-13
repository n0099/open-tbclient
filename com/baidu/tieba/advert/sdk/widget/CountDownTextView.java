package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int bnG;
    private b edh;
    private final Runnable edi;
    private boolean edj;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes10.dex */
    public interface b {
        void bq(View view);
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecD;

        private a(CountDownTextView countDownTextView) {
            this.ecD = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecD.get();
            if (countDownTextView != null) {
                countDownTextView.on(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bnG = 0;
        this.mText = "";
        this.edh = null;
        this.mHandler = new Handler();
        this.edj = false;
        this.edi = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.edj = z;
    }

    public void setTimeoutListener(b bVar) {
        this.edh = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        on(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZu();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            on(0);
        } else {
            aZu();
        }
    }

    public void al(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bnG = i;
        }
    }

    private void aZu() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
        this.bnG -= i;
        if (this.bnG == 0) {
            if (this.edh != null) {
                this.edh.bq(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bnG > 0) {
            if (this.edj) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.bnG)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.bnG)));
            }
        }
        this.mHandler.removeCallbacks(this.edi);
        this.mHandler.postDelayed(this.edi, 1000L);
    }
}
