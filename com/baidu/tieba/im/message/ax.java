package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ax extends ba {
    private String b;

    public ax(String str) {
        this.b = null;
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.ba
    protected void a(protobuf.i iVar) {
        iVar.e(b());
    }
}
