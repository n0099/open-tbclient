package com.baidu.tbadk.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aEc = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aEa != null) {
            a.aEa.setLength(message.arg1);
            a.aEa.setSize(message.arg2);
            if (a.aEa.getCallback() != null) {
                a.aEa.getCallback().e(a.aEa);
            }
        }
    }
}
