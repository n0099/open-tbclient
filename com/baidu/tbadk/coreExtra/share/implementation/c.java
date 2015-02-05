package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private com.baidu.tbadk.coreExtra.share.a Tl;
    private boolean Ty = true;
    private b Tz;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.Tl = aVar;
    }

    public void az(boolean z) {
        this.Ty = z;
    }

    public void a(b bVar) {
        this.Tz = bVar;
    }

    public void tu() {
        if (this.Ty) {
            this.Tl.tn();
            this.Tz.onSuccess();
            return;
        }
        this.Tl.tp();
    }

    public void tv() {
        this.Tl.to();
    }

    public void tw() {
        if (this.Ty) {
            this.Tl.tq();
        } else {
            this.Tl.tq();
        }
    }
}
