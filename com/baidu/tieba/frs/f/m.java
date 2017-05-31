package com.baidu.tieba.frs.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ i chJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.chJ = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.chJ.chq == null) {
            return;
        }
        this.chJ.adR();
        this.chJ.chB = true;
        i iVar = this.chJ;
        z = this.chJ.chC;
        iVar.ec(z);
    }
}
