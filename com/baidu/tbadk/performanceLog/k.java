package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.performanceLog.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j axb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.axb = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j.a aVar;
        j.a aVar2;
        int i;
        aVar = this.axb.awZ;
        if (aVar != null) {
            aVar2 = this.axb.awZ;
            i = this.axb.awP;
            aVar2.ew(i);
        }
    }
}
