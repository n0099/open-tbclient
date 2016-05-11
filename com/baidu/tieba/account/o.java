package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ActivationActivity aIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.aIG = activationActivity;
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
        ActivationActivity activationActivity = this.aIG;
        i = activationActivity.wa;
        activationActivity.wa = i - 1;
        i2 = this.aIG.wa;
        if (i2 <= 0) {
            this.aIG.aIw = true;
            textView2 = this.aIG.aIq;
            textView2.setText(this.aIG.getPageContext().getString(t.j.resend_code));
            aVar = this.aIG.aIv;
            if (aVar == null) {
                this.aIG.aIt.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aIG.getPageContext().getString(t.j.resend_code_second);
        i3 = this.aIG.wa;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aIG.aIq;
        textView.setText(format);
        handler = this.aIG.mHandler;
        runnable = this.aIG.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
