package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b bbU;
    final /* synthetic */ d bbV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.bbV = dVar;
        this.bbU = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.bbV.bbT;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.bbU != null && this.bbU.isSuccess()) {
            aVar.bbX = true;
            aVar.bbY = this.bbU;
        } else {
            aVar.bbX = false;
            aVar.bbY = this.bbU;
        }
        cVar2 = this.bbV.bbT;
        bVar = cVar2.bbN;
        bVar.a(aVar);
    }
}
