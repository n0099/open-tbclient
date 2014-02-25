package com.baidu.tieba.im.net;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    private WeakReference<h> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.a = new WeakReference<>(hVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        h hVar;
        super.handleMessage(message);
        if (message.what != 0 || (hVar = this.a.get()) == null) {
            return;
        }
        hVar.c();
    }
}
