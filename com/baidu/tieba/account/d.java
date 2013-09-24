package com.baidu.tieba.account;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f912a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ActivationActivity activationActivity) {
        this.f912a = activationActivity;
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
        h hVar;
        RelativeLayout relativeLayout;
        ActivationActivity activationActivity = this.f912a;
        i = activationActivity.q;
        activationActivity.q = i - 1;
        i2 = this.f912a.q;
        if (i2 <= 0) {
            this.f912a.p = true;
            textView2 = this.f912a.g;
            textView2.setText(this.f912a.getString(R.string.resend_code));
            hVar = this.f912a.o;
            if (hVar == null) {
                relativeLayout = this.f912a.m;
                relativeLayout.setEnabled(true);
                return;
            }
            return;
        }
        String string = this.f912a.getString(R.string.resend_code_second);
        i3 = this.f912a.q;
        String format = String.format(string, Integer.valueOf(i3));
        textView = this.f912a.g;
        textView.setText(format);
        handler = this.f912a.s;
        runnable = this.f912a.B;
        handler.postDelayed(runnable, 1000L);
    }
}
