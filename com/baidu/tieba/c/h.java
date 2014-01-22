package com.baidu.tieba.c;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0) {
            aVar = g.b;
            if (aVar != null) {
                aVar2 = g.b;
                aVar2.a(message.arg1);
                aVar3 = g.b;
                aVar3.b(message.arg2);
                com.baidu.adp.lib.g.e.d("download_file:" + message.arg1 + "/" + message.arg2);
                aVar4 = g.b;
                if (aVar4.m() != null) {
                    aVar5 = g.b;
                    f m = aVar5.m();
                    aVar6 = g.b;
                    m.b(aVar6);
                }
            }
        }
    }
}
