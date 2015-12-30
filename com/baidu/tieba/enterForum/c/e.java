package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aUZ;
    final /* synthetic */ d aVa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aVa = dVar;
        this.aUZ = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aVa.aUY;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aUZ != null && this.aUZ.isSuccess()) {
            aVar.aVc = true;
            aVar.aVd = this.aUZ;
        } else {
            aVar.aVc = false;
            aVar.aVd = this.aUZ;
        }
        cVar2 = this.aVa.aUY;
        bVar = cVar2.aUS;
        bVar.a(aVar);
    }
}
