package com.baidu.tieba.guide;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends Handler {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.a.a();
                return;
            case 1:
                this.a.d();
                return;
            default:
                return;
        }
    }
}
