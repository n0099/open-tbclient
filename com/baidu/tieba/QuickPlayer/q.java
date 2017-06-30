package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Handler.Callback {
    final /* synthetic */ p aSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aSE = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        if (message.what == 1) {
            if (message.obj instanceof e) {
                this.aSE.a((e) message.obj);
            }
        } else if (message.what == 2) {
            p pVar = this.aSE;
            bVar3 = this.aSE.aSv;
            pVar.a(bVar3);
            this.aSE.aSv = null;
        } else if (message.what == 3) {
            p pVar2 = this.aSE;
            bVar2 = this.aSE.aSv;
            pVar2.b(bVar2);
        } else if (message.what == 4) {
            p pVar3 = this.aSE;
            bVar = this.aSE.aSv;
            pVar3.c(bVar);
        } else if (message.what != 5) {
            if (message.what == 10) {
                if (message.obj instanceof e) {
                    this.aSE.a((e) message.obj, message.arg1);
                }
            } else if (message.what == 7) {
                this.aSE.JO();
            }
        } else {
            this.aSE.fH(message.arg1);
        }
        return true;
    }
}
