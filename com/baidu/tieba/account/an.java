package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
final class an implements View.OnClickListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LoginActivity.t(this.a);
    }
}
