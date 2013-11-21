package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1519a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.f1519a = bgVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.f1519a.R;
                handler.removeMessages(1);
                this.f1519a.l();
                this.f1519a.j();
                return;
            default:
                return;
        }
    }
}
