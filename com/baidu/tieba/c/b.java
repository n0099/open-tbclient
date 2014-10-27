package com.baidu.tieba.c;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aKI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aKI = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.aKI.count = 0;
            this.aKI.aKE = 0L;
            this.aKI.aKF = 0L;
        } else if (message.what == 1) {
            i = this.aKI.count;
            if (i == 1) {
                cVar = this.aKI.aKG;
                if (cVar != null) {
                    cVar2 = this.aKI.aKG;
                    cVar2.GJ();
                }
                this.aKI.count = 0;
                this.aKI.aKE = 0L;
                this.aKI.aKF = 0L;
            }
        }
    }
}
