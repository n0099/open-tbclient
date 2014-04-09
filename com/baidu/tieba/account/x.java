package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
/* loaded from: classes.dex */
final class x implements View.OnClickListener {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Button button;
        Button button2;
        String str;
        button = this.a.c;
        if (view != button) {
            button2 = this.a.b;
            if (view != button2) {
                return;
            }
            this.a.a();
            return;
        }
        this.a.j = true;
        com.baidu.tbadk.core.a.l a = com.baidu.tbadk.core.a.l.a();
        str = this.a.f;
        a.b(str);
        ReLoginShareActivity.c(this.a);
    }
}
