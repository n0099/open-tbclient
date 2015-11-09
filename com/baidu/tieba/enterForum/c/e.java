package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d aMA;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aMA = dVar;
        this.aMz = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aMA.aMy;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aMz != null && this.aMz.isSuccess()) {
            aVar.aMC = true;
            aVar.aMD = this.aMz;
        } else {
            aVar.aMC = false;
            aVar.aMD = this.aMz;
        }
        cVar2 = this.aMA.aMy;
        bVar = cVar2.aMs;
        bVar.a(aVar);
    }
}
