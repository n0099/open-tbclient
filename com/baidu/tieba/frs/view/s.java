package com.baidu.tieba.frs.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        u uVar;
        u uVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            uVar = this.a.o;
            if (uVar != null) {
                uVar2 = this.a.o;
                uVar2.c();
            }
        }
    }
}
