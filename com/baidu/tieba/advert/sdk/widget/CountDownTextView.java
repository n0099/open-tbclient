package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CountDownTextView extends TextView {
    private int biF;
    private b dYG;
    private final Runnable dYH;
    private boolean dYI;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes7.dex */
    public interface b {
        void bm(View view);
    }

    /* loaded from: classes7.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> dYc;

        private a(CountDownTextView countDownTextView) {
            this.dYc = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dYc.get();
            if (countDownTextView != null) {
                countDownTextView.nW(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.biF = 0;
        this.mText = "";
        this.dYG = null;
        this.mHandler = new Handler();
        this.dYI = false;
        this.dYH = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.dYI = z;
    }

    public void setTimeoutListener(b bVar) {
        this.dYG = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        nW(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aWI();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            nW(0);
        } else {
            aWI();
        }
    }

    public void am(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.biF = i;
        }
    }

    private void aWI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(int i) {
        this.biF -= i;
        if (this.biF == 0) {
            if (this.dYG != null) {
                this.dYG.bm(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.biF > 0) {
            if (this.dYI) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.biF)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.biF)));
            }
        }
        this.mHandler.removeCallbacks(this.dYH);
        this.mHandler.postDelayed(this.dYH, 1000L);
    }
}
