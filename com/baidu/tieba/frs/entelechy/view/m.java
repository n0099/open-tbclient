package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bXh = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bXh.Oa();
        this.bXh.e(true, 4);
    }
}
