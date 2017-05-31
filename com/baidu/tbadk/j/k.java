package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.j.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j aGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aGd = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j.a aVar;
        j.a aVar2;
        int i;
        aVar = this.aGd.aGb;
        if (aVar != null) {
            aVar2 = this.aGd.aGb;
            i = this.aGd.aFQ;
            aVar2.eY(i);
        }
    }
}
