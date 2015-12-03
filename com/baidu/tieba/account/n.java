package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ ActivationActivity aGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ActivationActivity activationActivity) {
        this.aGV = activationActivity;
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
        ActivationActivity activationActivity = this.aGV;
        i = activationActivity.Fd;
        activationActivity.Fd = i - 1;
        i2 = this.aGV.Fd;
        if (i2 <= 0) {
            this.aGV.aGM = true;
            textView2 = this.aGV.aGG;
            textView2.setText(this.aGV.getPageContext().getString(n.i.resend_code));
            aVar = this.aGV.aGL;
            if (aVar == null) {
                this.aGV.aGJ.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aGV.getPageContext().getString(n.i.resend_code_second);
        i3 = this.aGV.Fd;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aGV.aGG;
        textView.setText(format);
        handler = this.aGV.mHandler;
        runnable = this.aGV.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
