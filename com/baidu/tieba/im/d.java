package com.baidu.tieba.im;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkDebugActivity f1638a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NetWorkDebugActivity netWorkDebugActivity) {
        this.f1638a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("close socket");
        com.baidu.adp.lib.webSocket.m.a().c();
        NetWorkDebugActivity.a("end close");
    }
}
