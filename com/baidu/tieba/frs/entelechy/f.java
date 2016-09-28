package com.baidu.tieba.frs.entelechy;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ a bUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bUP = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bUP.add();
    }
}
