package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ ActivationActivity aeY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ActivationActivity activationActivity) {
        this.aeY = activationActivity;
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
        ActivationActivity activationActivity = this.aeY;
        i = activationActivity.aeO;
        activationActivity.aeO = i - 1;
        i2 = this.aeY.aeO;
        if (i2 <= 0) {
            this.aeY.aeN = true;
            textView2 = this.aeY.aeH;
            textView2.setText(this.aeY.getString(com.baidu.tieba.y.resend_code));
            rVar = this.aeY.aeM;
            if (rVar == null) {
                relativeLayout = this.aeY.aeK;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aeY.getString(com.baidu.tieba.y.resend_code_second);
        i3 = this.aeY.aeO;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aeY.aeH;
        textView.setText(format);
        handler = this.aeY.mHandler;
        runnable = this.aeY.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
