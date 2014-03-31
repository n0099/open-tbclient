package com.baidu.tieba.im.groupActivity;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
/* loaded from: classes.dex */
final class v extends Handler {
    private v() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(byte b) {
        this();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (s.g() != null) {
                    s.g().setVisibility(8);
                    s.a((TextView) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
