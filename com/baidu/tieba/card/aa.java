package com.baidu.tieba.card;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends Handler {
    final /* synthetic */ z aTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(z zVar, Looper looper) {
        super(looper);
        this.aTy = zVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 202:
                this.aTy.KV();
                return;
            case 203:
                this.aTy.KW();
                return;
            default:
                return;
        }
    }
}
