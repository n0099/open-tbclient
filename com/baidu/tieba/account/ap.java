package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f1042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ReLoginShareActivity reLoginShareActivity) {
        this.f1042a = reLoginShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        button = this.f1042a.d;
        if (view == button) {
            this.f1042a.c();
            return;
        }
        button2 = this.f1042a.c;
        if (view == button2) {
            this.f1042a.d();
        }
    }
}
