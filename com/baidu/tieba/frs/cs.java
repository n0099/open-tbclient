package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Handler.Callback {
    final /* synthetic */ cr aXU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.aXU = crVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.aXU.Mz();
                return false;
            default:
                return false;
        }
    }
}
