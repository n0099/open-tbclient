package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class bd extends bg {
    private String b;

    public bd(String str) {
        this.b = null;
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.bg
    protected void a(protobuf.k kVar) {
        kVar.f(b());
    }
}
