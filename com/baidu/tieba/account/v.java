package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ ActivationActivity avm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ActivationActivity activationActivity) {
        this.avm = activationActivity;
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
        ActivationActivity activationActivity = this.avm;
        i = activationActivity.EU;
        activationActivity.EU = i - 1;
        i2 = this.avm.EU;
        if (i2 <= 0) {
            this.avm.avc = true;
            textView2 = this.avm.auW;
            textView2.setText(this.avm.getPageContext().getString(com.baidu.tieba.y.resend_code));
            zVar = this.avm.avb;
            if (zVar == null) {
                relativeLayout = this.avm.auZ;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.avm.getPageContext().getString(com.baidu.tieba.y.resend_code_second);
        i3 = this.avm.EU;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.avm.auW;
        textView.setText(format);
        handler = this.avm.mHandler;
        runnable = this.avm.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
