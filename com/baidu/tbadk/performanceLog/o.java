package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n aoU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aoU = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        q qVar;
        q qVar2;
        int i;
        qVar = this.aoU.aoS;
        if (qVar != null) {
            qVar2 = this.aoU.aoS;
            i = this.aoU.aoI;
            qVar2.dY(i);
        }
    }
}
