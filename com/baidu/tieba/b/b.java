package com.baidu.tieba.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aNW = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.aNW.count = 0;
            this.aNW.aNS = 0L;
            this.aNW.aNT = 0L;
        } else if (message.what == 1) {
            i = this.aNW.count;
            if (i == 1) {
                cVar = this.aNW.aNU;
                if (cVar != null) {
                    cVar2 = this.aNW.aNU;
                    cVar2.Hi();
                }
                this.aNW.count = 0;
                this.aNW.aNS = 0L;
                this.aNW.aNT = 0L;
            }
        }
    }
}
