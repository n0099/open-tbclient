package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ ab cFt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.cFt = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        z zVar;
        zVar = this.cFt.cFs;
        zVar.alb();
    }
}
