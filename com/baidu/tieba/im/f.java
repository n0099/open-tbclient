package com.baidu.tieba.im;

import android.view.View;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkDebugActivity f1693a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NetWorkDebugActivity netWorkDebugActivity) {
        this.f1693a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("begin connect-----------");
        j.f1786a = this.f1693a.d.getText().toString();
        this.f1693a.d.setText(j.f1786a);
        TiebaSocketLinkService.a(true, "by testModel");
        NetWorkDebugActivity.a("end conncet-----------");
        NetWorkDebugActivity.a("wait connectcallback call-----------");
    }
}
