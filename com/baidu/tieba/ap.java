package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class ap implements Handler.Callback {
    final /* synthetic */ ao amm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.amm = aoVar;
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
