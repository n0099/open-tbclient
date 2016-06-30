package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a cqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.cqR = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cqR.hideTip();
    }
}
