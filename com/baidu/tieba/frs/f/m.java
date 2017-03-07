package com.baidu.tieba.frs.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ i ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.ccU = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.ccU.ccA == null) {
            return;
        }
        this.ccU.adQ();
        this.ccU.ccM = true;
        i iVar = this.ccU;
        z = this.ccU.ccN;
        iVar.dB(z);
    }
}
