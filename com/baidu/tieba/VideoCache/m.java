package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.Message;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class m implements Handler.Callback {
    final /* synthetic */ l aVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aVw = lVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        h hVar;
        h hVar2;
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
                hVar = this.aVw.aVu;
                hVar.setVideoUrl((String) message.obj);
                hVar2 = this.aVw.aVu;
                hVar2.run();
            }
        } else if (message.what == 3) {
            bVar4 = this.aVw.aVv;
            if (bVar4 != null) {
                bVar5 = this.aVw.aVv;
                bVar5.KL();
            }
        } else if (message.what == 4) {
            if (message.obj instanceof String) {
                bVar3 = this.aVw.aVv;
                bVar3.gE((String) message.obj);
            }
        } else if (message.what == 5) {
            bVar = this.aVw.aVv;
            if (bVar != null) {
                bVar2 = this.aVw.aVv;
                bVar2.clearCache();
            }
        }
        return true;
    }
}
