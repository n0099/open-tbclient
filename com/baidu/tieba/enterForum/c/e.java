package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aNl;
    final /* synthetic */ d aNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aNm = dVar;
        this.aNl = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aNm.aNk;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aNl != null && this.aNl.isSuccess()) {
            aVar.aNo = true;
            aVar.aNp = this.aNl;
        } else {
            aVar.aNo = false;
            aVar.aNp = this.aNl;
        }
        cVar2 = this.aNm.aNk;
        bVar = cVar2.aNe;
        bVar.a(aVar);
    }
}
