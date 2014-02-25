package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class be extends bg {
    private int b;
    private String c;
    private String d;

    public int b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public be(int i, String str, String str2) {
        this.b = 0;
        this.c = "";
        this.d = "";
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.tieba.im.message.bg
    protected void a(protobuf.k kVar) {
        kVar.e(d());
        kVar.d(c());
        kVar.d(b());
    }
}
