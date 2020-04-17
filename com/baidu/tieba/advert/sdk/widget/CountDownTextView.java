package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int bLZ;
    private b eDo;
    private final Runnable eDp;
    private boolean eDq;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes10.dex */
    public interface b {
        void br(View view);
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> eCH;

        private a(CountDownTextView countDownTextView) {
            this.eCH = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.eCH.get();
            if (countDownTextView != null) {
                countDownTextView.oC(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bLZ = 0;
        this.mText = "";
        this.eDo = null;
        this.mHandler = new Handler();
        this.eDq = false;
        this.eDp = new a();
    }

    public void setNumTypeFromBes(boolean z) {
        this.eDq = z;
    }

    public void setTimeoutListener(b bVar) {
        this.eDo = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        oC(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bhC();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            oC(0);
        } else {
            bhC();
        }
    }

    public void au(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bLZ = i;
        }
    }

    private void bhC() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC(int i) {
        this.bLZ -= i;
        if (this.bLZ == 0) {
            if (this.eDo != null) {
                this.eDo.br(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bLZ > 0) {
            if (this.eDq) {
                setText(String.format("%s 0%s", this.mText, Integer.valueOf(this.bLZ)));
            } else {
                setText(String.format("%s %s", this.mText, Integer.valueOf(this.bLZ)));
            }
        }
        this.mHandler.removeCallbacks(this.eDp);
        this.mHandler.postDelayed(this.eDp, 1000L);
    }
}
