package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.l();
    }
}
