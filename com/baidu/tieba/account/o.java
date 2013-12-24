package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        TextView textView;
        Handler handler;
        Runnable runnable;
        TextView textView2;
        s sVar;
        RelativeLayout relativeLayout;
        ActivationActivity.a(this.a);
        i = this.a.o;
        if (i <= 0) {
            this.a.n = true;
            textView2 = this.a.g;
            textView2.setText(this.a.getString(R.string.resend_code));
            sVar = this.a.m;
            if (sVar == null) {
                relativeLayout = this.a.k;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.a.getString(R.string.resend_code_second);
        i2 = this.a.o;
        String format = String.format(string, Integer.valueOf(i2));
        textView = this.a.g;
        textView.setText(format);
        handler = this.a.q;
        runnable = this.a.z;
        handler.postDelayed(runnable, 1000L);
    }
}
