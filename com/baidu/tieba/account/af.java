package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ProtocolActivity f1018a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ProtocolActivity protocolActivity) {
        this.f1018a = protocolActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1018a.finish();
    }
}
