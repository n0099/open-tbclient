package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        String str;
        button = this.a.c;
        if (view == button) {
            this.a.j = true;
            l a = l.a();
            str = this.a.f;
            a.b(str);
            this.a.c();
            return;
        }
        button2 = this.a.b;
        if (view == button2) {
            this.a.d();
        }
    }
}
