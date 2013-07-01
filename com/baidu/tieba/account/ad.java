package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ProtocolActivity f641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ProtocolActivity protocolActivity) {
        this.f641a = protocolActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f641a.finish();
    }
}
