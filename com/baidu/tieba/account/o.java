package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ActivationActivity amw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.amw = activationActivity;
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
        s sVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.amw;
        i = activationActivity.tW;
        activationActivity.tW = i - 1;
        i2 = this.amw.tW;
        if (i2 <= 0) {
            this.amw.amm = true;
            textView2 = this.amw.amg;
            textView2.setText(this.amw.getPageContext().getString(com.baidu.tieba.z.resend_code));
            sVar = this.amw.aml;
            if (sVar == null) {
                relativeLayout = this.amw.amj;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.amw.getPageContext().getString(com.baidu.tieba.z.resend_code_second);
        i3 = this.amw.tW;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.amw.amg;
        textView.setText(format);
        handler = this.amw.mHandler;
        runnable = this.amw.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
