package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ActivationActivity aIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.aIw = activationActivity;
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
        ActivationActivity activationActivity = this.aIw;
        i = activationActivity.Fp;
        activationActivity.Fp = i - 1;
        i2 = this.aIw.Fp;
        if (i2 <= 0) {
            this.aIw.aIn = true;
            textView2 = this.aIw.aIh;
            textView2.setText(this.aIw.getPageContext().getString(n.j.resend_code));
            aVar = this.aIw.aIm;
            if (aVar == null) {
                this.aIw.aIk.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aIw.getPageContext().getString(n.j.resend_code_second);
        i3 = this.aIw.Fp;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aIw.aIh;
        textView.setText(format);
        handler = this.aIw.mHandler;
        runnable = this.aIw.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
