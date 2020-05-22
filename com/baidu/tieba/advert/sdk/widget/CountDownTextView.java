package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int bVn;
    private b eRS;
    private final Runnable eRT;
    private boolean eRU;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes10.dex */
    public interface b {
        void bs(View view);
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> eRl;

        private a(CountDownTextView countDownTextView) {
            this.eRl = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.eRl.get();
            if (countDownTextView != null) {
                countDownTextView.pj(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bVn = 0;
        this.mText = "";
        this.eRS = null;
        this.mHandler = new Handler();
        this.eRU = false;
        this.eRT = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.eRU = z;
    }

    public void setTimeoutListener(b bVar) {
        this.eRS = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bnL();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            pj(0);
        } else {
            bnL();
        }
    }

    public void av(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bVn = i;
        }
    }

    private void bnL() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pj(int i) {
        this.bVn -= i;
        if (this.bVn == 0) {
            if (this.eRS != null) {
                this.eRS.bs(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bVn > 0) {
            if (this.eRU) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.bVn)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.bVn)));
            }
        }
        this.mHandler.removeCallbacks(this.eRT);
        this.mHandler.postDelayed(this.eRT, 1000L);
    }
}
