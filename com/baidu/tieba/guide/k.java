package com.baidu.tieba.guide;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j aNu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aNu = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aNu.IU();
                return;
            case 1:
                this.aNu.IT();
                return;
            default:
                return;
        }
    }
}
