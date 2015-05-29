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

    public void xF() {
        if (this.aeM) {
            this.aex.xy();
            this.aeN.onSuccess();
            return;
        }
        this.aex.xA();
    }

    public void xG() {
        this.aex.xz();
    }

    public void xH() {
        if (this.aeM) {
            this.aex.xB();
        } else {
            this.aex.xB();
        }
    }
}
