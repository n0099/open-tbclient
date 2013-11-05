package com.baidu.tieba.im;

import android.view.View;
import com.baidu.tieba.im.net.link.TiebaSocketLinkService;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkDebugActivity f1544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NetWorkDebugActivity netWorkDebugActivity) {
        this.f1544a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("begin connect-----------");
        j.f1635a = this.f1544a.d.getText().toString();
        this.f1544a.d.setText(j.f1635a);
        TiebaSocketLinkService.a(true, "by testModel");
        NetWorkDebugActivity.a("end conncet-----------");
        NetWorkDebugActivity.a("wait connectcallback call-----------");
    }
}
