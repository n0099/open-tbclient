package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aFy;
    final /* synthetic */ d aFz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aFz = dVar;
        this.aFy = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        h hVar;
        cVar = this.aFz.aFx;
        g gVar = new g(cVar);
        gVar.type = 0;
        if (this.aFy != null && this.aFy.isSuccess()) {
            gVar.aFB = true;
            gVar.aFC = this.aFy;
        } else {
            gVar.aFB = false;
            gVar.aFC = this.aFy;
        }
        cVar2 = this.aFz.aFx;
        hVar = cVar2.aFr;
        hVar.a(gVar);
    }
}
