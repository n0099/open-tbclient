package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Handler.Callback {
    final /* synthetic */ n aOA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aOA = nVar;
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (message.what == 2) {
            if (message.obj instanceof String) {
                iVar = this.aOA.aOy;
                iVar.setVideoUrl((String) message.obj);
                iVar2 = this.aOA.aOy;
                iVar2.run();
            }
        } else if (message.what == 3) {
            cVar4 = this.aOA.aOz;
            if (cVar4 != null) {
                cVar5 = this.aOA.aOz;
                cVar5.Kg();
            }
        } else if (message.what == 4) {
            if (message.obj instanceof String) {
                cVar3 = this.aOA.aOz;
                cVar3.gQ((String) message.obj);
            }
        } else if (message.what == 5) {
            cVar = this.aOA.aOz;
            if (cVar != null) {
                cVar2 = this.aOA.aOz;
                cVar2.clearCache();
            }
        }
        return true;
    }
}
