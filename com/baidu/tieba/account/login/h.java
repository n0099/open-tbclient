package com.baidu.tieba.account.login;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ Login2Activity axg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Login2Activity login2Activity) {
        this.axg = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.axg.EH();
    }
}
