package com.baidu.tieba.im.db;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                ImDbShrinkStatic.a(ImDbShrinkStatic.MA()).removeMessages(1);
                ImDbShrinkStatic.b(ImDbShrinkStatic.MA());
                return;
            default:
                return;
        }
    }
}
