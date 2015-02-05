package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ActivationActivity ann;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.ann = activationActivity;
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
        ActivationActivity activationActivity = this.ann;
        i = activationActivity.ua;
        activationActivity.ua = i - 1;
        i2 = this.ann.ua;
        if (i2 <= 0) {
            this.ann.and = true;
            textView2 = this.ann.amX;
            textView2.setText(this.ann.getPageContext().getString(com.baidu.tieba.z.resend_code));
            tVar = this.ann.anc;
            if (tVar == null) {
                relativeLayout = this.ann.ana;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.ann.getPageContext().getString(com.baidu.tieba.z.resend_code_second);
        i3 = this.ann.ua;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.ann.amX;
        textView.setText(format);
        handler = this.ann.mHandler;
        runnable = this.ann.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
