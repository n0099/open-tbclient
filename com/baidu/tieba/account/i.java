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
        i = activationActivity.p;
        activationActivity.p = i - 1;
        i2 = this.a.p;
        if (i2 <= 0) {
            this.a.o = true;
            textView2 = this.a.h;
            textView2.setText(this.a.getString(R.string.resend_code));
            mVar = this.a.n;
            if (mVar == null) {
                relativeLayout = this.a.l;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.a.getString(R.string.resend_code_second);
        i3 = this.a.p;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.a.h;
        textView.setText(format);
        handler = this.a.r;
        runnable = this.a.v;
        handler.postDelayed(runnable, 1000L);
    }
}
