package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1034a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ReLoginActivity reLoginActivity) {
        this.f1034a = reLoginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1034a.c();
    }
}
