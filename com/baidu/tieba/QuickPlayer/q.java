package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Handler.Callback {
    final /* synthetic */ p aMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aMv = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        if (message.what == 1) {
            if (message.obj instanceof e) {
                this.aMv.a((e) message.obj);
            }
        } else if (message.what == 2) {
            p pVar = this.aMv;
            bVar3 = this.aMv.aMm;
            pVar.a(bVar3);
            this.aMv.aMm = null;
        } else if (message.what == 3) {
            p pVar2 = this.aMv;
            bVar2 = this.aMv.aMm;
            pVar2.b(bVar2);
        } else if (message.what == 4) {
            p pVar3 = this.aMv;
            bVar = this.aMv.aMm;
            pVar3.c(bVar);
        } else if (message.what == 5) {
            this.aMv.fH(message.arg1);
        }
        return true;
    }
}
