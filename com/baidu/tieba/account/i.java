package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ActivationActivity activationActivity) {
        this.a = activationActivity;
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
        m mVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.a;
        i = activationActivity.q;
        activationActivity.q = i - 1;
        i2 = this.a.q;
        if (i2 <= 0) {
            this.a.p = true;
            textView2 = this.a.i;
            textView2.setText(this.a.getString(R.string.resend_code));
            mVar = this.a.o;
            if (mVar == null) {
                relativeLayout = this.a.m;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.a.getString(R.string.resend_code_second);
        i3 = this.a.q;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.a.i;
        textView.setText(format);
        handler = this.a.s;
        runnable = this.a.B;
        handler.postDelayed(runnable, 1000L);
    }
}
