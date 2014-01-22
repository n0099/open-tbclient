package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class bb extends ba {
    private String b;

    public bb(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.ba
    protected void a(protobuf.i iVar) {
        iVar.a(b());
    }
}
