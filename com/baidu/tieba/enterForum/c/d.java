package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bND;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bND = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bND.bJc;
        if (dVar != null) {
            dVar2 = this.bND.bJc;
            dVar2.dismiss();
        }
    }
}
