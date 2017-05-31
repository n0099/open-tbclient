package com.baidu.tieba.frs.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.frs.d.b;
/* loaded from: classes.dex */
class d extends Handler {
    final /* synthetic */ b cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, Looper looper) {
        super(looper);
        this.cfj = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        b.a aVar;
        switch (message.what) {
            case 5:
                if ((message.obj instanceof b.a) && (aVar = (b.a) message.obj) != null) {
                    aVar.cfl = false;
                    aVar.isRunning = false;
                    aVar.count = 0;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
