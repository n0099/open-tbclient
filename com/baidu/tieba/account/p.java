package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ActivationActivity aFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aFV = activationActivity;
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
        ActivationActivity activationActivity = this.aFV;
        i = activationActivity.EM;
        activationActivity.EM = i - 1;
        i2 = this.aFV.EM;
        if (i2 <= 0) {
            this.aFV.aFM = true;
            textView2 = this.aFV.aFG;
            textView2.setText(this.aFV.getPageContext().getString(i.h.resend_code));
            aVar = this.aFV.aFL;
            if (aVar == null) {
                this.aFV.aFJ.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aFV.getPageContext().getString(i.h.resend_code_second);
        i3 = this.aFV.EM;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aFV.aFG;
        textView.setText(format);
        handler = this.aFV.mHandler;
        runnable = this.aFV.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
