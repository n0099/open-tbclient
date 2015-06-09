package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private boolean aeM = true;
    private b aeN;
    private com.baidu.tbadk.coreExtra.share.a aex;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.aex = aVar;
    }

    public void aL(boolean z) {
        this.aeM = z;
    }

    public void a(b bVar) {
        this.aeN = bVar;
    }

    public void xG() {
        if (this.aeM) {
            this.aex.xz();
            this.aeN.onSuccess();
            return;
        }
        this.aex.xB();
    }

    public void xH() {
        this.aex.xA();
    }

    public void xI() {
        if (this.aeM) {
            this.aex.xC();
        } else {
            this.aex.xC();
        }
    }
}
