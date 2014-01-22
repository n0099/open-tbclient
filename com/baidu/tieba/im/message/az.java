package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class az extends ba {
    private String b;

    public az(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.ba
    protected void a(protobuf.i iVar) {
        iVar.b(b());
    }
}
