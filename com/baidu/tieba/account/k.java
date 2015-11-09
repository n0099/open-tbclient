package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ ActivationActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ActivationActivity activationActivity) {
        this.aDW = activationActivity;
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
        ActivationActivity activationActivity = this.aDW;
        i = activationActivity.EO;
        activationActivity.EO = i - 1;
        i2 = this.aDW.EO;
        if (i2 <= 0) {
            this.aDW.aDN = true;
            textView2 = this.aDW.aDH;
            textView2.setText(this.aDW.getPageContext().getString(i.h.resend_code));
            aVar = this.aDW.aDM;
            if (aVar == null) {
                this.aDW.aDK.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aDW.getPageContext().getString(i.h.resend_code_second);
        i3 = this.aDW.EO;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aDW.aDH;
        textView.setText(format);
        handler = this.aDW.mHandler;
        runnable = this.aDW.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
