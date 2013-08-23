package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ReLoginActivity reLoginActivity) {
        this.f876a = reLoginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f876a.finish();
    }
}
