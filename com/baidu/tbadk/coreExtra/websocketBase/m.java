package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends Handler {
    private final WeakReference<j> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.a = new WeakReference<>(jVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar;
        super.handleMessage(message);
        if (message.what != 0 || (jVar = this.a.get()) == null) {
            return;
        }
        jVar.c();
    }
}
