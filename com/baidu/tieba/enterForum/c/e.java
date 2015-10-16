package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aMr;
    final /* synthetic */ d aMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aMs = dVar;
        this.aMr = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aMs.aMq;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aMr != null && this.aMr.isSuccess()) {
            aVar.aMu = true;
            aVar.aMv = this.aMr;
        } else {
            aVar.aMu = false;
            aVar.aMv = this.aMr;
        }
        cVar2 = this.aMs.aMq;
        bVar = cVar2.aMk;
        bVar.a(aVar);
    }
}
