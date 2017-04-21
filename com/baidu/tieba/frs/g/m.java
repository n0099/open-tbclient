package com.baidu.tieba.frs.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ i cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.cdM = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.cdM.cds == null) {
            return;
        }
        this.cdM.aeM();
        this.cdM.cdE = true;
        i iVar = this.cdM;
        z = this.cdM.cdF;
        iVar.dN(z);
    }
}
