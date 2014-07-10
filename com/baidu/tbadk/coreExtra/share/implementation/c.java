package com.baidu.tbadk.coreExtra.share.implementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private com.baidu.tbadk.coreExtra.share.a a;
    private boolean b = true;
    private b c;

    public c(com.baidu.tbadk.coreExtra.share.a aVar) {
        this.a = aVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void a() {
        if (this.b) {
            this.a.a();
            this.c.a();
            return;
        }
        this.a.c();
    }

    public void b() {
        this.a.b();
    }

    public void c() {
        if (this.b) {
            this.a.d();
        } else {
            this.a.d();
        }
    }
}
