package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes22.dex */
public class CountDownTextView extends TextView {
    private int cjJ;
    private b fvB;
    private final Runnable fvC;
    private boolean fvD;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes22.dex */
    public interface b {
        void bH(View view);
    }

    /* loaded from: classes22.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fuU;

        private a(CountDownTextView countDownTextView) {
            this.fuU = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fuU.get();
            if (countDownTextView != null) {
                countDownTextView.sB(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cjJ = 0;
        this.mText = "";
        this.fvB = null;
        this.mHandler = new Handler();
        this.fvD = false;
        this.fvC = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.fvD = z;
    }

    public void setTimeoutListener(b bVar) {
        this.fvB = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sB(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bDy();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            sB(0);
        } else {
            bDy();
        }
    }

    public void ax(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cjJ = i;
        }
    }

    private void bDy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB(int i) {
        this.cjJ -= i;
        if (this.cjJ == 0) {
            if (this.fvB != null) {
                this.fvB.bH(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cjJ > 0) {
            if (this.fvD) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.cjJ)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.cjJ)));
            }
        }
        this.mHandler.removeCallbacks(this.fvC);
        this.mHandler.postDelayed(this.fvC, 1000L);
    }
}
