package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.f1572a = bmVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.f1572a.Q;
                handler.removeMessages(1);
                this.f1572a.l();
                this.f1572a.j();
                return;
            default:
                return;
        }
    }
}
