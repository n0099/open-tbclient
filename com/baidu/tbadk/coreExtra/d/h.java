package com.baidu.tbadk.coreExtra.d;
/* loaded from: classes.dex */
class h {
    public int a;
    public boolean b;
    public long c;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(h hVar) {
        this();
    }

    public void a() {
        this.a = 0;
        if (this.b) {
            this.b = false;
            this.c = 0L;
        }
    }

    public void a(int i) {
        this.a++;
        if (!this.b && this.a >= i) {
            this.b = true;
            this.c = System.currentTimeMillis();
        }
    }
}
