package com.baidu.tieba.im;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkDebugActivity f1483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NetWorkDebugActivity netWorkDebugActivity) {
        this.f1483a = netWorkDebugActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f1483a.c.append(((String) message.obj) + "\n");
    }
}
