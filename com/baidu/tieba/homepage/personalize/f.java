package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e cyB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cyB = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.cyB.cyA;
        aVar.aic();
    }
}
