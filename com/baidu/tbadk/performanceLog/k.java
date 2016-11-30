package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j aCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aCq = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j.a aVar;
        j.a aVar2;
        int i;
        aVar = this.aCq.aCo;
        if (aVar != null) {
            aVar2 = this.aCq.aCo;
            i = this.aCq.aCd;
            aVar2.fd(i);
        }
    }
}
