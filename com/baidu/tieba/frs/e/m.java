package com.baidu.tieba.frs.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.cbx = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.cbx.cbf == null) {
            return;
        }
        this.cbx.acO();
        this.cbx.cbp = true;
        i iVar = this.cbx;
        z = this.cbx.cbq;
        iVar.dM(z);
    }
}
