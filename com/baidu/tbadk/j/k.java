package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.j.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j aHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aHr = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j.a aVar;
        j.a aVar2;
        int i;
        aVar = this.aHr.aHp;
        if (aVar != null) {
            aVar2 = this.aHr.aHp;
            i = this.aHr.aHe;
            aVar2.fa(i);
        }
    }
}
