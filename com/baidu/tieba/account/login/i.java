package com.baidu.tieba.account.login;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ Login2Activity aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Login2Activity login2Activity) {
        this.aGf = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aGf.Go();
    }
}
