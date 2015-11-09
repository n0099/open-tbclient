package com.baidu.tieba.hottopic.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Handler.Callback {
    final /* synthetic */ e bqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bqF = eVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.bqF.Mz();
                return false;
            default:
                return false;
        }
    }
}
