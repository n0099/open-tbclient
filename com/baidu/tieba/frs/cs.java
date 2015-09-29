package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Handler.Callback {
    final /* synthetic */ cr aXA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.aXA = crVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.aXA.Mn();
                return false;
            default:
                return false;
        }
    }
}
