package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends Handler {
    private final WeakReference<i> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.a = new WeakReference<>(iVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        i iVar;
        super.handleMessage(message);
        if (message.what == 0 && (iVar = this.a.get()) != null) {
            i.a(iVar);
        }
    }
}
