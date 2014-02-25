package com.baidu.tieba.im.groupActivity;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
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
                if (r.h() != null) {
                    r.h().setVisibility(8);
                    r.a((TextView) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
