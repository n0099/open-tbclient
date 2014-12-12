package com.baidu.tieba.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aMO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aMO = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.aMO.count = 0;
            this.aMO.aMK = 0L;
            this.aMO.aML = 0L;
        } else if (message.what == 1) {
            i = this.aMO.count;
            if (i == 1) {
                cVar = this.aMO.aMM;
                if (cVar != null) {
                    cVar2 = this.aMO.aMM;
                    cVar2.GR();
                }
                this.aMO.count = 0;
                this.aMO.aMK = 0L;
                this.aMO.aML = 0L;
            }
        }
    }
}
