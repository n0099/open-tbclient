package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class au extends at {
    private String b;

    public au(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.at
    protected void a(protobuf.i iVar) {
        iVar.a(b());
    }
}
