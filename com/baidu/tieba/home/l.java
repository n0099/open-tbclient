package com.baidu.tieba.home;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ f aMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.aMC = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar;
        BdLog.d("First enter , startPullRefresh after loadCache !");
        rVar = this.aMC.aMr;
        rVar.hO();
    }
}
