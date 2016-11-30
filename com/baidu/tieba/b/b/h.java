package com.baidu.tieba.b.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.b.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ g baa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.baa = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.baa.aZZ;
                if (aVar3 != null) {
                    aVar4 = this.baa.aZZ;
                    aVar4.cs(true);
                    return true;
                }
                return true;
            case 2:
                aVar = this.baa.aZZ;
                if (aVar != null) {
                    aVar2 = this.baa.aZZ;
                    aVar2.cs(false);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }
}
