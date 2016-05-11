package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aYd;
    final /* synthetic */ d aYe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aYe = dVar;
        this.aYd = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aYe.aYc;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aYd != null && this.aYd.isSuccess()) {
            aVar.aYg = true;
            aVar.aYh = this.aYd;
        } else {
            aVar.aYg = false;
            aVar.aYh = this.aYd;
        }
        cVar2 = this.aYe.aYc;
        bVar = cVar2.aXW;
        bVar.a(aVar);
    }
}
