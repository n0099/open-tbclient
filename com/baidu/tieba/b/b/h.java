package com.baidu.tieba.b.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g aYO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aYO = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.aYO.aYN;
                if (aVar3 != null) {
                    aVar4 = this.aYO.aYN;
                    aVar4.cr(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.aYO.aYN;
                if (aVar != null) {
                    aVar2 = this.aYO.aYN;
                    aVar2.cr(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
