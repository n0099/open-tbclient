package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n aqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aqh = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        q qVar;
        q qVar2;
        int i;
        qVar = this.aqh.aqf;
        if (qVar != null) {
            qVar2 = this.aqh.aqf;
            i = this.aqh.apV;
            qVar2.ei(i);
        }
    }
}
