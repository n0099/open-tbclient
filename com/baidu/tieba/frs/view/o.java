package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        q qVar;
        q qVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            qVar = this.a.o;
            if (qVar != null) {
                qVar2 = this.a.o;
                qVar2.d();
            }
        }
    }
}
