package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes17.dex */
public class CountDownTextView extends TextView {
    private int cbI;
    private b fgQ;
    private final Runnable fgR;
    private boolean fgS;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes17.dex */
    public interface b {
        void bB(View view);
    }

    /* loaded from: classes17.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fgj;

        private a(CountDownTextView countDownTextView) {
            this.fgj = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fgj.get();
            if (countDownTextView != null) {
                countDownTextView.pX(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cbI = 0;
        this.mText = "";
        this.fgQ = null;
        this.mHandler = new Handler();
        this.fgS = false;
        this.fgR = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.fgS = z;
    }

    public void setTimeoutListener(b bVar) {
        this.fgQ = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pX(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btq();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            pX(0);
        } else {
            btq();
        }
    }

    public void au(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cbI = i;
        }
    }

    private void btq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(int i) {
        this.cbI -= i;
        if (this.cbI == 0) {
            if (this.fgQ != null) {
                this.fgQ.bB(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cbI > 0) {
            if (this.fgS) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.cbI)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.cbI)));
            }
        }
        this.mHandler.removeCallbacks(this.fgR);
        this.mHandler.postDelayed(this.fgR, 1000L);
    }
}
