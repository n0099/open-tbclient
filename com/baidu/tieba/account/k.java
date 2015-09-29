package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ ActivationActivity aER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ActivationActivity activationActivity) {
        this.aER = activationActivity;
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
        ActivationActivity activationActivity = this.aER;
        i = activationActivity.EM;
        activationActivity.EM = i - 1;
        i2 = this.aER.EM;
        if (i2 <= 0) {
            this.aER.aEI = true;
            textView2 = this.aER.aEC;
            textView2.setText(this.aER.getPageContext().getString(i.h.resend_code));
            aVar = this.aER.aEH;
            if (aVar == null) {
                this.aER.aEF.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aER.getPageContext().getString(i.h.resend_code_second);
        i3 = this.aER.EM;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aER.aEC;
        textView.setText(format);
        handler = this.aER.mHandler;
        runnable = this.aER.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
