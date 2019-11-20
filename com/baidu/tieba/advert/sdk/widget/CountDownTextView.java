package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {
    private int aKs;
    private b dlb;
    private final Runnable dlc;
    private boolean dld;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes5.dex */
    public interface b {
        void bp(View view);
    }

    /* loaded from: classes5.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> dku;

        private a(CountDownTextView countDownTextView) {
            this.dku = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dku.get();
            if (countDownTextView != null) {
                countDownTextView.lI(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aKs = 0;
        this.mText = "";
        this.dlb = null;
        this.mHandler = new Handler();
        this.dld = false;
        this.dlc = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.dld = z;
    }

    public void setTimeoutListener(b bVar) {
        this.dlb = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lI(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aES();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            lI(0);
        } else {
            aES();
        }
    }

    public void aa(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.aKs = i;
        }
    }

    private void aES() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(int i) {
        this.aKs -= i;
        if (this.aKs == 0) {
            if (this.dlb != null) {
                this.dlb.bp(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aKs > 0) {
            if (this.dld) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.aKs)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.aKs)));
            }
        }
        this.mHandler.removeCallbacks(this.dlc);
        this.mHandler.postDelayed(this.dlc, 1000L);
    }
}
