package com.baidu.tieba.frs.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ i bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bVC = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.bVC.bVi == null) {
            return;
        }
        this.bVC.acQ();
        this.bVC.bVu = true;
        i iVar = this.bVC;
        z = this.bVC.bVv;
        iVar.dB(z);
    }
}
