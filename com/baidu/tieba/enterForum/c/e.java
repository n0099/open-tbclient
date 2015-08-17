package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.enterForum.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aMY;
    final /* synthetic */ d aMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aMZ = dVar;
        this.aMY = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c.b bVar;
        cVar = this.aMZ.aMX;
        c.a aVar = new c.a();
        aVar.type = 0;
        if (this.aMY != null && this.aMY.isSuccess()) {
            aVar.aNb = true;
            aVar.aNc = this.aMY;
        } else {
            aVar.aNb = false;
            aVar.aNc = this.aMY;
        }
        cVar2 = this.aMZ.aMX;
        bVar = cVar2.aMR;
        bVar.a(aVar);
    }
}
