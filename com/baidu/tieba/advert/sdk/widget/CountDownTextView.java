package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int bnS;
    private b edx;
    private final Runnable edy;
    private boolean edz;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes10.dex */
    public interface b {
        void bq(View view);
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecT;

        private a(CountDownTextView countDownTextView) {
            this.ecT = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecT.get();
            if (countDownTextView != null) {
                countDownTextView.op(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bnS = 0;
        this.mText = "";
        this.edx = null;
        this.mHandler = new Handler();
        this.edz = false;
        this.edy = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.edz = z;
    }

    public void setTimeoutListener(b bVar) {
        this.edx = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        op(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZy();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            op(0);
        } else {
            aZy();
        }
    }

    public void al(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bnS = i;
        }
    }

    private void aZy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(int i) {
        this.bnS -= i;
        if (this.bnS == 0) {
            if (this.edx != null) {
                this.edx.bq(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bnS > 0) {
            if (this.edz) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.bnS)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.bnS)));
            }
        }
        this.mHandler.removeCallbacks(this.edy);
        this.mHandler.postDelayed(this.edy, 1000L);
    }
}
