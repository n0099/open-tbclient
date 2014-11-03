package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ ActivationActivity afg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ActivationActivity activationActivity) {
        this.afg = activationActivity;
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
        r rVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.afg;
        i = activationActivity.aeW;
        activationActivity.aeW = i - 1;
        i2 = this.afg.aeW;
        if (i2 <= 0) {
            this.afg.aeV = true;
            textView2 = this.afg.aeP;
            textView2.setText(this.afg.getString(com.baidu.tieba.y.resend_code));
            rVar = this.afg.aeU;
            if (rVar == null) {
                relativeLayout = this.afg.aeS;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.afg.getString(com.baidu.tieba.y.resend_code_second);
        i3 = this.afg.aeW;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.afg.aeP;
        textView.setText(format);
        handler = this.afg.mHandler;
        runnable = this.afg.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
