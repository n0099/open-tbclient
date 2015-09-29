package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aMg;
    final /* synthetic */ d aMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aMh = dVar;
        this.aMg = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aMh.aMf;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aMg != null && this.aMg.isSuccess()) {
            aVar.aMj = true;
            aVar.aMk = this.aMg;
        } else {
            aVar.aMj = false;
            aVar.aMk = this.aMg;
        }
        cVar2 = this.aMh.aMf;
        bVar = cVar2.aLZ;
        bVar.a(aVar);
    }
}
