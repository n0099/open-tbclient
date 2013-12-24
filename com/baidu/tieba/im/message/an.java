package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class an extends aq {
    private String b;

    public an(String str) {
        this.b = null;
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.aq
    protected void a(protobuf.i iVar) {
        iVar.e(b());
    }
}
