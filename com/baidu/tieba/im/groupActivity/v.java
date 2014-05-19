package com.baidu.tieba.im.groupActivity;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
/* loaded from: classes.dex */
class v extends Handler {
    private v() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(v vVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (s.e() != null) {
                    s.e().setVisibility(8);
                    s.a((TextView) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
