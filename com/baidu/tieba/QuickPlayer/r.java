package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aLM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aLM = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        t.c cVar;
        t.c cVar2;
        t.b bVar;
        t.b bVar2;
        t.a aVar;
        t.a aVar2;
        t.d dVar;
        t.d dVar2;
        if (message.what == 6) {
            dVar = this.aLM.aLF;
            if (dVar != null) {
                dVar2 = this.aLM.aLF;
                dVar2.onPrepared(this.aLM);
            }
        } else if (message.what == 7) {
            aVar = this.aLM.aLE;
            if (aVar != null) {
                aVar2 = this.aLM.aLE;
                aVar2.onCompletion(this.aLM);
            }
        } else if (message.what == 8) {
            bVar = this.aLM.aLG;
            if (bVar != null) {
                bVar2 = this.aLM.aLG;
                if (bVar2.onError(this.aLM, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aLM.aLH;
            if (cVar != null) {
                cVar2 = this.aLM.aLH;
                cVar2.a(this.aLM, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
