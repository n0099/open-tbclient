package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {
    private com.baidu.tbadk.coreExtra.share.a a;
    private boolean b = true;
    private b c;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.a = aVar;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final void a(b bVar) {
        this.c = bVar;
    }

    public final void a() {
        if (this.b) {
            this.a.a();
            this.c.a();
            return;
        }
        this.a.b();
    }

    public final void b() {
        com.baidu.tbadk.coreExtra.share.a aVar = this.a;
    }

    public final void c() {
        if (this.b) {
            com.baidu.tbadk.coreExtra.share.a aVar = this.a;
        } else {
            com.baidu.tbadk.coreExtra.share.a aVar2 = this.a;
        }
    }
}
