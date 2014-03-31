package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
final class n implements Runnable {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        TextView textView;
        Handler handler;
        Runnable runnable;
        TextView textView2;
        r rVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.a;
        i = activationActivity.p;
        activationActivity.p = i - 1;
        i2 = this.a.p;
        if (i2 <= 0) {
            this.a.o = true;
            textView2 = this.a.h;
            textView2.setText(this.a.getString(com.baidu.tieba.a.k.resend_code));
            rVar = this.a.n;
            if (rVar == null) {
                relativeLayout = this.a.l;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.a.getString(com.baidu.tieba.a.k.resend_code_second);
        i3 = this.a.p;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.a.h;
        textView.setText(format);
        handler = this.a.r;
        runnable = this.a.z;
        handler.postDelayed(runnable, 1000L);
    }
}
