package com.baidu.tieba.account;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ AccountVcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountVcodeActivity accountVcodeActivity) {
        this.a = accountVcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        AccountVcodeActivity accountVcodeActivity = this.a;
        str = this.a.g;
        accountVcodeActivity.c(str);
    }
}
