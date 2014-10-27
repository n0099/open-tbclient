package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ g YL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.YL = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar;
        j jVar2;
        int i;
        jVar = this.YL.YJ;
        if (jVar != null) {
            jVar2 = this.YL.YJ;
            i = this.YL.YB;
            jVar2.r(i);
        }
    }
}
