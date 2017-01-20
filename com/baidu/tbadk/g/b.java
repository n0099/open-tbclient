package com.baidu.tbadk.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aCo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aCo = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aCm != null) {
            a.aCm.setLength(message.arg1);
            a.aCm.setSize(message.arg2);
            if (a.aCm.getCallback() != null) {
                a.aCm.getCallback().e(a.aCm);
            }
        }
    }
}
