package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private com.baidu.tbadk.coreExtra.share.a MU;
    private boolean Nh = true;
    private b Ni;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.MU = aVar;
    }

    public void aj(boolean z) {
        this.Nh = z;
    }

    public void a(b bVar) {
        this.Ni = bVar;
    }

    public void pO() {
        if (this.Nh) {
            this.MU.pG();
            this.Ni.onSuccess();
            return;
        }
        this.MU.pI();
    }

    public void pP() {
        this.MU.pH();
    }

    public void pQ() {
        if (this.Nh) {
            this.MU.pJ();
        } else {
            this.MU.pJ();
        }
    }
}
