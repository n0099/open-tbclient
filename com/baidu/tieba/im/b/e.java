package com.baidu.tieba.im.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f1469a = dVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Handler handler;
        switch (message.what) {
            case 1:
                handler = this.f1469a.l;
                handler.removeMessages(1);
                if (this.f1469a.f1468a != null) {
                    this.f1469a.f1468a.a();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
