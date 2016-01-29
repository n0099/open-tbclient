package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aXl;
    final /* synthetic */ d aXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aXm = dVar;
        this.aXl = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aXm.aXk;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aXl != null && this.aXl.isSuccess()) {
            aVar.aXo = true;
            aVar.aXp = this.aXl;
        } else {
            aVar.aXo = false;
            aVar.aXp = this.aXl;
        }
        cVar2 = this.aXm.aXk;
        bVar = cVar2.aXe;
        bVar.a(aVar);
    }
}
