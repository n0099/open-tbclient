package com.baidu.tieba.card;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, Looper looper) {
        super(looper);
        this.bBb = yVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 202:
                this.bBb.Ul();
                return;
            case 203:
                this.bBb.Um();
                return;
            default:
                return;
        }
    }
}
