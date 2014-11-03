package com.baidu.tieba.guide;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j aLB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aLB = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aLB.ID();
                return;
            case 1:
                this.aLB.IC();
                return;
            default:
                return;
        }
    }
}
