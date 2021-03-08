package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CountDownTextView extends TextView {
    private a gnb;
    private c gnc;
    private final Runnable gnd;
    private boolean gne;
    private int mCounter;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes7.dex */
    public interface a {
        void ti(int i);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void cf(View view);
    }

    /* loaded from: classes7.dex */
    private static class b implements Runnable {
        private final WeakReference<CountDownTextView> glV;

        private b(CountDownTextView countDownTextView) {
            this.glV = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.glV.get();
            if (countDownTextView != null) {
                countDownTextView.tj(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mCounter = 0;
        this.mText = "";
        this.gnb = null;
        this.gnc = null;
        this.mHandler = new Handler();
        this.gne = false;
        this.gnd = new b();
    }

    public void setNumTypeFromBes(boolean z) {
        this.gne = z;
    }

    public void setTimeoutListener(c cVar) {
        this.gnc = cVar;
    }

    public void setTimerChangedListener(a aVar) {
        this.gnb = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            tj(0);
        } else {
            bMU();
        }
    }

    public void aF(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.mCounter = i;
        }
    }

    private void bMU() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        this.mCounter -= i;
        if (this.gnb != null && i != 0) {
            this.gnb.ti(this.mCounter);
        }
        if (this.mCounter == 0) {
            if (this.gnc != null) {
                this.gnc.cf(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.mCounter > 0) {
            if (this.gne) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.mCounter)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.mCounter)));
            }
        }
        this.mHandler.removeCallbacks(this.gnd);
        this.mHandler.postDelayed(this.gnd, 1000L);
    }
}
