package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class CountDownTextView extends TextView {
    private a gls;
    private c glt;
    private final Runnable glu;
    private boolean glv;
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
        private final WeakReference<CountDownTextView> gks;

        private b(CountDownTextView countDownTextView) {
            this.gks = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gks.get();
            if (countDownTextView != null) {
                countDownTextView.th(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mCounter = 0;
        this.mText = "";
        this.gls = null;
        this.glt = null;
        this.mHandler = new Handler();
        this.glv = false;
        this.glu = new b();
    }

    public void setNumTypeFromBes(boolean z) {
        this.glv = z;
    }

    public void setTimeoutListener(c cVar) {
        this.glt = cVar;
    }

    public void setTimerChangedListener(a aVar) {
        this.gls = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        th(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMO();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            th(0);
        } else {
            bMO();
        }
    }

    public void aE(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.mCounter = i;
        }
    }

    private void bMO() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        this.mCounter -= i;
        if (this.gls != null && i != 0) {
            this.gls.tg(this.mCounter);
        }
        if (this.mCounter == 0) {
            if (this.glt != null) {
                this.glt.cf(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.mCounter > 0) {
            if (this.glv) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.mCounter)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.mCounter)));
            }
        }
        this.mHandler.removeCallbacks(this.glu);
        this.mHandler.postDelayed(this.glu, 1000L);
    }
}
