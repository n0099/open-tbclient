package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private boolean adA = true;
    private b adB;
    private com.baidu.tbadk.coreExtra.share.a adj;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.adj = aVar;
    }

    public void aE(boolean z) {
        this.adA = z;
    }

    public void a(b bVar) {
        this.adB = bVar;
    }

    public void wN() {
        if (this.adA) {
            this.adj.wF();
            this.adB.onSuccess();
            return;
        }
        this.adj.wH();
    }

    public void wO() {
        this.adj.wG();
    }

    public void wP() {
        if (this.adA) {
            this.adj.wI();
        } else {
            this.adj.wI();
        }
    }
}
