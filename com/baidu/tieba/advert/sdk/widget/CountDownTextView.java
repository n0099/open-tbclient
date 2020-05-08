package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int bMe;
    private b eDt;
    private final Runnable eDu;
    private boolean eDv;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes10.dex */
    public interface b {
        void br(View view);
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> eCM;

        private a(CountDownTextView countDownTextView) {
            this.eCM = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.eCM.get();
            if (countDownTextView != null) {
                countDownTextView.oC(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bMe = 0;
        this.mText = "";
        this.eDt = null;
        this.mHandler = new Handler();
        this.eDv = false;
        this.eDu = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.eDv = z;
    }

    public void setTimeoutListener(b bVar) {
        this.eDt = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        oC(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bhA();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            oC(0);
        } else {
            bhA();
        }
    }

    public void au(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bMe = i;
        }
    }

    private void bhA() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC(int i) {
        this.bMe -= i;
        if (this.bMe == 0) {
            if (this.eDt != null) {
                this.eDt.br(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bMe > 0) {
            if (this.eDv) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.bMe)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.bMe)));
            }
        }
        this.mHandler.removeCallbacks(this.eDu);
        this.mHandler.postDelayed(this.eDu, 1000L);
    }
}
