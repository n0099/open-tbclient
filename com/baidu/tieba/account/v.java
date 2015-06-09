package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ ActivationActivity awW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ActivationActivity activationActivity) {
        this.awW = activationActivity;
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
        aa aaVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.awW;
        i = activationActivity.EL;
        activationActivity.EL = i - 1;
        i2 = this.awW.EL;
        if (i2 <= 0) {
            this.awW.awN = true;
            textView2 = this.awW.awH;
            textView2.setText(this.awW.getPageContext().getString(com.baidu.tieba.t.resend_code));
            aaVar = this.awW.awM;
            if (aaVar == null) {
                relativeLayout = this.awW.awK;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.awW.getPageContext().getString(com.baidu.tieba.t.resend_code_second);
        i3 = this.awW.EL;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.awW.awH;
        textView.setText(format);
        handler = this.awW.mHandler;
        runnable = this.awW.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
