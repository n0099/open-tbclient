package com.baidu.tieba.b.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g boW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.boW = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.boW.boV;
                if (aVar3 != null) {
                    aVar4 = this.boW.boV;
                    aVar4.cD(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.boW.boV;
                if (aVar != null) {
                    aVar2 = this.boW.boV;
                    aVar2.cD(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
