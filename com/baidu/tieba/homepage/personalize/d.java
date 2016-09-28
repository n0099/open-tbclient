package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cFt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cFt = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.cFt.cFs;
        aVar.alp();
    }
}
