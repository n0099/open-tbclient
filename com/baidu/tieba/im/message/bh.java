package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class bh extends bg {
    private String b;

    public bh(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.bg
    protected void a(protobuf.k kVar) {
        kVar.a(b());
    }
}
