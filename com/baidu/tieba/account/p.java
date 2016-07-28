package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ActivationActivity aMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aMX = activationActivity;
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
        ActivationActivity activationActivity = this.aMX;
        i = activationActivity.wD;
        activationActivity.wD = i - 1;
        i2 = this.aMX.wD;
        if (i2 <= 0) {
            this.aMX.aMN = true;
            textView2 = this.aMX.aMH;
            textView2.setText(this.aMX.getPageContext().getString(u.j.resend_code));
            aVar = this.aMX.aMM;
            if (aVar == null) {
                this.aMX.aMK.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aMX.getPageContext().getString(u.j.resend_code_second);
        i3 = this.aMX.wD;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aMX.aMH;
        textView.setText(format);
        handler = this.aMX.mHandler;
        runnable = this.aMX.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
