package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ReLoginActivity reLoginActivity) {
        this.f1035a = reLoginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1035a.finish();
    }
}
