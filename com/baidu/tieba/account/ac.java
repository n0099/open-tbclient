package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LoginActivity loginActivity) {
        this.f1039a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1039a.g();
    }
}
