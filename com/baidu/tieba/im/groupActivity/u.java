package com.baidu.tieba.im.groupActivity;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
/* loaded from: classes.dex */
final class u extends Handler {
    private u() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(byte b) {
        this();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (r.g() != null) {
                    r.g().setVisibility(8);
                    r.a((TextView) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
