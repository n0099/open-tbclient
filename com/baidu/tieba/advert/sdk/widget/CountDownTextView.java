package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class CountDownTextView extends TextView {
    private a gle;
    private c glf;
    private final Runnable glg;
    private boolean glh;
    private int mCounter;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes8.dex */
    public interface a {
        void tg(int i);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void cf(View view);
    }

    /* loaded from: classes8.dex */
    private static class b implements Runnable {
        private final WeakReference<CountDownTextView> gke;

        private b(CountDownTextView countDownTextView) {
            this.gke = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gke.get();
            if (countDownTextView != null) {
                countDownTextView.th(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mCounter = 0;
        this.mText = "";
        this.gle = null;
        this.glf = null;
        this.mHandler = new Handler();
        this.glh = false;
        this.glg = new b();
    }

    public void setNumTypeFromBes(boolean z) {
        this.glh = z;
    }

    public void setTimeoutListener(c cVar) {
        this.glf = cVar;
    }

    public void setTimerChangedListener(a aVar) {
        this.gle = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        th(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMH();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            th(0);
        } else {
            bMH();
        }
    }

    public void aE(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.mCounter = i;
        }
    }

    private void bMH() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        this.mCounter -= i;
        if (this.gle != null && i != 0) {
            this.gle.tg(this.mCounter);
        }
        if (this.mCounter == 0) {
            if (this.glf != null) {
                this.glf.cf(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.mCounter > 0) {
            if (this.glh) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.mCounter)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.mCounter)));
            }
        }
        this.mHandler.removeCallbacks(this.glg);
        this.mHandler.postDelayed(this.glg, 1000L);
    }
}
