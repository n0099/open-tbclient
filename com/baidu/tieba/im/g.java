package com.baidu.tieba.im;

import android.view.View;
import com.baidu.tieba.im.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkDebugActivity f1727a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NetWorkDebugActivity netWorkDebugActivity) {
        this.f1727a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("begin send-----------");
        com.baidu.tieba.im.messageCenter.e.a().a(new UpdateClientInfoMessage());
        NetWorkDebugActivity.a("end send-----------");
        NetWorkDebugActivity.a("wait callback call-----------");
    }
}
