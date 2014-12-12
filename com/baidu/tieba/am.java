package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class am implements Handler.Callback {
    final /* synthetic */ al alv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.alv = alVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2:
            case 3:
            default:
                return false;
        }
    }
}
