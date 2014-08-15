package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        z zVar;
        z zVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            zVar = this.a.o;
            if (zVar != null) {
                zVar2 = this.a.o;
                zVar2.d();
            }
        }
    }
}
