package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes23.dex */
public class CountDownTextView extends TextView {
    private int cwb;
    private b fHK;
    private final Runnable fHL;
    private boolean fHM;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes23.dex */
    public interface b {
        void bL(View view);
    }

    /* loaded from: classes23.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fHd;

        private a(CountDownTextView countDownTextView) {
            this.fHd = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fHd.get();
            if (countDownTextView != null) {
                countDownTextView.sZ(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cwb = 0;
        this.mText = "";
        this.fHK = null;
        this.mHandler = new Handler();
        this.fHM = false;
        this.fHL = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.fHM = z;
    }

    public void setTimeoutListener(b bVar) {
        this.fHK = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sZ(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bGk();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            sZ(0);
        } else {
            bGk();
        }
    }

    public void ay(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cwb = i;
        }
    }

    private void bGk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ(int i) {
        this.cwb -= i;
        if (this.cwb == 0) {
            if (this.fHK != null) {
                this.fHK.bL(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cwb > 0) {
            if (this.fHM) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.cwb)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.cwb)));
            }
        }
        this.mHandler.removeCallbacks(this.fHL);
        this.mHandler.postDelayed(this.fHL, 1000L);
    }
}
