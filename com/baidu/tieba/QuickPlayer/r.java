package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aKO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aKO = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        v.c cVar;
        v.c cVar2;
        v.b bVar;
        v.b bVar2;
        v.a aVar;
        v.a aVar2;
        v.d dVar;
        v.d dVar2;
        if (message.what == 6) {
            dVar = this.aKO.aKH;
            if (dVar != null) {
                dVar2 = this.aKO.aKH;
                dVar2.onPrepared(this.aKO);
            }
        } else if (message.what == 7) {
            aVar = this.aKO.aKG;
            if (aVar != null) {
                aVar2 = this.aKO.aKG;
                aVar2.onCompletion(this.aKO);
            }
        } else if (message.what == 8) {
            bVar = this.aKO.aKI;
            if (bVar != null) {
                bVar2 = this.aKO.aKI;
                if (bVar2.onError(this.aKO, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aKO.aKJ;
            if (cVar != null) {
                cVar2 = this.aKO.aKJ;
                cVar2.a(this.aKO, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
