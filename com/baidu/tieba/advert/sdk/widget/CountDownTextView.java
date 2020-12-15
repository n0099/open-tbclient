package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes23.dex */
public class CountDownTextView extends TextView {
    private int cPz;
    private b gdO;
    private final Runnable gdP;
    private boolean gdQ;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes23.dex */
    public interface b {
        void ca(View view);
    }

    /* loaded from: classes23.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> gdh;

        private a(CountDownTextView countDownTextView) {
            this.gdh = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gdh.get();
            if (countDownTextView != null) {
                countDownTextView.uw(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cPz = 0;
        this.mText = "";
        this.gdO = null;
        this.mHandler = new Handler();
        this.gdQ = false;
        this.gdP = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.gdQ = z;
    }

    public void setTimeoutListener(b bVar) {
        this.gdO = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        uw(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bNE();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            uw(0);
        } else {
            bNE();
        }
    }

    public void aA(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cPz = i;
        }
    }

    private void bNE() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(int i) {
        this.cPz -= i;
        if (this.cPz == 0) {
            if (this.gdO != null) {
                this.gdO.ca(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cPz > 0) {
            if (this.gdQ) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.cPz)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.cPz)));
            }
        }
        this.mHandler.removeCallbacks(this.gdP);
        this.mHandler.postDelayed(this.gdP, 1000L);
    }
}
