package com.baidu.tieba.barcode;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewfinderView f1160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ViewfinderView viewfinderView) {
        this.f1160a = viewfinderView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.f1160a.invalidate();
                handler = this.f1160a.r;
                handler.removeMessages(1);
                handler2 = this.f1160a.r;
                handler3 = this.f1160a.r;
                handler2.sendMessageDelayed(handler3.obtainMessage(1), 100L);
                return;
            default:
                return;
        }
    }
}
