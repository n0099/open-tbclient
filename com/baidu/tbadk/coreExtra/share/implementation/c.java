package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private com.baidu.tbadk.coreExtra.share.a SH;
    private boolean SX = true;
    private b SY;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.SH = aVar;
    }

    public void ax(boolean z) {
        this.SX = z;
    }

    public void a(b bVar) {
        this.SY = bVar;
    }

    public void tj() {
        if (this.SX) {
            this.SH.tc();
            this.SY.onSuccess();
            return;
        }
        this.SH.te();
    }

    public void tk() {
        this.SH.td();
    }

    public void tl() {
        if (this.SX) {
            this.SH.tf();
        } else {
            this.SH.tf();
        }
    }
}
