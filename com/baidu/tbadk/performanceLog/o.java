package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n age;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.age = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        q qVar;
        q qVar2;
        int i;
        qVar = this.age.agc;
        if (qVar != null) {
            qVar2 = this.age.agc;
            i = this.age.afS;
            qVar2.dO(i);
        }
    }
}
