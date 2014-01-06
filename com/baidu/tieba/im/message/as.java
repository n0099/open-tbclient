package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class as extends at {
    private String b;

    public as(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.at
    protected void a(protobuf.i iVar) {
        iVar.b(b());
    }
}
