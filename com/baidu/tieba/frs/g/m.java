package com.baidu.tieba.frs.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ i cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.cbv = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.cbv.cbb == null) {
            return;
        }
        this.cbv.adL();
        this.cbv.cbn = true;
        i iVar = this.cbv;
        z = this.cbv.cbo;
        iVar.dD(z);
    }
}
