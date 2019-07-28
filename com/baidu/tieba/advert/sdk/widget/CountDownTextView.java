package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {
    private String amD;
    private int aqW;
    private b daD;
    private final Runnable daE;
    private boolean daF;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface b {
        void bp(View view);
    }

    /* loaded from: classes5.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> cZV;

        private a(CountDownTextView countDownTextView) {
            this.cZV = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cZV.get();
            if (countDownTextView != null) {
                countDownTextView.mz(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aqW = 0;
        this.amD = "";
        this.daD = null;
        this.mHandler = new Handler();
        this.daF = false;
        this.daE = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.daF = z;
    }

    public void setTimeoutListener(b bVar) {
        this.daD = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mz(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aEd();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            mz(0);
        } else {
            aEd();
        }
    }

    public void ah(String str, int i) {
        this.amD = str;
        if (i > 0) {
            this.aqW = i;
        }
    }

    private void aEd() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(int i) {
        this.aqW -= i;
        if (this.aqW == 0) {
            if (this.daD != null) {
                this.daD.bp(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aqW > 0) {
            if (this.daF) {
                setText(String.format("%s 0%s", this.amD, Integer.valueOf(this.aqW)));
            } else {
                setText(String.format("%s %s", this.amD, Integer.valueOf(this.aqW)));
            }
        }
        this.mHandler.removeCallbacks(this.daE);
        this.mHandler.postDelayed(this.daE, 1000L);
    }
}
