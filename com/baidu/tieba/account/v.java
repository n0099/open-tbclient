package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ ActivationActivity awV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ActivationActivity activationActivity) {
        this.awV = activationActivity;
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
        ActivationActivity activationActivity = this.awV;
        i = activationActivity.EL;
        activationActivity.EL = i - 1;
        i2 = this.awV.EL;
        if (i2 <= 0) {
            this.awV.awM = true;
            textView2 = this.awV.awG;
            textView2.setText(this.awV.getPageContext().getString(com.baidu.tieba.t.resend_code));
            aaVar = this.awV.awL;
            if (aaVar == null) {
                relativeLayout = this.awV.awJ;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.awV.getPageContext().getString(com.baidu.tieba.t.resend_code_second);
        i3 = this.awV.EL;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.awV.awG;
        textView.setText(format);
        handler = this.awV.mHandler;
        runnable = this.awV.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
