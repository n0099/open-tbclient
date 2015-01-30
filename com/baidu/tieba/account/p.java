package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ActivationActivity anq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.anq = activationActivity;
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
        t tVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.anq;
        i = activationActivity.ud;
        activationActivity.ud = i - 1;
        i2 = this.anq.ud;
        if (i2 <= 0) {
            this.anq.ang = true;
            textView2 = this.anq.ana;
            textView2.setText(this.anq.getPageContext().getString(com.baidu.tieba.z.resend_code));
            tVar = this.anq.anf;
            if (tVar == null) {
                relativeLayout = this.anq.and;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.anq.getPageContext().getString(com.baidu.tieba.z.resend_code_second);
        i3 = this.anq.ud;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.anq.ana;
        textView.setText(format);
        handler = this.anq.mHandler;
        runnable = this.anq.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
