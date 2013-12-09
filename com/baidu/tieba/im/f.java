package com.baidu.tieba.im;

import android.view.View;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkDebugActivity f1694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NetWorkDebugActivity netWorkDebugActivity) {
        this.f1694a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("begin connect-----------");
        j.f1787a = this.f1694a.d.getText().toString();
        this.f1694a.d.setText(j.f1787a);
        TiebaSocketLinkService.a(true, "by testModel");
        NetWorkDebugActivity.a("end conncet-----------");
        NetWorkDebugActivity.a("wait connectcallback call-----------");
    }
}
