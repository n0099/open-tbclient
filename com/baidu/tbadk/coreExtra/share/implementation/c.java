package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private com.baidu.tbadk.coreExtra.share.a MY;
    private boolean Nl = true;
    private b Nm;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.MY = aVar;
    }

    public void aj(boolean z) {
        this.Nl = z;
    }

    public void a(b bVar) {
        this.Nm = bVar;
    }

    public void pQ() {
        if (this.Nl) {
            this.MY.pI();
            this.Nm.onSuccess();
            return;
        }
        this.MY.pK();
    }

    public void pR() {
        this.MY.pJ();
    }

    public void pS() {
        if (this.Nl) {
            this.MY.pL();
        } else {
            this.MY.pL();
        }
    }
}
