package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ ProtocolActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ProtocolActivity protocolActivity) {
        this.a = protocolActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
