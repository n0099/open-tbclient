package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bHP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bHP = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bHP.bDm;
        if (dVar != null) {
            dVar2 = this.bHP.bDm;
            dVar2.dismiss();
        }
    }
}
