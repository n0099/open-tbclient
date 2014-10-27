package com.baidu.tieba.im.groupActivity;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class u extends Handler {
    private u() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(u uVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (s.Kk() != null) {
                    s.Kk().setVisibility(8);
                    s.g(null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
