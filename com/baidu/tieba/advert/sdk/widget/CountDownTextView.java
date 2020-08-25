package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes17.dex */
public class CountDownTextView extends TextView {
    private int chD;
    private b fsl;
    private final Runnable fsm;
    private boolean fsn;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes17.dex */
    public interface b {
        void bD(View view);
    }

    /* loaded from: classes17.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> frE;

        private a(CountDownTextView countDownTextView) {
            this.frE = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.frE.get();
            if (countDownTextView != null) {
                countDownTextView.sj(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.chD = 0;
        this.mText = "";
        this.fsl = null;
        this.mHandler = new Handler();
        this.fsn = false;
        this.fsm = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.fsn = z;
    }

    public void setTimeoutListener(b bVar) {
        this.fsl = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bCl();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            sj(0);
        } else {
            bCl();
        }
    }

    public void ax(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.chD = i;
        }
    }

    private void bCl() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(int i) {
        this.chD -= i;
        if (this.chD == 0) {
            if (this.fsl != null) {
                this.fsl.bD(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.chD > 0) {
            if (this.fsn) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.chD)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.chD)));
            }
        }
        this.mHandler.removeCallbacks(this.fsm);
        this.mHandler.postDelayed(this.fsm, 1000L);
    }
}
