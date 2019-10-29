package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {
    private int aKK;
    private b dlS;
    private final Runnable dlT;
    private boolean dlU;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes5.dex */
    public interface b {
        void bp(View view);
    }

    /* loaded from: classes5.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> dll;

        private a(CountDownTextView countDownTextView) {
            this.dll = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dll.get();
            if (countDownTextView != null) {
                countDownTextView.lJ(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aKK = 0;
        this.mText = "";
        this.dlS = null;
        this.mHandler = new Handler();
        this.dlU = false;
        this.dlT = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.dlU = z;
    }

    public void setTimeoutListener(b bVar) {
        this.dlS = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lJ(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aEU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            lJ(0);
        } else {
            aEU();
        }
    }

    public void aa(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.aKK = i;
        }
    }

    private void aEU() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(int i) {
        this.aKK -= i;
        if (this.aKK == 0) {
            if (this.dlS != null) {
                this.dlS.bp(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aKK > 0) {
            if (this.dlU) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.aKK)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.aKK)));
            }
        }
        this.mHandler.removeCallbacks(this.dlT);
        this.mHandler.postDelayed(this.dlT, 1000L);
    }
}
