package com.baidu.tieba.download;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends Handler {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0) {
            aVar = c.b;
            if (aVar != null) {
                aVar2 = c.b;
                aVar2.a(message.arg1);
                aVar3 = c.b;
                aVar3.b(message.arg2);
                f.e("download_file:" + message.arg1 + "/" + message.arg2);
                aVar4 = c.b;
                if (aVar4.m() != null) {
                    aVar5 = c.b;
                    b m = aVar5.m();
                    aVar6 = c.b;
                    m.a(aVar6);
                }
            }
        }
    }
}
