package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        r rVar;
        r rVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            rVar = this.a.o;
            if (rVar != null) {
                rVar2 = this.a.o;
                rVar2.d();
            }
        }
    }
}
