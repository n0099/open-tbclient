package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class CountDownTextView extends TextView {
    private int cUw;
    private b gnf;
    private final Runnable gng;
    private boolean gnh;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes8.dex */
    public interface b {
        void cj(View view);
    }

    /* loaded from: classes8.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> gmy;

        private a(CountDownTextView countDownTextView) {
            this.gmy = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gmy.get();
            if (countDownTextView != null) {
                countDownTextView.uH(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cUw = 0;
        this.mText = "";
        this.gnf = null;
        this.mHandler = new Handler();
        this.gnh = false;
        this.gng = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.gnh = z;
    }

    public void setTimeoutListener(b bVar) {
        this.gnf = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        uH(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bPX();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            uH(0);
        } else {
            bPX();
        }
    }

    public void aC(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cUw = i;
        }
    }

    private void bPX() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(int i) {
        this.cUw -= i;
        if (this.cUw == 0) {
            if (this.gnf != null) {
                this.gnf.cj(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cUw > 0) {
            if (this.gnh) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.cUw)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.cUw)));
            }
        }
        this.mHandler.removeCallbacks(this.gng);
        this.mHandler.postDelayed(this.gng, 1000L);
    }
}
