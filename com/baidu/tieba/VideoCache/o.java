package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Handler.Callback {
    final /* synthetic */ n aNr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aNr = nVar;
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
                iVar = this.aNr.aNo;
                iVar.setVideoUrl((String) message.obj);
                iVar2 = this.aNr.aNo;
                iVar2.run();
            }
        } else if (message.what == 3) {
            cVar4 = this.aNr.aNp;
            if (cVar4 != null) {
                cVar5 = this.aNr.aNp;
                cVar5.Ju();
            }
        } else if (message.what == 4) {
            if (message.obj instanceof String) {
                cVar3 = this.aNr.aNp;
                cVar3.gJ((String) message.obj);
            }
        } else if (message.what == 5) {
            cVar = this.aNr.aNp;
            if (cVar != null) {
                cVar2 = this.aNr.aNp;
                cVar2.clearCache();
            }
        }
        return true;
    }
}
