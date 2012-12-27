package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ AccountVcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountVcodeActivity accountVcodeActivity) {
        this.a = accountVcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
