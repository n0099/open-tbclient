package com.baidu.tieba.guide;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends Handler {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.a.a();
                return;
            case 1:
                l.a(this.a);
                return;
            default:
                return;
        }
    }
}
