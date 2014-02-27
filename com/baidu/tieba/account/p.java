package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class p implements Runnable {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
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
        t tVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.a;
        i = activationActivity.o;
        activationActivity.o = i - 1;
        i2 = this.a.o;
        if (i2 <= 0) {
            this.a.n = true;
            textView2 = this.a.g;
            textView2.setText(this.a.getString(R.string.resend_code));
            tVar = this.a.m;
            if (tVar == null) {
                relativeLayout = this.a.k;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.a.getString(R.string.resend_code_second);
        i3 = this.a.o;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.a.g;
        textView.setText(format);
        handler = this.a.q;
        runnable = this.a.z;
        handler.postDelayed(runnable, 1000L);
    }
}
