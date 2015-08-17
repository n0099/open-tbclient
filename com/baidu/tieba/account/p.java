package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ActivationActivity aEn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aEn = activationActivity;
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
        ActivationActivity activationActivity = this.aEn;
        i = activationActivity.EM;
        activationActivity.EM = i - 1;
        i2 = this.aEn.EM;
        if (i2 <= 0) {
            this.aEn.aEe = true;
            textView2 = this.aEn.aDY;
            textView2.setText(this.aEn.getPageContext().getString(i.C0057i.resend_code));
            aVar = this.aEn.aEd;
            if (aVar == null) {
                this.aEn.aEb.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aEn.getPageContext().getString(i.C0057i.resend_code_second);
        i3 = this.aEn.EM;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aEn.aDY;
        textView.setText(format);
        handler = this.aEn.mHandler;
        runnable = this.aEn.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
