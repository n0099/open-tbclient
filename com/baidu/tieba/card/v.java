package com.baidu.tieba.card;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends Handler {
    final /* synthetic */ u bvn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, Looper looper) {
        super(looper);
        this.bvn = uVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 202:
                this.bvn.Kx();
                return;
            case 203:
                this.bvn.Ky();
                return;
            default:
                return;
        }
    }
}
