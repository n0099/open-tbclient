package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aDo;
    final /* synthetic */ d aDp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aDp = dVar;
        this.aDo = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        h hVar;
        cVar = this.aDp.aDn;
        g gVar = new g(cVar);
        gVar.type = 0;
        if (this.aDo != null && this.aDo.isSuccess()) {
            gVar.aDr = true;
            gVar.aDs = this.aDo;
        } else {
            gVar.aDr = false;
            gVar.aDs = this.aDo;
        }
        cVar2 = this.aDp.aDn;
        hVar = cVar2.aDh;
        hVar.a(gVar);
    }
}
