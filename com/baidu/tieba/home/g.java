package com.baidu.tieba.home;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        p pVar;
        BdLog.d("OnLoadForumDataCallback, startPullRefresh after load from db");
        eVar = this.a.a;
        pVar = eVar.b;
        pVar.a();
    }
}
