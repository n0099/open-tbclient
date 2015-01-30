package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private boolean TB = true;
    private b TC;
    private com.baidu.tbadk.coreExtra.share.a To;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.To = aVar;
    }

    public void az(boolean z) {
        this.TB = z;
    }

    public void a(b bVar) {
        this.TC = bVar;
    }

    public void tA() {
        if (this.TB) {
            this.To.tt();
            this.TC.onSuccess();
            return;
        }
        this.To.tv();
    }

    public void tB() {
        this.To.tu();
    }

    public void tC() {
        if (this.TB) {
            this.To.tw();
        } else {
            this.To.tw();
        }
    }
}
