package com.baidu.tieba.im;

import android.view.View;
import com.baidu.tieba.im.message.cd;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ NetWorkDebugActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NetWorkDebugActivity netWorkDebugActivity) {
        this.a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("begin send-----------");
        com.baidu.tieba.im.messageCenter.e.a().a(new cd());
        NetWorkDebugActivity.a("end send-----------");
        NetWorkDebugActivity.a("wait callback call-----------");
    }
}
