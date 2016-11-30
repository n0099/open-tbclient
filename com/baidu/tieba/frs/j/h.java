package com.baidu.tieba.frs.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ f cjT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.cjT = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.cjT.cjB == null) {
            return;
        }
        this.cjT.ahn();
        this.cjT.cjO = true;
        f fVar = this.cjT;
        z = this.cjT.cjP;
        fVar.dM(z);
    }
}
