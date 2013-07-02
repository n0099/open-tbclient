package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ ReLoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ReLoginActivity reLoginActivity) {
        this.a = reLoginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
