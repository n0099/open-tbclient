package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CountDownTextView extends TextView {
    private int cPK;
    private boolean giA;
    private b giy;
    private final Runnable giz;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes7.dex */
    public interface b {
        void cj(View view);
    }

    /* loaded from: classes7.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> ghQ;

        private a(CountDownTextView countDownTextView) {
            this.ghQ = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ghQ.get();
            if (countDownTextView != null) {
                countDownTextView.tb(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cPK = 0;
        this.mText = "";
        this.giy = null;
        this.mHandler = new Handler();
        this.giA = false;
        this.giz = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.giA = z;
    }

    public void setTimeoutListener(b bVar) {
        this.giy = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tb(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMg();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            tb(0);
        } else {
            bMg();
        }
    }

    public void aC(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cPK = i;
        }
    }

    private void bMg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(int i) {
        this.cPK -= i;
        if (this.cPK == 0) {
            if (this.giy != null) {
                this.giy.cj(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cPK > 0) {
            if (this.giA) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.cPK)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.cPK)));
            }
        }
        this.mHandler.removeCallbacks(this.giz);
        this.mHandler.postDelayed(this.giz, 1000L);
    }
}
