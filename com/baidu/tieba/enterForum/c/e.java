package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d aFA;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aFz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aFA = dVar;
        this.aFz = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        h hVar;
        cVar = this.aFA.aFy;
        g gVar = new g(cVar);
        gVar.type = 0;
        if (this.aFz != null && this.aFz.isSuccess()) {
            gVar.aFC = true;
            gVar.aFD = this.aFz;
        } else {
            gVar.aFC = false;
            gVar.aFD = this.aFz;
        }
        cVar2 = this.aFA.aFy;
        hVar = cVar2.aFs;
        hVar.a(gVar);
    }
}
