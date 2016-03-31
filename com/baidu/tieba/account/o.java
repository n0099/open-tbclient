package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ActivationActivity aMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.aMw = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        TextView textView;
        Handler handler;
        Runnable runnable;
        TextView textView2;
        ActivationActivity.a aVar;
        ActivationActivity activationActivity = this.aMw;
        i = activationActivity.FI;
        activationActivity.FI = i - 1;
        i2 = this.aMw.FI;
        if (i2 <= 0) {
            this.aMw.aMm = true;
            textView2 = this.aMw.aMg;
            textView2.setText(this.aMw.getPageContext().getString(t.j.resend_code));
            aVar = this.aMw.aMl;
            if (aVar == null) {
                this.aMw.aMj.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aMw.getPageContext().getString(t.j.resend_code_second);
        i3 = this.aMw.FI;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aMw.aMg;
        textView.setText(format);
        handler = this.aMw.mHandler;
        runnable = this.aMw.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
