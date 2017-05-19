package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f cuD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.cuD = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        bVar = this.cuD.cuC;
        bVar.agF();
    }
}
