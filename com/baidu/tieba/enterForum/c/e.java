package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ com.baidu.tieba.enterForum.b.b aDw;
    final /* synthetic */ d aDx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.enterForum.b.b bVar) {
        this.aDx = dVar;
        this.aDw = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        h hVar;
        cVar = this.aDx.aDv;
        g gVar = new g(cVar);
        gVar.type = 0;
        if (this.aDw != null && this.aDw.isSuccess()) {
            gVar.aDz = true;
            gVar.aDA = this.aDw;
        } else {
            gVar.aDz = false;
            gVar.aDA = this.aDw;
        }
        cVar2 = this.aDx.aDv;
        hVar = cVar2.aDp;
        hVar.a(gVar);
    }
}
