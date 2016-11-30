package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.Message;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Handler.Callback {
    final /* synthetic */ n aQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aQG = nVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        i iVar;
        i iVar2;
        if (message.what == 1) {
            if (message.obj instanceof InputStream) {
                try {
                    ((InputStream) message.obj).close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (message.what == 2) {
            if (message.obj instanceof String) {
                iVar = this.aQG.aQE;
                iVar.setVideoUrl((String) message.obj);
                iVar2 = this.aQG.aQE;
                iVar2.run();
            }
        } else if (message.what == 3) {
            cVar4 = this.aQG.aQF;
            if (cVar4 != null) {
                cVar5 = this.aQG.aQF;
                cVar5.KK();
            }
        } else if (message.what == 4) {
            if (message.obj instanceof String) {
                cVar3 = this.aQG.aQF;
                cVar3.gR((String) message.obj);
            }
        } else if (message.what == 5) {
            cVar = this.aQG.aQF;
            if (cVar != null) {
                cVar2 = this.aQG.aQF;
                cVar2.clearCache();
            }
        }
        return true;
    }
}
