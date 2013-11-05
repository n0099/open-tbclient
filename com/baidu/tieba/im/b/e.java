package com.baidu.tieba.im.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f1382a = dVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Handler handler;
        switch (message.what) {
            case 1:
                handler = this.f1382a.j;
                handler.removeMessages(1);
                if (this.f1382a.f1381a != null) {
                    this.f1382a.f1381a.a();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
