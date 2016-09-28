package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Handler.Callback {
    final /* synthetic */ j aLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aLC = jVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        e.c cVar;
        e.c cVar2;
        e.b bVar;
        e.b bVar2;
        e.a aVar;
        e.a aVar2;
        e.d dVar;
        e.d dVar2;
        if (message.what == 6) {
            dVar = this.aLC.aLr;
            if (dVar != null) {
                dVar2 = this.aLC.aLr;
                dVar2.onPrepared(this.aLC);
            }
        } else if (message.what == 7) {
            aVar = this.aLC.aLq;
            if (aVar != null) {
                aVar2 = this.aLC.aLq;
                aVar2.onCompletion(this.aLC);
            }
        } else if (message.what == 8) {
            bVar = this.aLC.aLs;
            if (bVar != null) {
                bVar2 = this.aLC.aLs;
                if (bVar2.onError(this.aLC, message.arg1, message.arg2)) {
                }
            }
        } else if (message.what == 9) {
            cVar = this.aLC.aLt;
            if (cVar != null) {
                cVar2 = this.aLC.aLt;
                cVar2.a(this.aLC, message.arg1, message.arg2);
            }
        }
        return true;
    }
}
