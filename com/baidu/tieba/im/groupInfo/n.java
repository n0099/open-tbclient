package com.baidu.tieba.im.groupInfo;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends Handler {
    int a = 0;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.b = mVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        if (message.what == 0) {
            if (this.a == 0) {
                m.a(this.b);
                m mVar = this.b;
                com.baidu.tieba.sharedPref.b.a().b("has_shown_activity_guide_toast", true);
            } else if (this.a >= 3) {
                this.b.z();
                handler = this.b.ai;
                handler.removeMessages(0);
                return;
            }
            this.a++;
            handler2 = this.b.ai;
            handler2.sendEmptyMessageDelayed(0, 1000L);
        }
    }
}
