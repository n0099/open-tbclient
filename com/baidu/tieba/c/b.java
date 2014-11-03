package com.baidu.tieba.c;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aKW = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.aKW.count = 0;
            this.aKW.aKS = 0L;
            this.aKW.aKT = 0L;
        } else if (message.what == 1) {
            i = this.aKW.count;
            if (i == 1) {
                cVar = this.aKW.aKU;
                if (cVar != null) {
                    cVar2 = this.aKW.aKU;
                    cVar2.GL();
                }
                this.aKW.count = 0;
                this.aKW.aKS = 0L;
                this.aKW.aKT = 0L;
            }
        }
    }
}
