package com.baidu.tieba.im;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ NetWorkDebugActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NetWorkDebugActivity netWorkDebugActivity) {
        this.a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("begin send-----------");
        com.baidu.tieba.im.message.d dVar = new com.baidu.tieba.im.message.d();
        dVar.a("123456");
        com.baidu.tieba.im.messageCenter.e.a().a(dVar);
        NetWorkDebugActivity.a("end send-----------");
        NetWorkDebugActivity.a("wait callback call-----------");
    }
}
