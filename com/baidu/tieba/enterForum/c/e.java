package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aRi;
    final /* synthetic */ d aRj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aRj = dVar;
        this.aRi = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aRj.aRh;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aRi != null && this.aRi.isSuccess()) {
            aVar.aRl = true;
            aVar.aRm = this.aRi;
        } else {
            aVar.aRl = false;
            aVar.aRm = this.aRi;
        }
        cVar2 = this.aRj.aRh;
        bVar = cVar2.aRb;
        bVar.a(aVar);
    }
}
