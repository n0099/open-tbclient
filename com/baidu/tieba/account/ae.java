package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ProtocolActivity f888a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ProtocolActivity protocolActivity) {
        this.f888a = protocolActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f888a.finish();
    }
}
