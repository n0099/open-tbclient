package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ActivationActivity aMd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aMd = activationActivity;
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
        ActivationActivity activationActivity = this.aMd;
        i = activationActivity.wc;
        activationActivity.wc = i - 1;
        i2 = this.aMd.wc;
        if (i2 <= 0) {
            this.aMd.aLT = true;
            textView2 = this.aMd.aLN;
            textView2.setText(this.aMd.getPageContext().getString(u.j.resend_code));
            aVar = this.aMd.aLS;
            if (aVar == null) {
                this.aMd.aLQ.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aMd.getPageContext().getString(u.j.resend_code_second);
        i3 = this.aMd.wc;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aMd.aLN;
        textView.setText(format);
        handler = this.aMd.mHandler;
        runnable = this.aMd.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
