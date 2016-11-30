package com.baidu.tieba.card;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends Handler {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, Looper looper) {
        super(looper);
        this.bde = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 202:
                this.bde.Kw();
                return;
            case 203:
                this.bde.Kx();
                return;
            default:
                return;
        }
    }
}
