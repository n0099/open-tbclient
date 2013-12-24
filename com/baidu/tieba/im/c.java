package com.baidu.tieba.im;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class c extends Handler {
    final /* synthetic */ NetWorkDebugActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NetWorkDebugActivity netWorkDebugActivity) {
        this.a = netWorkDebugActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.a.c.append(((String) message.obj) + "\n");
    }
}
