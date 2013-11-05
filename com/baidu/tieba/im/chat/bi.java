package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar) {
        this.f1436a = bhVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.f1436a.Q;
                handler.removeMessages(1);
                this.f1436a.l();
                this.f1436a.j();
                return;
            default:
                return;
        }
    }
}
