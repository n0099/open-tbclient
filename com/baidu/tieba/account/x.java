package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginActivity loginActivity) {
        this.f894a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f894a.n();
    }
}
