package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ActivationActivity aJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aJA = activationActivity;
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
        ActivationActivity activationActivity = this.aJA;
        i = activationActivity.FC;
        activationActivity.FC = i - 1;
        i2 = this.aJA.FC;
        if (i2 <= 0) {
            this.aJA.aJq = true;
            textView2 = this.aJA.aJk;
            textView2.setText(this.aJA.getPageContext().getString(t.j.resend_code));
            aVar = this.aJA.aJp;
            if (aVar == null) {
                this.aJA.aJn.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aJA.getPageContext().getString(t.j.resend_code_second);
        i3 = this.aJA.FC;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aJA.aJk;
        textView.setText(format);
        handler = this.aJA.mHandler;
        runnable = this.aJA.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
