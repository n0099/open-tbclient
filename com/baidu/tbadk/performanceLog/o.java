package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n agz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.agz = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        q qVar;
        q qVar2;
        int i;
        qVar = this.agz.agx;
        if (qVar != null) {
            qVar2 = this.agz.agx;
            i = this.agz.agn;
            qVar2.dU(i);
        }
    }
}
