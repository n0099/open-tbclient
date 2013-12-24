package com.baidu.tieba.im;

import android.view.View;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ NetWorkDebugActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NetWorkDebugActivity netWorkDebugActivity) {
        this.a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("begin connect-----------");
        j.a = this.a.d.getText().toString();
        this.a.d.setText(j.a);
        TiebaSocketLinkService.a(true, "by testModel");
        NetWorkDebugActivity.a("end conncet-----------");
        NetWorkDebugActivity.a("wait connectcallback call-----------");
    }
}
