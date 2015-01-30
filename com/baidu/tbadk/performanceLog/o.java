package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n agC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.agC = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        q qVar;
        q qVar2;
        int i;
        qVar = this.agC.agA;
        if (qVar != null) {
            qVar2 = this.agC.agA;
            i = this.agC.agq;
            qVar2.dU(i);
        }
    }
}
