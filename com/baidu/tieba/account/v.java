package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ ActivationActivity avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ActivationActivity activationActivity) {
        this.avu = activationActivity;
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
        z zVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.avu;
        i = activationActivity.EW;
        activationActivity.EW = i - 1;
        i2 = this.avu.EW;
        if (i2 <= 0) {
            this.avu.avk = true;
            textView2 = this.avu.ave;
            textView2.setText(this.avu.getPageContext().getString(com.baidu.tieba.y.resend_code));
            zVar = this.avu.avj;
            if (zVar == null) {
                relativeLayout = this.avu.avh;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.avu.getPageContext().getString(com.baidu.tieba.y.resend_code_second);
        i3 = this.avu.EW;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.avu.ave;
        textView.setText(format);
        handler = this.avu.mHandler;
        runnable = this.avu.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
