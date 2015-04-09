package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n apc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.apc = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        q qVar;
        q qVar2;
        int i;
        qVar = this.apc.apa;
        if (qVar != null) {
            qVar2 = this.apc.apa;
            i = this.apc.aoQ;
            qVar2.dY(i);
        }
    }
}
