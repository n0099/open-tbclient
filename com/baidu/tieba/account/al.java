package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1048a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ReLoginActivity reLoginActivity) {
        this.f1048a = reLoginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1048a.c();
    }
}
