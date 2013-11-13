package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1025a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LoginActivity loginActivity) {
        this.f1025a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1025a.g();
    }
}
