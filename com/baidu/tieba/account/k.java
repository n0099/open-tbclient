package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ ActivationActivity aFc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ActivationActivity activationActivity) {
        this.aFc = activationActivity;
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
        ActivationActivity activationActivity = this.aFc;
        i = activationActivity.EN;
        activationActivity.EN = i - 1;
        i2 = this.aFc.EN;
        if (i2 <= 0) {
            this.aFc.aET = true;
            textView2 = this.aFc.aEN;
            textView2.setText(this.aFc.getPageContext().getString(i.h.resend_code));
            aVar = this.aFc.aES;
            if (aVar == null) {
                this.aFc.aEQ.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aFc.getPageContext().getString(i.h.resend_code_second);
        i3 = this.aFc.EN;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aFc.aEN;
        textView.setText(format);
        handler = this.aFc.mHandler;
        runnable = this.aFc.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
