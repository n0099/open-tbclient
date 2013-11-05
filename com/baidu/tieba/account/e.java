package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ActivationActivity activationActivity) {
        this.f1042a = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        TextView textView;
        Handler handler;
        Runnable runnable;
        TextView textView2;
        i iVar;
        RelativeLayout relativeLayout;
        ActivationActivity.a(this.f1042a);
        i = this.f1042a.q;
        if (i <= 0) {
            this.f1042a.p = true;
            textView2 = this.f1042a.g;
            textView2.setText(this.f1042a.getString(R.string.resend_code));
            iVar = this.f1042a.o;
            if (iVar == null) {
                relativeLayout = this.f1042a.m;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.f1042a.getString(R.string.resend_code_second);
        i2 = this.f1042a.q;
        String format = String.format(string, Integer.valueOf(i2));
        textView = this.f1042a.g;
        textView.setText(format);
        handler = this.f1042a.s;
        runnable = this.f1042a.B;
        handler.postDelayed(runnable, 1000L);
    }
}
