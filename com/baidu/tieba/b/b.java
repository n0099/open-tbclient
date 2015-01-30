package com.baidu.tieba.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aNX = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.aNX.count = 0;
            this.aNX.aNT = 0L;
            this.aNX.aNU = 0L;
        } else if (message.what == 1) {
            i = this.aNX.count;
            if (i == 1) {
                cVar = this.aNX.aNV;
                if (cVar != null) {
                    cVar2 = this.aNX.aNV;
                    cVar2.Ho();
                }
                this.aNX.count = 0;
                this.aNX.aNT = 0L;
                this.aNX.aNU = 0L;
            }
        }
    }
}
