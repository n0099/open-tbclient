package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Handler.Callback {
    final /* synthetic */ p aQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aQP = pVar;
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
            dVar = this.aQP.aQI;
            if (dVar != null) {
                dVar2 = this.aQP.aQI;
                dVar2.onPrepared(this.aQP);
            }
        } else if (message.what == 7) {
            aVar = this.aQP.aQH;
            if (aVar != null) {
                aVar2 = this.aQP.aQH;
                aVar2.onCompletion(this.aQP);
            }
        } else if (message.what == 8) {
            bVar = this.aQP.aQJ;
            if (bVar != null) {
                bVar2 = this.aQP.aQJ;
                if (bVar2.onError(this.aQP, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aQP.aQK;
            if (cVar != null) {
                cVar2 = this.aQP.aQK;
                cVar2.a(this.aQP, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
