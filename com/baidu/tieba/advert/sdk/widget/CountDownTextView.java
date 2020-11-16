package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes22.dex */
public class CountDownTextView extends TextView {
    private int cIG;
    private b fVC;
    private final Runnable fVD;
    private boolean fVE;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes22.dex */
    public interface b {
        void bT(View view);
    }

    /* loaded from: classes22.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fUV;

        private a(CountDownTextView countDownTextView) {
            this.fUV = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fUV.get();
            if (countDownTextView != null) {
                countDownTextView.tS(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cIG = 0;
        this.mText = "";
        this.fVC = null;
        this.mHandler = new Handler();
        this.fVE = false;
        this.fVD = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.fVE = z;
    }

    public void setTimeoutListener(b bVar) {
        this.fVC = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tS(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bJV();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            tS(0);
        } else {
            bJV();
        }
    }

    public void az(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cIG = i;
        }
    }

    private void bJV() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS(int i) {
        this.cIG -= i;
        if (this.cIG == 0) {
            if (this.fVC != null) {
                this.fVC.bT(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cIG > 0) {
            if (this.fVE) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.cIG)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.cIG)));
            }
        }
        this.mHandler.removeCallbacks(this.fVD);
        this.mHandler.postDelayed(this.fVD, 1000L);
    }
}
