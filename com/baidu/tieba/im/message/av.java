package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class av extends at {
    private String b;

    public av(String str) {
        this.b = null;
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.at
    protected void a(protobuf.i iVar) {
        iVar.c(b());
    }
}
