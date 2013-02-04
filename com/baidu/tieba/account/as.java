package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        Button button3;
        button = this.a.d;
        if (view != button) {
            button2 = this.a.e;
            if (view != button2) {
                button3 = this.a.c;
                if (view == button3) {
                    this.a.j();
                    return;
                }
                return;
            }
        }
        this.a.i();
    }
}
