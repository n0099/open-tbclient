package com.baidu.tieba.card;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends Handler {
    final /* synthetic */ z aUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(z zVar, Looper looper) {
        super(looper);
        this.aUu = zVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 202:
                this.aUu.KU();
                return;
            case 203:
                this.aUu.KV();
                return;
            default:
                return;
        }
    }
}
