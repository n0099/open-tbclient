package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tieba.account.ActivationActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ ActivationActivity aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aSr = activationActivity;
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
        ActivationActivity activationActivity = this.aSr;
        i = activationActivity.yP;
        activationActivity.yP = i - 1;
        i2 = this.aSr.yP;
        if (i2 <= 0) {
            this.aSr.aSh = true;
            textView2 = this.aSr.aSb;
            textView2.setText(this.aSr.getPageContext().getString(t.j.resend_code));
            aVar = this.aSr.aSg;
            if (aVar == null) {
                this.aSr.aSe.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.aSr.getPageContext().getString(t.j.resend_code_second);
        i3 = this.aSr.yP;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.aSr.aSb;
        textView.setText(format);
        handler = this.aSr.mHandler;
        runnable = this.aSr.mRunnable;
        handler.postDelayed(runnable, 1000L);
    }
}
