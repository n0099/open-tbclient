package com.baidu.tieba.im;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ NetWorkDebugActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NetWorkDebugActivity netWorkDebugActivity) {
        this.a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("close socket");
        com.baidu.adp.lib.webSocket.m.a().c();
        NetWorkDebugActivity.a("end close");
    }
}
