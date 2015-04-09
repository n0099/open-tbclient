package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private boolean adI = true;
    private b adJ;
    private com.baidu.tbadk.coreExtra.share.a adr;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.adr = aVar;
    }

    public void aE(boolean z) {
        this.adI = z;
    }

    public void a(b bVar) {
        this.adJ = bVar;
    }

    public void wT() {
        if (this.adI) {
            this.adr.wL();
            this.adJ.onSuccess();
            return;
        }
        this.adr.wN();
    }

    public void wU() {
        this.adr.wM();
    }

    public void wV() {
        if (this.adI) {
            this.adr.wO();
        } else {
            this.adr.wO();
        }
    }
}
