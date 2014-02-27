package com.baidu.tieba.im.net;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends Handler {
    private final WeakReference<h> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.a = new WeakReference<>(hVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        h hVar;
        super.handleMessage(message);
        if (message.what == 0 && (hVar = this.a.get()) != null) {
            h.a(hVar);
        }
    }
}
